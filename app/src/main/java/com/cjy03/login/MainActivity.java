package com.cjy03.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.content.Intent;
import android.widget.Button;
import android.widget.*;
public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private EditText editText2;
    private Button bt_log;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);
        editText2 = (EditText) findViewById(R.id.editText2);
        bt_log = (Button) findViewById(R.id.button);
        //给登录按钮注册监听器，实现监听器接口，编写事件
        bt_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取用户输入的数据
                String userNameString = editText.getText().toString().trim();
                if (TextUtils.isEmpty(userNameString)){
                    Toast.makeText(MainActivity.this, "用户名不能为空！", Toast.LENGTH_SHORT).show();
                    return;
                }
                String passWordString = editText2.getText().toString().trim();
                if (TextUtils.isEmpty(passWordString)){
                    Toast.makeText(MainActivity.this, "用户密码不能为空！", Toast.LENGTH_SHORT).show();
                    return;
                }
                //判断用户名和密码是否正确（为可以进行测试，将用户名定义为wcl，密码为4545）
                if (userNameString.equals("wcl") && passWordString.equals("4545")) {
                    Toast.makeText(MainActivity.this, "用户名和密码正确！", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, Main2Activity.class);
                    startActivity(intent);
                }

                else {
                    Toast.makeText(MainActivity.this, "用户名或密码错误！", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
