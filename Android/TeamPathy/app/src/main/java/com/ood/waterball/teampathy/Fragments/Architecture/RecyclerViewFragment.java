package com.ood.waterball.teampathy.Fragments.Architecture;

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
    protected List<T> onFetchData(@Nullable Bundle arguBundle) {
        entityList = createEntityList();
        return entityList;
    }

    protected abstract List<T> createEntityList();

    @Override
    protected final void onFindViews(View parentView,List<T> entityList) {
        recyclerFactory = createRecyclerFactory(parentView,entityList);
        initiateRecyclerView();
        onFindUseCaseViews(parentView);
    }

    protected abstract RecyclerViewAbstractFactory<T> createRecyclerFactory(View parentView,List<T> entityList);

    protected final void initiateRecyclerView(){
        recyclerAdapter = recyclerFactory.getAdapter();
        recyclerView = recyclerFactory.getRecyclerView();
        layoutManager = recyclerFactory.getLayoutManager();
    }

    protected abstract void onFindUseCaseViews(View parentView);


}
