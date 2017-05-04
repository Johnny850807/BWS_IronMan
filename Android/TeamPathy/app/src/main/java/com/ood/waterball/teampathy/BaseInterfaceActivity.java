package com.ood.waterball.teampathy;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.ood.waterball.teampathy.Controllers.PageController;
import com.ood.waterball.teampathy.Fragments.HomePage.MemberHomePageFragment;

public class BaseInterfaceActivity extends AppCompatActivity implements SinglePageArchitecture {
    private PageController pageController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_interface_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        onPageControllerInitiate();
    }

    private void onPageControllerInitiate(){
        pageController = new PageController(getSupportFragmentManager(),R.id.base_interface_fragment_content);
        pageController.changePage(new MemberHomePageFragment());
    }


    @Override
    public void changePage(Fragment fragment) {
        pageController.changePage(fragment);
    }

    @Override
    public String getPageName() {
        return "單一Activity主頁";
    }
}
