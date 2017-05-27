package com.orientalfinance.eastcloud.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;
import java.util.Objects;

/**
 * Created by 29435 on 2017/5/27.
 */

public  class RVAdapter<T extends Object> extends RecyclerView.Adapter<DataBindingViewHolder> {
   private int BRID;
   private int mItemLayoutId;

    public RVAdapter(int BRID, int itemLayoutId, List<T> TList) {
        this.BRID = BRID;
        mTList = TList;
        this.mItemLayoutId = itemLayoutId;
    }

    List<T> mTList;

    @Override
    public final DataBindingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewDataBinding viewDataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), mItemLayoutId, null, false);
        DataBindingViewHolder viewholder = new DataBindingViewHolder(viewDataBinding.getRoot());
        viewholder.setViewDataBinding(viewDataBinding);
        return viewholder;
    }


    @Override
    public final void onBindViewHolder(DataBindingViewHolder holder, int position) {
        holder.mViewDataBinding.setVariable(BRID, mTList.get(position));
    }


    @Override
    public final int getItemCount() {
        return mTList.size();
    }
}
