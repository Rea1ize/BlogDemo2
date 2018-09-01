package com.example.tonjies.view.module.canvasx;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.tonjies.view.util.L;

/**
 * canvas类
 */
public class XView extends View {

    /**
     * 只含有一个参数Context,在代码中创建组件时会被调用
     * 例如XView xView=new XView
     * @param context
     */
    public XView(Context context) {
        super(context);
        L.d("在代码创建时被调用");
    }

    /**
     * 在xml加载时被调用
     * @param context
     * @param attrs
     */
    public XView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        L.d("在xml加载时被调用");
    }

    /**
     * 解释一下Canvas类，如果把XView类比作一个画板，那么Canvas就好比我们放在画板上的画纸，
     * 之后我们绘制的东西，就是呈现在该画纸上
     * @param canvas
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.parseColor("#03A9F4"));//使用java代码调用颜色
    }
}
