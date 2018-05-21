package com.example.wangguo20180521.presenter;

import com.example.wangguo20180521.base.BasePresenter;
import com.example.wangguo20180521.bean.User;
import com.example.wangguo20180521.model.UserCallback;
import com.example.wangguo20180521.model.UserModel;
import com.example.wangguo20180521.view.UserView;

/**
 * Created by lenovo on 2018/5/21.
 */

public class UserPresenter extends BasePresenter<UserView> {
    private UserView view;
    private UserModel model;

    public UserPresenter(UserView view) {
        this.view = view;
        model=new UserModel();
    }

    public void attach(int id){
        model.success(id, new UserCallback() {
            @Override
            public void successs(User user) {
                view.successs(user);
            }
        });
    }
   public void detavh(){
        view=null;
   }
}
