package com.example.tonjies.mvp_java_b.module.info.model;

import com.example.tonjies.mvp_java_b.module.info.bean.Student;
import com.example.tonjies.mvp_java_b.net.Api;
import com.example.tonjies.mvp_java_b.net.RetrofitHelper;

import io.reactivex.Observable;

/**
 * Created by 舍长 on 2019/1/4
 * describe:请求学生信息的Model层类
 */
public class InfoModel {
    private Api api;

    public InfoModel() {
        api = RetrofitHelper.getInstance().getServer();
    }

    /**
     * 请求学生数据,返回Observable对象
     */
    public Observable<Student> getData(){
        //查询数据库，拿出参数

        return api.getData();
    }
}
