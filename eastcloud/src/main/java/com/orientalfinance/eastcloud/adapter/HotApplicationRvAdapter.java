package com.orientalfinance.eastcloud.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.orientalfinance.BR;
import com.orientalfinance.R;
import com.orientalfinance.databinding.ItemChannelIndicatorBinding;
import com.orientalfinance.eastcloud.module.javabean.Application;
import com.orientalfinance.eastcloud.mvp.View.FullyGridLayoutManager;
import com.orientalfinance.eastcloud.utils.DensityUtil;
import com.orientalfinance.eastcloud.utils.GlideImageLoader;
import com.orientalfinance.eastcloud.utils.LogUtils;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 29435 on 2017/5/26.
 */

public class HotApplicationRvAdapter extends RecyclerView.Adapter<HotApplicationRvAdapter.ApplicationHolder> {
    List<Application> mApplications;
    public static int INDICATOR = 0;
    public static int APPLICATION = 1;
    public static int HEADER = 2;
    public static String TAG = HotApplicationRvAdapter.class.getSimpleName();
    Banner mHeader;

    public void setHeader(Banner header) {
        mHeader = header;
    }

    List<String> mImageUrl = new ArrayList<>();

    public View getHeader() {
        return mHeader;
    }

    public void setImageUrl(List<String> imageUrl) {
        mImageUrl = imageUrl;
        notifyDataSetChanged();
    }

    public HotApplicationRvAdapter(List<Application> applications) {
        mApplications = applications;
    }

    @Override
    public ApplicationHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == HEADER) {
            Banner banner = new Banner(parent.getContext());
            banner.setLayoutParams(new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, DensityUtil.dp2px(200)));

            ApplicationHolder videoViewHolder = new ApplicationHolder(banner);
            return videoViewHolder;
        }
        if (viewType == INDICATOR) {
            ItemChannelIndicatorBinding viewDataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_channel_indicator, null, false);
            ApplicationHolder videoViewHolder = new ApplicationHolder(viewDataBinding.getRoot());
            videoViewHolder.setViewDataBinding(viewDataBinding);
            return videoViewHolder;
        } else {
            RecyclerView recyclerView = new RecyclerView(parent.getContext());
            recyclerView.setNestedScrollingEnabled(false);
            recyclerView.setLayoutManager(new FullyGridLayoutManager(parent.getContext(), 3, LinearLayoutManager.VERTICAL, false));
            recyclerView.setAdapter(new ApplicationRvAdapter(new ArrayList<Application>()));
            ApplicationHolder videoViewHolder = new ApplicationHolder(recyclerView);
            return videoViewHolder;
        }


    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return HEADER;
        }
       else if (mApplications.get(position).getAppType() != null) {
            return INDICATOR;
        } else {
            return APPLICATION;
        }
    }

    @Override
    public void onBindViewHolder(ApplicationHolder holder, int position) {
        if (getItemViewType(position) == HEADER) {
            Banner banner = (Banner) holder.itemView;
            banner.setImageLoader(new GlideImageLoader());
            banner.setImages(mImageUrl);
            banner.start();
        }
        else if (getItemViewType(position) == INDICATOR) {
            holder.mViewDataBinding.setVariable(BR.application, mApplications.get(position));

        } else {
            RecyclerView recyclerView = (RecyclerView) holder.itemView;
            ApplicationRvAdapter applicationRvAdapter = (ApplicationRvAdapter) recyclerView.getAdapter();
            applicationRvAdapter.setApplications(mApplications.get(position).getAppList());
        }
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
