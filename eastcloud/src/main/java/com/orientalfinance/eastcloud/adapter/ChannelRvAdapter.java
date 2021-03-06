package com.orientalfinance.eastcloud.adapter;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.orientalfinance.BR;
import com.orientalfinance.R;
import com.orientalfinance.eastcloud.activity.ActivityTVPlayDetail;
import com.orientalfinance.eastcloud.module.javabean.Channel;

import java.util.List;

/**
 * Created by 29435 on 2017/5/26.
 */

public class ChannelRvAdapter extends RecyclerView.Adapter<ChannelRvAdapter.ChannelViewHolder> {
    List<Channel> mChannels;



    public ChannelRvAdapter(List<Channel> channels) {
        mChannels = channels;
    }

    public void setChannels(List<Channel> channels) {
        mChannels = channels;
    }

    @Override
    public ChannelViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {

            ViewDataBinding viewDataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_channel, null, false);
            ChannelViewHolder channelViewHolder = new ChannelViewHolder(viewDataBinding.getRoot());
            channelViewHolder.setViewDataBinding(viewDataBinding);
        channelViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(parent.getContext(), ActivityTVPlayDetail.class);
                parent.getContext().startActivity(intent);
            }
        });
            return channelViewHolder;

    }

    @Override
    public void onBindViewHolder(ChannelViewHolder holder, int position) {


            holder.mViewDataBinding.setVariable(BR.channel, mChannels.get(position));

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
