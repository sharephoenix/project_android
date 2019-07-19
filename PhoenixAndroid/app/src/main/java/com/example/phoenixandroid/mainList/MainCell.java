package com.example.phoenixandroid.mainList;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.phoenixandroid.R;


public class MainCell extends FrameLayout {
    private Context mContext;

    private TextView nameTx;
    private Button btn;

    private onMainCellListener mOnMainCellListener;


    public MainCell(Context context) {
        this(context, null);
    }

    public MainCell(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MainCell(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        initPage();
    }

    private void initPage() {
        View view = LayoutInflater.from(mContext).inflate(R.layout.cell_main, null);
        nameTx = view.findViewById(R.id.name);
        btn = view.findViewById(R.id.btn);

        this.setClickable(true);
        this.setDescendantFocusability(ViewGroup.FOCUS_BLOCK_DESCENDANTS);

        nameTx.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (MainCell.this.mOnMainCellListener != null)
                    mOnMainCellListener.onTextClick();
            }
        });


        btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (MainCell.this.mOnMainCellListener != null)
                    mOnMainCellListener.onBtnClick();
            }
        });

        addView(view);
    }



    public void setName(String name) {
        this.nameTx.setText(name);
    }

    public void setOnMainCellListener(onMainCellListener listener) {
        this.mOnMainCellListener = listener;
    }

    public interface onMainCellListener{
        void onTextClick();
        void onBtnClick();
    }

}
