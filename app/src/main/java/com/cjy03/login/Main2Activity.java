package com.cjy03.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private  int iProgress;
    private  ProgressBar mProgressBar;
    private TextView mTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mProgressBar = findViewById(R.id.progressBar);
        mTextView  = findViewById(R.id.textView3);


        autoIncrease();
    }


    private void  autoIncrease(){
        // 建立子线程
        Thread mThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (iProgress <= 100) {
                    iProgress += 1;
                    if (iProgress > 100) {
                        iProgress = 0;
                        return;
                    }
                    // 自动增加进度条功能-子线程中操作主线程UI
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mProgressBar.setProgress(iProgress);
                             mTextView.setText("进度:" + iProgress + "%");
                             if(iProgress>=100){
                                 Intent intent = new Intent(Main2Activity.this, Main3Activity.class);
                                 startActivity(intent);
                             }
                        }
                    });
                    // 自动增加进度条功能-延时200ms；启动线程
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        mThread.start();
    }


}
