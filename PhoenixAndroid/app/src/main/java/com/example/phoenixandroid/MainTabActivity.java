package com.example.phoenixandroid;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.os.TestLooperManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.phoenixandroid.fragments.HomeFragment;
import com.example.phoenixandroid.fragments.MineFragment;

public class MainTabActivity extends BaseActivity {

    private FragmentManager supportFragmentManager = getSupportFragmentManager();
    HomeFragment homeFragment = new HomeFragment();
    MineFragment mineFragment = new MineFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_tab);

        setNavTitle("MainTabActivity");
        FragmentManager manager = getSupportFragmentManager();
        addFragment(mineFragment, "mine");
        addFragment(homeFragment, "home");

        showFrame(0);

        Button home = (Button)findViewById(R.id.home_btn);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFrame(0);
            }
        });
        Button mine = (Button)findViewById(R.id.mine_btn);
        mine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFrame(1);
            }
        });

        /// 获取 activity 堆栈中的数量
        ActivityManager managers = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        ActivityManager.RunningTaskInfo info = managers.getRunningTasks(1).get(0);

        String packageName = info.topActivity.getPackageName();
        String topclassName = info.topActivity.getClassName();
        String baseclassname = info.baseActivity.getClassName();
        int acitivitynum = info.numActivities;
        TextView textView = (TextView)findViewById(R.id.content_txt);
        textView.setText(acitivitynum + ":::" + packageName + ":"+ topclassName + ":::" + baseclassname + ":");

    }

    private  void showFrame(int index) {
        hideFrag();
        FragmentTransaction transaction = supportFragmentManager.beginTransaction();
        switch (index) {
            case 0: {
                transaction.show(homeFragment);
                break;
            }
            case 1: {
                transaction.show(mineFragment);
                break;
            }
        }
        transaction.commit();
    }

    private void hideFrag() {
        //再重新获取一个开启事务
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
        //不等于空或者是否添加的时候
        if (homeFragment != null && homeFragment.isAdded()) {
            fragmentTransaction.hide(homeFragment);
        }
        if (mineFragment != null && mineFragment.isAdded()) {
            fragmentTransaction.hide(mineFragment);
        }

        fragmentTransaction.commit();
    }

    //添加Fragment到FragmentList中
    private void addFragment(Fragment fragment, String tag){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.fl_container,fragment,tag);
        transaction.commit();
    }

    // 清空fragmentList的所有Fragment，替换成新的Fragment，注意Fragment里面的坑
    private void replaceFragment(Fragment fragment, String tag){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fl_container,fragment,tag);
        transaction.commit();
    }

    //移除指定的Fragment
    private void removeFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.remove(fragment);
        transaction.commit();
    }

    //把Fragment设置成显示状态，但是并没有添加到FragmentList中
    private void showFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.show(fragment);
        transaction.commit();
    }

    //把Fragment设置成显示状态，但是并没有添加到FragmentList中
    private void hideFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.hide(fragment);
        transaction.commit();
    }

    // 效果和show相近，创建视图，添加到containerid指定的Added列表，FragmentList依然保留，但是会引起生命周期的变化
    private void attachFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.attach(fragment);
        transaction.commit();
    }

    // 效果和hide相近，清除视图，从containerid指定的Added列表移除，FragmentList依然保留，但是会引起生命周期的变化
    private void detachFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.detach(fragment);
        transaction.commit();
    }


}
