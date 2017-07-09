package com.ood.waterball.teampathy.Fragments.Architecture;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.ood.waterball.teampathy.Controllers.EntityControllers.EntityController;
import com.ood.waterball.teampathy.Controllers.MyUtils.AsyncTaskController;

import java.util.List;

public abstract class AsyncQueryRecyclerFragment<T> extends RecyclerViewFragment<T> {
    protected EntityController<T> entityController = createEntityController();


    protected abstract EntityController<T> createEntityController();

    public AsyncQueryRecyclerFragment(){}

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        if (progressDialog == null || !progressDialog.isShowing())
            getProgressDialog().show();
        super.onViewCreated(view, savedInstanceState);
        getProgressDialog().dismiss();
    }

    public final void CREATE(final T entity , final boolean readAfterOperation , final EntityController.OnFinishListener ...listeners){
        getParentActivity().showProgressBar();
        AsyncTask<Void,Void,Void> asyncTask = new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                try {
                    Thread.sleep(2000);
                    entityController.create(entity);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                if(readAfterOperation)
                    READ_DATA();
                else
                    getProgressDialog().dismiss();
                for (EntityController.OnFinishListener listener : listeners )
                    listener.onFinish();
            }
        };
        AsyncTaskController.runAsyncTask(this,asyncTask);
    }

    public final void CREATE(final T entity , final EntityController.OnFinishListener ...listeners){
        CREATE(entity, true , listeners);
    }

    public void DELETE(final T entity, final boolean readAfterOperation, final EntityController.OnFinishListener ...listeners){
        getProgressDialog().show();
        AsyncTask<Void,Void,Void> asyncTask = new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                try {
                    entityController.delete(entity);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                if(readAfterOperation)
                    READ_DATA();
                else
                    getProgressDialog().dismiss();
                for (EntityController.OnFinishListener listener : listeners )
                    listener.onFinish();
            }
        };
        AsyncTaskController.runAsyncTask(this,asyncTask);
    }

    public final void DELETE(final T entity ,final EntityController.OnFinishListener ...listeners){
        DELETE(entity, true , listeners);
    }

    public void UPDATE(final T entity, final boolean readAfterOperation, final EntityController.OnFinishListener ...listeners){
        getProgressDialog().show();
        AsyncTask<Void,Void,Void> asyncTask = new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                try {
                    entityController.update(entity);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                if(readAfterOperation)
                    READ_DATA();
                else
                    getProgressDialog().dismiss();
                for (EntityController.OnFinishListener listener : listeners )
                    listener.onFinish();
            }
        };
        AsyncTaskController.runAsyncTask(this,asyncTask);
    }

    public final void UPDATE(final T entity ,final EntityController.OnFinishListener ...listeners){
        UPDATE(entity, true , listeners);
    }


    public void READ_DATA(){
        AsyncTaskController.runAsyncTask(this,new AsyncTask<Void, Void, List<T>>() {
            @Override
            protected List<T> doInBackground(Void... voids) {
                return onFetchData(getArguments());
            }
            @Override
            protected void onPostExecute(List<T> entityList) {
                recyclerAdapter.notifyDataSetChanged();
                /*if(progressDialog != null && progressDialog.isShowing())
                    getProgressDialog().dismiss();*/
                getParentActivity().hideProgressBar();
            }
        });
    }

}
