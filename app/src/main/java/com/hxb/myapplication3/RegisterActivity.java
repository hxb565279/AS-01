package com.hxb.myapplication3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    Button register;
    private EditText username,phone,xx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);
        register  = findViewById(R.id.register1);
         username=findViewById(R.id.name);
        phone =findViewById(R.id.phone);
        xx = findViewById(R.id.xx);
        register.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (username.getText()==null){
            Toast.makeText(RegisterActivity.this,"账号输入为空",Toast.LENGTH_LONG).show();

        }
        if (phone.getText()==null){
            Toast.makeText(RegisterActivity.this,"手机号输入为空",Toast.LENGTH_LONG).show();
        }

        StringBuffer stringBuffer = new StringBuffer("注册成功,注册信息 "+"姓名："+username.getText()+"手机号： "+phone.getText()+" 身份证："+xx.getText());
        Toast.makeText(RegisterActivity.this,stringBuffer,Toast.LENGTH_LONG).show();
        Intent intent2 = new Intent(RegisterActivity.this,Message_check.class);
        startActivity(intent2);
    }
}
