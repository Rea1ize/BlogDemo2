package com.example.tonjies.mvp.module

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.tonjies.mvp.R
import com.example.tonjies.mvp.R.id.btnSend
import com.example.tonjies.mvp.R.id.txtStudentInfo
import com.example.tonjies.mvp.module.info.presenter.InfoPresenter
import com.example.tonjies.mvp.module.info.view.InfoView
import kotlinx.android.synthetic.main.activity_info.*

/**
 * 获取学生信息Activity
 */
class InfoActivity : AppCompatActivity(), InfoView {

    //声明p层接口
    private var infoPresenter = InfoPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)
        infoPresenter.attachView(this)
        btnSend.setOnClickListener {
            infoPresenter.getData()
        }
    }

    override fun show(msg: String) {
        //将请求到的数据设置到TextView上
        txtStudentInfo.text = msg
    }

    override fun onDestroy() {
        super.onDestroy()
        infoPresenter.detechView()
    }
}
