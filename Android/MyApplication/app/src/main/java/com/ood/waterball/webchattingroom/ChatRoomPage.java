package com.ood.waterball.webchattingroom;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.WebView;
import android.widget.TextView;

public class ChatRoomPage extends AppCompatActivity {
    private TextView announceTxt , welcomeTxt;
    private WebView chatWebView;  //聊天室web前端
    private final String chatroomURL = "http://waterball.lionfree.net/%E8%81%8A%E5%A4%A9%E5%AE%A4%E5%A4%A7%E5%BB%B3.html";

    private void processViews(){
        announceTxt = (TextView) findViewById(R.id.announceTxt_chatroom);
        welcomeTxt = (TextView) findViewById(R.id.welcomeTxt_chatroom);
        chatWebView = (WebView) findViewById(R.id.charWebView_chatroom);
    }

    private void processController(){
        autoLoginHandle();
        setWelcomeTexts();
        setWebPage();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_room_page);
        processViews();
        processController();
    }

    private void autoLoginHandle(){
        //處理自動登入的儲存
        boolean autoLogin = getIntent().getBooleanExtra("autoLogin",false);
        Log.d("myLog","自動登入 : "+autoLogin);

        //處理
    }

    private void setWelcomeTexts(){
        String welcome = getResources().getString(R.string.welcometxt);
        String announcement = getResources().getString(R.string.announcement);

        welcome += "水球潘";
        announcement += "宗億光碟買一送一 !!";

        announceTxt.setText(announcement);
        welcomeTxt.setText(welcome);
    }

    private void setWebPage(){
        chatWebView.loadUrl(chatroomURL);
    }
}
