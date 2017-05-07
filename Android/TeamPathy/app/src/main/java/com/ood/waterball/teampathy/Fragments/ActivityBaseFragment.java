package com.ood.waterball.teampathy.Fragments;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.ood.waterball.teampathy.SinglePageArchitecture;


public class ActivityBaseFragment extends Fragment {

    protected SinglePageArchitecture singlePage;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof SinglePageArchitecture) {
            singlePage = getParentSinglePage(context); //取得 Base Activity
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement SinglePageArchitecture");
        }
    }

    protected SinglePageArchitecture getParentSinglePage(Context context){
        SinglePageArchitecture singlePageArchitecture = (SinglePageArchitecture) context;
        //Log("根頁面: " + singlePageArchitecture.getPageName());
        return singlePageArchitecture;
    }

    protected SinglePageArchitecture getSinglePage(){
        return singlePage;
    }


    @Override
    public void onDetach() {
        super.onDetach();
        singlePage = null;
    }

}
