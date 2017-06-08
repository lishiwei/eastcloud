package com.orientalfinance.eastcloud.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.orientalfinance.BR;
import com.orientalfinance.R;
import com.orientalfinance.eastcloud.module.javabean.Application;

import java.util.List;

/**
 * Created by 29435 on 2017/5/26.
 */

public class HotApplicationRvAdapter extends RecyclerView.Adapter<HotApplicationRvAdapter.ApplicationHolder> {
    List<Application> mApplications;

    public HotApplicationRvAdapter(List<Application> applications) {
        mApplications = applications;
    }

    @Override
    public ApplicationHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewDataBinding viewDataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_hot_application, null, false);
        ApplicationHolder videoViewHolder = new ApplicationHolder(viewDataBinding.getRoot());
        videoViewHolder.setViewDataBinding(viewDataBinding);
        return videoViewHolder;
    }

    @Override
    public void onBindViewHolder(ApplicationHolder holder, int position) {
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
