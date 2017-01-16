package com.ood.waterball.webchattingroom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterPage extends AppCompatActivity {
    private EditText accountEd , passwordEd , passwordConfirmEd , nameEd;
    private boolean isAutoLogin;  //是否自動登入

    private void processViews(){
        accountEd = (EditText) findViewById(R.id.accountEd_register);
        passwordEd = (EditText) findViewById(R.id.passwordEd_register);
        passwordConfirmEd = (EditText) findViewById(R.id.pwConfirmEd_register);
        nameEd = (EditText) findViewById(R.id.nameEd_register);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);
        processViews();
        isAutoLogin = getIntent().getBooleanExtra("autoLogin" , false);  //得取首頁是否勾選自動登入
    }

    public void registerFinishedOnClick(View view) {

        if( registerAvailableConfirm() )
        {
            Intent intent = new Intent( this , ChatRoomPage.class );
            intent.putExtra("autoLogin", isAutoLogin);
            startActivityForResult(intent , 0); //註冊完 如果又返回 則要回到首頁
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //註冊完 如果又返回 則要回到首頁
        finish();
    }

    private boolean registerAvailableConfirm(){
        //註冊確認是否無誤
        //各項欄位必須輸入
        boolean accountLengthAV = accountEd.getText().toString().length() > 0 ;
        boolean passwordLengthAV = passwordEd.getText().toString().length() > 0 ;
        boolean passwordCfLengthAV = passwordConfirmEd.getText().toString().length() > 0 ;
        boolean nameLengthAV = nameEd.getText().toString().length() > 0 ;
        //密碼確認
        boolean passConfirmAV = passwordEd.getText().toString().equals( passwordConfirmEd.getText().toString() );

        boolean available = accountLengthAV && passwordCfLengthAV && passwordLengthAV
                && nameLengthAV && passConfirmAV;

        if (!available)
            Toast.makeText(getApplicationContext(),"欄位請確認無誤!!",Toast.LENGTH_SHORT).show();

        return available;
    }
}
