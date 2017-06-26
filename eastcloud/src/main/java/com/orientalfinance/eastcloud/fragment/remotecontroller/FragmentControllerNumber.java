package com.orientalfinance.eastcloud.fragment.remotecontroller;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.orientalfinance.R;
import com.orientalfinance.eastcloud.adapter.RemoteNumberAdapter;

import java.util.ArrayList;

/**
 * Created by lzy on 2017/6/20.
 * email:lizy@oriental-finance.com
 */

public class FragmentControllerNumber extends Fragment {

    private Integer[] resIDs = new Integer[]{R.drawable.number_1_bg, R.drawable.number_2_bg, R.drawable.number_3_bg,
            R.drawable.number_4_bg, R.drawable.number_5_bg, R.drawable.number_6_bg, R.drawable.number_7_bg,
            R.drawable.number_8_bg, R.drawable.number_9_bg, R.drawable.number_star_bg, R.drawable.number_0_bg,
            R.drawable.number_del_bg};
    ;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_controller_number, null);

        initViews(view);

        return view;
    }

    private void initViews(View view) {
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rcv_number);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        RemoteNumberAdapter remoteNumberAdapter = new RemoteNumberAdapter(getActivity(), resIDs);
        recyclerView.setAdapter(remoteNumberAdapter);
        remoteNumberAdapter.setChannelValueCallback(new RemoteNumberAdapter.ChannelValueCallback() {
            @Override
            public void onChannelValue(String value) {
                Toast.makeText(getActivity(), "频道:" + value, Toast.LENGTH_SHORT).show();
            }
        });


    }

}
