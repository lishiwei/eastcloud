package com.orientalfinance.eastcloud.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.orientalfinance.eastcloud.fragment.fragmentchannel.FragmentCCTV;
import com.orientalfinance.eastcloud.fragment.fragmentchannel.FragmentHighDefinition;
import com.orientalfinance.eastcloud.fragment.fragmentchannel.FragmentSatelliteTV;
import com.orientalfinance.eastcloud.fragment.fragmentchannel.FragmentShangHai;
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

public class ChannelPageAdapter extends FragmentPagerAdapter {
    List<String> mTabNames = new ArrayList<>();
    List<Fragment> mFragmentList = new ArrayList<>();
    public ChannelPageAdapter(FragmentManager fm) {
        super(fm);
        mTabNames.add("上海");
        mTabNames.add("卫视");
        mTabNames.add("央视");
        mTabNames.add("高清");

        mFragmentList.add(FragmentShangHai.newInstance("1",""));
        mFragmentList.add(FragmentShangHai.newInstance("2",""));
        mFragmentList.add(FragmentShangHai.newInstance("3",""));
        mFragmentList.add(FragmentShangHai.newInstance("4",""));

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
