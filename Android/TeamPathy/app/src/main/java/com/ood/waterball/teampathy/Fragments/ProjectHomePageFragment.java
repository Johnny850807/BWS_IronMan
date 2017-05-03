package com.ood.waterball.teampathy.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import com.ood.waterball.teampathy.Controllers.Global;
import com.ood.waterball.teampathy.Controllers.PageController;
import com.ood.waterball.teampathy.Domains.Project;
import com.ood.waterball.teampathy.R;
import com.ood.waterball.teampathy.SinglePageArchitecture;

import static com.ood.waterball.teampathy.Controllers.MyLog.Log;

public class ProjectHomePageFragment extends ContentFragment implements SinglePageArchitecture{

    private PageController pageController;
    private Project currentProject;

    public static ProjectHomePageFragment getInstance(String projectId){
        ProjectHomePageFragment fragment = new ProjectHomePageFragment();
        Bundle args = new Bundle();
        args.putString("projectId",projectId);
        fragment.setArguments(args);
        return fragment;
    }

    public ProjectHomePageFragment() {
        // Required empty public constructor
    }

    @Override
    protected void onFetchData(@Nullable Bundle savedInstanceState , @Nullable Bundle arguBundle) {
        try {
            onPageInitiate();
            String projectId = arguBundle.getString("projectId");
            Log(projectId);
            currentProject = Global.getTeamPathyFacade().getProjectById(projectId);
            Log(currentProject.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void onPageInitiate(){
        pageController = new PageController(getFragmentManager(),R.id.viewpager_project_home);
        pageController.changePage(ForumFragment.getInstance(currentProject.getId()));
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_project_home_page;
    }

    @Override
    protected void onFindViews(View parentView) {

    }

    @Override
    protected void onControlViews() {

    }

    @Override
    public void changePage(Fragment fragment) {
        pageController.changePage(fragment);
    }
}
