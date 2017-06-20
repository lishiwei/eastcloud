package com.orientalfinance.eastcloud.fragment.remotecontroller;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.orientalfinance.R;

/**
 * Created by lzy on 2017/6/20.
 * email:lizy@oriental-finance.com
 */

public class FragmentControllerMenu extends Fragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_controller_menu, null);

        return view;
    }
}
