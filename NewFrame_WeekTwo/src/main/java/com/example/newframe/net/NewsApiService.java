package com.example.newframe.net;

import com.example.duhongwang20180521.bean.NewsBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

/**
 * 网络请求接口类的 拼接部分
 */

public interface NewsApiService {
    @GET("satinApi?type=3&page=1")
    Observable<NewsBean>  getData();

    @GET
    Observable<String> get(@Url String url, @QueryMap Map<String, String> map);

}
