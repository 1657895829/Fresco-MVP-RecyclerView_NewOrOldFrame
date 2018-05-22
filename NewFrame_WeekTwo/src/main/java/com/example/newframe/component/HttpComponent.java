package com.example.newframe.component;

import com.example.newframe.module.HttpModule;
import com.example.newframe.ui.fragment.ImageFragment;
import com.example.newframe.ui.fragment.VideoFragment;
import dagger.Component;

/**
 * 沟通部分Component
 * @Component:作为桥梁，注入对象的通道。
 */
@Component(modules = HttpModule.class)                // 作为桥梁，沟通调用者和依赖对象库
public interface HttpComponent {
    void inject(ImageFragment imageFragment);           //注入对象到ImageFragment中

    void inject(VideoFragment videoFragment);           //注入对象到VideoFragment中
}
