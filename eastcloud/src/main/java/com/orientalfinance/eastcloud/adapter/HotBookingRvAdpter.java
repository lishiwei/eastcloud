package com.orientalfinance.eastcloud.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.orientalfinance.BR;
import com.orientalfinance.R;
import com.orientalfinance.databinding.ItemHotbookingBinding;
import com.orientalfinance.eastcloud.module.javabean.AppointmentProgram;

import java.util.List;

/**
 * Created by 29435 on 2017/5/26.
 */

public class HotBookingRvAdpter extends RecyclerView.Adapter<HotBookingRvAdpter.CurrentHitViewHolder> {
    private static final String TAG = HotBookingRvAdpter.class.getSimpleName();
    List<AppointmentProgram> mProgramList;
    OnAddAppointmentListener mOnAddAppointmentListener;
    OnCancelAppointmentListener mOnCancelAppointmentListener;

    public void setOnAddAppointmentListener(OnAddAppointmentListener onAddAppointmentListener) {
        mOnAddAppointmentListener = onAddAppointmentListener;
    }

    public void setOnCancelAppointmentListener(OnCancelAppointmentListener onCancelAppointmentListener) {
        mOnCancelAppointmentListener = onCancelAppointmentListener;
    }

    public List<AppointmentProgram> getProgramList() {
        return mProgramList;
    }

    public OnAddAppointmentListener getOnAddAppointmentListener() {
        return mOnAddAppointmentListener;
    }

    public OnCancelAppointmentListener getOnCancelAppointmentListener() {
        return mOnCancelAppointmentListener;
    }

    @Override
    public CurrentHitViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        ItemHotbookingBinding viewDataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_hotbooking, null, false);
        final CurrentHitViewHolder currentHitViewHolder = new CurrentHitViewHolder(viewDataBinding.getRoot());
        currentHitViewHolder.setViewDataBinding(viewDataBinding);
        currentHitViewHolder.itemView.findViewById(R.id.ll_Action).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mProgramList.get(currentHitViewHolder.getLayoutPosition()).getAppointId() == null) {
                    if (getOnAddAppointmentListener() != null) {
                        getOnAddAppointmentListener().onAddAppointment(mProgramList.get(currentHitViewHolder.getLayoutPosition()).getProgramId());
                    }
                }
                else {
                    if (getOnCancelAppointmentListener() != null) {
                        getOnCancelAppointmentListener().onCancelAppointment(mProgramList.get(currentHitViewHolder.getLayoutPosition()).getProgramId());
                    }
                }
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
        Log.d(TAG, "setProgramList: " + ProgramList.size());
        mProgramList = ProgramList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mProgramList.size();
    }

    class CurrentHitViewHolder extends RecyclerView.ViewHolder {
        ItemHotbookingBinding mViewDataBinding;

        public CurrentHitViewHolder(View itemView) {
            super(itemView);
        }

        public void setViewDataBinding(ItemHotbookingBinding viewDataBinding) {
            mViewDataBinding = viewDataBinding;
        }
    }

    public interface OnAddAppointmentListener {
        public void onAddAppointment(String program_id);
    }

    public interface OnCancelAppointmentListener {
        public void onCancelAppointment(String program_id);
    }
}
