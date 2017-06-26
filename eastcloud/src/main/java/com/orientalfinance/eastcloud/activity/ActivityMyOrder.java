package com.orientalfinance.eastcloud.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.orientalfinance.R;
import com.orientalfinance.eastcloud.adapter.OrderPageAdapter;
import com.orientalfinance.eastcloud.module.Retrofit.configration.Constant;

public class ActivityMyOrder extends AppCompatActivity {
    Toolbar mToolbar;
    TabLayout mTabLayout;
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_order);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");
        mTabLayout = (TabLayout) findViewById(R.id.tab_MyOrder);
        mViewPager = (ViewPager) findViewById(R.id.vp_Myorder);
        mTabLayout.setTabMode(TabLayout.MODE_FIXED);
        mTabLayout.setupWithViewPager(mViewPager);
        mViewPager.setAdapter(new OrderPageAdapter(getSupportFragmentManager()));
        String index = getIntent().getStringExtra(Constant.VALUE);
        switch (index) {
            case Constant.ALLORDER:
                mViewPager.setCurrentItem(0);
                break;
            case Constant.UNPAID:
                mViewPager.setCurrentItem(1);
                break;
            case Constant.UNDELIVERY:
                mViewPager.setCurrentItem(2);
                break;
            case Constant.UNRECIEVED:
                mViewPager.setCurrentItem(3);
                break;
            case Constant.SUCCEED:
                mViewPager.setCurrentItem(4);
                break;
        }
    }
}
