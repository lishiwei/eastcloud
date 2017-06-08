package com.orientalfinance.eastcloud.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.orientalfinance.BR;
import com.orientalfinance.R;


import java.util.List;

/**
 * Created by 29435 on 2017/5/26.
 */

public class SearchRvAdapter extends RecyclerView.Adapter<SearchRvAdapter.SearchViewHolder> {

    List<String> mStringList;

    public SearchRvAdapter(List<String> stringList) {
        mStringList = stringList;
    }

    @Override
    public SearchViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        ViewDataBinding viewDataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_search, null, false);
        SearchViewHolder channelViewHolder = new SearchViewHolder(viewDataBinding.getRoot());
        channelViewHolder.setViewDataBinding(viewDataBinding);
        return channelViewHolder;

    }


    @Override
    public void onBindViewHolder(SearchViewHolder holder, int position) {

        holder.mViewDataBinding.setVariable(BR.item, mStringList.get(position));


    }

    @Override
    public int getItemCount() {
        return mStringList.size();
    }

    public class SearchViewHolder extends RecyclerView.ViewHolder {
        ViewDataBinding mViewDataBinding;

        public void setViewDataBinding(ViewDataBinding viewDataBinding) {
            mViewDataBinding = viewDataBinding;
        }
        public SearchViewHolder(View itemView) {
            super(itemView);
        }
    }
}
