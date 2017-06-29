package com.ood.waterball.teampathy.Dialogs;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import com.ood.waterball.teampathy.Controllers.Global;
import com.ood.waterball.teampathy.DomainModels.Domains.Project;
import com.ood.waterball.teampathy.Fragments.MemberHomePageFragment;
import com.ood.waterball.teampathy.Fragments.ViewAbstractFactory.RecyclerViewAbstractFactory;
import com.ood.waterball.teampathy.Fragments.ViewAbstractFactory.SearchProjectRecyclerViewFactory;
import com.ood.waterball.teampathy.R;

import java.util.ArrayList;
import java.util.List;

public class SearchProjectDialog extends Dialog{
    private MemberHomePageFragment fragment;
    private List<Project> resultProjectList = new ArrayList<>();
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerViewAbstractFactory recyclerFactory;

    public SearchProjectDialog(@NonNull MemberHomePageFragment fragment) {
        super(fragment.getContext());
        this.fragment = fragment;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_project_dialog);
        findViews();
        initRecyclerView();
    }

    private void findViews() {

    }

    private void initRecyclerView() {
        recyclerFactory = new SearchProjectRecyclerViewFactory(fragment.getView(),resultProjectList);
        recyclerView = recyclerFactory.getRecyclerView();
        adapter = recyclerFactory.getAdapter();
    }

    private void search(String keyword) throws Exception {
        resultProjectList = Global.getProjectSearcher().searchProject(keyword);
        adapter.notifyDataSetChanged();
    }
}
