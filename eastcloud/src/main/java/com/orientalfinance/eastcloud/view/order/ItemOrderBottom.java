package com.orientalfinance.eastcloud.view.order;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.orientalfinance.R;
import com.orientalfinance.eastcloud.module.javabean.Order;

import static com.orientalfinance.eastcloud.module.Retrofit.configration.Constant.OrderC.JFB;


/**
 * 订单布局-底部布局
 * 作者：fly on 2016/8/24 0024 23:45
 * 邮箱：cugb_feiyang@163.com
 */
public class ItemOrderBottom implements OrderLayout {
    private Order order;

    public ItemOrderBottom(Order order) {
        this.order = order;
    }


    @Override
    public int getLayout() {
        return R.layout.item_order_bottom;
    }

    @Override
    public boolean isClickAble() {
        return true;
    }

    @Override
    public View getView(final Context mContext, View convertView, LayoutInflater inflater) {
        inflater = LayoutInflater.from(mContext);
        //TODO 数据展示-订单内容
        if (order.getBuzi_type().equals(JFB)) {
            if (order.getOrder_status().equals("待付款")) {
                convertView = inflater.inflate(R.layout.item_jfb_order_bottom, null);
            } else if (order.getOrder_status().equals("已完成")) {
                convertView = inflater.inflate(R.layout.item_right_now_pay_bottom, null);
                final TextView orderTip = (TextView) convertView.findViewById(R.id.tv_order_info);
                String data = mContext.getResources().getString(R.string.un_fa_huo);
                data = String.format(data, order.getGoods_num(), Float.parseFloat(order.getTotal_price()));
                orderTip.setText(data);
                TextView btnPay = (TextView) convertView.findViewById(R.id.btn_pay);
                btnPay.setVisibility(View.GONE);
            }
        } else {
            if (order.getOrder_status().equals("待付款")) {
                convertView = inflater.inflate(R.layout.item_right_now_pay_bottom, null);
                final TextView orderTip = (TextView) convertView.findViewById(R.id.tv_order_info);
                String data = mContext.getResources().getString(R.string.un_fa_huo);
                data = String.format(data, order.getGoods_num(), Float.parseFloat(order.getTotal_price()));
                orderTip.setText(data);
                TextView btnPay = (TextView) convertView.findViewById(R.id.btn_pay);
                btnPay.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(mContext, "立即付款" + order.toString(), Toast.LENGTH_SHORT).show();
                    }
                });
            } else if (order.getOrder_status().equals("待发货")) {
                convertView = inflater.inflate(R.layout.item_order_bottom, null);
                final TextView orderTip = (TextView) convertView.findViewById(R.id.tv_order_info);
                String data = mContext.getResources().getString(R.string.un_fa_huo);
                data = String.format(data, order.getGoods_num(), Float.parseFloat(order.getTotal_price()));
                orderTip.setText(data);
                TextView tvSaleReturn = (TextView) convertView.findViewById(R.id.btn_sales_return);
                TextView tvRemindDeliver = (TextView) convertView.findViewById(R.id.btn_remind_deliver_goods);
                tvRemindDeliver.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(mContext, "已提醒商家尽快发货", Toast.LENGTH_SHORT).show();
                    }
                });

                tvSaleReturn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(mContext, "退货：" + order.toString(), Toast.LENGTH_SHORT).show();
                    }
                });
            } else if (order.getOrder_status().equals("待收货")) {
                convertView = inflater.inflate(R.layout.item_right_now_pay_bottom, null);
                final TextView orderTip = (TextView) convertView.findViewById(R.id.tv_order_info);
                String data = mContext.getResources().getString(R.string.un_fa_huo);
                data = String.format(data, order.getGoods_num(), Float.parseFloat(order.getTotal_price()));
                orderTip.setText(data);
                TextView btnPay = (TextView) convertView.findViewById(R.id.btn_pay);
                btnPay.setText("确认收货");
                btnPay.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(mContext, "确认收货" + order.toString(), Toast.LENGTH_SHORT).show();
                    }
                });
            } else if (order.getOrder_status().equals("已完成")) {
                convertView = inflater.inflate(R.layout.item_right_now_pay_bottom, null);
                final TextView orderTip = (TextView) convertView.findViewById(R.id.tv_order_info);
                String data = mContext.getResources().getString(R.string.un_fa_huo);
                data = String.format(data, order.getGoods_num(), Float.parseFloat(order.getTotal_price()));
                orderTip.setText(data);
                TextView btnPay = (TextView) convertView.findViewById(R.id.btn_pay);
                btnPay.setVisibility(View.GONE);
            }

        }
        return convertView;
    }
}
