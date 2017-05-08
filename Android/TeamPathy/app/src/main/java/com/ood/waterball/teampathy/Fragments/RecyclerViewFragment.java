package com.ood.waterball.teampathy.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.ood.waterball.teampathy.Fragments.ViewAbstractFactory.RecyclerViewAbstractFactory;

import java.util.List;



public abstract class RecyclerViewFragment<T> extends AsyncTemplateFragment<T> {
    private RecyclerViewAbstractFactory<T> recyclerFactory;
    protected List<T> entityList;
    protected RecyclerView recyclerView;
    protected RecyclerView.LayoutManager layoutManager;
    protected RecyclerView.Adapter recyclerAdapter;

    @Override
    protected final void onFindViews(View parentView) {
        recyclerFactory = createRecyclerFactory(parentView);
        initiateRecyclerView();
        onFindUseCaseViews(parentView);
    }

    protected abstract RecyclerViewAbstractFactory<T> createRecyclerFactory(View parentView);

    @Override
    protected List<T> onFetchData(@Nullable Bundle arguBundle) {
        return entityList = recyclerFactory.getEntityList();
    }

    protected final void initiateRecyclerView(){
        recyclerAdapter = recyclerFactory.getAdapter();
        recyclerView = recyclerFactory.getRecyclerView();
        layoutManager = recyclerFactory.getLayoutManager();
    }

    protected abstract void onFindUseCaseViews(View parentView);


}
