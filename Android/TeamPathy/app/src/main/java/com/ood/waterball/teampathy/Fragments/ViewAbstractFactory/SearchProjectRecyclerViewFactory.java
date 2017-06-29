package com.ood.waterball.teampathy.Fragments.ViewAbstractFactory;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.ood.waterball.teampathy.DomainModels.Domains.Project;
import com.ood.waterball.teampathy.R;

import java.util.List;



public class SearchProjectRecyclerViewFactory extends RecyclerViewAbstractFactory<Project> {

    public SearchProjectRecyclerViewFactory(View rootView, List<Project> projects) {
        super(rootView, projects);
    }

    @Override
    protected RecyclerView createRecyclerView() {
        return (RecyclerView) rootView.findViewById(R.id.project_recycler_list_searchProjectDialog);
    }

    @Override
    protected RecyclerView.Adapter createRecyclerAdapter(List<Project> projects) {
        return new MyAdapter();
    }

    @Override
    protected RecyclerView.LayoutManager createLayoutManager() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        return layoutManager;
    }

    class MyAdapter extends RecyclerView.Adapter<MyViewHolder>{
        //todo item layout of recyclerview of search panel
        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return null;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return entityList.size();
        }
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        public MyViewHolder(View itemView) {
            super(itemView);
        }
    }
}
