package com.example.music

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.Binder
import android.os.IBinder
/**
 * Created by 舍长
 * describe:通过服务来播放音乐
 */
class MyService : Service() {

    override fun onBind(intent: Intent): IBinder {
        return Binder()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return START_NOT_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.stop()
        mediaPlayer.release()
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

    override fun onCreate() {
        super.onCreate()
        playRaw()
    }
}
