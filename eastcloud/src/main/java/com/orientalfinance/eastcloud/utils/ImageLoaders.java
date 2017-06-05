package com.orientalfinance.eastcloud.utils;


import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.orientalfinance.R;
import com.orientalfinance.eastcloud.module.GlideCircleTransform;

/**
 * Created by 29435 on 2017/5/25.
 */

public class ImageLoaders {

    private static final String TAG = ImageLoaders.class.getSimpleName();

    public static void displayImage(ImageView imageView, String url) {
        try {
            Glide.with(imageView.getContext()).load(Integer.valueOf(url)).centerCrop().placeholder(R.drawable.placeholder).into(imageView);
        }
        catch (Exception e)
        {
            Glide.with(imageView.getContext()).load(url).centerCrop().placeholder(R.drawable.placeholder).into(imageView);

        }
    }

    public static void displayImage(ImageView imageView, Integer url) {
        Glide.with(imageView.getContext()).load(url).centerCrop().into(imageView);
    }
    public static void displayCircleImage(ImageView imageView, String url) {
        Log.d(TAG, "displayCircleImage: ");
        try {
            Glide.with(imageView.getContext()).load(Integer.valueOf(url)).transform(new GlideCircleTransform(imageView.getContext())).into(imageView);
        }
        catch (Exception e)
        {
            Glide.with(imageView.getContext()).load(url).transform(new GlideCircleTransform(imageView.getContext())).into(imageView);

        }
    }
}


