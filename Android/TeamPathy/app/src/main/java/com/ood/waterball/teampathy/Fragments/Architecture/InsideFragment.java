package com.ood.waterball.teampathy.Fragments.Architecture;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.ood.waterball.teampathy.ParentActivityCallBack;

/**
 *  Context: A fragment which is inside a single activity architecture.
 */

public class InsideFragment extends Fragment {

    protected ParentActivityCallBack parentActivityCallBack;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof ParentActivityCallBack) {
            parentActivityCallBack = getParentSinglePage(context); //取得 Base Activity
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement ParentActivityCallBack");
        }
    }

    protected ParentActivityCallBack getParentSinglePage(Context context){
        return (ParentActivityCallBack) context;
    }

    protected ParentActivityCallBack getParentActivity(){
        return parentActivityCallBack;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        parentActivityCallBack = null;
    }

}
