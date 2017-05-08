package com.ood.waterball.teampathy.Fragments.ViewAbstractFactory;


import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ood.waterball.teampathy.BaseActivity;
import com.ood.waterball.teampathy.Domains.Project;
import com.ood.waterball.teampathy.Fragments.HomePage.ProjectHomePageFragment;
import com.ood.waterball.teampathy.R;

import java.util.List;

public class ProjectGridRecyclerViewFactory extends RecyclerViewAbstractFactory<Project>{
    private static final int NUM_OS_COL = 3;
    private String userId;

    public ProjectGridRecyclerViewFactory(View rootView,List<Project>projectList) {
        super(rootView,projectList);
    }


    @Override
    protected RecyclerView createRecyclerView() {
        return (RecyclerView) rootView.findViewById(R.id.projectGridMemberHomePage);
    }

    @Override
    protected RecyclerView.Adapter createRecyclerAdapter(List<Project> projectList) {
        return new RecyclerView.Adapter<MyViewHolder>() {
            @Override
            public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                View v = LayoutInflater.from(context).inflate(R.layout.project_item,parent,false);
                return new MyViewHolder(v);
            }

            @Override
            public void onBindViewHolder(MyViewHolder holder, int position) {
                final Project project = entityList.get(position);

                Glide.with(context)
                        .load(project.getImageUrl())
                        .into(holder.image);

                holder.text.setText(project.getName());
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String projectId = project.getId();
                        ((BaseActivity)context).changePage( ProjectHomePageFragment.getInstance(projectId) );
                    }
                });
            }

            @Override
            public int getItemCount() {
                return entityList.size();
            }
        };
    }

    private class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView text;
        MyViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.img_projectItem);
            text = (TextView) itemView.findViewById(R.id.name_projectItem);

        }
    }

    @Override
    protected RecyclerView.LayoutManager createLayoutManager() {
        return new GridLayoutManager(context,NUM_OS_COL);
    }

}
