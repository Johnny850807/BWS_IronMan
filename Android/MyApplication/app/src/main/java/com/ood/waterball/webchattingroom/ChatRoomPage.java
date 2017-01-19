package com.ood.waterball.webchattingroom;

import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ChatRoomPage extends AppCompatActivity {
    private WebView chatWebView;  //聊天室web前端
    private String chatroomURL = "http://waterball.lionfree.net/waterball.lionfree.net/johnny850807/homepage.html";

    private static MediaPlayer mediaPlayer;  //背景音樂


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
                    chatroomURL = request.getUrl().toString();
                    chatWebView.loadUrl(chatroomURL);

                    //載入聊天室頁面後播放音樂
                    playBackgroundMusic();
                }
                return super.shouldOverrideUrlLoading(view, request);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                chatroomURL = url;
                playBackgroundMusic();
            }

        });
    }

    private void loadWebPageFromServer(){
        //載入
        chatWebView.loadUrl(chatroomURL);
    }

    private void createMediaplayer(){
        if(mediaPlayer == null)
            mediaPlayer = MediaPlayer.create(this, R.raw.tt);
    }

    public void stopMediaplayer(){
        mediaPlayer.stop();
    }

    public void playBackgroundMusic(){
        createMediaplayer();
        Log.d("myLog","目前位於: "+chatroomURL);
        if ( chatroomURL.equals("http://waterball.lionfree.net/waterball.lionfree.net/johnny850807/chatroom.html") ){
            mediaPlayer.start();
            Log.d("myLog","進入聊天室，撥放音樂");
        }

    }

    @Override
    public void onStop(){
        super.onStop();
        stopMediaplayer();
    }

    @Override
    public void onResume(){
        super.onResume();
        playBackgroundMusic();
    }
}
