package com.ood.waterball.teampathy.Fragments;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.ood.waterball.teampathy.Controllers.EntityControllers.EntityController;
import com.ood.waterball.teampathy.Controllers.Global;
import com.ood.waterball.teampathy.Controllers.MyUtils.Dialogs.TitleContentPostingDialogBuilder;
import com.ood.waterball.teampathy.Controllers.MyUtils.GlideHelper;
import com.ood.waterball.teampathy.DomainModels.Domains.Issue;
import com.ood.waterball.teampathy.DomainModels.Domains.IssueComment;
import com.ood.waterball.teampathy.DomainModels.Domains.Member;
import com.ood.waterball.teampathy.Fragments.Architecture.AsyncQueryRecyclerFragment;
import com.ood.waterball.teampathy.Fragments.ViewAbstractFactory.IssueCommentsRecyclerViewFactory;
import com.ood.waterball.teampathy.Fragments.ViewAbstractFactory.RecyclerViewAbstractFactory;
import com.ood.waterball.teampathy.R;

import java.util.Date;
import java.util.List;


public class IssueDetailsFragment extends AsyncQueryRecyclerFragment<IssueComment> {
    private Issue currentIssue;

    private ImageView posterHeadImg;
    private TextView issueTitleTxt;
    private TextView issueContentTxt;
    private TextView dateTxt;
    private TextView issueTypeTxt;
    private ScrollView scrollView;
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
    protected int getLayoutResource() {
        return R.layout.fragment_issue_details_page;
    }


    @Override
    protected List<IssueComment> createEntityList() {
        try {
            currentIssue = (Issue) getArguments().getSerializable("issue");
            return Global.getIssueCommentController().readList(currentIssue.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected RecyclerViewAbstractFactory<IssueComment> createRecyclerFactory(View parentView, List<IssueComment> entityList) {
        return new IssueCommentsRecyclerViewFactory(parentView,entityList);
    }

    @Override
    protected void onFindUseCaseViews(View parentView) {
        issueTitleTxt = (TextView) parentView.findViewById(R.id.title_issue_details);
        posterHeadImg = (ImageView) parentView.findViewById(R.id.poster_picture_issue_details);
        issueContentTxt = (TextView) parentView.findViewById(R.id.issue_content_issue_details);
        dateTxt = (TextView) parentView.findViewById(R.id.postdate_issue_details);
        issueTypeTxt = (TextView) parentView.findViewById(R.id.issuetype_issue_details);
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
        GlideHelper.loadToCircularImage(getContext(),posterHeadImg,currentIssue.getPoster().getImageUrl());
        issueContentTxt.setText(currentIssue.getContent());
        issueTypeTxt.setText(currentIssue.getType().getName());
        issueTitleTxt.setText(currentIssue.getTitle());
        dateTxt.setText(currentIssue.getDateString());
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
                        .setIcon(R.drawable.logo)
                        .setView(view)
                        .setTitle(getString(R.string.create_issue_comment))
                        .show();
            }
        });
    }

    private void addNewIssueCommentAndRefresh(final IssueComment issueComment) throws Exception {
        CREATE(issueComment, new EntityController.OnFinishListener() {
            @Override
            public void onFinish() {
                snackbarNotify(issueComment);
            }
        });
    }

    private void snackbarNotify(IssueComment issueComment){
        /**通知並且設定點擊觀看則scroll到新留言所在position**/
        Snackbar.make(fab,R.string.comment_created_completed,Snackbar.LENGTH_SHORT).setAction(getString(R.string.watch), new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scrollView.fullScroll(ScrollView.FOCUS_DOWN);
            }
        }).show();
    }

    @Override
    protected EntityController<IssueComment> createEntityController() {
        return Global.getIssueCommentController();
    }


}
