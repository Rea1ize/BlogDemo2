package com.example.tonjies.mvp_java_b.module.refrence;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.tonjies.mvp_java_b.R;
import com.example.tonjies.mvp_java_b.module.info.bean.Student;
import com.example.tonjies.mvp_java_b.net.Api;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 舍长
 * describe:参考Activity
 */
public class RefrenceActivity extends AppCompatActivity {

    private Api api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refrence);
        //Model完成的
        Observable<Student> data = api.getData();

        //presenter完成的
        data.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Student>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(Student student) {
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
