package com.ood.waterball.teampathy.Fragments;

import android.os.AsyncTask;

import com.ood.waterball.teampathy.Controllers.EntityControllers.EntityController;
import com.ood.waterball.teampathy.Controllers.MyUtils.AsyncTaskController;

public abstract class AsyncQueryRecyclerFragment<T> extends RecyclerViewFragment<T> {
    protected EntityController entityController = createEntityController();

    protected abstract EntityController createEntityController();

    protected final void CREATE(T entity , EntityController.OnFinishListener ...listeners){
        AsyncTask<Void,Void,Void> asyncTask = new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                entityController.create(entity);
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                QUERY();
                for (EntityController.OnFinishListener listener : listeners )
                    listener.onFinish();
            }
        };
        AsyncTaskController.runAsyncTask(asyncTask);
    }

    protected void DELETE(T entity,EntityController.OnFinishListener ...listeners){
        AsyncTask<Void,Void,Void> asyncTask = new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                entityController.delete(entity);
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                QUERY();
                for (EntityController.OnFinishListener listener : listeners )
                    listener.onFinish();
            }
        };
        AsyncTaskController.runAsyncTask(asyncTask);
        QUERY();
    }

    protected void UPDATE(T entity,EntityController.OnFinishListener ...listeners){
        AsyncTask<Void,Void,Void> asyncTask = new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                entityController.update(entity);
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                QUERY();
                for (EntityController.OnFinishListener listener : listeners )
                    listener.onFinish();
            }
        };
        AsyncTaskController.runAsyncTask(asyncTask);
        QUERY();
    }


    protected void QUERY(){
        onFetchData(getArguments());
        recyclerAdapter.notifyDataSetChanged();
    }

}
