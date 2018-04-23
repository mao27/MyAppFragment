package com.test.myappfragment;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //进入首页
                startIndex();
            }
        }, 2000);
    }

    private void startIndex() {
        Intent intent=new Intent(this,IndexActivity.class);
        startActivity(intent);
        //关闭
        finish();
    }
}
