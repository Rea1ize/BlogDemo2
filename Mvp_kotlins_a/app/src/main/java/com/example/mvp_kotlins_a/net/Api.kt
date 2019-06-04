package com.example.mvp_kotlins_a.net


import okhttp3.ResponseBody
import retrofit2.http.GET
import rx.Observable

/**
 * Created by 舍长 on 2019/5/30
 * describe:
 */
interface Api {

    //获取网络数据
    @GET("get")//接口的后段部分
    fun getData(): Observable<ResponseBody>
}