package com.example.phoenixandroid;

import android.os.Build;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class BaseActivity extends AppCompatActivity {

    private TextView titleView;

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

            titleView = customView.findViewById(R.id.title_nav);
        }
    }

    public void setNavTitle(String title) {
        titleView.setText(title);
    }
}
