package com.ood.waterball.teampathy.Fragments;


import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ood.waterball.teampathy.DomainModels.Domains.TodoTask;
import com.ood.waterball.teampathy.R;

import org.apmem.tools.layouts.FlowLayout;

public class TaskItemFactory {
    private Context context;
    private TaskAnalysisFragment fragment;
    private FlowLayout flowLayout;

    public TaskItemFactory(Context context, TaskAnalysisFragment fragment, FlowLayout flowLayout) {
        this.context = context;
        this.fragment = fragment;
        this.flowLayout = flowLayout;
    }

    public View createItemView(@NonNull TodoTask todoTask){
        View itemView = LayoutInflater.from(context).inflate(R.layout.task_analysis_item,flowLayout,false);
        TextView nameTxt = (TextView) itemView.findViewById(R.id.name_taskItem);
        TextView ofGroupTxt = (TextView) itemView.findViewById(R.id.ofGroup_taskItem);
        ImageView addImg = (ImageView) itemView.findViewById(R.id.add_img_taskItem);
        nameTxt.setText(todoTask.getName());
        ofGroupTxt.setText(todoTask.getOfGroupName());
        //if (!todoTask.hasChild())
            //addImg.setVisibility(View.GONE);

        setAddChildWhenClick(itemView,todoTask);
        setEditWhenLongClick(itemView,todoTask);
        return itemView;
    }

    private void setAddChildWhenClick(View view,final TodoTask todoTask){
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragment.addChildTask(todoTask);
            }
        });
    }

    private void setEditWhenLongClick(View view, final TodoTask todoTask){
        view.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                fragment.editChildTask(todoTask);
                return false;
            }
        });
    }


}
