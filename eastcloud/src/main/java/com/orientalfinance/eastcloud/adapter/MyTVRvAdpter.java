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
import com.orientalfinance.eastcloud.activity.ActivityTopBoxDetail;
import com.orientalfinance.eastcloud.module.javabean.TV;

import java.util.List;

/**
 * Created by 29435 on 2017/5/26.
 */

public class MyTVRvAdpter extends RecyclerView.Adapter<MyTVRvAdpter.MyTVViewHolder> {
    private static final String TAG = MyTVRvAdpter.class.getSimpleName();
    List<TV> mMovieList;

    @Override
    public MyTVViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        ViewDataBinding viewDataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_mytv, null, false);
        MyTVViewHolder myTVViewHolder = new MyTVViewHolder(viewDataBinding.getRoot());
        myTVViewHolder.setViewDataBinding(viewDataBinding);
        myTVViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ActivityTopBoxDetail.class);
                v.getContext().startActivity(intent);
            }
        });
        return myTVViewHolder;
    }

    public MyTVRvAdpter(List<TV> movies) {
        mMovieList = movies;
    }

    @Override
    public void onBindViewHolder(MyTVViewHolder holder, int position) {

        holder.mViewDataBinding.setVariable(BR.item, mMovieList.get(position));
    }

    public void setMovieList(List<TV> movieList) {

        mMovieList = movieList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mMovieList.size();
    }

    class MyTVViewHolder extends RecyclerView.ViewHolder {
        ViewDataBinding mViewDataBinding;

        public MyTVViewHolder(View itemView) {
            super(itemView);
        }

        public void setViewDataBinding(ViewDataBinding viewDataBinding) {
            mViewDataBinding = viewDataBinding;
        }
    }
}
