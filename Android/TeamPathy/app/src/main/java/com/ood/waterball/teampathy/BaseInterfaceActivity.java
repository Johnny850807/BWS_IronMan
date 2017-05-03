package com.ood.waterball.teampathy;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.ood.waterball.teampathy.Controllers.PageController;
import com.ood.waterball.teampathy.Fragments.MemberHomePageFragment;

public class BaseInterfaceActivity extends AppCompatActivity implements SingleActivityArchitecture {
    private PageController pageController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_interface_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        onPageInitiate();
    }

    private void onPageInitiate(){
        pageController = new PageController(getSupportFragmentManager());
        pageController.changePage(new MemberHomePageFragment());
    }


    @Override
    public void changePage(Fragment fragment) {
        pageController.changePage(fragment);
    }
}
