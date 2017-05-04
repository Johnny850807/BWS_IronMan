package com.ood.waterball.teampathy.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.ood.waterball.teampathy.Controllers.Global;
import com.ood.waterball.teampathy.Domains.Project;
import com.ood.waterball.teampathy.R;

import static com.ood.waterball.teampathy.Controllers.MyLog.Log;

public class ProjectHomePageFragment extends ActivityBaseFragment {
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private PagerAdapter fragmentPagerAdapter;
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
       onViewPagerInitiate();
    }

    private void onViewPagerInitiate(){
        fragmentPagerAdapter = new TabFragmentPageAdapter(getFragmentManager());
        viewPager.setAdapter(fragmentPagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }

    public class TabFragmentPageAdapter extends MyFragmentPagerAdapter{
        public static final int FORUM = 0;

        public TabFragmentPageAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case FORUM:
                    return TabBaseFragment.getInstance(ForumFragment.class);
                default:
                    return TabBaseFragment.getInstance(ForumFragment.class);
            }
        }

        @Override
        protected String makeFragmentName(int position) {
            return TabFragmentPageAdapter.class.getName()+position;
        }

        @Override
        public int getCount() {
            return 4;
        }

    }

}
