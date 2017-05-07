package com.ood.waterball.teampathy.Fragments.Forum;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ood.waterball.teampathy.Controllers.Global;
import com.ood.waterball.teampathy.Controllers.MyUtils.Dialogs.TitleContentPostingDialogBuilder;
import com.ood.waterball.teampathy.Domains.Issue;
import com.ood.waterball.teampathy.Domains.IssueComment;
import com.ood.waterball.teampathy.Domains.Member;
import com.ood.waterball.teampathy.Fragments.EntityAsyncCRUDFragment;
import com.ood.waterball.teampathy.R;

import java.util.Date;
import java.util.List;


public class IssueDetailsFragment extends EntityAsyncCRUDFragment {
    private Issue currentIssue;
    private List<IssueComment> issueCommentList;

    private ImageView posterHeadImg;
    private TextView issueTitleTxt;
    private TextView issueContentTxt;
    private TextView dateTxt;
    private TextView issueTypeTxt;
    private ScrollView scrollView;
    private RecyclerView commentsRecyclerView;
    private LinearLayoutManager layoutManager;
    private MyRecyclerAdapter recyclerAdapter;
    private FloatingActionButton fab;

    public static IssueDetailsFragment getInstance(Issue currentIssue){
        IssueDetailsFragment fragment = new IssueDetailsFragment();
        Bundle args = new Bundle();
        args.putSerializable("issue",currentIssue);
        fragment.setArguments(args);
        return fragment;
    }


    public IssueDetailsFragment() {
        // Required empty public constructor
    }

    @Override
    protected void onFetchData(@Nullable Bundle savedInstanceState, @Nullable Bundle arguBundle) {
        try {
            currentIssue = (Issue) arguBundle.getSerializable("issue");
            issueCommentList = Global.getTeamPathyFacade().getIssueCommentListByIssueId(currentIssue.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_issue_details_page;
    }

    @Override
    protected void onFindViews(View parentView) {
        issueTitleTxt = (TextView) parentView.findViewById(R.id.title_issue_details);
        posterHeadImg = (ImageView) parentView.findViewById(R.id.poster_picture_issue_details);
        issueContentTxt = (TextView) parentView.findViewById(R.id.issue_content_issue_details);
        dateTxt = (TextView) parentView.findViewById(R.id.postdate_issue_details);
        issueTypeTxt = (TextView) parentView.findViewById(R.id.issuetype_issue_details);
        commentsRecyclerView = (RecyclerView) parentView.findViewById(R.id.recycler_issue_details);
        fab = (FloatingActionButton) parentView.findViewById(R.id.fab_issue_details);
        scrollView = (ScrollView) parentView.findViewById(R.id.scrollview_issue_detail);
    }

    @Override
    protected void onControlViews() {
        setupViews();
        initiateRecyclerView();
        setCommentingFabListener();
    }

    private void setupViews(){
        Glide.with(this).load(currentIssue.getPoster().getImageUrl()).into(posterHeadImg);
        issueContentTxt.setText(currentIssue.getContent());
        issueTypeTxt.setText(currentIssue.getType());
        issueTitleTxt.setText(currentIssue.getTitle());
        dateTxt.setText(currentIssue.getDateString());
    }

    private void initiateRecyclerView(){
        layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        layoutManager.setStackFromEnd(true);
        recyclerAdapter = new MyRecyclerAdapter();
        commentsRecyclerView.setLayoutManager(layoutManager);
        commentsRecyclerView.setAdapter(recyclerAdapter);
        commentsRecyclerView.setNestedScrollingEnabled(false);  //改善 scrollview 滑動慢的問題 see : http://stackoverflow.com/questions/33143485/recyclerview-inside-scrollview-not-scrolling-smoothly
    }

    private void setCommentingFabListener() {
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view = LayoutInflater.from(getContext()).inflate(R.layout.create_issue_comment_dialog,null);
                TitleContentPostingDialogBuilder builder = new TitleContentPostingDialogBuilder(getContext());
                builder.setContentTextInputEditTextId(R.id.commentContentED_issue_comment_dialog)
                        .setErrorTextViewId(R.id.errorTxt_issue_comment_dialog)
                        .setOnFinishListener(new TitleContentPostingDialogBuilder.onFinishListener() {
                            @Override
                            public void onFinish(String title,String content) {
                                try {
                                    Member poster = Global.getMemberController().getActiveMember();
                                    addNewIssueCommentAndRefresh(new IssueComment(poster,content,new Date()));
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        })
                        .setOnDetectListener(new TitleContentPostingDialogBuilder.OnDetectListener() {
                            @Override
                            public boolean onTextEmptyReport(int errorViewId,TextView errorText) {
                                if (errorViewId == R.id.commentContentED_issue_comment_dialog)
                                {
                                    errorText.setText(getString(R.string.issue_content_cannot_be_empty));
                                    return false;
                                }
                                return true;
                            }

                            @Override
                            public boolean onElseDetect(TextView errorText) {
                                return true;
                            }

                            @Override
                            public boolean onDetectLength(int viewId, int length,TextView errorText) {
                                return true;
                            }
                        })
                        .setScrollviewId(R.id.scrollView_issue_comment_dialog)
                        .setCancelDialogContentString(getString(R.string.make_sure_to_cancel))
                        .setConfirmString(getString(R.string.confirm))
                        .setCancelString(getString(R.string.cancel))
                        .setConfirmButtonId(R.id.confirmBTN_issue_comment_dialog)
                        .setCancelButtonId(R.id.cancelBTN_issue_comment_dialog)
                        .setIcon(R.drawable.logo_transparent)
                        .setView(view)
                        .setTitle(getString(R.string.create_issue_comment))
                        .show();
            }
        });
    }

    private void addNewIssueCommentAndRefresh(IssueComment issueComment) throws Exception {
        Global.getTeamPathyFacade().addIssueComment(issueComment);
        recyclerAdapter.notifyDataSetChanged();

        /**通知並且設定點擊觀看則scroll到新留言所在position**/
        Snackbar.make(fab,R.string.comment_created_completed,Snackbar.LENGTH_SHORT).setAction(getString(R.string.watch), new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scrollView.fullScroll(ScrollView.FOCUS_DOWN);
            }
        }).show();
    }


    class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.ViewHolder>{

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(getContext()).inflate(R.layout.issue_details_item,parent,false));
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            IssueComment issueComment = issueCommentList.get(position);
            holder.authorTxt.setText(issueComment.getPoster().getName());
            holder.commentTxt.setText(issueComment.getContent());
            holder.dateTxt.setText(Global.getTeamPathyFacade().
                    convertDateToString(issueComment.getPostDate()));
        }

        @Override
        public int getItemCount() {
            return issueCommentList.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder{
            private TextView commentTxt;
            private TextView authorTxt;
            private TextView dateTxt;

            public ViewHolder(View itemView) {
                super(itemView);
                commentTxt = (TextView) itemView.findViewById(R.id.comment_text_issue_details_item);
                authorTxt = (TextView) itemView.findViewById(R.id.author_text_issue_details_item);
                dateTxt = (TextView) itemView.findViewById(R.id.datetime_text_issue_details_item);
            }
        }
    }
}
