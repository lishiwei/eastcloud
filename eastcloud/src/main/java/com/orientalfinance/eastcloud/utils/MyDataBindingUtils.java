package com.orientalfinance.eastcloud.utils;

import android.content.Intent;
import android.databinding.BindingAdapter;
import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageView;

import com.orientalfinance.R;
import com.orientalfinance.eastcloud.activity.ActivityHotBooking;
import com.orientalfinance.eastcloud.activity.ActivitySearch;
import com.orientalfinance.eastcloud.module.javabean.Address;
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

    @BindingAdapter({"appointSrc"})
    public static void loadAppointImage(ImageView imageView, String appointId) {

        if (appointId == null) {
            ImageLoaders.displayImage(imageView, R.drawable.star);
        } else {
            ImageLoaders.displayImage(imageView, R.drawable.stared);
        }
    }

    public static String getStatus(String status) {
        if (status.equals("在线")) {
            return "连接";
        } else {
            return "";
        }
    }

    public static String getAppointText(String appointId) {
        if (appointId == null) {
            return "预约";
        } else {
            return "取消预约";
        }
    }

    public static SpannableStringBuilder getAddress(Address address) {
        SpannableStringBuilder builder;
        if (address.isDefault() == 0) {
            String s = "[ 默认地址 ]";
            builder = new SpannableStringBuilder(s + address.getAddress());
            ForegroundColorSpan modifySpan = new ForegroundColorSpan(Color.RED);
            builder.setSpan(modifySpan, 0, s.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            return builder;
        } else {
            builder = new SpannableStringBuilder(address.getAddress());
            return builder;
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
