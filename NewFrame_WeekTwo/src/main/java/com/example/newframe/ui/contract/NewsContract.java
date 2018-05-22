package com.example.newframe.ui.contract;

import com.example.newframe.bean.ImageBean;
import com.example.newframe.bean.VideoBean;
import com.example.newframe.ui.base.BaseContract;

import java.util.List;

/**
 * 定义协议接口
 */

public interface NewsContract {
    interface View extends BaseContract.BaseView{
        void imageData(List<ImageBean.DataBean>  imageList );
        void videoData(List<VideoBean.DataBean>  videoList );
    }

    interface Presenter extends BaseContract.BasePresenter<View>{
        void getNewsImage();
        void getNewsVideo();
    }
}
