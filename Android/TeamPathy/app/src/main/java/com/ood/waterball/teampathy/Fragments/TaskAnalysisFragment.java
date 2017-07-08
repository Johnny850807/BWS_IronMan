package com.ood.waterball.teampathy.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.ood.waterball.teampathy.Controllers.Global;
import com.ood.waterball.teampathy.Fragments.Architecture.TemplateFragment;
import com.ood.waterball.teampathy.R;


public class TaskAnalysisFragment extends TemplateFragment {
    private int projectId;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private String wbsXml;

    public TaskAnalysisFragment() {
        // Required empty public constructor
    }

    public static TaskAnalysisFragment getInstance(int projectId) {
        TaskAnalysisFragment fragment = new TaskAnalysisFragment();
        Bundle args = new Bundle();
        args.putInt("projectId", projectId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_task_analysis;
    }

    @Override
    protected void onFetchData(@Nullable Bundle arguBundle) {
        try {
            projectId = arguBundle.getInt("projectId");
            wbsXml = Global.getOfficeController().getTaskAnalysis(projectId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onFindViews(View parentView) {
        tabLayout = (TabLayout) parentView.findViewById(R.id.tablayout_task_analysis);
        viewPager = (ViewPager) parentView.findViewById(R.id.viewpager_task_analysis);
    }

    @Override
    protected void onControlViews() {
        initiateViewPager();
    }

    private void initiateViewPager(){
        viewPager.setAdapter(new MyFragmentPageAdapter(getChildFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);
    }

    private class MyFragmentPageAdapter extends FragmentPagerAdapter {

        private final String[] taskAnalysisSection;

        public MyFragmentPageAdapter(FragmentManager fm) {
            super(fm);
            taskAnalysisSection = getResources().getStringArray(R.array.task_analysis_sections);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            super.getPageTitle(position);
            return taskAnalysisSection[position];
        }

        @Override
        public Fragment getItem(int position) {
            switch (position)
            {
                case 0:
                    return WbsEditPanelFragment.getInstance(projectId,wbsXml);
                case 1:
                    return ChartWebViewFragment.getInstance(wbsXml, ChartWebViewFragment.XslType.WBS);
                default:
                    return ChartWebViewFragment.getInstance(wbsXml, ChartWebViewFragment.XslType.GanttChart);
            }
        }

        @Override
        public int getCount() {
            return taskAnalysisSection.length;
        }
    }

}
