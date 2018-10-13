package com.example.tonjies.view.module.edit;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.EditText;

import com.example.tonjies.view.R;

/**
 * Created by 舍长 on 2018/4/14.
 * 描述: 登录模块-自定义带显示，隐藏密码功能的editText
 */
@SuppressLint("AppCompatCustomView")
public class EyeEditText extends EditText {

    //    Context
    private Context contexts;

    //    要设置的图片
    private Drawable drawable;


    public EyeEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.contexts = context;
//        初始化数据
        init();
    }

    private void init() {

//
//        输入类型为普通文本TYPE_CLASS_TEXT,输入类型为数字密码
        setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
//        显示隐藏图标
        drawable = contexts.getResources().getDrawable(R.drawable.select_eyeclose);
        setCompoundDrawablesWithIntrinsicBounds(null, null, drawable, null);
//        监听输入相应
        addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            //            当有输入值时，突变显示
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
//        if (length() < 1)
//           当输入量小于1时在输入框右边不显示图像
//            setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
//        else
//           当输入量大于等于1时在输入框右边显示图像
//            setCompoundDrawablesWithIntrinsicBounds(null, null, drawable, null);
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
            if (rect.contains(eventX, eventY)) {
                //记住光标开始的位置
                int pos = getSelectionStart();
                if (getInputType() != (InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD)) {//隐藏密
                    drawable = contexts.getResources().getDrawable(R.drawable.select_eyeclose);
                    setCompoundDrawablesWithIntrinsicBounds(null, null, drawable, null);
                    setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                } else {//显示密码
                    drawable = contexts.getResources().getDrawable(R.drawable.select_eyeopen);
                    setCompoundDrawablesWithIntrinsicBounds(null, null, drawable, null);
//                 TYPE_TEXT_VARIATION_VISIBLE_PASSWORD   输入对用户可见的密码
                    setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                }
                setSelection(pos);
            }
        }
        return super.onTouchEvent(event);
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
}
