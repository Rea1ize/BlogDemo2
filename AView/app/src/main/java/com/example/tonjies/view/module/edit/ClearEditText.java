package com.example.tonjies.view.module.edit;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.EditText;

import com.example.tonjies.view.R;


/**
 * Created by 舍长 on 2018/4/14.
 * 描述: 登录模块-自定义带删除功能的editText
 */
@SuppressLint("AppCompatCustomView")
public class ClearEditText extends EditText {

    private Context contexts;
    private Drawable drawable;

    public ClearEditText(Context context) {
        super(context);

    }

    public ClearEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.contexts = context;
        init();
    }

    private void init() {
        drawable = contexts.getResources().getDrawable(R.drawable.ic_clear_black_24dp);
        addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                setDrawable();
            }
        });
    }

    /**
     * 绘制删除图片
     */
    private void setDrawable() {
        if (length() < 1)
            setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        else
            setCompoundDrawablesWithIntrinsicBounds(null, null, drawable, null);
    }


    //当触摸范围在右侧时，触发删除方法，隐藏叉叉
    @Override
    public boolean onTouchEvent(MotionEvent event) {
//      ACTION_UP 弹起事件
        if (drawable != null && event.getAction() == MotionEvent.ACTION_UP) {
            int eventX = (int) event.getRawX();
            int eventY = (int) event.getRawY();
            Rect rect = new Rect();
            getGlobalVisibleRect(rect);
            rect.left = rect.right - 100;
            if (rect.contains(eventX, eventY))
                setText("");
        }
        return super.onTouchEvent(event);
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
}
