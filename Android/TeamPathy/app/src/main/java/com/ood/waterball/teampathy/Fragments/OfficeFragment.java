package com.ood.waterball.teampathy.Fragments;


import android.os.Bundle;
import android.view.View;

import com.ood.waterball.teampathy.Controllers.EntityControllers.EntityController;
import com.ood.waterball.teampathy.Controllers.Global;
import com.ood.waterball.teampathy.Fragments.Architecture.AsyncQueryRecyclerFragment;
import com.ood.waterball.teampathy.Fragments.ViewAbstractFactory.RecyclerViewAbstractFactory;
import com.ood.waterball.teampathy.R;

import java.util.List;

public class OfficeFragment extends AsyncQueryRecyclerFragment {


    public static OfficeFragment getInstance(String projectId){
        OfficeFragment fragment = new OfficeFragment();
        Bundle args = new Bundle();
        args.putString("projectId",projectId);
        fragment.setArguments(args);
        return fragment;
    }


    public OfficeFragment() {
        // Required empty public constructor
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
        return Global.getMemberController();
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
}
