package com.ood.waterball.teampathy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.ood.waterball.teampathy.Controllers.Global;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Global.init(this.getResources());  // 初始化全域變數 並傳入資源
    }

    public void forgotOnClick(View view) {

    }

    public void registerOnClick(View view) {
        startActivity(new Intent(this,RegisterActivity.class));
    }

    public void logInOnClickMain(View view) {
        startActivity(new Intent(this,MemberHomePageActivity.class));
    }
}
