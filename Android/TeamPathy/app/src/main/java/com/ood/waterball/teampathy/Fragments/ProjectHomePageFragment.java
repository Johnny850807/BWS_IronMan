package com.ood.waterball.teampathy.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.ood.waterball.teampathy.R;

public class ProjectHomePageFragment extends ContentFragment {

    public static ProjectHomePageFragment getInstance(String projectId){
        ProjectHomePageFragment fragment = new ProjectHomePageFragment();
        Bundle args = new Bundle();
        args.putString("projectId",projectId);
        fragment.setArguments(args);
        return fragment;
    }

    public ProjectHomePageFragment() {
        // Required empty public constructor
    }

    @Override
    protected void onFetchData(@Nullable Bundle savedInstanceState , @Nullable Bundle arguBundle) {
        String projectId = arguBundle.getString("projectId");
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_project_home_page;
    }

    @Override
    protected void onFindViews(View parentView) {

    }

    @Override
    protected void onControlViews() {

    }
}
