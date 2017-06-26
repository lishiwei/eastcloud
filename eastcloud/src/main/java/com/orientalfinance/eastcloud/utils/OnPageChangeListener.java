package com.orientalfinance.eastcloud.utils;

import android.support.v4.view.ViewPager;
import android.support.v4.widget.EdgeEffectCompat;
import android.util.Log;

import java.lang.reflect.Field;

/**
 * Created by lzy on 2017/6/26.
 * email:lizy@oriental-finance.com
 */
public class OnPageChangeListener implements ViewPager.OnPageChangeListener {


    private EdgeEffectCompat leftEdge;
    private EdgeEffectCompat rightEdge;

    public OnPageChangeListener(ViewPager viewPager) {

        try {
            Field leftEdgeField = viewPager.getClass().getDeclaredField("mLeftEdge");
            Field rightEdgeField = viewPager.getClass().getDeclaredField("mRightEdge");
            Log.i("xinye", "=======leftEdgeField:" + leftEdgeField + ",rightEdgeField:" + rightEdgeField);
            if (leftEdgeField != null && rightEdgeField != null) {
                leftEdgeField.setAccessible(true);
                rightEdgeField.setAccessible(true);
                leftEdge = (EdgeEffectCompat) leftEdgeField.get(viewPager);
                rightEdge = (EdgeEffectCompat) rightEdgeField.get(viewPager);
                Log.i("xinye", "=======OK啦，leftEdge:" + leftEdge + ",rightEdge:" + rightEdge);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        if (leftEdge != null && rightEdge != null) {
            leftEdge.finish();
            rightEdge.finish();
            leftEdge.setSize(0, 0);
            rightEdge.setSize(0, 0);
        }
    }

    @Override
    public void onPageSelected(int i) {

    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }
}
