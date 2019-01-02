package com.example.tonjies.view.module.path;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.tonjies.view.R;

/**
 * Path类
 */
public class XViewc extends View {

    private Paint paint;

    public XViewc(Context context) {
        super(context);
    }

    public XViewc(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setStyle(Paint.Style.STROKE);//设置画笔类型为描边
//        paint.setStyle(Paint.Style.FILL);//设置画笔类型为填充
        paint.setStrokeWidth(8);//设置画笔宽度
        paint.setColor(getResources().getColor(R.color.colorAccent));

        //初始化Path
        Path path=new Path();
        path.moveTo(200,200);//moveTo方法是移动路径绘制起点位置，起点位置是(200,200)
        path.lineTo(400,200);//lineTo方法在起点(200,200)到(400,200)之间绘制一条线段
        path.lineTo(200,400);//linTo方法在起点(400,200)到(200,400)之间绘制一条直线，该直线在我们的图像中，就是斜线
        path.close();//close()方法会产生一条最短的线段闭合我们的路径，两点之间直线最短嘛，该直线在我们的图形中，就是点1(200,200)到点3(200,400)之间的直线

        //调用canvas的drawPath，把path和画笔作为参数传递进入
        canvas.drawPath(path,paint);
    }
}
