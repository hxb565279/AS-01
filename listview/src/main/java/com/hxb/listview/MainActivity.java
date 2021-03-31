package com.hxb.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ListView mlistView;

    //需要适配的数据
    private String[] titles = {"桌子", "苹果", "蛋糕", "线衣", "猕猴桃",
            "围巾"};
    private String[] prices = {"1800元", "10元/kg", "300元", "350元", "10元/kg",
            "280元"};
    //图片集合
    private int[] icons = {R.drawable.table, R.drawable.apple, R.drawable.cake,
            R.drawable.wireclothes, R.drawable.kiwifruit, R.drawable.scarf};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mlistView = findViewById(R.id.lv);
        MyBaseAdapter myBaseAdapter = new MyBaseAdapter();
        mlistView.setAdapter(myBaseAdapter);
    }


    public class MyBaseAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return titles.length;
        }

        @Override
        public Object getItem(int position) {
            return titles[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = View.inflate(MainActivity.this, R.layout.list_item, null);
            TextView title = (TextView) view.findViewById(R.id.title);
            TextView price = (TextView) view.findViewById(R.id.price);
            ImageView iv = (ImageView) view.findViewById(R.id.iv);
            title.setText(titles[position]);
            price.setText(prices[position]);
            iv.setBackgroundResource(icons[position]);
            return view;
        }
    }
}