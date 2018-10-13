package com.example.tonjies.services.module.service

import android.app.AlarmManager
import android.app.Notification
import android.app.PendingIntent
import android.app.Service
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Binder
import android.os.Build
import android.os.IBinder
import android.os.SystemClock
import android.support.v4.app.NotificationCompat
import com.example.tonjies.services.MainActivity
import com.example.tonjies.services.R
import com.example.tonjies.services.module.util.L
import org.jetbrains.anko.doAsync
import java.lang.Thread.sleep

class MyService : Service() {


    /**
     * 可以被多次调用
     */
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return super.onStartCommand(intent, flags, startId)
    }


    /**
     * 用于和Activity之间的通信
     */
    override fun onBind(intent: Intent): IBinder {
//        TODO("Return the communication channel to the service.")
//        加入这一行
        return Binder()
    }

    /**
     * 开始服务是被调用
     */
    override fun onCreate() {
        super.onCreate()
        //自己封装的log工具类
        L.d("执行onCreate方法，服务被创建")
        //
        var i = 0
        //AnKo，开启一个异步请求
        doAsync {
            while (true) {
//              打印Log显示
                val s = "正在播放第" + i + "首音乐"

                L.d(s)
                i++
                sleep(1600)
            }
        }
        val intent = Intent(this@MyService, MyService::class.java)
        val pi = PendingIntent.getActivity(this@MyService, 0, intent, 0)
        val notification = NotificationCompat.Builder(this@MyService)
                .setContentTitle("小白音乐")
                .setContentText("音乐")
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(resources, R.mipmap.ic_launcher))
                .setContentIntent(pi)
                .build()

    }

    /**
     * 停止服务时被调用
     */
    override fun onDestroy() {
        super.onDestroy()
        L.d("执行onDestroy方法，服务被销毁")
    }

}
