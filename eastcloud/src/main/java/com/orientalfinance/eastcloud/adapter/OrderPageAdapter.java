package com.orientalfinance.eastcloud.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.orientalfinance.eastcloud.fragment.fragmentorder.FragmentAllOrder;
import com.orientalfinance.eastcloud.fragment.fragmentorder.FragmentUnEvaluation;
import com.orientalfinance.eastcloud.fragment.fragmentorder.FragmentUnReceived;
import com.orientalfinance.eastcloud.fragment.fragmentorder.FragmentUndelivery;
import com.orientalfinance.eastcloud.fragment.fragmentorder.FragmentUnpaid;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 29435 on 2017/5/26.
 */

public class OrderPageAdapter extends FragmentPagerAdapter {
    List<String> mTabNames = new ArrayList<>();
    List<Fragment> mFragmentList = new ArrayList<>();
    public OrderPageAdapter(FragmentManager fm) {
        super(fm);
        mTabNames.add("全部");
        mTabNames.add("待付款");
        mTabNames.add("待发货");
        mTabNames.add("待收货");
        mTabNames.add("已完成");

        mFragmentList.add(FragmentAllOrder.newInstance("1",""));
        mFragmentList.add(FragmentUnpaid.newInstance("2",""));
        mFragmentList.add(FragmentUndelivery.newInstance("3",""));
        mFragmentList.add(FragmentUnReceived.newInstance("4",""));
        mFragmentList.add(FragmentUnEvaluation.newInstance("4",""));

    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTabNames.get(position);
    }
}
