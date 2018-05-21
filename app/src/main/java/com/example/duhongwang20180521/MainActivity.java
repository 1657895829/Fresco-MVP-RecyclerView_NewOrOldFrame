package com.example.duhongwang20180521;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import com.example.duhongwang20180521.fragment.ChildFragment;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    private List<Integer> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //设置标题传入的参数type
        list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        viewPager.setOffscreenPageLimit(list.size());

        //设置使用ViewPager+Fragment显示数据布局的适配器
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {

            //得到当前页的标题,,,也就是设置当前页面显示的标题是tabLayout对应的标题
            @Override
            public CharSequence getPageTitle(int position) {
                switch (position) {
                    case 0:
                        return "文字";
                    case 1:
                        return "图片";
                    case 2:
                        return "视频";
                    case 3:
                        return "预留";
                    case 4:
                        return "预留";
                    default:
                        return "";
                }
            }

            @Override
            public Fragment getItem(int position) {
                //在这个位置对比一下标题是什么,,,然后返回对应的fragment
                ChildFragment childFragment = new ChildFragment();

                //判断所选的标题，进行传值显示（下面注释的代码可简写为下面一行代码）
                Bundle bundle = new Bundle();
                bundle.putInt("name", list.get(position));
                if (list.get(position).equals(0)) {
                    bundle.putInt("name", 0);
                } else if (list.get(position).equals(1)) {
                    bundle.putInt("name", 1);
                }else if (list.get(position).equals(2)) {
                    bundle.putInt("name", 2);
                }else if (list.get(position).equals(3)) {
                    bundle.putInt("name", 3);
                }else if (list.get(position).equals(4)) {
                    bundle.putInt("name", 4);
                }
                childFragment.setArguments(bundle);
                return childFragment;
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });

        //TabLyout要与ViewPager关联显示
        tabLayout.setupWithViewPager(viewPager);
    }
}
