package com.orientalfinance.eastcloud.fragment.remotecontroller;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.orientalfinance.R;

/**
 * Created by lzy on 2017/6/20.
 * email:lizy@oriental-finance.com
 */

public class FragmentControllerMenu extends Fragment implements View.OnClickListener {
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
        startPropertyAnimWithClockwise(remoteMenu);
        startAnimWithAnticlockwise(view.findViewById(R.id.tv_center_ok));
        view.findViewById(R.id.iv_voice_plus).setOnClickListener(this);
        view.findViewById(R.id.iv_voice_minus).setOnClickListener(this);
        view.findViewById(R.id.iv_left_top).setOnClickListener(this);
        view.findViewById(R.id.iv_below_left).setOnClickListener(this);
        view.findViewById(R.id.iv_below_right).setOnClickListener(this);
        view.findViewById(R.id.iv_right_top).setOnClickListener(this);
        view.findViewById(R.id.iv_center).setOnClickListener(this);
        view.findViewById(R.id.iv_exit).setOnClickListener(this);
        view.findViewById(R.id.iv_retur).setOnClickListener(this);
    }

    /**
     * 方法描述：顺时针旋转45度
     */
    private void startPropertyAnimWithClockwise(View view) {
        ObjectAnimator anim = ObjectAnimator.ofFloat(view, "rotation", 0f, 45f);
        anim.setDuration(10);
        anim.start();
    }

    /**
     * 方法描述：逆时针旋转45度
     */

    private void startAnimWithAnticlockwise(View view) {
        ObjectAnimator anim = ObjectAnimator.ofFloat(view, "rotation", 0f, -45f);
        anim.setDuration(10);
        anim.start();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_voice_plus:
                Toast.makeText(getActivity(), "音量+++++", Toast.LENGTH_SHORT).show();
                break;
            case R.id.iv_voice_minus:
                Toast.makeText(getActivity(), "音量-----", Toast.LENGTH_SHORT).show();
                break;
            case R.id.iv_left_top:
                Toast.makeText(getActivity(), "top", Toast.LENGTH_SHORT).show();
                break;
            case R.id.iv_below_left:
                Toast.makeText(getActivity(), "left", Toast.LENGTH_SHORT).show();
                break;
            case R.id.iv_below_right:
                Toast.makeText(getActivity(), "bottom", Toast.LENGTH_SHORT).show();
                break;
            case R.id.iv_right_top:
                Toast.makeText(getActivity(), "right", Toast.LENGTH_SHORT).show();
                break;
            case R.id.iv_center:
                Toast.makeText(getActivity(), "center", Toast.LENGTH_SHORT).show();
                break;
            case R.id.iv_exit:
                Toast.makeText(getActivity(), "退出", Toast.LENGTH_SHORT).show();
                break;
            case R.id.iv_retur:
                Toast.makeText(getActivity(), "返回", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
