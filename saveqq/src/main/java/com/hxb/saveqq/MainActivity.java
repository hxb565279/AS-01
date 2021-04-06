package com.hxb.saveqq;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText et_account;
    EditText et_password;
    Button btn_login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        interView();
        Map<String, String> userInfo = FileSaveQQ.getUserInfo(MainActivity.this);
        if (userInfo != null) {
            et_account.setText(userInfo.get("account"));
            et_password.setText(userInfo.get("password"));
        }


    }

    private void interView() {
        et_account = (EditText) findViewById(R.id.et_account);
        et_password = (EditText) findViewById(R.id.et_password);
        btn_login = (Button) findViewById(R.id.btn_login);
        btn_login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                String account = et_account.getText().toString().trim();
                String password = et_password.getText().toString().trim();
                if (TextUtils.isEmpty(account)) {
                    Toast.makeText(this, "请输入qq", Toast.LENGTH_LONG).show();
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(this, "请输入密码", Toast.LENGTH_LONG).show();
                }
                Toast.makeText(this, "登录成功", Toast.LENGTH_LONG).show();
                boolean isSaveSuccess = FileSaveQQ.saveUserInfo(this, account, password);

                if (isSaveSuccess) {
                    Toast.makeText(this, "保存成功", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(this, "保存成功", Toast.LENGTH_LONG).show();
                }


//                {
//                    Toast.makeText(this,"保存成功",Toast.LENGTH_LONG).show();
//                }

        }
    }
}