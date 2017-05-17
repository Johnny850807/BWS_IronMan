package com.ood.waterball.teampathy.Fragments;


import android.os.Bundle;
import android.view.View;

import com.ood.waterball.teampathy.Controllers.EntityControllers.EntityController;
import com.ood.waterball.teampathy.Controllers.Global;
import com.ood.waterball.teampathy.DomainModels.Domains.TodoTask;
import com.ood.waterball.teampathy.Fragments.Architecture.AsyncQueryRecyclerFragment;
import com.ood.waterball.teampathy.Fragments.ViewAbstractFactory.RecyclerViewAbstractFactory;
import com.ood.waterball.teampathy.Fragments.ViewAbstractFactory.TodoListRecyclerViewFactory;
import com.ood.waterball.teampathy.R;

import java.util.List;

public class TodoListFragment extends AsyncQueryRecyclerFragment<TodoTask> {

    public static TodoListFragment getInstance(int projectId){
        TodoListFragment fragment = new TodoListFragment();
        Bundle args = new Bundle();
        args.putInt("projectId",projectId);
        fragment.setArguments(args);
        return fragment;
    }


    public TodoListFragment() {
        // Required empty public constructor
    }


    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_todolist_page;
    }

    @Override
    protected EntityController<TodoTask> createEntityController() {
        return Global.getTodotaskController();
    }

    @Override
    protected List<TodoTask> createEntityList() {
        try {
            int projectId = getArguments().getInt("projectId");
            return Global.getTodotaskController().readList(projectId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected RecyclerViewAbstractFactory<TodoTask> createRecyclerFactory(View parentView, List<TodoTask> entityList) {
        return new TodoListRecyclerViewFactory(parentView,entityList);
    }

    @Override
    protected void onFindUseCaseViews(View parentView) {

    }

    @Override
    protected void onControlViews() {

    }

}
