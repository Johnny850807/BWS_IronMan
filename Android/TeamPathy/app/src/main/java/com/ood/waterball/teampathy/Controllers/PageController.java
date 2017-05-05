package com.ood.waterball.teampathy.Controllers;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.util.Log;

import com.ood.waterball.teampathy.R;


public class PageController {
    private Context context;
    private FragmentManager fragmentManager;
    private int targetContainerId;

    public PageController(Context context, FragmentManager fragmentManager , int targetContainerId){
        this.fragmentManager = fragmentManager;
        this.targetContainerId = targetContainerId;
        this.context = context;
    };


    public void changePage(Fragment fragment, Transition enterTransition , Transition exitTransition){
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        String name = fragment.getClass().getName();

        fragmentTransaction.replace(targetContainerId , fragment , name);
        Log.d("myLog","Switch Page to " + name);

        if (enterTransition != null)
            fragment.setEnterTransition(enterTransition);
        if (exitTransition != null)
            fragment.setExitTransition(exitTransition);

        fragmentTransaction.addToBackStack(name);
        fragmentTransaction.commit();
    }

    public void changePage(Fragment fragment){
        Transition enterTransition = null;
        Transition exitTransition = null;

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
            enterTransition = TransitionInflater.from(context).inflateTransition(R.transition.auto_transition);
            exitTransition = fragment.setExitTransition(TransitionInflater.from(context).inflateTransition(R.transition.auto_transition);
        }

        changePage(fragment,enterTransition,exitTransition);
    }

}
