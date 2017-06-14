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
import com.orientalfinance.eastcloud.activity.ActivityAddFamilyMember;
import com.orientalfinance.eastcloud.module.javabean.FamilyMember;

import java.util.List;

/**
 * Created by 29435 on 2017/5/26.
 */

public class FamilyMemberRvAdapter extends RecyclerView.Adapter<FamilyMemberRvAdapter.FamilyMemberViewHolder> {
    List<FamilyMember> mFamilyMembers;
public static String TAG = FamilyMemberRvAdapter.class.getSimpleName();
    public FamilyMemberRvAdapter(List<FamilyMember> familyMembers) {
        mFamilyMembers = familyMembers;
    }

    public void setFamilyMembers(List<FamilyMember> familyMembers) {
        mFamilyMembers = familyMembers;
        notifyDataSetChanged();
    }

    @Override
    public FamilyMemberViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewDataBinding viewDataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_family_member, null, false);
        final FamilyMemberViewHolder memberViewHolder = new FamilyMemberViewHolder(viewDataBinding.getRoot());
        memberViewHolder.setViewDataBinding(viewDataBinding);
        memberViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (memberViewHolder.getLayoutPosition()==mFamilyMembers.size())
                {
                    v.getContext().startActivity(new  Intent(v.getContext(), ActivityAddFamilyMember.class));
                }
            }
        });
        return memberViewHolder;
    }

    @Override
    public void onBindViewHolder(FamilyMemberViewHolder holder, int position) {

        if (position == mFamilyMembers.size()) {
            holder.mViewDataBinding.setVariable(BR.familyMember, new FamilyMember(R.drawable.plus+"","添加成员"));
        }
        else {
            holder.mViewDataBinding.setVariable(BR.familyMember, mFamilyMembers.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return mFamilyMembers.size() + 1;
    }

    public class FamilyMemberViewHolder extends RecyclerView.ViewHolder {
        ViewDataBinding mViewDataBinding;

        public FamilyMemberViewHolder(View itemView) {
            super(itemView);
        }

        public void setViewDataBinding(ViewDataBinding viewDataBinding) {
            mViewDataBinding = viewDataBinding;
        }
    }
}
