package com.orientalfinance.eastcloud.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.orientalfinance.BR;
import com.orientalfinance.R;
import com.orientalfinance.eastcloud.module.javabean.Comment;

import java.util.List;

/**
 * Created by 29435 on 2017/5/31.
 */

public class DetailRVAdapter extends RecyclerView.Adapter<DetailRVAdapter.DetailViewHolder> {
    List<Comment> mComments;

    public DetailRVAdapter(List<Comment> comments) {
        mComments = comments;
    }

    public void setComments(List<Comment> comments) {
        mComments = comments;
        notifyDataSetChanged();
    }

    public List<Comment> getComments() {
        return mComments;
    }

    @Override

    public DetailViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewDataBinding viewDataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_detail_comment,null,false);
      DetailViewHolder detailViewHolder = new DetailViewHolder(viewDataBinding.getRoot());
        detailViewHolder.setViewDataBinding(viewDataBinding);
        return detailViewHolder;
    }

    @Override
    public void onBindViewHolder(DetailViewHolder holder, int position) {
holder.mViewDataBinding.setVariable(BR.comment,mComments.get(position));
    }

    @Override
    public int getItemCount() {
        return mComments.size();
    }

    public class DetailViewHolder extends RecyclerView.ViewHolder{
        ViewDataBinding mViewDataBinding;

        public void setViewDataBinding(ViewDataBinding viewDataBinding) {
            mViewDataBinding = viewDataBinding;
        }

        public DetailViewHolder(View itemView) {
        super(itemView);
    }
}}
