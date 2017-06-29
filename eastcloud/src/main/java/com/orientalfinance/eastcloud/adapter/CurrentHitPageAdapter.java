package com.orientalfinance.eastcloud.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.orientalfinance.eastcloud.module.javabean.RecommandCategory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 29435 on 2017/5/26.
 */

public class CurrentHitPageAdapter extends FragmentPagerAdapter {
    List<String> mTabNames = new ArrayList<>();
    List<Fragment> mFragmentList = new ArrayList<>();

    public CurrentHitPageAdapter(FragmentManager fm, List<RecommandCategory> tabNames, List<Fragment> fragments) {
        super(fm);
        for (int i = 0; i < tabNames.size(); i++) {
            mTabNames.add(tabNames.get(i).getCateName());
        }
        mFragmentList = fragments;


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
