package com.ood.waterball.teampathy.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import com.ood.waterball.teampathy.Controllers.PageController;
import com.ood.waterball.teampathy.R;
import com.ood.waterball.teampathy.SinglePageArchitecture;

/**
 *  TabBaseFragment 代表著 FragmentPageAdapter 會 實體化的 依附在各個Tab的 Fragment
 */

public class TabBaseFragment extends ActivityBaseFragment implements SinglePageArchitecture{
    public static final String KEY = "homePagefragmentClass";
    private Fragment homePage;
    private PageController pageController;

    public TabBaseFragment() {
        // Required empty public constructor
    }

    public static TabBaseFragment getInstance(Class<? extends Fragment> homePagefragmentClass)  {
        /** Fragment 初始時要切換至首頁，因此傳遞該首頁的Class，之後用Reflection實體化
            然後傳遞至 PageController 中進行切換。
        */
        TabBaseFragment fragment = new TabBaseFragment();
        Bundle args = new Bundle();
        args.putSerializable(KEY,homePagefragmentClass);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    protected void onFetchData(@Nullable Bundle savedInstanceState, @Nullable Bundle arguBundle) {
        try {
            homePage = initiateHomePageFragment(arguBundle);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (java.lang.InstantiationException e) {
            e.printStackTrace();
        }
    }

    private Fragment initiateHomePageFragment(Bundle arguBundle) throws IllegalAccessException, java.lang.InstantiationException {
        Class<? extends Fragment> homePagefragmentClass = (Class<? extends Fragment>) arguBundle.getSerializable(KEY);
        return homePagefragmentClass.newInstance();
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_tab_base;
    }

    @Override
    protected void onFindViews(View parentView) {}

    @Override
    protected void onControlViews() {
        initiatePageController(homePage);
    }

    private void initiatePageController(Fragment fragment){
        pageController = new PageController(getFragmentManager(),R.id.tab_base_content_frame);
        pageController.changePage(fragment);
    }


    @Override
    public void changePage(Fragment fragment) {
        pageController.changePage(fragment);
    }
}
