package com.example.wangguo20180521.base;

import android.app.Activity;
import android.os.Bundle;

public abstract class BaseMvpActivity<V,T extends BasePresenter<V>> extends Activity {

    public abstract T initPresenter();
    public  T presnter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presnter = initPresenter();



    }


    @Override
    protected void onResume() {
        super.onResume();
        presnter.attach((V) this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presnter.detach();
    }
}
