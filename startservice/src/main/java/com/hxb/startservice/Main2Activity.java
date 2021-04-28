package com.hxb.startservice;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {
    private MyService2.MyBinder myBinder;
    private MyConn myconn;
    private Button btn_bind, btn_call, btn_unbind;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        init();
    }
    private void init() {
        btn_bind = (Button) findViewById(R.id.btn_bind);
        btn_call = (Button) findViewById(R.id.btn_call);
        btn_unbind = (Button) findViewById(R.id.btn_unbind);
        //设置3个按钮的点击监听事件
        btn_bind.setOnClickListener(this);
        btn_call.setOnClickListener(this);
        btn_unbind.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_bind:
                if (myconn == null) {
                    myconn = new MyConn();
                }
                Intent intent = new Intent(Main2Activity.this, MyService.class);
                bindService(intent, myconn, BIND_AUTO_CREATE);
                break;
            case R.id.btn_call:
                myBinder.callMethodInService();
                break;
            case R.id.btn_unbind:
                if (myconn != null) {
                    unbindService(myconn);
                    myconn = null;
                }
                break;
        }
    }
    /**aQSW
     * 创建MyConn类,用于实现连接服务
     */
    private class MyConn implements ServiceConnection {
        /**
         * 当成功绑定服务时调用的方法,该方法获取MyService中的Ibinder对象
         */
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder)
        {
            myBinder = (MyService2.MyBinder) iBinder;
            Log.i("MainActivity", "服务成功绑定, 内存地址为:" + myBinder.toString());
        }
        /**
         * 当服务失去连接时调用的方法
         */
        @Override
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }
}
