package com.example.newframe.component;

import com.example.duhongwang20180521.MainActivity;
import com.example.duhongwang20180521.module.HttpModule;

import dagger.Component;

/**
 * 沟通部分Component
 * @Component:作为桥梁，注入对象的通道。
 */
@Component(modules = HttpModule.class)                // 作为桥梁，沟通调用者和依赖对象库
public interface HttpComponent {
    void inject(MainActivity mainActivity);           //注入对象到MainActivity中
}
