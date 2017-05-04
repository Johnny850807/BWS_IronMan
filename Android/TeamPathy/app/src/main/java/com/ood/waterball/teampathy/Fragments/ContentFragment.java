package com.ood.waterball.teampathy.Fragments;


import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.ood.waterball.teampathy.SinglePageArchitecture;

import static com.ood.waterball.teampathy.Controllers.MyLog.Log;

/**
 * 存放在 Single Base Fragment 中的 Fragment
 */

public abstract class ContentFragment extends ActivityBaseFragment {


    @Override
    protected SinglePageArchitecture getParentSinglePage(Context context) {
        FragmentManager fragmentManager = ((AppCompatActivity)context).getSupportFragmentManager();
        SinglePageArchitecture singlePageFragment =
                (SinglePageArchitecture) fragmentManager.findFragmentByTag(getFragmentName());
        Log(singlePageFragment.toString());
        return singlePageFragment;
    }

    protected abstract String getFragmentName();
}
