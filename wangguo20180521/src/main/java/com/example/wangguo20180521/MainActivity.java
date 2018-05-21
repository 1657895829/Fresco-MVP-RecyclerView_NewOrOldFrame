package com.example.wangguo20180521;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.wangguo20180521.fragment.Picture;
import com.example.wangguo20180521.fragment.Text;
import com.example.wangguo20180521.fragment.Vivedo;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tl)
    TabLayout tl;
    @BindView(R.id.vp)
    ViewPager vp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new Text());
        fragments.add(new Picture());
        fragments.add(new Vivedo());
        MyPagerAdapter myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager());
        myPagerAdapter.setFragments(fragments);
        vp.setAdapter(myPagerAdapter);
        tl.addTab(tl.newTab());
        tl.addTab(tl.newTab());
        tl.addTab(tl.newTab());
        tl.addTab(tl.newTab());
        tl.setupWithViewPager(vp);
        tl.getTabAt(0).setText("文字");
        tl.getTabAt(1).setText("图片");
        tl.getTabAt(2).setText("视频");
    }
    public class MyPagerAdapter extends FragmentPagerAdapter {

        private List<Fragment> mFragmentList;

        public void setFragments(ArrayList<Fragment> fragments) {
            mFragmentList = fragments;
        }

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            Fragment fragment = mFragmentList.get(position);

            return fragment;
        }

        @Override
        public int getCount() {

            return mFragmentList.size();
        }
    }
}
