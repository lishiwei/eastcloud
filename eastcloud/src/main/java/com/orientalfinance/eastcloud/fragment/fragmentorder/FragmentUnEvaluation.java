package com.orientalfinance.eastcloud.fragment.fragmentorder;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.andview.refreshview.XRefreshView;
import com.orientalfinance.R;
import com.orientalfinance.eastcloud.adapter.OrderAdapter;
import com.orientalfinance.eastcloud.adapter.OrderListAdapter;
import com.orientalfinance.eastcloud.module.javabean.Order;
import com.orientalfinance.eastcloud.utils.OrderUtils;
import com.orientalfinance.eastcloud.view.order.ItemOrderBottom;
import com.orientalfinance.eastcloud.view.order.ItemOrderIn;
import com.orientalfinance.eastcloud.view.order.ItemOrderTop;
import com.orientalfinance.eastcloud.view.order.OrderLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentUnEvaluation#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentUnEvaluation extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private RecyclerView recyclerView;
    private OrderAdapter orderAdapter;
    private XRefreshView refreshView;
    private ArrayList<OrderLayout> orderLayouts;
    private long lastRefreshTime;


    public FragmentUnEvaluation() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentUnEvaluation.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentUnEvaluation newInstance(String param1, String param2) {
        FragmentUnEvaluation fragment = new FragmentUnEvaluation();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_un_evaluation, container, false);
        initData();
        initViews(view);

        return view;
    }

    /**
     * 设置数据
     */
    private void initData() {
        //TODO 最外层数据-一般是从接口获取
        List<Order> orderList = OrderUtils.loadData();

        orderLayouts = new ArrayList<OrderLayout>();

        for (int k = 0; k < orderList.size(); k++) {
            Order order = orderList.get(k);
            List<Order.Goods> goodsList = order.getGoodsList();
            String order_status = order.getOrder_status();
            if (order_status.equals("已完成")) {
                ItemOrderTop itemOrderTop = new ItemOrderTop(order);
                orderLayouts.add(itemOrderTop);
                if (goodsList == null) {
                    //没有订单
                } else {
                    //中间for循环，将数据循环读取后存到订单中间部分
                    //TODO 设置中间数据
                    for (int j = 0; j < goodsList.size(); j++) {
                        Order.Goods goods = new Order.Goods();
                        goods.setGoods_name(goodsList.get(j).getGoods_name());
                        goods.setGoods_spec(goodsList.get(j).getGoods_spec());
                        //goods.setGoodsSize(goodsList.get(j).get());
                        goods.setGoods_price(goodsList.get(j).getGoods_price());
                        goods.setGoods_num(goodsList.get(j).getGoods_num());
                        goods.setGoods_img(goodsList.get(j).getGoods_img());
                        //需要的数据直接传
                        ItemOrderIn orderIMiddle = new ItemOrderIn(order, goods);
                        orderLayouts.add(orderIMiddle);
                        Log.i("myLog", "orderLayouts =" + orderLayouts);
                    }
                }


                //外部第二个循环，将数据循环读取后存到订单底部
                //TODO 设置底部数据-需要的数据直接传
                ItemOrderBottom orderBottom = new ItemOrderBottom(order);
                orderLayouts.add(orderBottom);

            }
        }
    }

    private void initViews(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        OrderListAdapter adapter = new OrderListAdapter(this.getActivity(), orderLayouts);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter);

        refreshView = (XRefreshView) view.findViewById(R.id.custom_view);

        refreshView.setPullRefreshEnable(true);
        refreshView.setPullLoadEnable(false);
        refreshView.restoreLastRefreshTime(lastRefreshTime);
        //当下拉刷新被禁用时，调用这个方法并传入false可以不让头部被下拉
        refreshView.setMoveHeadWhenDisablePullRefresh(true);
        refreshView.setXRefreshViewListener(new XRefreshView.SimpleXRefreshListener() {


            @Override
            public void onLoadMore(boolean isSilence) {
                Toast.makeText(getActivity(), "上拉加载更多", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRefresh(boolean isPullDown) {
                refreshView.stopRefresh();
                Toast.makeText(getActivity(), "下拉刷新", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onRelease(float direction) {
                Toast.makeText(getActivity(), "onRelease", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
