package com.ood.waterball.teampathy.Fragments;


import android.os.Bundle;
import android.view.View;

import com.ood.waterball.teampathy.Controllers.EntityControllers.EntityController;
import com.ood.waterball.teampathy.Controllers.Global;
import com.ood.waterball.teampathy.DomainModels.Models.MemberIdCardModel;
import com.ood.waterball.teampathy.Fragments.Architecture.AsyncQueryRecyclerFragment;
import com.ood.waterball.teampathy.Fragments.ViewAbstractFactory.OfficeRecyclerViewFactory;
import com.ood.waterball.teampathy.Fragments.ViewAbstractFactory.RecyclerViewAbstractFactory;
import com.ood.waterball.teampathy.R;

import java.util.List;

public class OfficeFragment extends AsyncQueryRecyclerFragment<MemberIdCardModel> {


    public static OfficeFragment getInstance(int projectId){
        OfficeFragment fragment = new OfficeFragment();
        Bundle args = new Bundle();
        args.putInt("projectId",projectId);
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
    protected EntityController<MemberIdCardModel> createEntityController(){
        return Global.getMemberIdCardController();
    }

    @Override
    protected List<MemberIdCardModel> createEntityList() {
        int projectId = getArguments().getInt("projectId");
        try {
            return Global.getMemberIdCardController().readList(projectId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected RecyclerViewAbstractFactory<MemberIdCardModel> createRecyclerFactory(View parentView, List<MemberIdCardModel> entityList) {
        return new OfficeRecyclerViewFactory(parentView,entityList);
    }

    @Override
    protected void onFindUseCaseViews(View parentView) {

    }
}
