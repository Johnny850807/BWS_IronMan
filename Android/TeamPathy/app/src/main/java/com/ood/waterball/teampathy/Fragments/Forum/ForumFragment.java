package com.ood.waterball.teampathy.Fragments.Forum;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ood.waterball.teampathy.Controllers.Global;
import com.ood.waterball.teampathy.Domains.Issue;
import com.ood.waterball.teampathy.Fragments.ActivityBaseFragment;
import com.ood.waterball.teampathy.R;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static com.ood.waterball.teampathy.Controllers.MyLog.Log;

public class ForumFragment extends ActivityBaseFragment {
    private List<Issue> issueList;
    private FloatingActionButton fab;

    private RecyclerView issueRecyclerView;
    private MyRecyclerAdapter recyclerAdapter;
    public static ForumFragment getInstance(String projectId){
        ForumFragment fragment = new ForumFragment();
        Bundle args = new Bundle();
        args.putString("projectId",projectId);
        fragment.setArguments(args);
        return fragment;
    }


    public ForumFragment() {
        // Required empty public constructor
    }

    @Override
    protected void onFetchData(@Nullable Bundle savedInstanceState, @Nullable Bundle arguBundle) {
        try {
            String projectId = (String) arguBundle.get("projectId");
            issueList = Global.getTeamPathyFacade().getAllIssuesByProjectId(projectId);
            Log("文章數量:" + issueList.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_forum_page;
    }

    @Override
    protected void onFindViews(View parentView) {
        issueRecyclerView = (RecyclerView) parentView.findViewById(R.id.issues_recyclerview_forum);
        fab = (FloatingActionButton) parentView.findViewById(R.id.fab_forum);
    }

    @Override
    protected void onControlViews() {
        recyclerAdapter = new MyRecyclerAdapter();
        issueRecyclerView.setAdapter(recyclerAdapter);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        issueRecyclerView.setLayoutManager(layoutManager);
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
            holder.titleTxt.setText(issueList.get(position).getTitle());
            holder.typeTxt.setText(issueList.get(position).getType());
            holder.dateTxt.setText(convertDateToString(issueList.get(position).getDatetime()));
            holder.authorTxt.setText(issueList.get(position).getPoster().getName());
        }

        private String convertDateToString(Date datetime){
            String[] monthNames = getResources().getStringArray(R.array.month_names);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(datetime);
            String date = String.valueOf(calendar.get(Calendar.DATE));
            String month = monthNames[(calendar.get(Calendar.MONTH))];
            String year = String.valueOf(calendar.get(Calendar.YEAR));
            return year + " " + date + " " + month;
        }

        @Override
        public int getItemCount() {
            return issueList.size();
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
            }
        }
    }

}
