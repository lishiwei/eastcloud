package com.orientalfinance.eastcloud.fragment.remotecontroller;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

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
        initViews(view);

        return view;
    }

    private void initViews(View view) {
        View remoteMenu = view.findViewById(R.id.flyout_center);
        startPropertyAnim(remoteMenu);

        view.findViewById(R.id.iv_voice_plus).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "音量+++++", Toast.LENGTH_SHORT).show();
            }
        });
        view.findViewById(R.id.iv_left_top).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "iv_left_top", Toast.LENGTH_SHORT).show();
            }
        });
        view.findViewById(R.id.iv_right_top).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "iv_right_top", Toast.LENGTH_SHORT).show();
            }
        });
        view.findViewById(R.id.iv_below_left).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "iv_below_left", Toast.LENGTH_SHORT).show();
            }
        });
        view.findViewById(R.id.iv_below_right).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "iv_below_right", Toast.LENGTH_SHORT).show();
            }
        });
        view.findViewById(R.id.iv_center).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "iv_center", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void startPropertyAnim(View view) {
        ObjectAnimator anim = ObjectAnimator.ofFloat(view, "rotation", 0f, 45f);
        anim.setDuration(10);
        anim.start();
    }
}
