package com.orientalfinance.eastcloud.fragment.fragmentorder;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.andview.refreshview.XRefreshView;
import com.orientalfinance.R;
import com.orientalfinance.eastcloud.adapter.OrderAdapter;
import com.orientalfinance.eastcloud.module.javabean.Order;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentAllOrder#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentAllOrder extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ListView listView;
    private ArrayList<Order> orders;
    private XRefreshView refreshView;
    private OrderAdapter orderAdapter;
    private long lastRefreshTime;

    public FragmentAllOrder() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentAllOrder.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentAllOrder newInstance(String param1, String param2) {
        FragmentAllOrder fragment = new FragmentAllOrder();
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
        View view = inflater.inflate(R.layout.fragment_all_order, container, false);

        loadData();
        initViews(view);

        return view;
    }

    private void loadData() {
        orders = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Order order = new Order();
            order.setName("杜鹃同款对白春款时尚撞色潮流穿搭2017高档雪纺连衣裙");
            order.setColor("白色");
            order.setCount("1");
            order.setPrice("128");
            order.setSize("XXXL");
            order.setLogoUrl("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=715805757,2162331109&fm=26&gp=0.jpg");
            orders.add(order);
        }
    }

    private void initViews(View view) {
        refreshView = (XRefreshView) view.findViewById(R.id.custom_view);
        listView = (ListView) view.findViewById(R.id.lv_all_order);
        orderAdapter = new OrderAdapter(getContext(), orders);
        listView.setAdapter(orderAdapter);
        refreshView.setPullRefreshEnable(true);
        refreshView.setPullLoadEnable(true);
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
                Toast.makeText(getActivity(), "下拉刷新", Toast.LENGTH_SHORT).show();
                refreshView.stopRefresh();
                lastRefreshTime = refreshView.getLastRefreshTime();
                for (int i = 0; i < 3; i++) {
                    Order order = new Order();
                    order.setName("杜鹃同款对白春款时尚撞色潮流穿搭2017高档雪纺连衣裙");
                    order.setColor("白色");
                    order.setCount("1");
                    order.setPrice("128");
                    order.setSize("XXXL");
                    order.setLogoUrl("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=715805757,2162331109&fm=26&gp=0.jpg");
                    orders.add(order);
                }
                orderAdapter.notifyDataSetChanged();
            }

            @Override
            public void onRelease(float direction) {
                Toast.makeText(getActivity(), "onRelease", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
