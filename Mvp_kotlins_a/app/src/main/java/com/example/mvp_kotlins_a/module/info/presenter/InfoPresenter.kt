package com.example.mvp_kotlins_a.module.info.presenter

import android.content.Context
import android.util.Log
import com.example.mvp_kotlins_a.module.info.view.InfoView
import com.example.mvp_kotlins_a.net.Api
import com.example.mvp_kotlins_a.net.RetrofitFactory
import okhttp3.ResponseBody
import rx.Observer
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * Created by 舍长 on 2019/5/30
 * describe:用于抽取Activity层的代码
 */
class InfoPresenter {

    //View接口
    private var infoView: InfoView? = null

    //声明Api接口api
    private var api: Api? = null

    constructor() {
        //初始化RetrofitFactory
        api = RetrofitFactory.instance.create(Api::class.java);
    }


    //绑定View
    fun attachView(view: InfoView) {
        this.infoView = view
    }

    //销毁View对象
    fun detechView() {
        infoView = null
    }


    /**
     * 再此处进行网络请求，并将请求到的结果返回给Activity，
     * 这里我们使用伪代码，假装已经请求成功，现在我们需要把获取到
     * 的数据返回给Activity，需要怎么做呢？
     */
    fun getData() {
//        var data = "从网络获取到的数据"
//        infoView?.show(data)//返回相应的数据
        //进行网络请求
        //进行网络请求
        api?.getData()
            ?.observeOn(AndroidSchedulers.mainThread()) //
            ?.subscribeOn(Schedulers.io())
            ?.subscribe(object : Observer<ResponseBody> {
                override fun onError(e: Throwable) {
                    Log.d("tonjies", e.message)
                }

                override fun onNext(t: ResponseBody) {
                    infoView?.show(t.string().toString())//返回相应的数据
                }

                override fun onCompleted() {
                }
            })
    }
}