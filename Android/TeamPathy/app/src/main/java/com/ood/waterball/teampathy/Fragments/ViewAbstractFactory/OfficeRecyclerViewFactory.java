package com.ood.waterball.teampathy.Fragments.ViewAbstractFactory;


import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ood.waterball.teampathy.Controllers.MyUtils.GlideHelper;
import com.ood.waterball.teampathy.DomainModels.Domains.Member;
import com.ood.waterball.teampathy.DomainModels.Domains.TodoTask;
import com.ood.waterball.teampathy.DomainModels.Models.MemberIdCardModel;
import com.ood.waterball.teampathy.R;

import java.util.List;

public class OfficeRecyclerViewFactory extends RecyclerViewAbstractFactory<MemberIdCardModel>{

    public OfficeRecyclerViewFactory(View rootView, List<MemberIdCardModel> memberIdCardModels) {
        super(rootView, memberIdCardModels);
    }

    @Override
    protected RecyclerView createRecyclerView() {
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.member_recycler_card_office);
        recyclerView.setNestedScrollingEnabled(false);
        return recyclerView;
    }

    @Override
    protected RecyclerView.Adapter createRecyclerAdapter(List<MemberIdCardModel> memberIdCardModels) {
        return new MyAdapter();
    }

    @Override
    protected RecyclerView.LayoutManager createLayoutManager() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        return layoutManager;
    }

    class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(context).inflate(R.layout.member_id_card_item,parent,false);
            return new MyViewHolder(v);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            MemberIdCardModel cardModel = entityList.get(position);
            Member member = cardModel.getMember();
            TodoTask todoTask = cardModel.getTodoTask();
            GlideHelper.loadToCircularImage(context,holder.headImg,member.getImageUrl());
            holder.nameTxt.setText( member.getName());
            holder.positionTxt.setText(member.getPosition());
            holder.taskNameTxt.setText(todoTask.getName());
            holder.taskGroupTxt.setText(todoTask.getGroupName());
        }

        @Override
        public int getItemCount() {
            return entityList.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder{
            ImageView headImg;
            TextView nameTxt;
            TextView positionTxt;
            TextView taskNameTxt;
            TextView taskGroupTxt;
            public MyViewHolder(View itemView) {
                super(itemView);
                headImg = (ImageView) itemView.findViewById(R.id.member_head_icon_id_card_item);
                nameTxt = (TextView) itemView.findViewById(R.id.member_name_id_card_item);
                positionTxt = (TextView) itemView.findViewById(R.id.member_position_id_card_item);
                taskNameTxt = (TextView) itemView.findViewById(R.id.member_current_task_name_id_card_item);
                taskGroupTxt = (TextView) itemView.findViewById(R.id.member_current_task_groupname_id_card_item);
            }
        }

        @Override
        public void onViewDetachedFromWindow(MyViewHolder holder) {
            super.onViewDetachedFromWindow(holder);
        }
    }
}
