package com.stardust.demo.project_5g.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

import com.stardust.demo.project_5g.R;

/**
 * Created on 2019/5/9.
 *
 * @author siasun-wangchongyang
 */
public class CirclePanelView extends View {
    public static final String TAG = CirclePanelView.class.getSimpleName();

    private int mRightPadding;
    private int mOrientation;

    //白环画笔
    private Paint mWhiteCirclePaint;
    //蓝环画笔
    private Paint mBlueCirclePaint;
    //刻度画笔
    private Paint mScaleDataPaint;
    //称重数据画笔
    private Paint weightDataPaint;

    //圆环矩形
    private RectF mRecArea;
    //指针偏转角度起点
    private float mScaleStart;
    //指针偏转角度起点
    private float mScaleSEnd;
    //圆环的总偏转角度范围
    private float mSweepAngle;



    public CirclePanelView(Context context) {
        super(context);
    }

    public CirclePanelView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CirclePanelView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.CirclePanelView, defStyleAttr, 0);
        int indexCount = a.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int attr = a.getIndex(i);
            switch (attr) {
                case R.styleable.CirclePanelView_rightPadding:
                    Log.d(TAG,"CirclePanelView_rightPadding");
                    mRightPadding = a.getDimensionPixelSize(attr, 0);
                    break;
                case R.styleable.CirclePanelView_orientation:
                    Log.d(TAG,"CirclePanelView_orientation");
                    mOrientation = a.getInt(R.styleable.CirclePanelView_orientation,-1);
                    break;
            }
        }
        a.recycle();
    }

    private void initView() {
        //初始化画笔
        mWhiteCirclePaint = new Paint();
        mWhiteCirclePaint.setAntiAlias(true);
        mWhiteCirclePaint.setColor(Color.WHITE);
        mWhiteCirclePaint.setStyle(Paint.Style.STROKE);

        mBlueCirclePaint = new Paint();
        mBlueCirclePaint.setAntiAlias(true);
        mBlueCirclePaint.setColor(Color.parseColor("#3a84f4"));
        mBlueCirclePaint.setStyle(Paint.Style.STROKE);
        mBlueCirclePaint.setShadowLayer(10,10,10,Color.parseColor("#99000000"));


        mScaleDataPaint = new Paint();
        mScaleDataPaint.setColor(Color.WHITE);
        mScaleDataPaint.setTextSize(26);

        weightDataPaint = new Paint();
        weightDataPaint.setColor(Color.WHITE);
        weightDataPaint.setTextSize(37);
        weightDataPaint.setStyle(Paint.Style.STROKE);

        mScaleStart = 0;
        mScaleSEnd = 0;

        setLayerType(LAYER_TYPE_SOFTWARE,null);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int width = MeasureSpec.getSize(widthMeasureSpec);
        setMeasuredDimension(width,width);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
