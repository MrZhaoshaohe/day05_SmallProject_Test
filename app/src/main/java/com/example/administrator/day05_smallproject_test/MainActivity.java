package com.example.administrator.day05_smallproject_test;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.administrator.day05_smallproject_test.activity.RecyActivity;

public class MainActivity extends AppCompatActivity {

    private Handler handler =new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
    }

    private void initData() {

     handler.postDelayed(new Runnable() {
         @Override
         public void run() {

             Intent intent =new Intent(MainActivity.this,RecyActivity.class);
             startActivity(intent);
         }
     },3000);
    }
}
