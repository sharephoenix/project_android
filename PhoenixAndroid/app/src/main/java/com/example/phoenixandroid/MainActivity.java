package com.example.phoenixandroid;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.DataSetObserver;
import android.support.v7.app.AlertDialog;
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

import com.example.phoenixandroid.activities.recyclerView.RecyclerActivity;
import com.example.phoenixandroid.bean.EventBean;
import com.example.phoenixandroid.mainList.MainCell;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    ListView mainListView;

    ArrayList<EventBean> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setNavTitle("MainActivity");

        /// 初始化界面控件
        mainListView = (ListView) findViewById(R.id.mainListView);
        this.list = new ArrayList<EventBean>();

        /// 添加数据
        EventBean toast = new EventBean();
        toast.setId("toast");
        toast.setName("Toast");
        toast.setDes("Toast 描述");
        this.list.add(toast);

        EventBean recycler = new EventBean();
        recycler.setId("recyclerView");
        recycler.setName("recyclerView");
        recycler.setDes("recyclerView 描述");
        this.list.add(recycler);

        EventBean tabbar = new EventBean();
        tabbar.setId("tabbar");
        tabbar.setName("tabbar");
        tabbar.setDes("tabbar 描述");
        this.list.add(tabbar);

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
                final EventBean bean = MainActivity.this.list.get(position);
                view.setName(bean.getDes());
                view.setBtnContext(bean.getName());

                view.setOnMainCellListener(new MainCell.onMainCellListener() {
                    @Override
                    public void onTextClick() {
                        showEventAlert(bean);
                    }

                    @Override
                    public void onBtnClick() {
                        pushEventDetail(bean.getId());
                    }
                });

                return view;
            }
        });
    }

    /*
    * 弹出 事件说明框
    * */
    private void showEventAlert(EventBean bean) {
        new AlertDialog.Builder(MainActivity.this)
                .setTitle(bean.getName())
                .setIcon(R.mipmap.ic_launcher)
                .setMessage(bean.getDes())
                .setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        }).setNeutralButton("忽略", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        }).create().show();
    }

    private void pushEventDetail(String id) {
        if (id == "toast") {
            Intent intent = new Intent(MainActivity.this, ToastActivity.class);
            MainActivity.this.startActivity(intent);
        }
        if (id == "recyclerView") {
            Intent intent = new Intent(MainActivity.this, RecyclerActivity.class);
            MainActivity.this.startActivity(intent);
        }
        if (id == "tabbar") {
            Intent intent = new Intent(MainActivity.this, MainTabActivity.class);
            MainActivity.this.startActivity(intent);
        }
    }
}
