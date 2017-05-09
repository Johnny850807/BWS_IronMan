package com.ood.waterball.teampathy.Fragments.ViewAbstractFactory;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ood.waterball.teampathy.Controllers.Global;
import com.ood.waterball.teampathy.Controllers.MyUtils.DateConvertStrategy.DateConvertStrategy;
import com.ood.waterball.teampathy.DomainModels.Domains.TodoTask;
import com.ood.waterball.teampathy.R;

import java.util.List;


public class TodoListRecyclerViewFactory extends RecyclerViewAbstractFactory<TodoTask> {

    public TodoListRecyclerViewFactory(View rootView, List<TodoTask> list) {
        super(rootView, list);
    }

    @Override
    protected RecyclerView createRecyclerView() {
        return (RecyclerView) rootView.findViewById(R.id.recyclerview_todolist);
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
            TodoTask todoTask = entityList.get(position);
            holder.nameTxt.setText(todoTask.getName());
            DateConvertStrategy dateConvertStrategy = Global.dateConvertStrategy;
            String dateString = Global.resources.getString(R.string.task_start_date) + ": " +
                    dateConvertStrategy.dateToTime(todoTask.getStartDate()) + "\n" +
                    Global.resources.getString(R.string.task_end_date) + ": " +
                    dateConvertStrategy.dateToTime(todoTask.getEndDate());

            holder.dateTxt.setText(dateString);
            holder.groupTxt.setText(todoTask.getGroupName());
        }

        @Override
        public int getItemCount() {
            return entityList.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder{
            View view;
            TextView nameTxt;
            TextView dateTxt;
            TextView groupTxt;
            MyViewHolder(View itemView) {
                super(itemView);
                view = itemView;
                nameTxt = (TextView) itemView.findViewById(R.id.name_todotask_item);
                dateTxt = (TextView) itemView.findViewById(R.id.date_todotask_item);
                groupTxt = (TextView) itemView.findViewById(R.id.group_todotask_item);
            }
        }
    }
}
