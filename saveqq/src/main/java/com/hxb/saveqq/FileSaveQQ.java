package com.hxb.saveqq;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class FileSaveQQ {
    public static Map<String,String> getUserInfo(Context context){
        String content="";
        Map<String,String> userMap= new HashMap<>();
        FileInputStream fileInputStream= null;
        try {
            fileInputStream = context.openFileInput("date.txt");
            byte[] buffer = new byte[fileInputStream.available()];
           int count =    fileInputStream.read(buffer);
            content = new String(buffer);
            String [] infos = content.split(":");
            userMap.put("account",infos[0]);
            userMap.put("password",infos[1]);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fileInputStream!=null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return userMap;
    }


    public static boolean saveUserInfo(Context context, String account, String password) {
        FileOutputStream fos = null;
        try {
            //输出流对象的获取
            fos = context.openFileOutput("data.txt", Context.MODE_PRIVATE);
            byte[] bstr = (account + "" + password).getBytes();
            try {
                fos.write(bstr);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {

                }
            }
        }
        return false;
    }


}
