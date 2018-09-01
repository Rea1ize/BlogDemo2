package com.example.tonjies.okhttpdemo.module.AsyncHttp

import okhttp3.OkHttpClient
import okhttp3.Request

fun main(args: Array<String>) {
    println("一，当前的线程是:${Thread.currentThread().name}")
    sendRequest2()
    println("三，当前的线程是:${Thread.currentThread().name}")
}

/**
 * 同步请求
 */
fun sendRequest2() {
    val client = OkHttpClient()
    val request: Request = Request.Builder()
            .url("http://www.wanandroid.com/tools/mockapi/2872/student")
            .build()
    val reponse = client.newCall(request).execute()
    if (reponse.isSuccessful) {
        print("二，当前的线程是:${Thread.currentThread().name}")
        println(reponse.body()!!.string())
    }
}

