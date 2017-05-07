package com.ood.waterball.teampathy.Fragments;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ood.waterball.teampathy.Controllers.MyUtils.AsyncTaskController;

/**
    在 Single Activity Architecture結構下，放置在Base Activity中的Fragment
 */

public abstract class EntityAsyncCRUDFragment extends ActivityBaseFragment {

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
                onFetchData(savedInstanceState,getArguments());
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                onFindViews(view);
                onControlViews();
            }
        };

        AsyncTaskController.runAsyncTask(asyncTask);
    }

    protected abstract void onFetchData(@Nullable Bundle savedInstanceState , @Nullable Bundle arguBundle);
    protected abstract void onFindViews(View parentView);
    protected abstract void onControlViews();


}
