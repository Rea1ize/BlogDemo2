package com.example.music

import android.content.pm.PackageManager
import android.icu.lang.UCharacter.GraphemeClusterBreak.L
import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_simple_use.*

/**
 * Created by 舍长
 * describe:MediaPlayer的简单使用
 */
class SimpleUseActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple_use)
        btnNet.setOnClickListener(this)
        btnSD.setOnClickListener(this)
        btnRaw.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnNet -> {
                playNet()
            }
            R.id.btnRaw -> {
                playRaw()
            }
            R.id.btnSD -> {
                if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE), 1)
                } else {
                    initSD()
                }
            }
        }
    }

        /**
         * 播放SD卡的资源文件
         */
        private fun initSD() {
            //1,创建Mediaplayer对象
            val media = MediaPlayer()
            //2,重置
            media.reset()//重置
            //3，设置播放源
            val externalStorageDirectory = Environment.getExternalStorageDirectory()
            val s = "$externalStorageDirectory/music.mp3"
            Log.d("tonjies","最終文件的播放源:$s")
            media.setDataSource(s)
            //4，进入准备状态
            media.prepare()
            //5,播放音乐
            media.start()
        }

    //延迟初始化
    private lateinit var mediaPlayer: MediaPlayer
    /**
     * 播放raw文件夹下的music.mp3文件
     */
    private fun playRaw() {
        //通过create方法创建的MediaPlayer对象不需要再调用prepare方法了
        //因为在create中已经调用过prepare方法了，再次调用反而会报错
        //R.raw.music
        mediaPlayer = MediaPlayer.create(this, R.raw.music)
        mediaPlayer.start()
    }

    /**
     * 在离开的时候将MediaPlayer销毁
     */
    override fun onDestroy() {
        super.onDestroy()
//        mediaPlayer.pause()//暂停播放
        mediaPlayer.stop()
        mediaPlayer.release()
    }

    /**
     * 放网络音频
     * http://sc1.111ttt.cn:8282/2018/1/03m/13/396131229550.m4a?tflag=1546606800&pin=97bb2268ae26c20fe093fd5b0f04be80#.mp3
     * 1,添加网络权限
     */
    private fun playNet() {
        //2,创建MediaPlayer
        val media = MediaPlayer()
        //3,重置ediaPlayer
        media.reset()
        //4,设置播放源
        media.setDataSource("http://sc1.111ttt.cn:8282/2018/1/03m/13/396131229550.m4a?tflag=1546606800&pin=97bb2268ae26c20fe093fd5b0f04be80#.mp3")
        //5,激活MediaPlayer
        media.prepare()
        //6,开始播放
        media.start()
    }
}
