package com.ood.waterball.teampathy.Fragments.ViewAbstractFactory;


import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ood.waterball.teampathy.BaseActivity;
import com.ood.waterball.teampathy.Controllers.Global;
import com.ood.waterball.teampathy.DomainModels.Domains.Issue;
import com.ood.waterball.teampathy.Fragments.IssueDetailsFragment;
import com.ood.waterball.teampathy.R;

import java.util.List;

public class IssuesRecyclerViewFactory extends RecyclerViewAbstractFactory<Issue>{

    public IssuesRecyclerViewFactory(View rootView,List<Issue> issueList) {
        super(rootView,issueList);
    }

    @Override
    protected RecyclerView createRecyclerView() {
        return (RecyclerView) rootView.findViewById(R.id.issues_recyclerview_forum);
    }

    @Override
    protected RecyclerView.Adapter createRecyclerAdapter(List<Issue> issues) {
        return new MyRecyclerAdapter();
    }

    @Override
    protected RecyclerView.LayoutManager createLayoutManager() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        return layoutManager;
    }

    class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.MyViewHolder>{

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.issue_item, parent, false);

            return  new MyViewHolder(v);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            Issue issue = entityList.get(position);
            holder.titleTxt.setText(issue.getTitle());
            holder.typeTxt.setText(issue.getType().getName());
            holder.dateTxt.setText(Global.dateConvertStrategy.dateToTime(entityList.get(position).getPostDate()));
            holder.authorTxt.setText(issue.getPoster().getName());
        }

        @Override
        public int getItemCount() {
            return entityList.size();
        }

        class MyViewHolder extends  RecyclerView.ViewHolder{
            TextView titleTxt;
            TextView typeTxt;
            TextView dateTxt;
            TextView authorTxt;

            public MyViewHolder(View itemView) {
                super(itemView);
                titleTxt = (TextView) itemView.findViewById(R.id.title_text_issue_item);
                typeTxt = (TextView) itemView.findViewById(R.id.type_text_issue_item);
                dateTxt = (TextView) itemView.findViewById(R.id.datetime_text_issue_item);
                authorTxt = (TextView) itemView.findViewById(R.id.author_text_issue_item);

                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int position = getLayoutPosition();
                        Issue issue = entityList.get(position);
                        ((BaseActivity)context).changePage(IssueDetailsFragment.getInstance(issue));
                    }
                });
            }
        }
    }
}
