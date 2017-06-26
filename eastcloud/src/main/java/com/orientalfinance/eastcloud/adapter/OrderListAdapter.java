package com.orientalfinance.eastcloud.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.orientalfinance.eastcloud.module.javabean.Order;
import com.orientalfinance.eastcloud.view.order.OrderLayout;

import java.util.List;

/**
 * 作者：fly on 2016/8/24 0024 23:34
 * 邮箱：cugb_feiyang@163.com
 */
public class OrderListAdapter extends RecyclerView.Adapter<OrderListAdapter.MyViewHolder> {
    private Context mContext;
    private List<OrderLayout> list;
    private LayoutInflater mInflater;
    private List<Order> mOrderList;

    public OrderListAdapter(Context mContext, List<OrderLayout> list) {
        this.mContext = mContext;
        this.list = list;
    }


    private int time = 0;

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, final int viewType) {
        MyViewHolder holder = new MyViewHolder(list.get(viewType).getView(mContext, parent, mInflater));
//        View view = list.get(viewType).getView(mContext, parent, mInflater);
//        MyViewHolder holder = new MyViewHolder(view);
//        MyViewHolder holder = null;
//        switch (viewType) {
//            case 0:
//                ItemOrderTop itemOrderTop = (ItemOrderTop) list.get(time);
//                View view = itemOrderTop.getView(mContext, parent, mInflater);
//                holder = new MyViewHolder(view);
//                time++;
//                break;
//            case 1:
//                ItemOrderIn itemOrderIn = (ItemOrderIn) list.get(time);
//                View view1 = itemOrderIn.getView(mContext, parent, mInflater);
//                holder = new MyViewHolder(view1);
//                time++;
//                break;
//            case 2:
//                ItemOrderBottom itemOrderBottom = (ItemOrderBottom) list.get(time);
//                View view2 = itemOrderBottom.getView(mContext, parent, mInflater);
//                holder = new MyViewHolder(view2);
//                time++;
//                break;
//
//        }


//        OrderLayout orderLayout = list.get(viewType);
//        if (orderLayout instanceof ItemOrderIn) {
//            final Order.Goods itemOrderParam = ((ItemOrderIn) orderLayout).getItemOrderParam();
//            view.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    if (mOnGoodsListener != null) {
//                        mOnGoodsListener.onGoodsClick(itemOrderParam);
//                    }
//                }
//            });
//        } else if (orderLayout instanceof ItemOrderBottom) {
//            ItemOrderBottom itemOrderBottom = (ItemOrderBottom) orderLayout;
//            final Order order = itemOrderBottom.getOrder();
//            view.findViewById(R.id.btn_undeliver_goods).setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Toast.makeText(mContext, "商品order=》" + order.toString(), Toast.LENGTH_SHORT).show();
//                }
//            });
//        } else if (orderLayout instanceof ItemOrderTop) {
//
//        }

        return holder;
    }

    private int position;

    /**
     * 每一个位置的item都作为单独一项来设置
     * viewType 设置为position
     *
     * @param position
     * @return
     */
    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public void onViewRecycled(MyViewHolder holder) {
        super.onViewRecycled(holder);
    }

    /**
     * 更新数据
     *
     * @param orderLayouts
     */
    public void updateList(List<OrderLayout> orderLayouts) {
        this.list = orderLayouts;
        this.notifyDataSetChanged();
    }

    /**
     * 清除数据
     */
    public void clearList() {
        this.list.clear();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        public MyViewHolder(View itemView) {
            super(itemView);
        }
    }
}
