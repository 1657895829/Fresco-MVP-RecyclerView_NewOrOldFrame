package com.example.oldframe_week2demo.model;

import com.example.oldframe_week2demo.bean.NewsBean;
import com.example.oldframe_week2demo.utils.APIGet_Post_Factory;
import com.example.oldframe_week2demo.utils.AbstractObserver;

/**
 * model层实现类
 */

public class MyModel {
    /**
     * 使用Retrofit结合RxJava,Okhttp工具类get请求数据
     * @param callBack
     */
    public void getData(int id,final ModelCallBack callBack){
        //调用封装的请求方式的单例模式执行类请求接口

        APIGet_Post_Factory.getInstance().get("/satinApi?type=" + id + "&page=1", new AbstractObserver<NewsBean>() {
            @Override
            public void onSuccess(NewsBean bean) {
                callBack.onSuccess(bean);
            }

            @Override
            public void onFailure(Exception e) {
                callBack.onFailure(e);
            }
        });
    }
}
