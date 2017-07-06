package com.ood.waterball.teampathy.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import com.ood.waterball.teampathy.Controllers.Global;
import com.ood.waterball.teampathy.DomainModels.WBS.TaskGroup;
import com.ood.waterball.teampathy.DomainModels.WBS.TaskItem;
import com.ood.waterball.teampathy.DomainModels.WBS.TaskRoot;
import com.ood.waterball.teampathy.DomainModels.WBS.TodoTask;
import com.ood.waterball.teampathy.DomainModels.WBS.WbsVisitor;
import com.ood.waterball.teampathy.Fragments.Architecture.AsyncTemplateFragment;
import com.ood.waterball.teampathy.R;

import org.apmem.tools.layouts.FlowLayout;

import java.util.List;

import static com.ood.waterball.teampathy.Controllers.MyLog.Log;


public class TaskAnalysisFragment extends AsyncTemplateFragment<String> implements WbsVisitor {
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
        test();
    }

    private void test() {
        try {
            TaskItem taskRoot = createTestTaskRoot();
            for (TaskItem t : taskRoot)
                taskPanelView.addView(taskItemFactory.createItemView(t));
            Log(taskRoot.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private TaskItem createTestTaskRoot(){
        TaskItem root = new TaskRoot("TeamPathy");
        TaskGroup g1 = new TaskGroup(root.getName(),"G1");

        g1.addTaskChild(new TodoTask(g1.getName(),"t11",""));
        g1.addTaskChild(new TodoTask(g1.getName(),"t12",""));
        g1.addTaskChild(new TodoTask(g1.getName(),"t13",""));

        TaskGroup g2 = new TaskGroup(root.getName(),"G2");
        TaskGroup g21 = new TaskGroup(g2.getName(),"G21");
        TaskGroup g22 = new TaskGroup(g2.getName(),"G22");

        g2.addTaskChild(g21);
        g2.addTaskChild(g22);

        g21.addTaskChild(new TodoTask(g21.getName(),"t211",""));
        g21.addTaskChild(new TodoTask(g21.getName(),"t212",""));
        g22.addTaskChild(new TodoTask(g22.getName(),"t221",""));

        TaskGroup g3 = new TaskGroup(root.getName(),"G3");

        g3.addTaskChild(new TaskGroup(g3.getName(),"G31"));

        root.addTaskChild(g1);
        root.addTaskChild(g2);
        root.addTaskChild(g3);

        return root;
    }


    @Override
    public void taskViewOnClick(TaskGroup TaskGoup) {
        //todo show the options for choosing to add a task or to add a taskgroup

    }

    @Override
    public void taskViewOnClick(TodoTask task) {
        //todo show a dialog which shows the details of task item
        Toast.makeText(getContext(),task.getName(),Toast.LENGTH_LONG).show();
    }

    @Override
    public void taskViewOnLongClick(TaskGroup TaskGoup) {
        //todo show a dialog for editting the taskgroup
    }

    @Override
    public void taskViewOnLongClick(TodoTask task) {
        //todo show a dialog for editting the task item
    }
}
