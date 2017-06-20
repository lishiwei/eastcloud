package com.orientalfinance.eastcloud.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.orientalfinance.eastcloud.fragment.fragmenthomepage.FragmentCurrentHit;
import com.orientalfinance.eastcloud.fragment.fragmenthomepage.FragmentTVPlay;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 29435 on 2017/5/26.
 */

public class CurrentHitPageAdapter extends FragmentPagerAdapter {
    List<String> mTabNames = new ArrayList<>();
    List<Fragment> mFragmentList = new ArrayList<>();

    public CurrentHitPageAdapter(FragmentManager fm, List<String> tabNames) {
        super(fm);
        mTabNames = tabNames;
        mFragmentList.add(FragmentCurrentHit.newInstance("", ""));
        mFragmentList.add(FragmentTVPlay.newInstance("", ""));
        mFragmentList.add(FragmentTVPlay.newInstance("1", ""));
        mFragmentList.add(FragmentTVPlay.newInstance("2", ""));
        mFragmentList.add(FragmentTVPlay.newInstance("3", ""));
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
