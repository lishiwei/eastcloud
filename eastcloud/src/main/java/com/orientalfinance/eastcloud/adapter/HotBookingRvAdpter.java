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
import com.orientalfinance.eastcloud.activity.ActivityBookingDetail;
import com.orientalfinance.eastcloud.module.javabean.AppointmentProgram;

import java.util.List;

/**
 * Created by 29435 on 2017/5/26.
 */

public class HotBookingRvAdpter extends RecyclerView.Adapter<HotBookingRvAdpter.CurrentHitViewHolder> {
    private static final String TAG = HotBookingRvAdpter.class.getSimpleName();
    List<AppointmentProgram> mProgramList;

    @Override
    public CurrentHitViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        ViewDataBinding viewDataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_hotbooking, null, false);
        CurrentHitViewHolder currentHitViewHolder = new CurrentHitViewHolder(viewDataBinding.getRoot());
        currentHitViewHolder.setViewDataBinding(viewDataBinding);
        currentHitViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ActivityBookingDetail.class);
                v.getContext().startActivity(intent);
            }
        });
        return currentHitViewHolder;
    }

    public HotBookingRvAdpter(List<AppointmentProgram> programs) {
        mProgramList = programs;
    }

    @Override
    public void onBindViewHolder(CurrentHitViewHolder holder, int position) {
        holder.mViewDataBinding.setVariable(BR.program, mProgramList.get(position));
    }

    public void setProgramList(List<AppointmentProgram> ProgramList) {
        Log.d(TAG, "setProgramList: "+ProgramList.size());
        mProgramList = ProgramList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mProgramList.size();
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
