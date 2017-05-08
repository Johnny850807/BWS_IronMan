package com.ood.waterball.teampathy.Fragments.ViewAbstractFactory;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

public abstract class RecyclerViewAbstractFactory<TEntity> {
    protected Context context;
    protected View rootView;
    protected List<TEntity> entityList;
    protected RecyclerView recyclerView;
    protected RecyclerView.Adapter adapter;
    protected RecyclerView.LayoutManager layoutManager;

    public RecyclerViewAbstractFactory(View rootView,List<TEntity> entityList) {
        this.rootView = rootView;
        this.entityList = entityList;
        this.context = rootView.getContext();
        init();
    }

    private void init(){
        recyclerView = createRecyclerView();
        adapter = createRecyclerAdapter(entityList);
        layoutManager = createLayoutManager();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
        onFurtherRecyclerViewConfig(recyclerView,adapter,layoutManager);
    }

    protected abstract RecyclerView createRecyclerView();

    protected abstract RecyclerView.Adapter createRecyclerAdapter(List<TEntity> entityList);

    protected abstract RecyclerView.LayoutManager createLayoutManager();

    protected void onFurtherRecyclerViewConfig(RecyclerView  recyclerView, RecyclerView.Adapter adapter , RecyclerView.LayoutManager layoutManager) {
        /**hook method**/
    }

    public RecyclerView.Adapter getAdapter() {
        return adapter;
    }

    public RecyclerView.LayoutManager getLayoutManager() {
        return layoutManager;
    }

    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    public View getRootView() {
        return rootView;
    }
}
