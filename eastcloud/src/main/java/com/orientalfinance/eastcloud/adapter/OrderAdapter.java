package com.orientalfinance.eastcloud.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.orientalfinance.R;
import com.orientalfinance.eastcloud.module.javabean.Order;

import java.util.List;

/**
 * Created by lzy on 2017/6/19.
 * email:lizy@oriental-finance.com
 */

public class OrderAdapter extends BaseAdapter {
    private Context mCtx;
    private List<Order> mList;
    private final LayoutInflater layoutInflater;

    public OrderAdapter(Context context, List<Order> list) {
        this.mCtx = context;
        this.mList = list;
        layoutInflater = LayoutInflater.from(mCtx);
    }

    @Override
    public int getCount() {
        return mList == null ? 0 : mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.item_order, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else viewHolder = (ViewHolder) convertView.getTag();

        Order order = mList.get(position);
        Glide.with(mCtx).load(order.getLogoUrl()).placeholder(R.mipmap.ic_launcher).into(viewHolder.ivLog);
        viewHolder.tvProductName.setText(order.getName());
        viewHolder.tvProductColor.setText(order.getColor());
        viewHolder.tvProductCount.setText(order.getCount());
        viewHolder.tvProductPrice.setText(order.getPrice());
        viewHolder.tvProductSize.setText(order.getSize());

        return convertView;
    }


    public static class ViewHolder {
        private final ImageView ivLog;
        private final TextView tvProductName;
        private final TextView tvProductColor;
        private final TextView tvProductSize;
        private final TextView tvProductPrice;
        private final TextView tvProductCount;

        ViewHolder(View view) {
            ivLog = (ImageView) view.findViewById(R.id.iv_logo);
            tvProductName = (TextView) view.findViewById(R.id.tv_product_name);
            tvProductColor = (TextView) view.findViewById(R.id.tv_color);
            tvProductSize = (TextView) view.findViewById(R.id.tv_product_size);
            tvProductPrice = (TextView) view.findViewById(R.id.tv_product_price);
            tvProductCount = (TextView) view.findViewById(R.id.tv_product_count);
        }
    }
}
