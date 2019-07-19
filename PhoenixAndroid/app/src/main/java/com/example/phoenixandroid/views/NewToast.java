package com.example.phoenixandroid.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.phoenixandroid.R;
import com.example.phoenixandroid.bean.ToastBean;

public class NewToast extends FrameLayout {
    private int viewWidth;
    private int viewHeight;

    private Paint paint;

    private TextPaint textPaint;

    private float ascent;
    private float descent;

    private float textOffset;

    private float startX = 0;
    private float startY = 0;
    private float endX = 0;
    private float endY = 0;

    private RectF rectF;

    private Context mContext;
    private ToastBean mToastBean;

    public NewToast(Context context) {
        this(context,null);
    }

    public NewToast(Context context, AttributeSet attrs) {
        this(context, attrs,0 );
    }

    public NewToast(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        init();
    }

    private void initToastView(){
        View view = LayoutInflater.from(mContext).inflate(R.layout.toast_fragment, null); //加載layout下的布局
        ImageView iv = view.findViewById(R.id.tvImageToast);
        TextView title = view.findViewById(R.id.tvTitleToast);
        title.setText(mToastBean.getTitle()); //toast的标题
        TextView text = view.findViewById(R.id.tvTextToast);
        text.setText(mToastBean.getContent()); //toast内容

        Button btn = view.findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("NewToast", "onClick: button");
            }
        });
        addView(view);
    }

    public void setToastBean(ToastBean bean) {
        this.mToastBean = bean;
        initToastView();
    }


    private void init() {

        Log.e("MyView", "init");

        /*
         * 画笔样式分三种：
         * 1.Paint.Style.STROKE：描边
         * 2.Paint.Style.FILL_AND_STROKE：描边并填充
         * 3.Paint.Style.FILL：填充
         */

        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);
        paint.setColor(0xff000000);

        //初始化文字画笔
        textPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG);
        textPaint.setTextSize(50);
        textPaint.setColor(0xff000000);
        textPaint.setTextAlign(Paint.Align.CENTER);

        //文字的上坡度和下坡度。用于计算偏移量
        ascent = textPaint.ascent();
        descent = textPaint.descent();

        //偏移量，用于辅助文字居中
        textOffset = (ascent + descent) / 2;

        startX = 10;
        startY = 10;

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        Log.e("MyView", "onSizeChanged");

        viewWidth = w;
        viewHeight = h;

        endX = viewWidth - 10;
        endY = viewHeight - 10;

        rectF = new RectF(startX, startY, endX, endY);
    }


    @Override
    protected void dispatchDraw(Canvas canvas) {

        int width = getWidth();
        int height = getHeight();
//        Paint mPaint = new Paint();
//        mPaint.setColor(Color.BLUE);
//        mPaint.setStyle(Paint.Style.STROKE);
//        mPaint.setStrokeWidth(5);
//        float cornor = 16.0f;
//        canvas.drawRoundRect(cornor, cornor, width-cornor, height-cornor, 20, 20, mPaint);
//        super.dispatchDraw(canvas);

        canvas.save();
        if (viewWidth >= 12 && viewHeight > 12) {
//            Path path = new Path();
//            float cc = 77;
//            //四个圆角
//            path.moveTo(cc, 0);
//            path.lineTo(viewWidth - cc, 0);
//
//            path.quadTo(viewWidth, 0, viewWidth, cc);
//            path.lineTo(viewWidth, viewHeight - cc);
//
//            path.quadTo(viewWidth, viewHeight, viewWidth - cc, viewHeight);
//            path.lineTo(12, viewHeight);
//
//            path.quadTo(0, viewHeight, 0, viewHeight - cc);
//            path.lineTo(0, cc);
//
//            path.quadTo(0, 0, cc, 0);


            Path path = new Path();
//            path.addCircle(width / 2, height / 2, 160, Path.Direction.CW);
            RectF rectF = new RectF(0, 0, width, height);
            path.addRoundRect(rectF, 120, 120, Path.Direction.CW);
            canvas.clipPath(path);
        }
        super.dispatchDraw(canvas);


//        Log.e("MyView", "onDraw");
//
//        canvas.save();
//
//        // 平移和旋转画布
//        canvas.translate(viewWidth / 2, viewHeight / 2 - textOffset);
//        canvas.rotate(-30);
//
//        //绘制文字。因为这个时候，画布已经移动到控件中心点了，如果在中心位置写字，字的中心坐标，就是(0,0)
//        canvas.drawText("该课程已下架", 0, 0, textPaint);
//
//        // 释放画布
//        canvas.restore();
//
//        canvas.drawRoundRect(rectF, 50, 50, paint);

    }

}
