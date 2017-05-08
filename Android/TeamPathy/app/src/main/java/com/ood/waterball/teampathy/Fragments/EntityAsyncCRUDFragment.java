package com.ood.waterball.teampathy.Fragments;

import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ood.waterball.teampathy.Controllers.MyUtils.AsyncTaskController;

import java.util.ArrayList;
import java.util.List;

public abstract class EntityAsyncCRUDFragment<T> extends ActivityBaseFragment {
    private List<T> entityList;
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private RecyclerView.Adapter recyclerAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(getLayoutResource(), container, false);
    }

    protected abstract int getLayoutResource();

    @Override
    public void onViewCreated(final View view, @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        AsyncTask<Void,Void,Void> asyncTask = new AsyncTask<Void, Void, Void>() {

            @Override
            protected Void doInBackground(Void... voids) {
                entityList = onFetchData(getArguments());
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                onFindViews(view);
                recyclerView = onFindRecyclerView(view);
                initiateRecyclerView();
                onControlViews();

            }
        };

        AsyncTaskController.runAsyncTask(asyncTask);
    }

    protected abstract List<T> onFetchData(@Nullable Bundle arguBundle);
    protected abstract void onFindViews(View parentView);
    protected void initiateRecyclerView(){
        entityList = onInitiateEntityList();
        recyclerAdapter = onInitiateAdapter(entityList);
        recyclerView.setAdapter(recyclerAdapter);
        layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        onFurtherRecyclerViewConfig(recyclerView,recyclerAdapter,layoutManager);
    }
    protected abstract RecyclerView onFindRecyclerView(View parentView);
    protected List<T> onInitiateEntityList(){
        return new ArrayList<T>();
    }
    protected abstract RecyclerView.Adapter onInitiateAdapter(List<T> entityList);
    protected abstract void onControlViews();
    protected void onFurtherRecyclerViewConfig(RecyclerView  recyclerView, RecyclerView.Adapter adapter , RecyclerView.LayoutManager layoutManager){
        /**hook method**/
    }

    protected void add(T t, final RUDOperation<T> operation){
        AsyncTask<Void,Void,T> asyncTask = new AsyncTask<Void, Void, T>() {

            @Override
            protected T doInBackground(Void... voids) {
                return  operation.doOperation();
            }

            @Override
            protected void onPostExecute(T entity) {
                entityList = onFetchData(getArguments());
                recyclerAdapter.notifyDataSetChanged();
            }
        };

        excecuteAsynctask(asyncTask);
    }

    public interface RUDOperation<T>{
        public T doOperation();
    }


    private AsyncTask<Void,Void,T> excecuteAsynctask(AsyncTask<Void,Void,T> asyncTask){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            return asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        } else {
            return asyncTask.execute();
        }
    }




}
