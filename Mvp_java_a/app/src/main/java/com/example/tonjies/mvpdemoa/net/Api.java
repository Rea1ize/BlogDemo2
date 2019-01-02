package com.example.tonjies.mvpdemoa.net;


import com.example.tonjies.mvpdemoa.module.info.bean.Student;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface Api {

    //获取学生数据信息
    @GET("2872/student")
    Observable<Student> getData();
}
