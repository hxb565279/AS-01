package com.hxb.saveqq;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;
import java.util.Map;

public class SPSaveQQ {
    public static boolean saveUserInfo(Context context,String account,String password){
        SharedPreferences sp = context.getSharedPreferences("data",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("userName",account);
        editor.putString("pwd",password);
        editor.commit();
        return true;
    }

    public static Map<String,String> getUserInfo(Context context){
        Map<String,String> userMap = new HashMap<>();
        SharedPreferences sharedPreferences = context.getSharedPreferences("data",Context.MODE_PRIVATE);
        String account = sharedPreferences.getString("username",null);
        String password = sharedPreferences.getString("pwd",null);
        userMap.put("account",account);
        userMap.put("pwd",password);
        return userMap;
    }

}
