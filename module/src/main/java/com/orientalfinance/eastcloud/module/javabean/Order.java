package com.orientalfinance.eastcloud.module.javabean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by lzy on 2017/6/19.
 * email:lizy@oriental-finance.com
 */
public class Order implements Serializable {
    private String order_id;
    private String order_name;
    private String order_status;
    private String goods_num;
    private String total_price;
    private String buzi_type;
    private List<Goods> goodsList;

    public Order() {
    }

    public Order(String order_id, String order_name, String order_status, String goods_num,
                 String total_price, String buzi_type, List<Goods> goodsList) {
        this.order_id = order_id;
        this.order_name = order_name;
        this.order_status = order_status;
        this.goods_num = goods_num;
        this.total_price = total_price;
        this.buzi_type = buzi_type;
        this.goodsList = goodsList;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getOrder_name() {
        return order_name;
    }

    public void setOrder_name(String order_name) {
        this.order_name = order_name;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    public String getGoods_num() {
        return goods_num;
    }

    public void setGoods_num(String goods_num) {
        this.goods_num = goods_num;
    }

    public String getTotal_price() {
        return total_price;
    }

    public void setTotal_price(String total_price) {
        this.total_price = total_price;
    }

    public String getBuzi_type() {
        return buzi_type;
    }

    public void setBuzi_type(String buzi_type) {
        this.buzi_type = buzi_type;
    }

    public List<Goods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }

    @Override
    public String toString() {
        return "Order{" +
                "order_id='" + order_id + '\'' +
                ", order_name='" + order_name + '\'' +
                ", order_status='" + order_status + '\'' +
                ", goods_num='" + goods_num + '\'' +
                ", total_price='" + total_price + '\'' +
                ", buzi_type='" + buzi_type + '\'' +
                ", goodsList=" + goodsList +
                '}';
    }

    public static class Goods implements Serializable {
        private String goods_img;
        private String goods_name;
        private String goods_spec;
        private String goods_num;
        private String goods_price;

        public Goods() {
        }

        public Goods(String goods_img, String goods_name, String goods_spec, String goods_num, String goods_price) {
            this.goods_img = goods_img;
            this.goods_name = goods_name;
            this.goods_spec = goods_spec;
            this.goods_num = goods_num;
            this.goods_price = goods_price;
        }

        public String getGoods_img() {
            return goods_img;
        }

        public void setGoods_img(String goods_img) {
            this.goods_img = goods_img;
        }

        public String getGoods_name() {
            return goods_name;
        }

        public void setGoods_name(String goods_name) {
            this.goods_name = goods_name;
        }

        public String getGoods_spec() {
            return goods_spec;
        }

        public void setGoods_spec(String goods_spec) {
            this.goods_spec = goods_spec;
        }

        public String getGoods_num() {
            return goods_num;
        }

        public void setGoods_num(String goods_num) {
            this.goods_num = goods_num;
        }

        public String getGoods_price() {
            return goods_price;
        }

        public void setGoods_price(String goods_price) {
            this.goods_price = goods_price;
        }

        @Override
        public String toString() {
            return "Goods{" +
                    "goods_img='" + goods_img + '\'' +
                    ", goods_name='" + goods_name + '\'' +
                    ", goods_spec='" + goods_spec + '\'' +
                    ", goods_num='" + goods_num + '\'' +
                    ", goods_price='" + goods_price + '\'' +
                    '}';
        }
    }
}
