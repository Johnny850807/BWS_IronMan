package com.ood.waterball.teampathy.Fragments;

import android.view.View;

import com.ood.waterball.teampathy.Controllers.EntityControllers.EntityController;
import com.ood.waterball.teampathy.Fragments.Architecture.AsyncQueryRecyclerFragment;
import com.ood.waterball.teampathy.Fragments.ViewAbstractFactory.RecyclerViewAbstractFactory;

import java.util.List;

/**
 * Created by AndroidWork on 2017/5/8.
 */

public class test extends AsyncQueryRecyclerFragment {
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
