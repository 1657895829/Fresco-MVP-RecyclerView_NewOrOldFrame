package com.example.oldframe_week2demo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.oldframe_week2demo.R;
import com.example.oldframe_week2demo.adapter.ImageAdapter;
import com.example.oldframe_week2demo.base.BaseMvpFragment;
import com.example.oldframe_week2demo.bean.NewsBean;
import com.example.oldframe_week2demo.presenter.MyPresenter;
import com.example.oldframe_week2demo.view.MyView;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created   by    Dewey
 * 子 Fragment 显示图片数据
 */
public class ImageFragment extends BaseMvpFragment<MyView,MyPresenter> implements MyView {
    private List<NewsBean.DataBean> list = new ArrayList<>();
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    private Unbinder unbinder;

    //声明presenter层,与view层交互
    @Override
    public MyPresenter initPresenter() {
        return new MyPresenter();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //设置布局
        View view = inflater.inflate(R.layout.image_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //p层请求数据
        p.get(3);
    }


    @Override
    public void onSuccess(NewsBean bean) {
        //设置布局管理器以及布局适配器,添加分割线
        LinearLayoutManager manager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        ImageAdapter adapter = new ImageAdapter(getActivity(), bean.getData());
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onFailure(Exception e) {
        System.out.println("数据出错：" + e);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    //实现presenter内部的防止内存溢出方法
    @Override
    public void onDestroy() {
        super.onDestroy();
        p.detach();
    }
}
