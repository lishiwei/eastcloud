package com.orientalfinance.eastcloud.adapter;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.orientalfinance.BR;
import com.orientalfinance.R;
import com.orientalfinance.eastcloud.activity.ActivityDetail;
import com.orientalfinance.eastcloud.module.Movie;

import java.util.List;

/**
 * Created by 29435 on 2017/5/26.
 */

public class PlayRecordRvAdpter extends RecyclerView.Adapter<PlayRecordRvAdpter.PlayRecordViewHolder> {
    private static final String TAG = PlayRecordRvAdpter.class.getSimpleName();
    List<Movie> mMovieList;

    @Override
    public PlayRecordViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        ViewDataBinding viewDataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_play_record, null, false);
        PlayRecordViewHolder currentHitViewHolder = new PlayRecordViewHolder(viewDataBinding.getRoot());
        currentHitViewHolder.setViewDataBinding(viewDataBinding);
        currentHitViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ActivityDetail.class);
                v.getContext().startActivity(intent);
            }
        });
        return currentHitViewHolder;
    }

    public PlayRecordRvAdpter(List<Movie> movies) {
        mMovieList = movies;
    }

    @Override
    public void onBindViewHolder(PlayRecordViewHolder holder, int position) {
        holder.mViewDataBinding.setVariable(BR.movie, mMovieList.get(position));
    }

    public void setMovieList(List<Movie> movieList) {
        Log.d(TAG, "setMovieList: "+movieList.size());
        mMovieList = movieList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mMovieList.size();
    }

    class PlayRecordViewHolder extends RecyclerView.ViewHolder {
        ViewDataBinding mViewDataBinding;

        public PlayRecordViewHolder(View itemView) {
            super(itemView);
        }

        public void setViewDataBinding(ViewDataBinding viewDataBinding) {
            mViewDataBinding = viewDataBinding;
        }
    }
}
