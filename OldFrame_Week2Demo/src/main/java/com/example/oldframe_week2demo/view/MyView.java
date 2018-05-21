package com.example.oldframe_week2demo.view;

import com.example.oldframe_week2demo.bean.NewsBean;

/**
 * view层
 */
public interface MyView {
    public void onSuccess(NewsBean bean);
    public void onFailure(Exception e);
}
