package com.example.newframe.ui.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.dou361.ijkplayer.widget.PlayerView;
import com.example.duhongwang20180521.R;
import com.example.duhongwang20180521.bean.NewsBean;
import com.example.duhongwang20180521.ui.adapter.ChildAdapter;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created   by    Dewey
 * 站在顶峰，看世界
 * 落在谷底，思人生
 */

public class ChildFragment extends Fragment {
    private List<NewsBean.DataBean> list = new ArrayList<>();
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    private Unbinder unbinder;
    private ChildAdapter adapter;
    private Handler handler = new Handler();
    private int type;
    PlayerView play;
    private LinearLayout line;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //设置布局
        View view = inflater.inflate(R.layout.child_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);
        line = view.findViewById(R.id.line);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //获取传递的标题数据，把获取的标题转码实现
        Bundle bundle = getArguments();
        type = bundle.getInt("name", 0);

//        if (type == 2) {
//            //视频播放地址
//            String url = "http://pic.ibaotu.com/00/44/96/93k888piCRAj.mp4_10s.mp4";
//            play = new PlayerView(getActivity())
//                    .setTitle("视频")
//                    .setScaleType(PlayStateParams.fitparent)
//                    .hideMenu(true)
//                    .forbidTouch(false)
//                    .setPlaySource(url);
//            play.startPlay();
//        } else {
//            line.setVisibility(View.GONE);
//            getData(type);
//        }
        getData(type);
    }

    //请求网络数据的方法
    public void getData(int data) {
        //使用OKhttp请求网络数据
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                //https://www.apiopen.top/satinApi?type=3&page=1
                .url("https://www.apiopen.top/satinApi?type=" + type + "&page=1")
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Toast.makeText(getActivity(), "数据出错：" + e, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String result = response.body().string();
                System.out.println("返回：" + result);

                handler.post(new Runnable() {
                    @Override
                    public void run() {

                        //子线程内成功的回调
                        NewsBean bean = new Gson().fromJson(result, NewsBean.class);
                        list = bean.getData();

                        //设置布局管理器以及布局适配器
                        if (adapter == null) {
                            LinearLayoutManager manager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
                            recyclerView.setLayoutManager(manager);
                            adapter = new ChildAdapter(getActivity(), list);
                            recyclerView.setAdapter(adapter);
                        } else {
                            adapter.notifyDataSetChanged();
                        }
                    }
                });

            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    //退出页面，即生命周期结束时，停止播放视频
    @Override
    public void onStop() {
        super.onStop();
        play.stopPlay();
    }
}
