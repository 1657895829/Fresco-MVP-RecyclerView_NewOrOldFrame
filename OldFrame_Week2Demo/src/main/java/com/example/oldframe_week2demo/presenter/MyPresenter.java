package com.example.oldframe_week2demo.presenter;

import com.example.oldframe_week2demo.base.BasePresenter;
import com.example.oldframe_week2demo.bean.NewsBean;
import com.example.oldframe_week2demo.model.ModelCallBack;
import com.example.oldframe_week2demo.model.MyModel;
import com.example.oldframe_week2demo.view.MyView;

/**
 * Presenter层,继承自定义的泛型Presenter层（持有view层接口），进行view层与model数据的交互
 */

public class MyPresenter extends BasePresenter<MyView> {
    //声明model层
    private MyModel myModel;

    public MyPresenter() {
        this.myModel = new MyModel();
    }

    //获取数据的方法
    public void get(int id){
        myModel.getData(id,new ModelCallBack() {
            @Override
            public void onSuccess(NewsBean bean) {
                view.onSuccess(bean);
            }

            @Override
            public void onFailure(Exception e) {
                view.onFailure(e);
            }
        });
    }

    //取消绑定，防止内存泄露
    @Override
    public void detach(){
        view = null;
    }
}
