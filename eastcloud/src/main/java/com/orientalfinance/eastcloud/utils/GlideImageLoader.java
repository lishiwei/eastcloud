package com.orientalfinance.eastcloud.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.orientalfinance.R;
import com.youth.banner.loader.ImageLoader;

/**
 * Created by 29435 on 2017/5/25.
 */

public class GlideImageLoader extends ImageLoader {
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        Glide.with(context).load((String)path).placeholder(R.drawable.loading).error(R.drawable.loaderrorlarge).centerCrop().into(imageView);
    }
}
