package com.example.newframe.ui.presenter;

import com.example.newframe.bean.ImageBean;
import com.example.newframe.bean.VideoBean;
import com.example.newframe.net.NewsApi;
import com.example.newframe.ui.base.BasePresenter;
import com.example.newframe.ui.contract.NewsContract;
import java.util.List;
import javax.inject.Inject;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
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

    //使用RxJava请求网络图片处理
    @Override
    public void getNewsImage() {
        newsApi.getImage()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Function<ImageBean, List<ImageBean.DataBean>>() {

                    @Override
                    public List<ImageBean.DataBean> apply(ImageBean imgBean) throws Exception {
                        return imgBean.getData();
                    }
                }).subscribe(new Consumer<List<ImageBean.DataBean>>() {
            @Override
            public void accept(List<ImageBean.DataBean> dataBeans) throws Exception {
                if (mView != null) {
                    mView.imageData(dataBeans);
                }
            }
        });
    }

    //使用RxJava请求网络视频处理
    @Override
    public void getNewsVideo() {
        newsApi.getVideo()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Function<VideoBean, List<VideoBean.DataBean>>() {

                    @Override
                    public List<VideoBean.DataBean> apply(VideoBean videoBean) throws Exception {
                        return videoBean.getData();
                    }
                }).subscribe(new Consumer<List<VideoBean.DataBean>>() {
            @Override
            public void accept(List<VideoBean.DataBean> dataBeans) throws Exception {
                if (mView != null) {
                    mView.videoData(dataBeans);
                }
            }
        });
    }
}
