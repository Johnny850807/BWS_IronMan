package com.ood.waterball.teampathy.Fragments;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.ood.waterball.teampathy.Controllers.EntityControllers.EntityController;
import com.ood.waterball.teampathy.Controllers.Global;
import com.ood.waterball.teampathy.Controllers.MyUtils.GlideHelper;
import com.ood.waterball.teampathy.Dialogs.CreateIssueCommentDialog;
import com.ood.waterball.teampathy.DomainModels.Domains.Issue;
import com.ood.waterball.teampathy.DomainModels.Domains.IssueComment;
import com.ood.waterball.teampathy.Fragments.Architecture.AsyncQueryRecyclerFragment;
import com.ood.waterball.teampathy.Fragments.ViewAbstractFactory.IssueCommentsRecyclerViewFactory;
import com.ood.waterball.teampathy.Fragments.ViewAbstractFactory.RecyclerViewAbstractFactory;
import com.ood.waterball.teampathy.R;

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
        setupIssueDetailsView();
        setCommentingFabListener();
    }

    private void setupIssueDetailsView(){
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
                new CreateIssueCommentDialog(IssueDetailsFragment.this)
                        .show();
            }
        });
    }

    public ScrollView getScrollView() {
        return scrollView;
    }

    @Override
    protected EntityController<IssueComment> createEntityController() {
        return Global.getIssueCommentController();
    }


}
