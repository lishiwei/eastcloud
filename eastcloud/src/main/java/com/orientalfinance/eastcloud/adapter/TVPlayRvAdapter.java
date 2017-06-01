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

public class TVPlayRvAdapter extends RecyclerView.Adapter<TVPlayRvAdapter.ChannelViewHolder> {
    List<Channel> mChannels;
    static int Header = 0;
    static int Normal = 1;
    private View mHeaderView;

    public TVPlayRvAdapter(List<Channel> channels) {
        mChannels = channels;
    }

    @Override
    public ChannelViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mHeaderView != null && viewType == Header) {
            return new ChannelViewHolder(mHeaderView);
        } else {
            ViewDataBinding viewDataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_channel, null, false);
            ChannelViewHolder channelViewHolder = new ChannelViewHolder(viewDataBinding.getRoot());
            channelViewHolder.setViewDataBinding(viewDataBinding);
            return channelViewHolder;
        }
    }

    public void setHeaderView(View headerView) {
        mHeaderView = headerView;
        notifyItemInserted(0);
    }

    @Override
    public void onBindViewHolder(ChannelViewHolder holder, int position) {
        if (position==0)
        {

        }
        else {
            holder.mViewDataBinding.setVariable(BR.channel, mChannels.get(position));
        }

    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return Header;
        } else {
            return Normal;
        }

    }

    @Override
    public int getItemCount() {
        return mChannels.size();
    }

    public class ChannelViewHolder extends RecyclerView.ViewHolder {
        ViewDataBinding mViewDataBinding;

        public void setViewDataBinding(ViewDataBinding viewDataBinding) {
            mViewDataBinding = viewDataBinding;
        }

        public ChannelViewHolder(View itemView) {
            super(itemView);
        }
    }
}
