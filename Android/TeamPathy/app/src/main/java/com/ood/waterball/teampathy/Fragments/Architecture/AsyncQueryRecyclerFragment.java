package com.ood.waterball.teampathy.Fragments.Architecture;

import android.os.AsyncTask;

import com.ood.waterball.teampathy.Controllers.EntityControllers.EntityController;
import com.ood.waterball.teampathy.Controllers.MyUtils.AsyncTaskController;
import com.ood.waterball.teampathy.Domains.Entity;

public abstract class AsyncQueryRecyclerFragment<T extends Entity> extends RecyclerViewFragment<T> {
    protected EntityController<T> entityController = createEntityController();

    protected abstract EntityController<T> createEntityController();

    protected final void CREATE(final T entity , final EntityController.OnFinishListener ...listeners){
        AsyncTask<Void,Void,Void> asyncTask = new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                try {
                    entityController.create(entity);
                } catch (Exception e) {
                    e.printStackTrace();
                }
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

    protected void DELETE(final T entity, final EntityController.OnFinishListener ...listeners){
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
                QUERY();
                for (EntityController.OnFinishListener listener : listeners )
                    listener.onFinish();
            }
        };
        AsyncTaskController.runAsyncTask(asyncTask);
        QUERY();
    }

    protected void UPDATE(final T entity, final EntityController.OnFinishListener ...listeners){
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
