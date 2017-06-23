package com.orientalfinance.eastcloud.view.order;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

/**
 * 接口回调
 */
public interface OrderLayout {

    int getLayout();

    boolean isClickAble();

    View getView(Context mContext, View convertView, LayoutInflater inflater);
}

