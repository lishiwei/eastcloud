package com.orientalfinance.eastcloud.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 29435 on 2017/5/26.
 */

public class ChannelPageAdapter extends FragmentPagerAdapter {
    List<String> mTabNames = new ArrayList<>();
    List<Fragment> mFragmentList = new ArrayList<>();
    public ChannelPageAdapter(FragmentManager fm,List<String> tabNames,List<Fragment> fragmentList) {
        super(fm);
        mTabNames = tabNames;
        mFragmentList =fragmentList;
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
