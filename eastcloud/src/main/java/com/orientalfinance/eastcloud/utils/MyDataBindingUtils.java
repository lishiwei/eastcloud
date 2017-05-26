package com.orientalfinance.eastcloud.utils;

import android.databinding.BindingAdapter;
import android.view.View;
import android.widget.ImageView;


import com.orientalfinance.eastcloud.module.ImageLoaders;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

/**
 * Created by lishiwei on 2017/4/25.
 */

public class MyDataBindingUtils {
    @Inject
    public MyDataBindingUtils() {
    }

    public void onClick(View view) {

    }
    @BindingAdapter({"imageUrl"})
    public static void loadImage(ImageView imageView,String url)
    {
        ImageLoaders.displayImage(imageView,url);
    }
}
