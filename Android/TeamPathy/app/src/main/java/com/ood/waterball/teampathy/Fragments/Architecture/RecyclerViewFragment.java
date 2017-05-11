package com.ood.waterball.teampathy.Fragments.Architecture;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.ood.waterball.teampathy.Fragments.ViewAbstractFactory.RecyclerViewAbstractFactory;
import com.ood.waterball.teampathy.R;

import java.util.List;



public abstract class RecyclerViewFragment<T> extends AsyncTemplateFragment<T> {
    protected Toolbar toolbar;
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
        toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
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

    protected void setScrollingEnabled(boolean isEnabled) {
        setScrollingEnabled(isEnabled,(AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL | AppBarLayout.LayoutParams.SCROLL_FLAG_ENTER_ALWAYS));
    }

    protected void setScrollingEnabled(boolean isEnabled,int flag) {
        AppBarLayout.LayoutParams params = (AppBarLayout.LayoutParams) toolbar.getLayoutParams();
        params.setScrollFlags(isEnabled ? flag : 0);
    }

}
