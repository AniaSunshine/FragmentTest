package com.example.hao.fragmenttest.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;

import com.example.hao.fragmenttest.R;
import com.example.hao.fragmenttest.fragment.PageFragment1;
import com.example.hao.fragmenttest.fragment.PageFragment2;
import com.example.hao.fragmenttest.fragment.PageFragment3;
import com.example.hao.fragmenttest.fragment.PageFragment4;
import com.example.hao.fragmenttest.view.NoScrollViewPager;

/**
 * Created by 012 on 2016/1/8.
 */
public class HomeActivity extends FragmentActivity implements View.OnClickListener {
    private NoScrollViewPager viewPager;
    private RadioButton rb_index;
    private RadioButton rb_mine;
    private RadioButton rb_money;
    private RadioButton rb_more;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_home);
        initView();
        initListener();
    }


    private void initView() {
        viewPager = (NoScrollViewPager) findViewById(R.id.noscroll_viewapger);//中间布局是viewpager
        viewPager.setScrollble(false);//禁止滑动
        rb_index = (RadioButton) findViewById(R.id.rb_index);
        rb_mine = (RadioButton) findViewById(R.id.rb_mine);
        rb_money = (RadioButton) findViewById(R.id.rb_money);
        rb_more = (RadioButton) findViewById(R.id.rb_more);
        rb_index.setOnClickListener(this);
        rb_mine.setOnClickListener(this);
        rb_money.setOnClickListener(this);
        rb_more.setOnClickListener(this);

        FragmentAdapter fragmentAdapter = new FragmentAdapter(getSupportFragmentManager());
        viewPager.setAdapter(fragmentAdapter);
    }


    private void initListener() {
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                Log.i("---onPageScroll--", "position" + position + "positionOffset" + positionOffset + "positionOffsetPixels" + positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                Log.i("---onPageSelected--", "position" + position);
                switch (position){
                    case 0:
                        rb_index.setChecked(true);
                        break;
                    case 1:
                        rb_mine.setChecked(true);
                        break;
                    case 2:
                        rb_money.setChecked(true);
                        break;
                    case 3:
                        rb_more.setChecked(true);
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                Log.i("---StateChanged--", "state" + state);
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rb_index:
                viewPager.setCurrentItem(0);
                break;
            case R.id.rb_mine:
                viewPager.setCurrentItem(1);
                break;
            case R.id.rb_money:
                viewPager.setCurrentItem(2);
                break;
            case R.id.rb_more:
                viewPager.setCurrentItem(3);
                break;
        }
    }





    public class FragmentAdapter extends FragmentPagerAdapter {

        public FragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    PageFragment1 pageFragment1=new PageFragment1();
                    return pageFragment1;
                case 1:
                    PageFragment2 pageFragment2=new PageFragment2();
                    return pageFragment2;
                case 2:
                    PageFragment3 pageFragment3=new PageFragment3();
                    return pageFragment3;
                case 3:
                    PageFragment4 pageFragment4=new PageFragment4();
                    return pageFragment4;
            }
            return null;
        }

        @Override
        public int getCount() {
            return 4;
        }
    }
}
