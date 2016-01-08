package com.example.hao.fragmenttest.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hao.fragmenttest.R;
import com.ogaclejapan.smarttablayout.SmartTabLayout;

/**
 * Created by 012 on 2016/1/8.
 */
public class PageFragment1 extends Fragment {
    View rootView;
    private ViewPager viewPager;
    private SmartTabLayout smartTabLayout;
    private String[] titles = { "AA", "BBBBBBBBBBB", "CCCCCCCCCCCCCCCC" };
    private ItemFragment1 itemFragment1;
    private ItemFragment2 itemFragment2;
    private ItemFragment3 itemFragment3;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.frag_index, null);
        initView();
        initListener();
        return rootView;
    }

    private void initView() {
        viewPager= (ViewPager) rootView.findViewById(R.id.viewpager);
        smartTabLayout= (SmartTabLayout) rootView.findViewById(R.id.viewpager_tab);

        viewPager.setAdapter(new MyFragmentAdapter(getFragmentManager(),titles));
        smartTabLayout.setViewPager(viewPager);
    }

    private void initListener() {
    }

    public class MyFragmentAdapter extends FragmentPagerAdapter{
        private String[] mTitles;

        public MyFragmentAdapter(FragmentManager fm,String[] titles) {
            super(fm);
            this.mTitles=titles;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles[position];
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    if(itemFragment1==null){
                        itemFragment1=new ItemFragment1();
                    }
                    return itemFragment1;
                case 1:
                    if (itemFragment2==null){
                        itemFragment2=new ItemFragment2();
                    }
                    return itemFragment2;
                case 2:
                    if (itemFragment3==null){
                        itemFragment3=new ItemFragment3();
                    }
                    return itemFragment3;
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return mTitles.length;
        }
    }
}
