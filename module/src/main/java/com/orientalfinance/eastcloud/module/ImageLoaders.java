package com.orientalfinance.eastcloud.module;


import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by 29435 on 2017/5/25.
 */

public class ImageLoaders {

    private static final String TAG = ImageLoaders.class.getSimpleName();

    public static void displayImage(ImageView imageView, String url) {
        Glide.with(imageView.getContext()).load(url).centerCrop().into(imageView);
    }

    public static void displayImage(ImageView imageView, Integer url) {
        Glide.with(imageView.getContext()).load(url).centerCrop().into(imageView);
    }
    public static void displayCircleImage(ImageView imageView, String url) {
        Log.d(TAG, "displayCircleImage: ");
        Glide.with(imageView.getContext()).load(url).transform(new GlideCircleTransform(imageView.getContext())).into(imageView);
    }
}


