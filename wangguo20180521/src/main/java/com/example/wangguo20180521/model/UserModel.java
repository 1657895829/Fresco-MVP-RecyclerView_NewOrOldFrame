package com.example.wangguo20180521.model;

import com.example.wangguo20180521.bean.User;
import com.example.wangguo20180521.utils.APIFactory;
import com.example.wangguo20180521.utils.AbstractObserver;

/**
 * Created by lenovo on 2018/5/21.
 */

public class UserModel {
    public void success(int id, final UserCallback callback){
        APIFactory.getInstance().get("satinApi?type=" + id + "&page=1", new AbstractObserver<User>() {
            @Override
            public void onSuccess(User user) {
                callback.successs(user);
            }

            @Override
            public void onFailure(int code) {

            }
        });
    }
}
