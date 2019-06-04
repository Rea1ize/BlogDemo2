package com.example.music

import android.app.Service
import android.content.Intent
import android.media.AudioManager
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.view.View
import kotlinx.android.synthetic.main.activity_audio.*

/**
 * Created by 舍长
 * describe:AudioManager的使用
 */
class AudioActivity : AppCompatActivity(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_audio)
        btnUp.setOnClickListener(this)
        btnDown.setOnClickListener(this)
        btnMute.setOnClickListener(this)
        btnUnMute.setOnClickListener(this)
        btn_01.setOnClickListener {
            //启动服务
            startService(Intent(this, MyService::class.java))
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onClick(v: View?) {
        //1,获取声音管理器
        var manager = getSystemService(Service.AUDIO_SERVICE) as AudioManager
        //2,操作
        when (v?.id) {
            //增大声音
            R.id.btnUp -> {
                //ADJUST_RAISE升高声音 对应的还有ADJUST_LOWER降低声音
                //AudioManager.FLAG_SHOW_UI 显示系统调节声音进度条,FLAG_PLAY_SOUND只有提示音
                manager.adjustStreamVolume(
                    AudioManager.STREAM_MUSIC,
                    AudioManager.ADJUST_RAISE,
                    AudioManager.FLAG_SHOW_UI
                )
            }
            //减小声音
            R.id.btnDown -> {
                //ADJUST_RAISE升高声音 对应的还有ADJUST_LOWER降低声音
                //AudioManager.FLAG_SHOW_UI 显示系统调节声音进度条,FLAG_PLAY_SOUND只有提示音
                manager.adjustStreamVolume(
                    AudioManager.STREAM_MUSIC,
                    AudioManager.ADJUST_LOWER,
                    AudioManager.FLAG_SHOW_UI
                )
            }
            //静音
            R.id.btnMute -> {
                //API>=23
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    manager.adjustStreamVolume(
                        AudioManager.STREAM_MUSIC,
                        AudioManager.ADJUST_MUTE,
                        AudioManager.FLAG_SHOW_UI
                    )
                }else{
                    //API<23
                    manager.setStreamMute(AudioManager.STREAM_MUSIC, true)
                }
            }
            //非静音
            R.id.btnUnMute -> {
                //API>=23
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    manager.adjustStreamVolume(
                        AudioManager.STREAM_MUSIC,
                        AudioManager.ADJUST_MUTE,
                        AudioManager.FLAG_SHOW_UI
                    )
                }else{
                    //API<23
                    manager.setStreamMute(AudioManager.STREAM_MUSIC, false)
                }
            }
        }
    }
}
