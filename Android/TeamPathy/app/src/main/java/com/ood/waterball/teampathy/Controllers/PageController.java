package com.ood.waterball.teampathy.Controllers;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

import com.ood.waterball.teampathy.R;


public class PageController {

    private FragmentManager fragmentManager;

    public PageController(FragmentManager fragmentManager){
        this.fragmentManager = fragmentManager;
    };

    public void changePage(Fragment fragment){
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        String name = fragment.getClass().getName();

        fragmentTransaction.replace(R.id.base_interface_fragment_content , fragment , name);
        Log.d("myLog","Change Page to " + name);


        fragmentTransaction.commit();
        fragmentManager.executePendingTransactions();
    }

}
