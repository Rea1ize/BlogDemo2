package com.example.music

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_service.*

/**
 * Created by 舍长
 * describe:通过服务来播放音乐
 */
class ServiceActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service)
            btn_01.setOnClickListener {
                //启动服务
                startService(Intent(this,MyService::class.java))
            }
    }
}
