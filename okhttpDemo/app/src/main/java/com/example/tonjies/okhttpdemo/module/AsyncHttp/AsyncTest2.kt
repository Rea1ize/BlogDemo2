package com.example.tonjies.okhttpdemo.module.AsyncHttp

import okhttp3.*
import java.io.IOException

fun main(args: Array<String>) {
    println("一，当前的线程是:${Thread.currentThread().name}")
    sendAsyncRequest2("http://www.wanandroid.com/tools/mockapi/2872/student")
    println("三，当前的线程是:${Thread.currentThread().name}")
}

/**
 * 异步请求
 */
fun sendAsyncRequest2(url: String) {
    val okHttpClient = OkHttpClient()
    val request: Request = Request.Builder().url(url).build()
    okHttpClient.newCall(request).enqueue(object : Callback {
        override fun onFailure(call: Call?, e: IOException?) {

        }

        override fun onResponse(call: Call?, response: Response?) {
            if (response!!.isSuccessful) {
                print("二，网络请求，当前的线程是:${Thread.currentThread().name}")
                println("" + response.body()!!.string())

            }
        }
    })
}
