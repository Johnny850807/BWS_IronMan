package com.ood.waterball.teampathy.Fragments.Forum;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.ood.waterball.teampathy.Domains.Issue;
import com.ood.waterball.teampathy.Fragments.ActivityBaseFragment;
import com.ood.waterball.teampathy.R;

import java.util.List;

public class ForumFragment extends ActivityBaseFragment {

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
    protected void onFetchData(@Nullable Bundle savedInstanceState, @Nullable Bundle arguBundle) {

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
