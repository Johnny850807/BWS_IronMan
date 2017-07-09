package com.ood.waterball.teampathy.Controllers.MyUtils;


import android.os.AsyncTask;
import android.os.Build;

import com.ood.waterball.teampathy.Fragments.Architecture.AsyncTemplateFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AsyncTaskController {
    private static Map<AsyncTemplateFragment,List<AsyncTask>> asyncTaskCache = new HashMap<>();
    public static <T> AsyncTask<Void,Void,T> runAsyncTask(AsyncTemplateFragment fragment, AsyncTask<Void, Void, T> task) {
        putAsyncTask(fragment,task);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            return task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        } else {
            return task.execute();
        }
    }

    private static <T> void putAsyncTask(AsyncTemplateFragment fragment, AsyncTask<Void, Void, T> task) {
        if ( asyncTaskCache.containsKey(fragment) )
            asyncTaskCache.get(fragment).add(task);
        else
            asyncTaskCache.put(fragment,new ArrayList<AsyncTask>());
    }

    public static void clearAsyncTask(AsyncTemplateFragment fragment){
        for ( AsyncTask asyncTask : asyncTaskCache.get(fragment) )
            asyncTask.cancel(true);
    }

}
