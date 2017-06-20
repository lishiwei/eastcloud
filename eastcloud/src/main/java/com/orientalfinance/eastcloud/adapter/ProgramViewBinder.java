package com.orientalfinance.eastcloud.adapter;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.orientalfinance.BR;
import com.orientalfinance.R;
import com.orientalfinance.databinding.ItemProgramBinding;
import com.orientalfinance.eastcloud.module.javabean.HomepageProgram;

import me.drakeet.multitype.ItemViewBinder;

/**
 * Created by 29435 on 2017/6/20.
 */

public class ProgramViewBinder extends ItemViewBinder<HomepageProgram, ProgramViewBinder.ProgramViewHolder> {
    @NonNull
    @Override
    protected ProgramViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        ItemProgramBinding itemProgramBinding = DataBindingUtil.inflate(inflater, R.layout.item_program, parent, false);


        ProgramViewHolder programViewHolder = new ProgramViewHolder(itemProgramBinding.getRoot());
        programViewHolder.setItemProgramBinding(itemProgramBinding);
        return programViewHolder;
    }

    @Override
    protected void onBindViewHolder(@NonNull ProgramViewHolder holder, @NonNull HomepageProgram item) {
        holder.getItemProgramBinding().setVariable(BR.program, item);
    }

    static class ProgramViewHolder extends RecyclerView.ViewHolder {
        ItemProgramBinding mItemProgramBinding;

        public ProgramViewHolder(View itemView) {
            super(itemView);
        }

        public void setItemProgramBinding(ItemProgramBinding itemProgramBinding) {
            mItemProgramBinding = itemProgramBinding;
        }

        public ItemProgramBinding getItemProgramBinding() {
            return mItemProgramBinding;
        }
    }
}
