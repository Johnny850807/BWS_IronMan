package com.ood.waterball.teampathy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.ood.waterball.teampathy.Controllers.Global;
import com.ood.waterball.teampathy.Controllers.EntityControllers.MemberSystem.Exceptions.AccountNotFoundException;

public class MainActivity extends AppCompatActivity {
    private EditText accountEd;
    private EditText passwordEd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Global.init(this.getResources());  // 初始化全域變數 並傳入資源

        findViews();
    }

    private void findViews() {
        accountEd = (EditText) findViewById(R.id.inputAccount_Main);
        passwordEd = (EditText) findViewById(R.id.inputPassword_Main);
    }

    public void forgotOnClick(View view) {
        //todo 忘記密碼
    }

    public void registerOnClick(View view) {
        startActivity(new Intent(this,RegisterActivity.class));
    }

    public void logInOnClickMain(View view) {
        try {
            Global.getMemberController().logIn(accountEd.getText().toString(),
                    passwordEd.getText().toString());

            startActivity(new Intent(this,BaseActivity.class));

        } catch (AccountNotFoundException e) {
            Toast.makeText(this,e.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }
}
