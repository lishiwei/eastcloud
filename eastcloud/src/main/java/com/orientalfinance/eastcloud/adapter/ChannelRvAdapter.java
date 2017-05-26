package com.orientalfinance.eastcloud.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.orientalfinance.BR;
import com.orientalfinance.R;
import com.orientalfinance.eastcloud.module.Channel;

import java.util.List;

/**
 * Created by 29435 on 2017/5/26.
 */

public class ChannelRvAdapter extends RecyclerView.Adapter<ChannelRvAdapter.ChannelViewHolder> {
List<Channel> mChannels;

    public ChannelRvAdapter(List<Channel> channels) {
        mChannels = channels;
    }

    @Override
    public ChannelViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewDataBinding viewDataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_channel,null,false);
        ChannelViewHolder channelViewHolder = new ChannelViewHolder(viewDataBinding.getRoot());
        channelViewHolder.setViewDataBinding(viewDataBinding);
        return channelViewHolder;
    }

    @Override
    public void onBindViewHolder(ChannelViewHolder holder, int position) {
holder.mViewDataBinding.setVariable(BR.channel,mChannels.get(position));
    }

    @Override
    public int getItemCount() {
        return mChannels.size();
    }

    public class ChannelViewHolder extends RecyclerView.ViewHolder{
        ViewDataBinding mViewDataBinding;

        public void setViewDataBinding(ViewDataBinding viewDataBinding) {
            mViewDataBinding = viewDataBinding;
        }

        public ChannelViewHolder(View itemView) {
        super(itemView);
    }
}
}
