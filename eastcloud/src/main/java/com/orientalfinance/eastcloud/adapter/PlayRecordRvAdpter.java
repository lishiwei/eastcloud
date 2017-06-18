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
import com.orientalfinance.databinding.ItemPlayRecordBinding;
import com.orientalfinance.eastcloud.activity.ActivityDetail;
import com.orientalfinance.eastcloud.module.javabean.History;
import com.orientalfinance.eastcloud.view.OnSwipeDeleteListener;

import java.util.List;

/**
 * Created by 29435 on 2017/5/26.
 */

public class PlayRecordRvAdpter extends RecyclerView.Adapter<PlayRecordRvAdpter.PlayRecordViewHolder> {
    private static final String TAG = PlayRecordRvAdpter.class.getSimpleName();
    List<History> mChannelList;
    public boolean isShow = false;
OnSwipeDeleteListener mOnSwipeDeleteListener;

    public void setOnSwipeDeleteListener(OnSwipeDeleteListener onSwipeDeleteListener) {
        mOnSwipeDeleteListener = onSwipeDeleteListener;
    }

    public OnSwipeDeleteListener getOnSwipeDeleteListener() {
        return mOnSwipeDeleteListener;
    }

    @Override
    public PlayRecordViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        ItemPlayRecordBinding viewDataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_play_record, null, false);
        PlayRecordViewHolder currentHitViewHolder = new PlayRecordViewHolder(viewDataBinding.getRoot());
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

    public PlayRecordRvAdpter(List<History> Channels) {
        mChannelList = Channels;
    }

    @Override
    public void onBindViewHolder(PlayRecordViewHolder holder, int position) {
        holder.mViewDataBinding.setVariable(BR.channel, mChannelList.get(position));
        if (isShow) {
            holder.mCheckBox.setVisibility(View.VISIBLE);
        } else {
            holder.mCheckBox.setVisibility(View.GONE);
        }

        holder.mCheckBox.setChecked(mChannelList.get(position).isChecked());
    }

    public void setChannelList(List<History> ChannelList) {

        mChannelList = ChannelList;
        notifyDataSetChanged();
    }

    public List<History> getChannelList() {
        return mChannelList;
    }

    @Override
    public int getItemCount() {
        return mChannelList.size();
    }

    class PlayRecordViewHolder extends RecyclerView.ViewHolder {

        ItemPlayRecordBinding mViewDataBinding;
        CheckBox mCheckBox;
        Button mButton;
        SwipeMenuLayout mSwipeMenuLayout;

        public PlayRecordViewHolder(final View itemView) {
            super(itemView);
            mCheckBox = (CheckBox) itemView.findViewById(R.id.cb_del);
            mButton = (Button) itemView.findViewById(R.id.btnDelete);
            mSwipeMenuLayout = (SwipeMenuLayout) itemView.findViewById(R.id.swipeMenu_Record);
            mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    mChannelList.get(getLayoutPosition()).setChecked(isChecked);
                }
            });
            mButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mOnSwipeDeleteListener!=null)
                    {
                        mOnSwipeDeleteListener.onDeleteListener(mSwipeMenuLayout,getLayoutPosition());

                    }

                }
            });
        }

        public void setViewDataBinding(ItemPlayRecordBinding viewDataBinding) {
            mViewDataBinding = viewDataBinding;
        }
    }
}
