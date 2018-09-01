package com.example.tonjies.view.module.paint;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Point类
 */
public class XViewb extends View {

    private Paint paint;

    public XViewb(Context context) {
        super(context);
    }

    public XViewb(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setStyle(Paint.Style.FILL);//设置画笔类型
        paint.setStrokeWidth(200f);//设置画笔宽度
        paint.setColor(Color.parseColor("#03A9F4"));//设置画笔颜色
        canvas.drawPoint(0,0,paint);//设置坐标为0
    }
}
