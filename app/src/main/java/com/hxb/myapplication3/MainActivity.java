package com.hxb.myapplication3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bt1 = findViewById(R.id.bt1);
        bt1.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
               Intent intent = new Intent(MainActivity.this,RegisterActivity.class);
               startActivity(intent);

    }
}