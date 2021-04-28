package com.hxb.startservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    public MyService() {
    }

     public void onCreate(){
        super.onCreate();
         Log.i("MyService", "创建服务，执行onCreate()方法");
     }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("MyService", "开启服务，执行onStartCommand()方法");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}