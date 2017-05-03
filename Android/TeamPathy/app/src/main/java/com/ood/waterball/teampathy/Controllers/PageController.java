package com.ood.waterball.teampathy.Controllers;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;


public class PageController {

    private FragmentManager fragmentManager;
    private int contentId;

    public PageController(FragmentManager fragmentManager , int contentId){
        this.fragmentManager = fragmentManager;
        this.contentId = contentId;
    };

    public void changePage(Fragment fragment){
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        String name = fragment.getClass().getName();

        fragmentTransaction.replace(contentId , fragment , name);
        Log.d("myLog","Change Page to " + name);


        fragmentTransaction.commit();
        fragmentManager.executePendingTransactions();
    }

}
