package com.example.newframe.net;

import com.example.duhongwang20180521.bean.NewsBean;

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

    public static NewsApi getNewsApi(NewsApiService service){
        if (newsApi == null){
            newsApi = new NewsApi(service);
        }
        return newsApi;
    }

    public Observable<NewsBean> getNewsApi(){
        return service.getData();
    }

}
