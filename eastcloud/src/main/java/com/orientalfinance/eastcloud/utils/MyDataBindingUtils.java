package com.orientalfinance.eastcloud.utils;

import android.content.Intent;
import android.databinding.BindingAdapter;
import android.view.View;
import android.widget.ImageView;


import com.orientalfinance.eastcloud.activity.ActivityHotBooking;
import com.orientalfinance.eastcloud.activity.ActivitySearch;

import javax.inject.Inject;

/**
 * Created by lishiwei on 2017/4/25.
 */

public class MyDataBindingUtils {
    @Inject
    public MyDataBindingUtils() {
    }

    public void onClick(View view) {
        Intent intent = new Intent(view.getContext(), ActivityHotBooking.class);
        view.getContext().startActivity(intent);
    }
    public void onSearchClick(View view) {
        Intent intent = new Intent(view.getContext(), ActivitySearch.class);
        view.getContext().startActivity(intent);
    }

    @BindingAdapter({"imageUrl"})
    public static void loadImage(ImageView imageView, String url) {
        ImageLoaders.displayImage(imageView, url);
    }

    @BindingAdapter({"circleImageUrl"})
    public static void loadCircleImage(ImageView imageView, String url) {
        ImageLoaders.displayCircleImage(imageView, url);
    }

    @BindingAdapter({"imageSrc"})
    public static void loadSrcImage(ImageView imageView, Integer src) {
        ImageLoaders.displayImage(imageView, src);
    }
}
