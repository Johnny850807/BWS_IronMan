package com.ood.waterball.teampathy.Fragments.TodoList;


import android.os.Bundle;
import android.view.View;

import com.ood.waterball.teampathy.Controllers.EntityControllers.EntityController;
import com.ood.waterball.teampathy.Domains.Issue;
import com.ood.waterball.teampathy.Fragments.Architecture.AsyncQueryRecyclerFragment;
import com.ood.waterball.teampathy.Fragments.ViewAbstractFactory.RecyclerViewAbstractFactory;

import java.util.List;

public class TodoListFragment extends AsyncQueryRecyclerFragment {

    private List<Issue> issueList;

    public static TodoListFragment getInstance(String projectId){
        TodoListFragment fragment = new TodoListFragment();
        Bundle args = new Bundle();
        args.putString("projectId",projectId);
        fragment.setArguments(args);
        return fragment;
    }


    public TodoListFragment() {
        // Required empty public constructor
        //todo 更換正確id
    }


    @Override
    protected EntityController createEntityController() {
        return null;
    }

    @Override
    protected List createEntityList() {
        return null;
    }

    @Override
    protected RecyclerViewAbstractFactory createRecyclerFactory(View parentView, List entityList) {
        return null;
    }

    @Override
    protected void onFindUseCaseViews(View parentView) {

    }

    @Override
    protected int getLayoutResource() {
        return 0;
    }

    @Override
    protected void onControlViews() {

    }
}
