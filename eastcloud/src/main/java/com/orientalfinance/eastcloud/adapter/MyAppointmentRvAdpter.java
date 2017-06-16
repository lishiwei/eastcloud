package com.orientalfinance.eastcloud.adapter;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.mcxtzhang.swipemenulib.SwipeMenuLayout;
import com.orientalfinance.BR;
import com.orientalfinance.R;
import com.orientalfinance.databinding.ItemMyappointmentBinding;
import com.orientalfinance.eastcloud.activity.ActivityDetail;
import com.orientalfinance.eastcloud.module.javabean.Appointment;
import com.orientalfinance.eastcloud.view.OnSwipeDeleteListener;

import java.util.List;

/**
 * Created by 29435 on 2017/5/26.
 */

public class MyAppointmentRvAdpter extends RecyclerView.Adapter<MyAppointmentRvAdpter.MyAppointmentViewHolder> {
    private static final String TAG = MyAppointmentRvAdpter.class.getSimpleName();
    List<Appointment> mAppointmentList;
    public boolean isShow = false;
    OnSwipeDeleteListener mOnSwipeDeleteListener;

    public void setOnSwipeDeleteListener(OnSwipeDeleteListener onSwipeDeleteListener) {
        mOnSwipeDeleteListener = onSwipeDeleteListener;
    }

    public OnSwipeDeleteListener getOnSwipeDeleteListener() {
        return mOnSwipeDeleteListener;
    }

    @Override
    public MyAppointmentViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        ItemMyappointmentBinding viewDataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_myappointment, null, false);
        MyAppointmentViewHolder currentHitViewHolder = new MyAppointmentViewHolder(viewDataBinding.getRoot());
        currentHitViewHolder.setViewDataBinding(viewDataBinding);

        currentHitViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ActivityDetail.class);
                v.getContext().startActivity(intent);
            }
        });


        return currentHitViewHolder;
    }

    public boolean isShow() {
        return isShow;
    }

    public void setShow(boolean show) {
        isShow = show;
    }

    public MyAppointmentRvAdpter(List<Appointment> Appointments) {
        mAppointmentList = Appointments;
    }

    @Override
    public void onBindViewHolder(MyAppointmentViewHolder holder, int position) {
        holder.mViewDataBinding.setVariable(BR.appointment, mAppointmentList.get(position));
        if (isShow) {
            holder.mCheckBox.setVisibility(View.VISIBLE);
        } else {
            holder.mCheckBox.setVisibility(View.GONE);
        }

        holder.mCheckBox.setChecked(mAppointmentList.get(position).isChecked());
    }

    public void setAppointmentList(List<Appointment> AppointmentList) {

        mAppointmentList = AppointmentList;
        notifyDataSetChanged();
    }

    public List<Appointment> getAppointmentList() {
        return mAppointmentList;
    }

    @Override
    public int getItemCount() {
        return mAppointmentList.size();
    }

    class MyAppointmentViewHolder extends RecyclerView.ViewHolder {

        ItemMyappointmentBinding mViewDataBinding;
        CheckBox mCheckBox;
        Button mButton;
        SwipeMenuLayout mSwipeMenuLayout;

        public MyAppointmentViewHolder(final View itemView) {
            super(itemView);
            mCheckBox = (CheckBox) itemView.findViewById(R.id.cb_del);
            mButton = (Button) itemView.findViewById(R.id.btnDelete);
            mSwipeMenuLayout = (SwipeMenuLayout) itemView.findViewById(R.id.swipeMenu_Record);
            mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    mAppointmentList.get(getLayoutPosition()).setChecked(isChecked);
                }
            });
            mButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mOnSwipeDeleteListener != null) {
                        mOnSwipeDeleteListener.onDeleteListener(mSwipeMenuLayout, getLayoutPosition());

                    }

                }
            });
        }

        public void setViewDataBinding(ItemMyappointmentBinding viewDataBinding) {
            mViewDataBinding = viewDataBinding;
        }
    }
}
