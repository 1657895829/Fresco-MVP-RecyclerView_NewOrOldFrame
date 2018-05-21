package com.example.newframe.ui.presenter;

import com.example.duhongwang20180521.bean.NewsBean;
import com.example.duhongwang20180521.net.NewsApi;
import com.example.duhongwang20180521.ui.base.BasePresenter;
import com.example.duhongwang20180521.ui.contract.NewsContract;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * p层 继承自定义内容
 */

public class NewsPresenter extends BasePresenter<NewsContract.View> implements NewsContract.Presenter {
    private NewsApi newsApi;

    @Inject
    public NewsPresenter(NewsApi newsApi){
        this.newsApi = newsApi;
    }

    //使用RxJava请求网络处理
    @Override
    public void getData() {
        newsApi.getNewsApi()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<NewsBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(NewsBean bean) {
                        mView.newsData(bean);
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
