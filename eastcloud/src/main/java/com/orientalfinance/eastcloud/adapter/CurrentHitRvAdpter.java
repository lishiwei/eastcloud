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
import com.orientalfinance.eastcloud.module.Retrofit.configration.Constant;
import com.orientalfinance.eastcloud.module.javabean.HomepageProgram;

import java.util.List;

/**
 * Created by 29435 on 2017/5/26.
 */

public class CurrentHitRvAdpter extends RecyclerView.Adapter<CurrentHitRvAdpter.CurrentHitViewHolder> {
    private static final String TAG = CurrentHitRvAdpter.class.getSimpleName();
    List<HomepageProgram> mMovieList;

    @Override
    public CurrentHitViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        ViewDataBinding viewDataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_currenthit, null, false);
        final CurrentHitViewHolder currentHitViewHolder = new CurrentHitViewHolder(viewDataBinding.getRoot());
        currentHitViewHolder.setViewDataBinding(viewDataBinding);
        currentHitViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ActivityDetail.class);
                intent.putExtra(Constant.VALUE,mMovieList.get(currentHitViewHolder.getLayoutPosition()).getProgramId());
                v.getContext().startActivity(intent);
            }
        });
        return currentHitViewHolder;
    }

    public CurrentHitRvAdpter(List<HomepageProgram> movies) {
        mMovieList = movies;
    }

    @Override
    public void onBindViewHolder(CurrentHitViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: "+mMovieList.get(position));
        holder.mViewDataBinding.setVariable(BR.program, mMovieList.get(position));
    }

    public void setProgramList(List<HomepageProgram> movieList) {
        Log.d(TAG, "setMovieList: "+movieList.size());
        mMovieList = movieList;
        notifyDataSetChanged();
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
