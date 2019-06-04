package com.example.music

import android.content.Intent
import android.media.AudioManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
/**
 * Created by 舍长
 * describe:
 * SimpleUseActivity: 简单播放音乐
 * ServiceActivity ：通过Service播放音乐
 * AudioActivity ：声音管理器的使用
 */
class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnSimple.setOnClickListener(this)
        btnService.setOnClickListener(this)
        btnAudioManger.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnSimple -> {
                startActivity(Intent(this, SimpleUseActivity::class.java))
            }
            R.id.btnService -> {
                startActivity(Intent(this, ServiceActivity::class.java))
            }
            R.id.btnAudioManger -> {
                startActivity(Intent(this, AudioActivity::class.java))
            }
        }
    }

}
