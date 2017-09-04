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

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 29435 on 2017/7/3.
 */

public class ApplicationRvAdapter extends RecyclerView.Adapter<ApplicationRvAdapter.ApplicationViewHolder> {
  List<Application> mApplications = new ArrayList<>();

    public ApplicationRvAdapter(List<Application> applications) {
        mApplications = applications;
    }

    public List<Application> getApplications() {
        return mApplications;
    }

    @Override
    public ApplicationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewDataBinding viewDataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_hot_application,null,false);
        ApplicationViewHolder  applicationViewHolder = new ApplicationViewHolder(viewDataBinding.getRoot());
        applicationViewHolder.setViewDataBinding(viewDataBinding);
        return applicationViewHolder;
    }

    public void setApplications(List<Application> applications) {
        mApplications = applications;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(ApplicationViewHolder holder, int position) {
holder.getViewDataBinding().setVariable(BR.application,mApplications.get(position));
    }

    @Override
    public int getItemCount() {
        return mApplications.size();
    }

    public static class ApplicationViewHolder extends RecyclerView.ViewHolder{
        ViewDataBinding mViewDataBinding;

        public void setViewDataBinding(ViewDataBinding viewDataBinding) {
            mViewDataBinding = viewDataBinding;
        }

        public ViewDataBinding getViewDataBinding() {
            return mViewDataBinding;
        }

        public ApplicationViewHolder(View itemView) {
            super(itemView);
        }
    }
}
