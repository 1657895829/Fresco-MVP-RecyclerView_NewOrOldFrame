package com.example.newframe.ui.contract;

import com.example.duhongwang20180521.bean.NewsBean;
import com.example.duhongwang20180521.ui.base.BaseContract;

/**
 * 定义协议接口
 */

public interface NewsContract {
    interface View extends BaseContract.BaseView{
        void newsData(NewsBean bean);
    }

    interface Presenter extends BaseContract.BasePresenter<View>{
        void getData();
    }
}
