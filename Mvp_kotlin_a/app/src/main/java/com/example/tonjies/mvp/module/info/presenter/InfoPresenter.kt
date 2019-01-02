package com.example.tonjies.mvp.module.info.presenter

import android.content.Context
import android.util.Log
import com.example.tonjies.mvp.module.info.bean.Student
import com.example.tonjies.mvp.module.info.view.InfoView
import com.example.tonjies.mvp.net.Api
import com.example.tonjies.weatherx.net.RetrofitFactory
import rx.Observable
import rx.Observer
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * 获取学生信息P层类
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

    fun getData() {
        //在此处进行网络请求，并将请求结果返回给Activity，这里假设我们已经请求成功，想要返回学生数据
//        infoView?.show("数据请求成功")

        //进行网络请求
        api!!.getData()
                .observeOn(AndroidSchedulers.mainThread()) //
                .subscribeOn(Schedulers.io())
                .subscribe(object : Observer<Student> {
                    override fun onError(e: Throwable) {
                        Log.d("tonjies", e.message)
                    }

                    override fun onNext(t: Student) {
                        var studentName = t.name //学生姓名
                        var studentAge = t.age //学生年龄
                        infoView!!.show("学生的姓名是:" + studentName + "学生的年龄是:" + studentAge)
                    }

                    override fun onCompleted() {
                    }
                })
    }
}