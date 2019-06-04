package com.example.mvp_kotlins_a.module.info

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.mvp_kotlins_a.R
import com.example.mvp_kotlins_a.module.info.presenter.InfoPresenter
import com.example.mvp_kotlins_a.module.info.view.InfoView
import kotlinx.android.synthetic.main.activity_info.*

/**
 * Created by 舍长
 * describe:在P层获取完网络数据后显示在界面上
 */
class InfoActivity : AppCompatActivity(), InfoView {

    //声明p层接口
    private var infoPresenter = InfoPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)
        //完成对view接口的绑定，此时p层还没有该方法
        infoPresenter.attachView(this)
        btnSend.setOnClickListener {
            infoPresenter.getData()
        }
    }

    /**
     * O层返回数据的回调方法
     */
    override fun show(msg: String) {
        //将请求到的数据设置到TextView上
        txtStudentInfo.text = msg
    }

    override fun onDestroy() {
        super.onDestroy()
        //销毁P层，防止内存泄漏，同样，此时还有没该方法
        infoPresenter.detechView()
    }
}
