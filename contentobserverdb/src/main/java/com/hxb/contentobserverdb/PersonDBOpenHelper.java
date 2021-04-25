package com.hxb.contentobserverdb;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class PersonDBOpenHelper extends SQLiteOpenHelper {
    //构造方法，调用该方法创建一个person.db数据库
    public PersonDBOpenHelper(Context context) {
        super(context, "person.db", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table info (_id integer primary key autoincrement, name varchar(20))");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
