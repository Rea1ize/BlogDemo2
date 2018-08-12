package com.example.tonjies.mvpdemoa.module.info.presenter;


import android.content.Context;
import android.util.Log;

import com.example.tonjies.mvpdemoa.module.info.bean.Student;
import com.example.tonjies.mvpdemoa.module.info.view.InfoView;
import com.example.tonjies.mvpdemoa.net.Api;
import com.example.tonjies.mvpdemoa.net.RetrofitHelper;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import static com.example.tonjies.mvpdemoa.net.RetrofitHelper.getInstance;

public class InfoPresenter {

    //View对象
    private InfoView infoView;

    //Api
    private Api api;

    //绑定View对象
    public void attachView(InfoView view) {
        this.infoView = view;
        //实例化api类
        api = RetrofitHelper.getInstance().getServer();
    }

    //销毁View对象
    public void detachView() {
        infoView = null;
    }

    public void getData() {
        //在此处进行网络请求，并将请求结果返回给Activity，这里假设我们已经请求成功，想要返回学生数据
//        infoView.show("学生姓名：tonjies，学生年龄：20！");
        api.getData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Student>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Student student) {
                        infoView.show("学生姓名:" + student.getName() + "学生年龄：" + student.getAge());
                    }

                    @Override
                    public void onError(Throwable e) {
                        infoView.show("获取失败"+e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
