package com.ood.waterball.teampathy.Controllers;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;


public class PageController {

    private FragmentManager fragmentManager;
    private int targetContainerId;

    public PageController(FragmentManager fragmentManager , int targetContainerId){
        this.fragmentManager = fragmentManager;
        this.targetContainerId = targetContainerId;
    };

    public void changePage(Fragment fragment){
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        String name = fragment.getClass().getName();

        fragmentTransaction.replace(targetContainerId , fragment , name);
        Log.d("myLog","更換頁面至 to " + name);

        fragmentTransaction.addToBackStack(name);
        fragmentTransaction.commit();
    }

}
