package com.example.oldframe_week2demo.model;

import com.example.oldframe_week2demo.bean.NewsBean;

/**
 * model层接口类
 */
public interface ModelCallBack {
    public void onSuccess(NewsBean bean);
    public void onFailure(Exception e);
}
