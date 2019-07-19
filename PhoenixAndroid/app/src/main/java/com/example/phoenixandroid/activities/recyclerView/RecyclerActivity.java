package com.example.phoenixandroid.activities.recyclerView;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.phoenixandroid.R;

import java.util.ArrayList;

public class RecyclerActivity extends AppCompatActivity {

    RecyclerView recyclerView = null;
    ArrayList<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        recyclerView = findViewById(R.id.recycleView);

        this.list = new ArrayList<String>();
        /// 添加数据
        this.list.add("toast");
        this.list.add("Swift");
        this.list.add("JAVA");

        recyclerView.setAdapter(new RecyclerView.Adapter() {
            @NonNull
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
                return null;
            }

            @Override
            public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

            }

            @Override
            public int getItemCount() {
                return 0;
            }
        });
    }
}
