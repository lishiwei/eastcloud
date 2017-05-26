package com.orientalfinance.eastcloud.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.orientalfinance.BR;
import com.orientalfinance.R;
import com.orientalfinance.eastcloud.module.Movie;

import java.util.List;

/**
 * Created by 29435 on 2017/5/26.
 */

public class LiveVideoRvAdapter extends RecyclerView.Adapter<LiveVideoRvAdapter.LiveVideoViewHolder> {
    List<Movie> mMovieList;

    public LiveVideoRvAdapter(List<Movie> movies) {
        mMovieList = movies;
    }

    @Override
    public LiveVideoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewDataBinding viewDataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_live_video,null,false);
        LiveVideoViewHolder videoViewHolder = new LiveVideoViewHolder(viewDataBinding.getRoot());
        videoViewHolder.setViewDataBinding(viewDataBinding);
        return videoViewHolder;
    }

    @Override
    public void onBindViewHolder(LiveVideoViewHolder holder, int position) {
holder.mViewDataBinding.setVariable(BR.movie,mMovieList.get(position));
    }

    @Override
    public int getItemCount() {
        return mMovieList.size();
    }

    public class LiveVideoViewHolder extends RecyclerView.ViewHolder {
        ViewDataBinding mViewDataBinding;
        public LiveVideoViewHolder(View itemView) {
            super(itemView);
        }

        public void setViewDataBinding(ViewDataBinding viewDataBinding) {
            mViewDataBinding = viewDataBinding;
        }
    }
}
