package com.example.phoenixandroid;

import android.content.Intent;
import android.database.DataSetObserver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.phoenixandroid.mainList.MainCell;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView mainListView;

    ArrayList<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /// 初始化界面控件
        mainListView = (ListView) findViewById(R.id.mainListView);
        this.list = new ArrayList<String>();

        /// 添加数据
        this.list.add("toast");
        this.list.add("Swift");
        this.list.add("JAVA");
        /// 添加相关事件

        mainListView.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return MainActivity.this.list.size();
            }

            @Override
            public Object getItem(int position) {
                return MainActivity.this.list.get(position);
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                MainCell view = null;
                if (view == null) {
                    view = new MainCell(MainActivity.this);
                } else {
                    view = (MainCell)convertView;
                }
                String name = MainActivity.this.list.get(position);
                view.setName(name);
                view.setOnMainCellListener(new MainCell.onMainCellListener() {
                    @Override
                    public void onTextClick() {
                        Intent intent = new Intent(MainActivity.this, ToastActivity.class);
                        MainActivity.this.startActivity(intent);
                    }

                    @Override
                    public void onBtnClick() {
                        Intent intent = new Intent(MainActivity.this, ToastActivity.class);
                        MainActivity.this.startActivity(intent);
                    }
                });

                return view;
            }
        });
        mainListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, ToastActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });
    }
}
