package com.hxb.myapplication3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Message_check extends AppCompatActivity implements View.OnClickListener {
    MyHelper myHelper;
    private EditText Name;
    private EditText Phone;
    private EditText XX;
    private TextView mTvShow;
    private Button mBtnAdd;
    private Button mBtnQuery;
    private Button mBtnUpdate;
    private Button mBtnDelete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message_check_activity);
        myHelper = new MyHelper(this);
        init();

    }


    private void init() {
        Name = (EditText) findViewById(R.id.name);
        Phone = (EditText) findViewById(R.id.phone);
        XX= (EditText) findViewById(R.id.xx);
        mTvShow = (TextView) findViewById(R.id.tv_show);
        mBtnAdd = (Button) findViewById(R.id.btn_add);
        mBtnQuery = (Button) findViewById(R.id.btn_query);
        mBtnUpdate = (Button) findViewById(R.id.btn_update);
        mBtnDelete = (Button) findViewById(R.id.btn_delete);
        mBtnAdd.setOnClickListener(this);
        mBtnQuery.setOnClickListener(this);
        mBtnUpdate.setOnClickListener(this);
        mBtnDelete.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String name, phone,xx;
        SQLiteDatabase db;
        ContentValues values;

        switch (v.getId()) {
            case R.id.btn_add:
                name = Name.getText().toString();
                phone = Phone.getText().toString();
                xx= XX.getText().toString();
                db = myHelper.getWritableDatabase();
                values = new ContentValues();
                values.put("name", name);
                values.put("phone", phone);
                values.put("xx",xx);
                db.insert("information", null, values);
                Toast.makeText(this, "信息已添加", Toast.LENGTH_SHORT).show();
                db.close();
                break;

            case R.id.btn_query:
                db=myHelper.getReadableDatabase();
                Cursor cursor = db.query("information",null,null,null,null,null,null);
                if (cursor.getCount()==0){
                    mTvShow.setText("");
                    Toast.makeText(this, "没有数据", Toast.LENGTH_SHORT).show();
                }else {
                    cursor.moveToFirst();
                    mTvShow.setText("Name :  " + cursor.getString(1) +
                            "  ；Tel :  " + cursor.getString(2)+" ; XX : "+cursor.getString(3));
                }
                while (cursor.moveToNext()) {
                    mTvShow.append("\n" + "Name :  " + cursor.getString(1) +
                            "  ；Tel :  " + cursor.getString(2)+" ; XX : "+cursor.getString(3));
                }
                cursor.close();
                db.close();
                break;
            case R.id.btn_update:
                db = myHelper.getWritableDatabase();
                values = new ContentValues();
                values.put("phone", phone = Phone.getText().toString());
                db.update("information", values, "name=?",
                        new String[]{Name.getText().toString()});
                Toast.makeText(this, "信息已修改", Toast.LENGTH_SHORT).show();
                db.close();
                break;
            case R.id.btn_delete:
                db = myHelper.getWritableDatabase();
                db.delete("information", null, null);
                Toast.makeText(this, "信息已删除", Toast.LENGTH_SHORT).show();
                mTvShow.setText("");
                db.close();
                break;


        }
    }

    class MyHelper extends SQLiteOpenHelper {
        public MyHelper(Context context) {
            super(context, "itcast.db", null, 1);
        }
        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE information(_id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR(20),  phone VARCHAR(20))");
        }
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        }
    }
}
