package com.ood.waterball.teampathy.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.ood.waterball.teampathy.Controllers.Global;
import com.ood.waterball.teampathy.Domains.Issue;
import com.ood.waterball.teampathy.R;

import java.util.List;

import static com.ood.waterball.teampathy.Controllers.MyLog.Log;

public class ForumFragment extends ContentFragment {

    private List<Issue> issueList;

    public static ForumFragment getInstance(String projectId){
        ForumFragment fragment = new ForumFragment();
        Bundle args = new Bundle();
        args.putString("projectId",projectId);
        fragment.setArguments(args);
        return fragment;
    }


    public ForumFragment() {
        // Required empty public constructor
        //todo 更換正確id
    }

    @Override
    protected String getFragmentName() {
        return ProjectHomePageFragment.TabFragmentPageAdapter.class.getName()+ ProjectHomePageFragment.TabFragmentPageAdapter.FORUM;
    }

    @Override
    protected void onFetchData(@Nullable Bundle savedInstanceState, @Nullable Bundle arguBundle) {
        try {
            String projectId = arguBundle.getString("projectId");
            Log(projectId);
            issueList = Global.getTeamPathyFacade().getAllIssuesByProjectId(projectId);
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

    }

    @Override
    protected void onControlViews() {

    }

}
