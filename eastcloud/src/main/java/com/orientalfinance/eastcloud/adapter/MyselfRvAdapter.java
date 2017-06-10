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
import com.orientalfinance.eastcloud.activity.ActivityMyTV;
import com.orientalfinance.eastcloud.module.javabean.ItemMyself;
import com.orientalfinance.eastcloud.utils.LogUtils;

import java.util.List;

/**
 * Created by 29435 on 2017/5/26.
 */

public class MyselfRvAdapter extends RecyclerView.Adapter<MyselfRvAdapter.ItemMyselfViewHolder> {
    List<ItemMyself> mItemMyselfs;
public static String TAG = MyselfRvAdapter.class.getSimpleName();
    public MyselfRvAdapter(List<ItemMyself> itemMyselfs) {
        mItemMyselfs = itemMyselfs;
    }

    @Override
    public ItemMyselfViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        ViewDataBinding viewDataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_myself, null, false);
        final ItemMyselfViewHolder itemMyselfViewHolder = new ItemMyselfViewHolder(viewDataBinding.getRoot());
        itemMyselfViewHolder.setViewDataBinding(viewDataBinding);
        itemMyselfViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LogUtils.d(TAG, "onClick: "+itemMyselfViewHolder.getLayoutPosition());
                switch (itemMyselfViewHolder.getLayoutPosition()) {
                    case 0:
                        break;
                    case 1:
                        LogUtils.d(TAG, "onClick: ");
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        parent.getContext().startActivity(new Intent(parent.getContext(), ActivityMyTV.class));

                        break;
                    case 5:
                        break;
                }
            }
        });

        return itemMyselfViewHolder;
    }

    @Override
    public void onBindViewHolder(ItemMyselfViewHolder holder, int position) {
        holder.mViewDataBinding.setVariable(BR.item, mItemMyselfs.get(position));
    }

    @Override
    public int getItemCount() {
        return mItemMyselfs.size();
    }

    public class ItemMyselfViewHolder extends RecyclerView.ViewHolder {
        ViewDataBinding mViewDataBinding;

        public ItemMyselfViewHolder(View itemView) {
            super(itemView);

        }

        public void setViewDataBinding(ViewDataBinding viewDataBinding) {
            mViewDataBinding = viewDataBinding;
        }
    }
}
