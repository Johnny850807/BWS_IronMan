package com.ood.waterball.teampathy;

/**
 *  單一Activity架構之公用介面
 */

import android.support.v4.app.Fragment;

public interface ParentActivityCallBack {
    public void changePage(Fragment fragment);
    public void finish();
    public void popPage();
    public void showProgressBar();
    public void hideProgressBar();
    public boolean isProgressBarShowing();
}
