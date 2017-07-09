package com.ood.waterball.teampathy.Fragments.Architecture;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ood.waterball.teampathy.Controllers.MyUtils.AsyncTaskController;
import com.ood.waterball.teampathy.R;

import java.util.List;


public abstract class AsyncTemplateFragment<T> extends InsideFragment {
    protected ProgressDialog progressDialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(getLayoutResource(), container, false);
    }

    protected abstract int getLayoutResource();

    @Override
    public void onViewCreated(final View view, @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getParentActivity().showProgressBar();
        AsyncTask<Void,Void,List<T>> asyncTask = new AsyncTask<Void, Void, List<T>>() {
            @Override
            protected List<T> doInBackground(Void... voids) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return onFetchData(getArguments());
            }

            @Override
            protected void onPostExecute(List<T> entityList) {
                onFindViews(view,entityList);
                onControlViews();
                getParentActivity().hideProgressBar();
            }
        };

        AsyncTaskController.runAsyncTask(this,asyncTask);
    }

    protected abstract List<T> onFetchData(@Nullable Bundle arguBundle);
    protected abstract void onFindViews(View parentView,List<T> entityList);
    protected abstract void onControlViews();

    public ProgressDialog getProgressDialog(){
        if (progressDialog == null)
        {
            progressDialog = new ProgressDialog(getContext());
            progressDialog.setTitle(getString(R.string.loading));
            progressDialog.setMessage(getString(R.string.please_wait));
            progressDialog.setIcon(R.drawable.logo_icon);
        }
        return progressDialog;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        getParentActivity().hideProgressBar();
        AsyncTaskController.clearAsyncTask(this);
    }
}
