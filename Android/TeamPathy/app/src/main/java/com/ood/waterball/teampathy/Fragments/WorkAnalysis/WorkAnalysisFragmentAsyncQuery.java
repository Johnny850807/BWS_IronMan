package com.ood.waterball.teampathy.Fragments.WorkAnalysis;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.ood.waterball.teampathy.Domains.Issue;
import com.ood.waterball.teampathy.Fragments.Fragmenttt;
import com.ood.waterball.teampathy.R;

import java.util.List;

public class WorkAnalysisFragmentAsyncQuery extends Fragmenttt {

    private List<Issue> issueList;

    public static WorkAnalysisFragmentAsyncQuery getInstance(String projectId){
        WorkAnalysisFragmentAsyncQuery fragment = new WorkAnalysisFragmentAsyncQuery();
        Bundle args = new Bundle();
        args.putString("projectId",projectId);
        fragment.setArguments(args);
        return fragment;
    }


    public WorkAnalysisFragmentAsyncQuery() {
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
