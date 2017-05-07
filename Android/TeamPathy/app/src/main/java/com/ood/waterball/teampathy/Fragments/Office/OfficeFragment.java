package com.ood.waterball.teampathy.Fragments.Office;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.ood.waterball.teampathy.Domains.Issue;
import com.ood.waterball.teampathy.Fragments.EntityAsyncCRUDFragment;
import com.ood.waterball.teampathy.R;

import java.util.List;

public class OfficeFragment extends EntityAsyncCRUDFragment {

    private List<Issue> issueList;

    public static OfficeFragment getInstance(String projectId){
        OfficeFragment fragment = new OfficeFragment();
        Bundle args = new Bundle();
        args.putString("projectId",projectId);
        fragment.setArguments(args);
        return fragment;
    }


    public OfficeFragment() {
        // Required empty public constructor
        //todo 更換正確id
    }

    @Override
    protected void onFetchData(@Nullable Bundle savedInstanceState, @Nullable Bundle arguBundle) {

    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_office_page;
    }

    @Override
    protected void onFindViews(View parentView) {

    }

    @Override
    protected void onControlViews() {

    }


}
