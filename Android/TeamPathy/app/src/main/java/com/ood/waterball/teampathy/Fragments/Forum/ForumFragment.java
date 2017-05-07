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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.ood.waterball.teampathy.Controllers.Global;
import com.ood.waterball.teampathy.Controllers.MyUtils.Dialogs.TitleContentPostingDialogBuilder;
import com.ood.waterball.teampathy.Domains.Issue;
import com.ood.waterball.teampathy.Domains.Member;
import com.ood.waterball.teampathy.Fragments.ActivityBaseFragment;
import com.ood.waterball.teampathy.R;

import java.util.List;

import static com.ood.waterball.teampathy.Controllers.MyLog.Log;

public class ForumFragment extends ActivityBaseFragment {
    private String projectId;
    private List<Issue> issueList;
    private FloatingActionButton fab;

    private RecyclerView issueRecyclerView;
    private LinearLayoutManager layoutManager;
    private MyRecyclerAdapter recyclerAdapter;
    private String issueType; //點選新增文章時會出現分類Spinner，將其選擇的選項字串儲存至issueType中

    public static ForumFragment getInstance(String projectId){
        ForumFragment fragment = new ForumFragment();
        Bundle args = new Bundle();
        args.putString("projectId",projectId);
        fragment.setArguments(args);
        return fragment;
    }


    public ForumFragment() {
        // Required empty public constructor
    }

    @Override
    protected void onFetchData(@Nullable Bundle savedInstanceState, @Nullable Bundle arguBundle) {
        try {
            projectId = (String) arguBundle.get("projectId");
            issueList = Global.getTeamPathyFacade().getIssueListByProjectId(projectId);
            Log("文章數量:" + issueList.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_forum_page;
    }

    @Override
    protected void onFindViews(View parentView) {
        issueRecyclerView = (RecyclerView) parentView.findViewById(R.id.issues_recyclerview_forum);
        fab = (FloatingActionButton) parentView.findViewById(R.id.fab_forum);
    }

    @Override
    protected void onControlViews() {
        initiateRecyclerView();
        setListeners();
    }

    private void initiateRecyclerView(){
        recyclerAdapter = new MyRecyclerAdapter();
        issueRecyclerView.setAdapter(recyclerAdapter);
        layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        issueRecyclerView.setLayoutManager(layoutManager);
    }

    private void setListeners(){
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                final View dialogView = LayoutInflater.from(getContext()).inflate(R.layout.create_issue_dialog,null);
                setDialogSpinnerListener(dialogView);

                TitleContentPostingDialogBuilder builder = new TitleContentPostingDialogBuilder(getContext());
                builder.setContentTextInputEditTextId(R.id.issueContentED_issue_dialog)
                        .setTitleTextInputEditTextId(R.id.issueTitleED_issue_dialog)
                        .setErrorTextViewId(R.id.errorTxt_issue_dialog)
                        .setOnFinishListener(new TitleContentPostingDialogBuilder.onFinishListener() {
                            @Override
                            public void onFinish(String title,String content) {
                                try {
                                    Member poster = Global.getMemberController().getActiveMember();
                                    addIssueAndNotify(new Issue(poster,title,content,issueType));
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        })
                        .setOnDetectListener(new TitleContentPostingDialogBuilder.OnDetectListener() {
                            @Override
                            public boolean onTextEmptyReport(int errorViewId,TextView errorText) {
                                if (errorViewId == R.id.issueTitleED_issue_dialog)
                                {
                                    errorText.setText(getString(R.string.title_cannot_be_empty));
                                    return false;
                                }
                                if (errorViewId == R.id.issueContentED_issue_dialog)
                                {
                                    errorText.setText(getString(R.string.issue_content_cannot_be_empty));
                                    return false;
                                }
                                return true;
                            }

                            @Override
                            public boolean onElseDetect(TextView errorText) {
                                if ( issueType.equals(getString(R.string.get_all_issue_types)) )
                                {
                                    errorText.setText(getString(R.string.please_choose_an_issue_type));
                                    errorText.setVisibility(View.VISIBLE);
                                    return false;
                                }
                                return true;
                            }

                            @Override
                            public boolean onDetectLength(int viewId, int length,TextView errorText) {
                                if ( viewId == R.id.issueTitleED_issue_dialog && length > 12 )
                                {
                                    errorText.setText(R.string.title_cannt_be_exceeding_12_words);
                                    return false;
                                }
                                return true;
                            }
                        })
                        .setScrollviewId(R.id.scrollView_issue_dialog)
                        .setCancelDialogContentString(getString(R.string.make_sure_to_cancel))
                        .setConfirmString(getString(R.string.confirm))
                        .setCancelString(getString(R.string.cancel))
                        .setConfirmButtonId(R.id.confirmBTN_issue_dialog)
                        .setCancelButtonId(R.id.cancelBTN_issue_dialog)
                        .setIcon(R.drawable.logo)
                        .setView(dialogView)
                        .setTitle(getString(R.string.CreateIssue))
                        .show();
            }
        });
    }


    private void setDialogSpinnerListener(View dialogView){

        try {
            Spinner typeSpinner = (Spinner) dialogView.findViewById(R.id.typeSpinner_issue_dialog);
            final String[] typeList = Global.getTeamPathyFacade().getIssueTypeListByProjectId(projectId);
            ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1,typeList);
            typeSpinner.setAdapter(stringArrayAdapter);
            typeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                    issueType = typeList[position];
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {}
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    private void addIssueAndNotify(final Issue issue) throws Exception {
        Global.getTeamPathyFacade().addIssue(issue);
        recyclerAdapter.notifyDataSetChanged();
        layoutManager.scrollToPosition(0);
        Snackbar.make(fab, R.string.issue_created_completed, Snackbar.LENGTH_LONG)
                .setAction(R.string.enter, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        getSinglePage().changePage(IssueDetailsFragment.getInstance(issue));
                    }
                }).show();
    }


    class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.MyViewHolder>{

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.issue_item, parent, false);

            return  new MyViewHolder(v);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            Issue issue = issueList.get(position);
            holder.titleTxt.setText(issue.getTitle());
            holder.typeTxt.setText(issue.getType());
            holder.dateTxt.setText(Global.getTeamPathyFacade().convertDateToString(issueList.get(position).getPostDate()));
            holder.authorTxt.setText(issue.getPoster().getName());
        }

        @Override
        public int getItemCount() {
            return issueList.size();
        }

        class MyViewHolder extends  RecyclerView.ViewHolder{
            TextView titleTxt;
            TextView typeTxt;
            TextView dateTxt;
            TextView authorTxt;

            public MyViewHolder(View itemView) {
                super(itemView);
                titleTxt = (TextView) itemView.findViewById(R.id.title_text_issue_item);
                typeTxt = (TextView) itemView.findViewById(R.id.type_text_issue_item);
                dateTxt = (TextView) itemView.findViewById(R.id.datetime_text_issue_item);
                authorTxt = (TextView) itemView.findViewById(R.id.author_text_issue_item);

                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int position = getLayoutPosition();
                        Issue issue = issueList.get(position);
                        getSinglePage().changePage(IssueDetailsFragment.getInstance(issue));
                    }
                });
            }
        }
    }

}
