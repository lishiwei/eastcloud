package com.orientalfinance.eastcloud.utils;

import android.content.Intent;
import android.databinding.BindingAdapter;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;

import com.orientalfinance.eastcloud.activity.ActivityHotBooking;
import com.orientalfinance.eastcloud.activity.ActivitySearch;
import com.orientalfinance.eastcloud.view.ExpandTextView;

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
    @BindingAdapter({"contentText"})
    public static void settext(ExpandTextView expandTextView, String content) {
        expandTextView.setContent(content);
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

    public static String getStatus(String status) {
        if (status.equals("在线")) {
            return "连接";
        } else {
            return "";
        }
    }

    public static int getStatusColor(String status) {
        if (status.equals("在线")) {
            return Color.RED;
        } else {
            return Color.GRAY;
        }
    }
}
