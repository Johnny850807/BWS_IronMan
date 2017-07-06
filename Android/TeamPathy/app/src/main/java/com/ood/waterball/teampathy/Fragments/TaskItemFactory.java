package com.ood.waterball.teampathy.Fragments;


import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ood.waterball.teampathy.DomainModels.WBS.TaskItem;
import com.ood.waterball.teampathy.DomainModels.WBS.WbsVisitor;
import com.ood.waterball.teampathy.R;

import org.apmem.tools.layouts.FlowLayout;

public class TaskItemFactory {
    private Context context;
    private WbsVisitor visitor;
    private FlowLayout flowLayout;

    public TaskItemFactory(Context context, WbsVisitor visitor, FlowLayout flowLayout) {
        this.context = context;
        this.visitor = visitor;
        this.flowLayout = flowLayout;
    }

    public View createItemView(@NonNull TaskItem taskItem){
        View itemView = LayoutInflater.from(context).inflate(R.layout.task_analysis_item,flowLayout,false);
        TextView nameTxt = (TextView) itemView.findViewById(R.id.name_taskItem);
        TextView ofGroupTxt = (TextView) itemView.findViewById(R.id.ofGroup_taskItem);
        ImageView addImg = (ImageView) itemView.findViewById(R.id.add_img_taskItem);
        nameTxt.setText(taskItem.getName());
        ofGroupTxt.setText(taskItem.getOfGroupName());
        if (!taskItem.hasChild())
            addImg.setVisibility(View.GONE);

        setAddChildWhenClick(itemView,taskItem);
        setEditWhenLongClick(itemView,taskItem);
        return itemView;
    }

    private void setAddChildWhenClick(View view,final TaskItem taskItem){
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                taskItem.onClick(TaskItemFactory.this.visitor);
            }
        });
    }

    private void setEditWhenLongClick(View view, final TaskItem taskItem){
        view.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                taskItem.onLongClick(TaskItemFactory.this.visitor);
                return false;
            }
        });
    }


}
