package com.example.tonjies.mvp_java_b.module.info.prsenter.contract;

/**
 * Created by 舍长 on 2019/1/3
 * describe:Contract层
 */
public interface InfoContract {

    /**
     * 学生信息view接口，用来进行P层和Activity的消息传输
     */
    interface infoView {
        void show(String msg);//请求返回的数据
    }

    /**
     * 学生信息P层实现接口，用来对Presenter类进行一些"约束"
     */
    interface InfoIPresenter{
        void getData();//获取学生数据
        //方法1
        //方法2
        //方法3
    }
}
