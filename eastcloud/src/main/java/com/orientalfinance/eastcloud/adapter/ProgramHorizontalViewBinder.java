package com.orientalfinance.eastcloud.adapter;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.orientalfinance.BR;
import com.orientalfinance.R;
import com.orientalfinance.databinding.ItemProgramHorizontalBinding;
import com.orientalfinance.eastcloud.module.javabean.HorizontalProgram;

import me.drakeet.multitype.ItemViewBinder;

/**
 * Created by 29435 on 2017/6/20.
 */

public class ProgramHorizontalViewBinder extends ItemViewBinder<HorizontalProgram, ProgramHorizontalViewBinder.ProgramHorizontalViewHolder> {
    @NonNull
    @Override
    protected ProgramHorizontalViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        ItemProgramHorizontalBinding itemProgramBinding = DataBindingUtil.inflate(inflater, R.layout.item_program_horizontal, parent, false);

        ProgramHorizontalViewHolder programViewHolder = new ProgramHorizontalViewHolder(itemProgramBinding.getRoot());
        programViewHolder.setItemProgramBinding(itemProgramBinding);
        return programViewHolder;
    }

    @Override
    protected void onBindViewHolder(@NonNull ProgramHorizontalViewHolder holder, @NonNull HorizontalProgram item) {

        holder.getItemProgramBinding().setVariable(BR.horizontalprogram, item);

    }

    static class ProgramHorizontalViewHolder extends RecyclerView.ViewHolder {
        ItemProgramHorizontalBinding mItemProgramBinding;

        public ProgramHorizontalViewHolder(View itemView) {
            super(itemView);
        }

        public void setItemProgramBinding(ItemProgramHorizontalBinding itemProgramBinding) {
            mItemProgramBinding = itemProgramBinding;
        }

        public ItemProgramHorizontalBinding getItemProgramBinding() {
            return mItemProgramBinding;
        }
    }
}
