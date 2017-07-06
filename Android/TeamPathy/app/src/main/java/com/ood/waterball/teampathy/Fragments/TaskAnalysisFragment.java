package com.ood.waterball.teampathy.Fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.ood.waterball.teampathy.Controllers.Global;
import com.ood.waterball.teampathy.DomainModels.Domains.TaskItem;
import com.ood.waterball.teampathy.Fragments.Architecture.AsyncTemplateFragment;
import com.ood.waterball.teampathy.R;

import org.apmem.tools.layouts.FlowLayout;

import java.util.List;


public class TaskAnalysisFragment extends AsyncTemplateFragment<String> {
    private int projectId;
    private FlowLayout taskPanelView;
    private String wbsXml;
    private TaskItemFactory taskItemFactory;

    public static TaskAnalysisFragment getInstance(int projectId){
        TaskAnalysisFragment fragment = new TaskAnalysisFragment();
        Bundle args = new Bundle();
        args.putInt("projectId",projectId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_task_analysis;
    }

    @Override
    protected List<String> onFetchData(@Nullable Bundle arguBundle) {
        try {
            projectId = arguBundle.getInt("projectId");
            wbsXml = Global.getOfficeController().getTaskAnalysis(projectId);
            //todo convert xml to todo Nodes structure
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;  // here we need no list just only to get the xml string
    }

    @Override
    protected void onFindViews(View parentView, List<String> entityList) {
        taskPanelView = (FlowLayout) parentView.findViewById(R.id.panel_flowlayout_taskAnalysis);
    }

    @Override
    protected void onControlViews() {
        taskItemFactory = new TaskItemFactory(getContext(),this,taskPanelView);
    }

    public void addChildTask(@NonNull TaskItem taskItem){
        //todo add child when click the task item view
    }

    public void editChildTask(@NonNull TaskItem taskItem){
        //todo edit when long click the task item view
    }
}
