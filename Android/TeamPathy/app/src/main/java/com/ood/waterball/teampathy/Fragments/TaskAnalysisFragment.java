package com.ood.waterball.teampathy.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.ood.waterball.teampathy.Fragments.Architecture.AsyncTemplateFragment;

import java.util.List;


public class TaskAnalysisFragment extends AsyncTemplateFragment<String> {

    public static TaskAnalysisFragment getInstance(int projectId){
        TaskAnalysisFragment fragment = new TaskAnalysisFragment();
        Bundle args = new Bundle();
        args.putInt("projectId",projectId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutResource() {
        return 0;
    }

    @Override
    protected List<String> onFetchData(@Nullable Bundle arguBundle) {
        return null;
    }

    @Override
    protected void onFindViews(View parentView, List<String> entityList) {

    }

    @Override
    protected void onControlViews() {

    }
}
