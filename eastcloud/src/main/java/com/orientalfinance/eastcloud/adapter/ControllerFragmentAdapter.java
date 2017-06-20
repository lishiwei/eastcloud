package com.orientalfinance.eastcloud.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by lzy on 2017/6/20.
 * email:lizy@oriental-finance.com
 */

public class ControllerFragmentAdapter extends FragmentPagerAdapter {
    private List<Fragment> mFragments;
    ;

    public ControllerFragmentAdapter(FragmentManager fm, List<Fragment> fragmentList) {
        super(fm);
        this.mFragments = fragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments == null ? 0 : mFragments.size();
    }
}
