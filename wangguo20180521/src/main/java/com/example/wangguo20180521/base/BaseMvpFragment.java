package com.example.wangguo20180521.base;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public abstract class BaseMvpFragment<V,T extends BasePresenter<V>> extends Fragment {

    public abstract T initPresenter();
    public T presenter ;
    public Context context ;

    public BaseMvpFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        presenter = initPresenter() ;
        context = getActivity() ;
       return  null;
    }


    @Override
    public void onResume() {
        super.onResume();
        presenter.attach((V) this);


    }


    @Override
    public void onDetach() {
        super.onDetach();
        presenter.detach();
    }
}
