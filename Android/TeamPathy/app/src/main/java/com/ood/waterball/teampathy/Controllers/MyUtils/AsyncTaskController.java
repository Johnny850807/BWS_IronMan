package com.ood.waterball.teampathy.Controllers.MyUtils;


import android.os.AsyncTask;
import android.os.Build;

public class AsyncTaskController {

    public static <T> AsyncTask<Void,Void,T> runAsyncTask(AsyncTask<Void,Void,T> task) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            return task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        } else {
            return task.execute();
        }
    }

}
