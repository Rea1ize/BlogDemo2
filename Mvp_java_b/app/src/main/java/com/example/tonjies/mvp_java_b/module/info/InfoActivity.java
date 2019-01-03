package com.example.tonjies.mvp_java_b.module.info;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.tonjies.mvp_java_b.R;
import com.example.tonjies.mvp_java_b.module.info.prsenter.InfoPresenter;
import com.example.tonjies.mvp_java_b.module.info.prsenter.contract.InfoContract;

import org.jetbrains.annotations.Contract;
/**
 * 获取学生信息Activity
 */
public class InfoActivity extends AppCompatActivity implements InfoContract.infoView{
    private Button button;

    //声明P层变量
    private InfoPresenter infoPresenter;

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        infoPresenter=new InfoPresenter(this);
        button=findViewById(R.id.btn_01);//点击请求
        textView=findViewById(R.id.txt_01);//显示文本
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                infoPresenter.getData();//进行网络请求
            }
        });
    }

    /**
     * 在P层中回调的方法
     * @param msg
     */
    @Override
    public void show(String msg) {
        textView.setText("获取到的学生数据:"+msg);
    }

    /**
     * 销毁View对象
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        infoPresenter.detachView();
    }
}
