package com.ood.waterball.webchattingroom;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ChatRoomPage extends AppCompatActivity {
    private WebView chatWebView;  //聊天室web前端
    private final String chatroomURL = "http://waterball.lionfree.net/waterball.lionfree.net/johnny850807/homepage.html";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        webviewSetting();
        loadWebPageFromServer();
        setContentView(chatWebView);

    }

    private void webviewSetting(){
        chatWebView = new WebView(this);

        /***讓網址request在android內完成而非開啟新的瀏覽器***/
        chatWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    chatWebView.loadUrl(request.getUrl().toString());
                }
                return super.shouldOverrideUrlLoading(view, request);
            }
        });
    }

    private void loadWebPageFromServer(){


        //載入
        chatWebView.loadUrl(chatroomURL);
    }
}
