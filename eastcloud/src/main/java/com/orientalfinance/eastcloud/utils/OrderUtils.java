package com.orientalfinance.eastcloud.utils;

import android.util.Log;

import com.orientalfinance.eastcloud.module.javabean.Order;

import java.util.ArrayList;
import java.util.List;

import static com.orientalfinance.eastcloud.module.Retrofit.configration.Constant.OrderC.JFB;
import static com.orientalfinance.eastcloud.module.Retrofit.configration.Constant.OrderC.YYB;

/**
 * Created by lzy on 2017/6/23.
 * email:lizy@oriental-finance.com
 */

public class OrderUtils {
    /**
     * 模拟拉取服务端数据
     *
     * @return
     */
    public static List<Order> loadData() {
        List<Order> orderList = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            Order order = new Order();
            order.setOrder_id(i + "");
            if (i == 0) {
                order.setBuzi_type(JFB);
                order.setOrder_name("东方有线电视账单");
                order.setOrder_status("待付款");
                order.setGoods_num("1");
                order.setTotal_price("123");
            } else if (i == 1) {
                order.setBuzi_type(YYB);
                order.setOrder_name("");
                order.setOrder_status("待付款");
                order.setGoods_num("1");
                order.setTotal_price("123");
            } else if (i == 2) {
                order.setBuzi_type(YYB);
                order.setOrder_name("");
                order.setOrder_status("待发货");
                order.setGoods_num("1");
                order.setTotal_price("123");
            } else if (i == 3) {
                order.setBuzi_type(YYB);
                order.setOrder_name("");
                order.setOrder_status("待收货");
                order.setGoods_num("1");
                order.setTotal_price("123");
            } else if (i == 4) {
                order.setBuzi_type(YYB);
                order.setOrder_name("");
                order.setOrder_status("已完成");
                order.setGoods_num("1");
                order.setTotal_price("123");
            } else if (i == 5) {
                order.setBuzi_type(JFB);
                order.setOrder_name("东方有线电视账单");
                order.setOrder_status("已完成");
                order.setGoods_num("1");
                order.setTotal_price("123");
            }
            ArrayList<Order.Goods> goodses = new ArrayList<>();
            for (int k = 0; k < i + 1; k++) {
                Order.Goods goods = new Order.Goods();
                goods.setGoods_num("1");
                goods.setGoods_name("杜鹃同款对白春款时尚撞色潮流穿搭2017高档雪纺连衣裙" + i);
                goods.setGoods_spec("白色");
                if (order.getBuzi_type().equals(YYB)) {
                    goods.setGoods_img("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=715805757," +
                            "2162331109&fm=26&gp=0.jpg");
                } else {
                    goods.setGoods_img("http://www.jianbihua.org/jianbihua/image/201510/2015102414440459_S.jpg");
                }
                goods.setGoods_price("234");
                goodses.add(goods);
            }
            order.setGoodsList(goodses);
            Log.e("TAG", "模拟数据：" + order.toString());
            orderList.add(order);
        }
        return orderList;
    }

}
