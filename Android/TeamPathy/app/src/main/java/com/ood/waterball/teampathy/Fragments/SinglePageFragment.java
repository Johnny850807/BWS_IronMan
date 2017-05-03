package com.ood.waterball.teampathy.Fragments;


import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.ood.waterball.teampathy.R;
import com.ood.waterball.teampathy.SinglePageArchitecture;

import static com.ood.waterball.teampathy.Controllers.MyLog.Log;

public abstract class SinglePageFragment extends ContentFragment{
    @Override
    protected SinglePageArchitecture getParentSinglePage(Context context) {
        FragmentManager fragmentManager = ((AppCompatActivity)context).getSupportFragmentManager();
        SinglePageArchitecture singlePageFragment =
                (SinglePageArchitecture) fragmentManager.findFragmentById(R.id.base_interface_fragment_content);
        Log(singlePageFragment.toString());
        return singlePageFragment;
    }
}
