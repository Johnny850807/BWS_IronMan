package com.ood.waterball.teampathy.Fragments.WorkAnalysis;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.ood.waterball.teampathy.Domains.Issue;
import com.ood.waterball.teampathy.Fragments.ActivityBaseFragment;
import com.ood.waterball.teampathy.R;

import java.util.List;

public class WorkAnalysisFragment extends ActivityBaseFragment {

    private List<Issue> issueList;

    public static WorkAnalysisFragment getInstance(String projectId){
        WorkAnalysisFragment fragment = new WorkAnalysisFragment();
        Bundle args = new Bundle();
        args.putString("projectId",projectId);
        fragment.setArguments(args);
        return fragment;
    }


    public WorkAnalysisFragment() {
        // Required empty public constructor
        //todo 更換正確id
    }

    @Override
    protected void onFetchData(@Nullable Bundle savedInstanceState, @Nullable Bundle arguBundle) {

    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_work_analysis_page;
    }

    @Override
    protected void onFindViews(View parentView) {

    }

    @Override
    protected void onControlViews() {

    }

}
