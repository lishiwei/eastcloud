package com.orientalfinance.eastcloud.adapter;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by 29435 on 2017/5/27.
 */

public  class DataBindingViewHolder extends RecyclerView.ViewHolder {
   public ViewDataBinding mViewDataBinding;

    public void setViewDataBinding(ViewDataBinding viewDataBinding) {
        mViewDataBinding = viewDataBinding;
    }

    public DataBindingViewHolder(View itemView) {
        super(itemView);
    }
}
