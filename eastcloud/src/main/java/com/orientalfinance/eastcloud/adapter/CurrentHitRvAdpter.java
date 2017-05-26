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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by 29435 on 2017/5/26.
 */

public class CurrentHitRvAdpter extends RecyclerView.Adapter<CurrentHitRvAdpter.CurrentHitViewHolder> {
    List<Movie> mMovieList;

    @Override
    public CurrentHitViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewDataBinding viewDataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_currenthit, null, false);
        CurrentHitViewHolder currentHitViewHolder = new CurrentHitViewHolder(viewDataBinding.getRoot());
        currentHitViewHolder.setViewDataBinding(viewDataBinding);
        return currentHitViewHolder;
    }

    public CurrentHitRvAdpter(List<Movie> movies) {
        mMovieList = movies;
    }

    @Override
    public void onBindViewHolder(CurrentHitViewHolder holder, int position) {
        holder.mViewDataBinding.setVariable(BR.movie, mMovieList.get(position));
    }

    @Override
    public int getItemCount() {
        return mMovieList.size();
    }

    class CurrentHitViewHolder extends RecyclerView.ViewHolder {
        ViewDataBinding mViewDataBinding;

        public CurrentHitViewHolder(View itemView) {
            super(itemView);
        }

        public void setViewDataBinding(ViewDataBinding viewDataBinding) {
            mViewDataBinding = viewDataBinding;
        }
    }
}
