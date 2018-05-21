package com.example.wangguo20180521.base;

/**
 * Created by muhanxi on 17/12/5.
 */

public class BasePresenter<V> {

    public V view ;

    public void attach(V v){
        this.view = v;
    }

    public void detach(){
        this.view = null;
    }

}
