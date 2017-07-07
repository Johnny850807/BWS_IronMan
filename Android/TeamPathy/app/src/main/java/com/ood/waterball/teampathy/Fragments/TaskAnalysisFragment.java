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
import com.ood.waterball.teampathy.DomainModels.WBS.XmlTranslator;
import com.ood.waterball.teampathy.DomainModels.WBS.XmlTranslatorImp;
import com.ood.waterball.teampathy.Fragments.Architecture.AsyncTemplateFragment;
import com.ood.waterball.teampathy.R;

import org.apmem.tools.layouts.FlowLayout;

import java.util.List;

import static com.ood.waterball.teampathy.Controllers.MyLog.Log;


public class TaskAnalysisFragment extends AsyncTemplateFragment<String> implements WbsVisitor {
    private int projectId;
    private FlowLayout taskPanelView;
    private XmlTranslator xmlTranslator = new XmlTranslatorImp();
    private TaskItem taskRoot;
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
            taskRoot = xmlTranslator.xmlToTasks(wbsXml);
            Log(xmlTranslator.taskToXml(taskRoot));
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
            for (TaskItem t : taskRoot)
                taskPanelView.addView(taskItemFactory.createItemView(t));

            Log(taskRoot.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private TaskItem createTestTaskRoot(){
        TaskItem teampathy = new TaskRoot("TeamPathy");
        TaskGroup 設計 = new TaskGroup(teampathy.getName(),"設計");
        TaskGroup 實作 = new TaskGroup(teampathy.getName(),"實作");
        TaskGroup 文案 = new TaskGroup(teampathy.getName(),"文案");

        teampathy.addTaskChild(設計);
        teampathy.addTaskChild(實作);
        teampathy.addTaskChild(文案);

        TaskGroup 系統設計 = new TaskGroup(設計.getName(),"系統分析");
        TaskGroup 介面設計 = new TaskGroup(設計.getName(),"介面設計");

        設計.addTaskChild(系統設計);
        設計.addTaskChild(介面設計);

        系統設計.addTaskChild(new TodoTask(系統設計.getName(),"類別圖設計",""));
        系統設計.addTaskChild(new TodoTask(系統設計.getName(),"ER Model 設計",""));

        TaskGroup 前端 = new TaskGroup(實作.getName(),"前端");
        TaskGroup 後端 = new TaskGroup(實作.getName(),"後端");

        實作.addTaskChild(前端);
        實作.addTaskChild(後端);

        前端.addTaskChild(new TodoTask(實作.getName(),"Android 開發",""));
        前端.addTaskChild(new TodoTask(實作.getName(),"推播通知",""));
        前端.addTaskChild(new TodoTask(實作.getName(),"XML to WBS",""));

        後端.addTaskChild(new TodoTask(實作.getName(),"ASP.Net MVC 開發",""));
        後端.addTaskChild(new TodoTask(實作.getName(),"Access Token 安全性設置",""));

        文案.addTaskChild(new TodoTask(文案.getName(),"初審文件",""));
        文案.addTaskChild(new TodoTask(文案.getName(),"總審文件",""));
        文案.addTaskChild(new TodoTask(文案.getName(),"總審PPT",""));

        return teampathy;
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
