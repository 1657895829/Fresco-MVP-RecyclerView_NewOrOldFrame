package com.example.newframe.net;

import com.example.newframe.bean.ImageBean;
import com.example.newframe.bean.VideoBean;
import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * 网络请求接口类的 拼接部分
 */

public interface NewsApiService {

    @GET("satinApi?type=3&page=1")
    Observable<ImageBean> getImage();

    @GET("satinApi?type=4&page=1")
    Observable<VideoBean> getVideo();
}
