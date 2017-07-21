package com.ood.waterball.teampathy;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.ood.waterball.teampathy.Controllers.Global;
import com.ood.waterball.teampathy.Controllers.MyUtils.GlideHelper;
import com.ood.waterball.teampathy.Controllers.PageController;
import com.ood.waterball.teampathy.DomainModels.Domains.User;
import com.ood.waterball.teampathy.Fragments.MemberHomePageFragment;

public class BaseActivity extends AppCompatActivity implements ParentActivityCallBack {
    private Toolbar toolbar;
    private PageController pageController;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private View navlayoutView;
    private ImageView userHeadImgNav;
    private TextView userNameTxtNav;

    private ProgressBar progressBar;
    private int progressBarShowingRequestAmount = 0; // keep showing progress bar if amount greater than 0

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_page);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        findViews();
        setupDrawerlayout();
        onPageControllerInitiate();
    }


    private void findViews() {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout_base);
        navigationView = (NavigationView) findViewById(R.id.navigationView_base);
        navlayoutView = navigationView.getHeaderView(0);
        userHeadImgNav = (ImageView) navlayoutView.findViewById(R.id.head_pic_nav);
        userNameTxtNav = (TextView) navlayoutView.findViewById(R.id.name_txt_nav);
        progressBar = (ProgressBar) findViewById(R.id.progress_spinner_base);
    }

    private void setupDrawerlayout() {
        setupNavView();
        setupActionBarDrawerToggle();
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.menu_homepage_nav:
                        changePage(new MemberHomePageFragment());
                        break;
                    case R.id.profile_nav:
                        break;
                    case R.id.whole_timeline_nav:
                        break;
                    case R.id.log_out_nav:
                        finish();
                }
                drawerLayout.closeDrawers();
                return true;
            }
        });
    }

    private void setupNavView() {
        User user = Global.getMemberController().getActiveUser();
        GlideHelper.loadToCircularImage(BaseActivity.this, userHeadImgNav, user.getImageUrl());
        userNameTxtNav.setText(user.getName());
    }

    private void setupActionBarDrawerToggle() {
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.openDrawer, R.string.closeDrawer) {
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }

    private void onPageControllerInitiate() {
        pageController = new PageController(this, getSupportFragmentManager(), R.id.base_interface_fragment_content);
        pageController.changePage(new MemberHomePageFragment());
    }


    @Override
    public void changePage(Fragment fragment) {
        pageController.changePage(fragment);
    }

    @Override
    public void popPage() {
        getFragmentManager().popBackStack();
    }

    @Override
    public void showProgressBar() {
        if (progressBar != null && progressBarShowingRequestAmount++ == 0)
            progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        if (progressBar != null && --progressBarShowingRequestAmount == 0)
            progressBar.setVisibility(View.GONE);
    }

    @Override
    public boolean isProgressBarShowing() {
        return progressBar.getVisibility() == View.VISIBLE;
    }

}
