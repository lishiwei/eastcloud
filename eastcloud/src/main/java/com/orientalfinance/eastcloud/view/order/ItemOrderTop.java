package com.orientalfinance.eastcloud.view.order;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.orientalfinance.R;
import com.orientalfinance.eastcloud.module.javabean.Order;

import static com.orientalfinance.eastcloud.module.Retrofit.configration.Constant.OrderC.JFB;


/**
 * 订单布局-top
 * 作者：fly on 2016/8/24 0024 23:45
 * 邮箱：cugb_feiyang@163.com
 */
public class ItemOrderTop implements OrderLayout {
    private Order order;

    public ItemOrderTop(Order order) {
        this.order = order;
    }


    @Override
    public int getLayout() {
        return R.layout.item_order_top;
    }

    @Override
    public boolean isClickAble() {
        return true;
    }

    @Override
    public View getView(Context mContext, View convertView, LayoutInflater inflater) {
        inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(R.layout.item_order_top, null);
        TextView tvStatus = (TextView) convertView.findViewById(R.id.tv_top_status);
        TextView tvOrderName = (TextView) convertView.findViewById(R.id.tv_order_name);
        if (order.getBuzi_type().equals(JFB)) {
            tvOrderName.setText(order.getOrder_name());
        }
        tvStatus.setText(order.getOrder_status());
        return convertView;
    }
}
