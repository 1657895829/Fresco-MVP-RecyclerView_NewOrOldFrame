package com.example.newframe.net;

import com.example.newframe.bean.ImageBean;
import com.example.newframe.bean.VideoBean;
import io.reactivex.Observable;

/**
 * 网络请求，使用Observable封装实现
 */
public class NewsApi {
    private NewsApiService service;
    private static NewsApi newsApi;

    public NewsApi(NewsApiService service) {
        this.service = service;
    }

    public static NewsApi getDataApi(NewsApiService service){
        if (newsApi == null){
            newsApi = new NewsApi(service);
        }
        return newsApi;
    }

    public Observable<ImageBean> getImage(){
        return service.getImage();
    }

    public Observable<VideoBean> getVideo(){
        return service.getVideo();
    }

}
