package com.example.appk.module.canvasx

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.View
import com.example.appk.util.L

class XView: View{
    /**
     * 只含有一个参数Context，在代码创建组件时会被调用
     * 例如val xView=XView(this)
     */
    constructor(context: Context?) : super(context){
        L.d("在代码创建时被调用")
    }

    /**
     * 在xml加载时被调用
     */
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs){
        L.d("在xml加载时被调用")
    }

    /**
     * 如果把XView类比作一块画板，那么Canvas就好比我们放在画板上的画纸，
     * 之后我们绘制的东西，就是呈现在该画纸上
     */
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
    }
}