package com.example.phoenixandroid.activities.recyclerView;

import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ActivityChooserView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.phoenixandroid.R;
import com.example.phoenixandroid.mainList.MainCell;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class RecyclerActivity extends AppCompatActivity {

    RecyclerView recyclerView = null;
    ArrayList<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(false);
            actionBar.setDisplayShowTitleEnabled(false);
            actionBar.setDisplayShowHomeEnabled(false);
            actionBar.setDisplayShowCustomEnabled(true);

            if (Build.VERSION.SDK_INT >= 21) {
                actionBar.setElevation(0);
            }
            View customView = getLayoutInflater().inflate(R.layout.custom_action_bar, null);
            actionBar.setDisplayShowHomeEnabled(false);
            actionBar.setDisplayShowCustomEnabled(true);
            actionBar.setDisplayShowTitleEnabled(false);
            actionBar.setCustomView(customView);
            Toolbar parent =(Toolbar) customView.getParent();
            parent.setPadding(0,0,0,0);//for tab otherwise give space in tab
            parent.setContentInsetsAbsolute(0,0);
        }
        setContentView(R.layout.activity_recycler);


        recyclerView = findViewById(R.id.recycleView);

        this.list = new ArrayList<String>();
        /// 添加数据
        this.list.add("toast");
        this.list.add("Swift");
        this.list.add("JAVA");
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new RecyclerView.Adapter() {
            @NonNull
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

                MainCell view = new MainCell(RecyclerActivity.this, viewGroup);
                view.setOnMainCellListener(new MainCell.onMainCellListener() {
                    @Override
                    public void onTextClick() {

                    }

                    @Override
                    public void onBtnClick() {

                    }
                });
                return new ItemViewHolder(view);
            }

            @Override
            public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

            }

            @Override
            public int getItemCount() {
                return 10;
            }
        });
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {

        public ItemViewHolder(View itemView) {
            super(itemView);

        }
    }
}
