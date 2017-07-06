package com.ood.waterball.teampathy.Fragments.ViewAbstractFactory;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ood.waterball.teampathy.Controllers.Global;
import com.ood.waterball.teampathy.Controllers.MyUtils.DateConvertStrategy.DateConvertStrategy;
import com.ood.waterball.teampathy.DomainModels.WBS.TodoTask;
import com.ood.waterball.teampathy.R;

import java.util.List;


public class TodoListRecyclerViewFactory extends RecyclerViewAbstractFactory<TodoTask> {

    public TodoListRecyclerViewFactory(View rootView, List<TodoTask> list) {
        super(rootView, list);
    }

    @Override
    protected RecyclerView createRecyclerView() {
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerview_todolist);
        recyclerView.setNestedScrollingEnabled(false);
        return recyclerView;
    }

    @Override
    protected RecyclerView.Adapter createRecyclerAdapter(List list) {
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
            View v = LayoutInflater.from(context).inflate(R.layout.todotask_item,parent,false);
            return new MyViewHolder(v);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            setupViewHolder(holder,position);
        }

        private void setupViewHolder(MyViewHolder holder,int position)
        {
            TodoTask todoTask = entityList.get(position);
            holder.nameTxt.setText(todoTask.getName());
            DateConvertStrategy dateConvertStrategy = Global.dateConvertStrategy;
            String startDate = dateConvertStrategy.dateToTime(todoTask.getStartDate());
            String endDate = dateConvertStrategy.dateToTime(todoTask.getEndDate());

            holder.startdateTxt.setText(startDate);
            holder.enddateTxt.setText(endDate);
            holder.groupTxt.setText(todoTask.getOfGroupName());
        }

        @Override
        public int getItemCount() {
            return entityList.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder{
            View view;
            TextView nameTxt;
            TextView startdateTxt;
            TextView enddateTxt;
            TextView groupTxt;
            MyViewHolder(View itemView) {
                super(itemView);
                view = itemView;
                nameTxt = (TextView) itemView.findViewById(R.id.name_todotask_item);
                startdateTxt = (TextView) itemView.findViewById(R.id.startdate_todotask_item);
                enddateTxt = (TextView) itemView.findViewById(R.id.enddate_todotask_item);
                groupTxt = (TextView) itemView.findViewById(R.id.group_todotask_item);
            }
        }
    }
}
