package com.example.phoenixandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.phoenixandroid.bean.ToastBean;
import com.example.phoenixandroid.views.NewToast;

public class ToastActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);

        Button btn = (Button)findViewById(R.id.toastBtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastMessage("title", "content");
            }
        });
    }

    private void ToastMessage(String titles, String messages) {
//         //LayoutInflater的作用：对于一个没有被载入或者想要动态载入的界面，都需要LayoutInflater.inflate()来载入，LayoutInflater是用来找res/layout/下的xml布局文件，并且实例化
//         LayoutInflater inflater = getLayoutInflater();//调用Activity的getLayoutInflater()
//         View view = inflater.inflate(R.layout.toast_fragment, null); //加載layout下的布局
//         ImageView iv = view.findViewById(R.id.tvImageToast);
//         TextView title = view.findViewById(R.id.tvTitleToast);
//         title.setText(titles); //toast的标题
//         TextView text = view.findViewById(R.id.tvTextToast);
//         text.setText(messages); //toast内容

        NewToast newToast = new NewToast(this);
        ToastBean toastBean = new ToastBean();
        toastBean.setTitle("#21321");
        toastBean.setContent("32321321");
        newToast.setToastBean(toastBean);

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.TOP, 12, 20);//setGravity用来设置Toast显示的位置，相当于xml中的android:gravity或android:layout_gravity
        toast.setDuration(Toast.LENGTH_LONG);//setDuration方法：设置持续时间，以毫秒为单位。该方法是设置补间动画时间长度的主要方法
        toast.setView(newToast); //添加视图文件
        toast.show();
    }

}
