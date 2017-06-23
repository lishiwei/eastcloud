package com.orientalfinance.eastcloud.view.order;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.bumptech.glide.Glide;
import com.orientalfinance.R;
import com.orientalfinance.eastcloud.module.javabean.Order;
import com.orientalfinance.eastcloud.utils.ImageLoaders;

import static com.orientalfinance.eastcloud.module.Retrofit.configration.Constant.OrderC.JFB;


/**
 * 订单布局-中间商品布局
 * 作者：fly on 2016/8/24 0024 23:45
 * 邮箱：cugb_feiyang@163.com
 */
public class ItemOrderIn implements OrderLayout {
    private Order order;
    private Order.Goods goods;

    public ItemOrderIn(Order order, Order.Goods goods) {
        this.order = order;
        this.goods = goods;
    }

    @Override
    public int getLayout() {
        return R.layout.item_order;
    }

    @Override
    public boolean isClickAble() {
        return true;
    }

    @Override
    public View getView(final Context mContext, View convertView, LayoutInflater inflater) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        if (order.getBuzi_type().equals(JFB)) {
            convertView = layoutInflater.inflate(R.layout.item_jfb_order_middle, null);
            ImageView ivTVLogo = (ImageView) convertView.findViewById(R.id.iv_logo);
            TextView tvProductName = (TextView) convertView.findViewById(R.id.tv_product_name);
            TextView tvProductPrice = (TextView) convertView.findViewById(R.id.tv_product_price);
            tvProductName.setText(goods.getGoods_name());
            tvProductPrice.setText(goods.getGoods_price());
            ImageLoaders.displayImage(ivTVLogo, goods.getGoods_img());
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, "东方有线", Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            convertView = layoutInflater.inflate(getLayout(), null);
            ImageView ivLog = (ImageView) convertView.findViewById(R.id.iv_logo);
            TextView tvProductName = (TextView) convertView.findViewById(R.id.tv_product_name);
            TextView tvProductColor = (TextView) convertView.findViewById(R.id.tv_color);
            TextView tvProductSize = (TextView) convertView.findViewById(R.id.tv_product_size);
            TextView tvProductPrice = (TextView) convertView.findViewById(R.id.tv_product_price);
            TextView tvProductCount = (TextView) convertView.findViewById(R.id.tv_product_count);

            tvProductName.setText(goods.getGoods_name());
            tvProductColor.setText(goods.getGoods_spec());
            Log.e("YYY", "图片路径：" + goods.getGoods_img());
            ImageLoaders.displayImage(ivLog, goods.getGoods_img());
            //tvProductSize.setText(goods.get());
            tvProductPrice.setText(goods.getGoods_price());
            tvProductCount.setText(goods.getGoods_num());
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, "购物", Toast.LENGTH_SHORT).show();
                }
            });
        }
        return convertView;
    }
}
