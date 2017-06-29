package com.orientalfinance.eastcloud.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.orientalfinance.BR;
import com.orientalfinance.R;
import com.orientalfinance.databinding.ItemChannelBinding;
import com.orientalfinance.eastcloud.module.javabean.Application;

import java.util.List;

/**
 * Created by 29435 on 2017/5/26.
 */

public class HotApplicationRvAdapter extends RecyclerView.Adapter<HotApplicationRvAdapter.ApplicationHolder> {
    List<Application> mApplications;
public static int INDICATOR = 0;
public static int APPLICATION = 1;

    public HotApplicationRvAdapter(List<Application> applications) {
        mApplications = applications;
    }

    @Override
    public ApplicationHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == INDICATOR)
        {
            ItemChannelBinding viewDataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_channel_indicator, null, false);
            ApplicationHolder videoViewHolder = new ApplicationHolder(viewDataBinding.getRoot());
            videoViewHolder.setViewDataBinding(viewDataBinding);
            return videoViewHolder;
        }
        else {
            ViewDataBinding viewDataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_hot_application, null, false);
            ApplicationHolder videoViewHolder = new ApplicationHolder(viewDataBinding.getRoot());
            videoViewHolder.setViewDataBinding(viewDataBinding);
            return videoViewHolder;
        }


    }

    @Override
    public int getItemViewType(int position) {
        if (mApplications.get(position).getAppType()==null)
        {
            return INDICATOR;
        }
        else {
          return   APPLICATION;
        }
    }

    @Override
    public void onBindViewHolder(ApplicationHolder holder, int position) {
//       if (getItemViewType(position) == INDICATOR){
//
//        }
        holder.mViewDataBinding.setVariable(BR.application, mApplications.get(position));
    }

    @Override
    public int getItemCount() {
        return mApplications.size();
    }

    public class ApplicationHolder extends RecyclerView.ViewHolder {
        ViewDataBinding mViewDataBinding;

        public ApplicationHolder(View itemView) {
            super(itemView);
        }

        public void setViewDataBinding(ViewDataBinding viewDataBinding) {
            mViewDataBinding = viewDataBinding;
        }
    }
}
