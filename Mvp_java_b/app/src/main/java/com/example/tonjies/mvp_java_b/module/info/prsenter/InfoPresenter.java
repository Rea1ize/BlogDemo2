package com.example.tonjies.mvp_java_b.module.info.prsenter;

import android.util.Log;

import com.example.tonjies.mvp_java_b.module.info.bean.Student;
import com.example.tonjies.mvp_java_b.module.info.model.InfoModel;
import com.example.tonjies.mvp_java_b.module.info.prsenter.contract.InfoContract;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 舍长 on 2019/1/4
 * describe:获取学生数据P层实现接口
 */
public class InfoPresenter implements InfoContract.InfoIPresenter {
    //声明View接口
    private InfoContract.infoView view;

    //声明Model变量
    private InfoModel infoModel;

    public InfoPresenter(InfoContract.infoView view) {
        this.view = view;
        infoModel = new InfoModel();
    }

    //获取学生数据
    @Override
    public void getData() {
        infoModel.getData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Student>() {
                    //可以在这里拦截请求
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Student student) {
                        view.show("学生姓名:" + student.getName() + "学生年龄：" + student.getAge());
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.show("获取失败" + e.getMessage());
                    }

                    //请求完成
                    @Override
                    public void onComplete() {
                        Log.d("helloWorld", "请求完成");
                    }
                });
    }

    //销毁View对象
    public void detachView() {
        view = null;
    }

}
