package com.ood.waterball.teampathy.Fragments;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;

import com.ood.waterball.teampathy.Controllers.EntityControllers.EntityController;
import com.ood.waterball.teampathy.Controllers.Global;
import com.ood.waterball.teampathy.Dialogs.CreateIssueDialog;
import com.ood.waterball.teampathy.DomainModels.Domains.Issue;
import com.ood.waterball.teampathy.Fragments.Architecture.AsyncQueryRecyclerFragment;
import com.ood.waterball.teampathy.Fragments.ViewAbstractFactory.IssuesRecyclerViewFactory;
import com.ood.waterball.teampathy.Fragments.ViewAbstractFactory.RecyclerViewAbstractFactory;
import com.ood.waterball.teampathy.R;

import java.util.List;

public class ForumFragment extends AsyncQueryRecyclerFragment<Issue> {
    private int projectId;
    private FloatingActionButton fab;

    public static ForumFragment getInstance(int projectId){
        ForumFragment fragment = new ForumFragment();
        Bundle args = new Bundle();
        args.putInt("projectId",projectId);
        fragment.setArguments(args);
        return fragment;
    }


    public ForumFragment() {
        // Required empty public constructor
    }


    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_forum_page;
    }


    @Override
    protected void onFindUseCaseViews(View parentView) {
        fab = (FloatingActionButton) parentView.findViewById(R.id.fab_forum);
    }

    @Override
    protected List<Issue> createEntityList() {
        try {
            projectId =  getArguments().getInt("projectId");
            return Global.getIssueController().readList(projectId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected RecyclerViewAbstractFactory<Issue> createRecyclerFactory(View parentView, List<Issue> entityList) {
        return new IssuesRecyclerViewFactory(parentView,entityList);
    }

    @Override
    protected void onControlViews() {
        setScrollingEnabled(true);
        setListeners();
    }

    private void setListeners(){
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                new CreateIssueDialog(ForumFragment.this)
                        .show();
            }
        });
    }

    @Override
    protected EntityController<Issue> createEntityController() {
        return Global.getIssueController();
    }

    public int getProjectId() {
        return projectId;
    }
}
