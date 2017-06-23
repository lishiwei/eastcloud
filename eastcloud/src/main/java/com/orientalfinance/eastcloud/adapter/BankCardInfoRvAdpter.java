package com.orientalfinance.eastcloud.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.orientalfinance.BR;
import com.orientalfinance.R;
import com.orientalfinance.eastcloud.module.javabean.BankCardInfo;

import java.util.List;

/**
 * Created by 29435 on 2017/5/26.
 */

public class BankCardInfoRvAdpter extends RecyclerView.Adapter<BankCardInfoRvAdpter.BankCardViewHolder> {
    private static final String TAG = BankCardInfoRvAdpter.class.getSimpleName();
    List<BankCardInfo> mBankCardInfos;

    @Override
    public BankCardViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        ViewDataBinding viewDataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_bankcard, null, false);
        BankCardViewHolder bankCardViewHolder = new BankCardViewHolder(viewDataBinding.getRoot());
        bankCardViewHolder.setViewDataBinding(viewDataBinding);
        bankCardViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(v.getContext(), ActivityTopBox.class);
//                v.getContext().startActivity(intent);
            }
        });
        return bankCardViewHolder;
    }

    public void setBankCardInfos(List<BankCardInfo> bankCardInfos) {
        mBankCardInfos = bankCardInfos;
notifyDataSetChanged();
    }

    public List<BankCardInfo> getBankCardInfos() {
        return mBankCardInfos;
    }

    public BankCardInfoRvAdpter(List<BankCardInfo> movies) {
        mBankCardInfos = movies;
    }

    @Override
    public void onBindViewHolder(BankCardViewHolder holder, int position) {

        holder.mViewDataBinding.setVariable(BR.bankInfo, mBankCardInfos.get(position));
    }

    public void setMovieList(List<BankCardInfo> bankCardInfos) {

        mBankCardInfos = bankCardInfos;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mBankCardInfos.size();
    }

    class BankCardViewHolder extends RecyclerView.ViewHolder {
        ViewDataBinding mViewDataBinding;

        public BankCardViewHolder(View itemView) {
            super(itemView);
        }

        public void setViewDataBinding(ViewDataBinding viewDataBinding) {
            mViewDataBinding = viewDataBinding;
        }
    }
}
