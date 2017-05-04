package com.ood.waterball.teampathy.Fragments.HomePage;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.ood.waterball.teampathy.Controllers.Global;
import com.ood.waterball.teampathy.Domains.Project;
import com.ood.waterball.teampathy.Domains.ProjectSection;
import com.ood.waterball.teampathy.Fragments.ActivityBaseFragment;
import com.ood.waterball.teampathy.Fragments.Forum.ForumFragment;
import com.ood.waterball.teampathy.Fragments.Office.OfficeFragment;
import com.ood.waterball.teampathy.Fragments.TodoList.TodoListFragment;
import com.ood.waterball.teampathy.Fragments.WorkAnalysis.WorkAnalysisFragment;
import com.ood.waterball.teampathy.R;

import static com.ood.waterball.teampathy.Controllers.MyLog.Log;

public class ProjectHomePageFragment extends ActivityBaseFragment {
    private ViewPager viewPager;
    private TabLayout tabLayout;
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
            fetchCurrentProject(arguBundle);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void fetchCurrentProject(Bundle arguBundle) throws Exception {
        String projectId = arguBundle.getString("projectId");
        Log(projectId);
        currentProject = Global.getTeamPathyFacade().getProjectById(projectId);
        Log(currentProject.toString());
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_project_home_page;
    }

    @Override
    protected void onFindViews(View parentView) {
        viewPager = (ViewPager) parentView.findViewById(R.id.viewpager_project_home);
        tabLayout = (TabLayout) parentView.findViewById(R.id.tablayout_poject_home);
    }

    @Override
    protected void onControlViews() {
        initiateViewPager();
    }


    private void initiateViewPager(){
        viewPager.setAdapter(new MyFragmentPageAdapter(getChildFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);
    }

     class MyFragmentPageAdapter extends FragmentPagerAdapter{

        private final String[] projectSections;

        public MyFragmentPageAdapter(FragmentManager fm) {
            super(fm);
            projectSections = getResources().getStringArray(R.array.project_sections);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            super.getPageTitle(position);

            return projectSections[position];
        }

        @Override
        public Fragment getItem(int position) {
            if (position == ProjectSection.FORUM.ordinal())
                return ForumFragment.getInstance(currentProject.getId());
            else if (position == ProjectSection.TODOLIST.ordinal())
                return TodoListFragment.getInstance(currentProject.getId());
            else if (position == ProjectSection.WORK_ANALYSIS.ordinal())
                return WorkAnalysisFragment.getInstance(currentProject.getId());
            else
                return OfficeFragment.getInstance(currentProject.getId());
        }

        @Override
        public int getCount() {
            return ProjectSection.values().length;
        }
    }

}
