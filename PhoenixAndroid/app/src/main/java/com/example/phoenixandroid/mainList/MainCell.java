package com.example.phoenixandroid.mainList;

import android.content.Context;
import android.graphics.Canvas;
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
    private ViewGroup parent;
    private View view;

    private TextView nameTx;
    private Button btn;

    private onMainCellListener mOnMainCellListener;

    public MainCell(Context context, ViewGroup parent) {
        super(context, null);
        this.mContext = context;
        this.parent = parent;
        initPage();
    }

    private void initPage() {
        view = LayoutInflater.from(mContext).inflate(R.layout.cell_main, parent, false);
        if (parent != null) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_main, parent, false);
        }
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

    public MainCell(Context context) {
        super(context);
        this.mContext = context;
        initPage();
    }

    public MainCell(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        initPage();
    }

    public MainCell(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        initPage();
    }

    public void setName(String name) {
        this.nameTx.setText(name);
    }

    public void setBtnContext(String title) {
        this.btn.setText(title);
    }

    public void setOnMainCellListener(onMainCellListener listener) {
        this.mOnMainCellListener = listener;
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        /// 重新设置 cell 的高度 RecyclerView 不知道为啥，宽度不能撑起来 TODO: 有待学习
        if (parent != null) {
            int width = parent.getWidth();
            view.setMinimumWidth(width);
        }
        super.dispatchDraw(canvas);
    }

    public interface onMainCellListener{
        void onTextClick();
        void onBtnClick();
    }

}
