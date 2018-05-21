package com.example.oldframe_week2demo;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.oldframe_week2demo.fragment.ImageFragment;
import com.example.oldframe_week2demo.fragment.VideoFragment;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;

//Fragment与ViewPager联动显示
public class MainActivity extends AppCompatActivity {
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    private List<Fragment> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //添加Fragment
        list = new ArrayList<>();
        list.add(new ImageFragment());
        list.add(new VideoFragment());

        //设置使用ViewPager+Fragment显示数据布局的适配器
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {

            @Override
            public Fragment getItem(int position) {
                //返回对应的fragment
                Fragment fragment = list.get(position);
                return fragment;
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });

        //动态添加Tab选项卡
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.getTabAt(0).setText("图片");
        tabLayout.getTabAt(0).setText("视频");

        //TabLyout要与ViewPager关联显示
        tabLayout.setupWithViewPager(viewPager);
    }

}
