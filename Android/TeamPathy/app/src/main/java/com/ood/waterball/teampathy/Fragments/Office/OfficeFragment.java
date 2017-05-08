package com.ood.waterball.teampathy.Fragments.Office;


import android.os.Bundle;
import android.view.View;

import com.ood.waterball.teampathy.Controllers.EntityControllers.EntityController;
import com.ood.waterball.teampathy.Domains.Issue;
import com.ood.waterball.teampathy.Fragments.AsyncQueryRecyclerFragment;
import com.ood.waterball.teampathy.Fragments.ViewAbstractFactory.RecyclerViewAbstractFactory;
import com.ood.waterball.teampathy.R;

import java.util.List;

public class OfficeFragment extends AsyncQueryRecyclerFragment {

    private List<Issue> issueList;

    public static OfficeFragment getInstance(String projectId){
        OfficeFragment fragment = new OfficeFragment();
        Bundle args = new Bundle();
        args.putString("projectId",projectId);
        fragment.setArguments(args);
        return fragment;
    }


    public OfficeFragment() {
        // Required empty public constructor
        //todo 更換正確id
    }


    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_office_page;
    }

    @Override
    protected void onControlViews() {

    }


    @Override
    protected EntityController createEntityController() {
        return null;
    }

    @Override
    protected RecyclerViewAbstractFactory createRecyclerFactory(View parentView) {
        return null;
    }

    @Override
    protected void onFindUseCaseViews(View parentView) {

    }
}
