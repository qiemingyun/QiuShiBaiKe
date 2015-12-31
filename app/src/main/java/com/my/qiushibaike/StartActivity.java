package com.my.qiushibaike;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

/**
 * 程序启动欢迎界面
 */
public class StartActivity extends AppCompatActivity implements Runnable{

    private ImageView logo;
    public static final int START = 101;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            int what = msg.what;
            switch (what){
                case START:
                    logo.setBackgroundResource(R.mipmap.splash_sologan);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        logo = (ImageView) findViewById(R.id.logo);

        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
            Message msg = Message.obtain(handler,START);
            handler.sendMessage(msg);
            Thread.sleep(1500);
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
            finish();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}