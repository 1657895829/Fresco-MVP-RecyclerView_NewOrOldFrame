package com.example.newframe.ui.fragment;

import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.example.newframe.R;
import com.example.newframe.bean.ImageBean;
import com.example.newframe.bean.VideoBean;
import com.example.newframe.component.DaggerHttpComponent;
import com.example.newframe.ui.adapter.VideoAdapter;
import com.example.newframe.ui.base.BaseFragment;
import com.example.newframe.ui.contract.NewsContract;
import com.example.newframe.ui.presenter.NewsPresenter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created   by    Dewey
 * 子 Fragment 显示视频数据
 */
public class VideoFragment extends BaseFragment<NewsPresenter> implements NewsContract.View {
    private List<VideoBean.DataBean> data = new ArrayList<>();
    private VideoAdapter adapter;

    //声明布局
    @Override
    public int getContentLayout() {
        return R.layout.video_fragment;
    }

    @Override
    public void inject() {
        DaggerHttpComponent.builder()
                .build()
                .inject(this);
    }

    @Override
    public void initView(View view) {
        //设置布局管理器以及布局适配器,添加分割线
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        adapter = new VideoAdapter(getActivity(),data);
        recyclerView.setAdapter(adapter);

        //先去请求数据
        mPresenter.getNewsVideo();
    }

    @Override
    public void imageData(List<ImageBean.DataBean> imageList) {

    }

    @Override
    public void videoData(List<VideoBean.DataBean> videoList) {
        if (adapter != null) {
            adapter.addData(videoList);
        }
    }
}
