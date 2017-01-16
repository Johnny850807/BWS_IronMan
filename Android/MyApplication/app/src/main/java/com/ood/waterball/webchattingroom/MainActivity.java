package com.ood.waterball.webchattingroom;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText accountED , passwordED;
    private CheckBox autoLogIn_chbx;

    void processViews(){
        accountED = (EditText) findViewById(R.id.account_Ed_main);
        passwordED = (EditText) findViewById(R.id.password_Ed_main);
        autoLogIn_chbx = (CheckBox) findViewById(R.id.autoLogIn_Main);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        processViews();
    }

    public void logInOnClick(View view) {
        if( registerAvailableConfirm() )
        {
            Intent intent = new Intent(this, ChatRoomPage.class);
            intent.putExtra("autoLogin", autoLogIn_chbx.isChecked());
            startActivity(intent);
        }
    }

    public void registerOnClick(View view) {
        Intent intent = new Intent( this , RegisterPage.class );
        intent.putExtra("autoLogin", autoLogIn_chbx.isChecked());
        startActivity(intent);
    }

    private boolean registerAvailableConfirm(){
        //註冊確認是否無誤
        //各項欄位必須輸入
        boolean accountLengthAV = accountED.getText().toString().length() > 0 ;
        boolean passwordLengthAV = passwordED.getText().toString().length() > 0 ;

        boolean available = accountLengthAV && passwordLengthAV;

        if (!available)
            Toast.makeText(getApplicationContext(),"欄位請確認無誤!!",Toast.LENGTH_SHORT).show();

        return available;
    }

}
