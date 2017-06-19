package com.orientalfinance.eastcloud.module.javabean;

/**
 * Created by lzy on 2017/6/19.
 * email:lizy@oriental-finance.com
 */

public class Order {
    private String id;
    private String logoUrl;
    private String name;
    private String color;
    private String size;
    private String price;
    private String count;

    public Order() {
    }

    public Order(String id, String logoUrl, String name, String color, String size, String price, String count) {
        this.id = id;
        this.logoUrl = logoUrl;
        this.name = name;
        this.color = color;
        this.size = size;
        this.price = price;
        this.count = count;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", logoUrl='" + logoUrl + '\'' +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", size='" + size + '\'' +
                ", price='" + price + '\'' +
                ", count='" + count + '\'' +
                '}';
    }
}
