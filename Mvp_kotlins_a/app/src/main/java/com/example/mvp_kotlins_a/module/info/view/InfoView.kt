package com.example.mvp_kotlins_a.module.info.view

/**
 * 用于在P层将数据返回给Activity,使用方法是
 * 让需要传递数据的Activity继承该接口，再将Activity本身传递到P层里面
 * 然后调用显示数据的方法
 */
interface InfoView {
    //展示数据
    fun show(msg: String)
}