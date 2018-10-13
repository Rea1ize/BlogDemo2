package com.example.tonjies.services

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.tonjies.services.module.service.MyService
//引入布局文件
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //
        init()
    }

    private fun init() {
        btnStart.setOnClickListener(this)
        btnStop.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            //开始服务
            R.id.btnStart -> {
                val intent = Intent(this@MainActivity, MyService::class.java)
                startService(intent)
            }
            //结束服务
            R.id.btnStop -> {
                val intent = Intent(this@MainActivity, MyService::class.java)
                stopService(intent)
            }
        }
    }
}
