package com.orientalfinance.eastcloud.module;


import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by 29435 on 2017/5/25.
 */

public class ImageLoaders {

    public static void displayImage(ImageView imageView, String url) {
        Glide.with(imageView.getContext()).load(url).centerCrop().into(imageView);
    }
}


