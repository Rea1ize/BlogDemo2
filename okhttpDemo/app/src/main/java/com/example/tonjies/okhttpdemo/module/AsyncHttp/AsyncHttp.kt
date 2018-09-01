package com.example.tonjies.okhttpdemo.module.AsyncHttp

import okhttp3.*
import java.io.IOException

fun main(args: Array<String>) {
    sendRequest()//同步请求
//    sendAsyncRequest("http://www.wanandroid.com/tools/mockapi/2872/student")
}

/**
 * 同步请求
 */
fun sendRequest() {
    val client = OkHttpClient()
    val request: Request = Request.Builder()
            .url("http://www.wanandroid.com/tools/mockapi/2872/student")//请求地址
            .build()
    val reponse = client.newCall(request).execute()
    //如果相应成功
    if (reponse.isSuccessful) {
        //将请求到的内容输出
        print(reponse.body()!!.string())
    }
}

/**
 * 异步请求
 */
fun sendAsyncRequest(url: String) {
    val okHttpClient = OkHttpClient()
    val request: Request = Request.Builder().url(url).build()
    okHttpClient.newCall(request).enqueue(object : Callback {
        override fun onFailure(call: Call?, e: IOException?) {
            println("请求失败:${e.toString()}")
        }

        override fun onResponse(call: Call?, response: Response?) {
            if (response!!.isSuccessful) {
                println(""+response.body()!!.string())
            }
        }
    })
}
