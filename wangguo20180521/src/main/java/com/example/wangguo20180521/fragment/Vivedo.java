package com.example.wangguo20180521.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wangguo20180521.R;
import com.example.wangguo20180521.adapter.MyAdapter;
import com.example.wangguo20180521.adapter.VideoAdapter;
import com.example.wangguo20180521.bean.User;
import com.example.wangguo20180521.presenter.UserPresenter;
import com.example.wangguo20180521.view.UserView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by lenovo on 2018/5/21.
 */

public class Vivedo extends Fragment implements UserView{
    @BindView(R.id.rv1)
    RecyclerView rv1;
    Unbinder unbinder;
    private UserPresenter presenter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.vivedo, null);
        unbinder = ButterKnife.bind(this, view);
        presenter = new UserPresenter((UserView) this);
        presenter.attach(4);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        presenter.detavh();
    }

    @Override
    public void successs(User user) {
        LinearLayoutManager manager=new LinearLayoutManager(getActivity());
        rv1.setLayoutManager(manager);
        rv1.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        VideoAdapter adapter=new VideoAdapter(getActivity(),user);
        rv1.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}
