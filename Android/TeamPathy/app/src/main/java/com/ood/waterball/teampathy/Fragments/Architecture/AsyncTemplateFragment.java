package com.ood.waterball.teampathy.Fragments.Architecture;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ood.waterball.teampathy.Controllers.MyUtils.AsyncTaskController;

import java.util.List;


public abstract class AsyncTemplateFragment<T> extends InsideFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(getLayoutResource(), container, false);
    }

    protected abstract int getLayoutResource();

    @Override
    public void onViewCreated(final View view, @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        AsyncTask<Void,Void,List<T>> asyncTask = new AsyncTask<Void, Void, List<T>>() {
            @Override
            protected List<T> doInBackground(Void... voids) {
                return onFetchData(getArguments());
            }

            @Override
            protected void onPostExecute(List<T> entityList) {
                onFindViews(view);
                onControlViews();
            }
        };
        AsyncTaskController.runAsyncTask(asyncTask);
    }

    protected abstract List<T> onFetchData(@Nullable Bundle arguBundle);
    protected abstract void onFindViews(View parentView);
    protected abstract void onControlViews();

}
