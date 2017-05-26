package com.orientalfinance.eastcloud.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.orientalfinance.eastcloud.fragment.fragmenthomepage.FragmentCurrentHit;
import com.orientalfinance.eastcloud.fragment.fragmenthomepage.FragmentSpecialTopic;
import com.orientalfinance.eastcloud.fragment.fragmenthomepage.FragmentTVPlay;
import com.orientalfinance.eastcloud.fragment.fragmenthomepage.FragmentTVStation;
import com.orientalfinance.eastcloud.fragment.fragmenthomepage.FragmentVariety;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 29435 on 2017/5/26.
 */

public class CurrentHitPageAdapter extends FragmentPagerAdapter {
    List<String> mTabNames = new ArrayList<>();
    List<Fragment> mFragmentList = new ArrayList<>();
    public CurrentHitPageAdapter(FragmentManager fm) {
        super(fm);
        mTabNames.add("当前热播");
        mTabNames.add("电视剧");
        mTabNames.add("专题");
        mTabNames.add("综艺");
        mTabNames.add("电视台");
        mFragmentList.add(FragmentCurrentHit.newInstance("",""));
        mFragmentList.add(FragmentTVPlay.newInstance("",""));
        mFragmentList.add(FragmentSpecialTopic.newInstance("",""));
        mFragmentList.add(FragmentVariety.newInstance("",""));
        mFragmentList.add(FragmentTVStation.newInstance("",""));
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
