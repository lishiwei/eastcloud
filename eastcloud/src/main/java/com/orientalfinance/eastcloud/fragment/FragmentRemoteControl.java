package com.orientalfinance.eastcloud.fragment;


import android.animation.ObjectAnimator;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.orientalfinance.R;
import com.orientalfinance.eastcloud.App;
import com.orientalfinance.eastcloud.utils.WeakHandler;

import java.util.Timer;
import java.util.TimerTask;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentRemoteControl#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentRemoteControl extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private View statusView;
    private WindowManager windowManager;
    private MyHandler handler;


    public FragmentRemoteControl() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentRemoteControl.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentRemoteControl newInstance(String param1, String param2) {
        FragmentRemoteControl fragment = new FragmentRemoteControl();
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
        View view = inflater.inflate(R.layout.fragment_remote_control, container, false);
        statusView = inflater.inflate(R.layout.header_status, null);
        RelativeLayout controllerMenu = (RelativeLayout) view.findViewById(R.id.rlout);
        startPropertyAnim(controllerMenu);
        initViews(view);

        return view;
    }

    private void initViews(View view) {
        view.findViewById(R.id.img_top).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Top", Toast.LENGTH_SHORT).show();
            }
        });

        view.findViewById(R.id.img_right).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "right", Toast.LENGTH_SHORT).show();
            }
        });

        view.findViewById(R.id.img_bottom).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "bottom", Toast.LENGTH_SHORT).show();
            }
        });

        view.findViewById(R.id.img_left).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "left", Toast.LENGTH_SHORT).show();
            }
        });

        view.findViewById(R.id.img_center).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "center", Toast.LENGTH_SHORT).show();
                showStatus();
            }
        });

    }

    private void startPropertyAnim(View view) {
        ObjectAnimator anim = ObjectAnimator.ofFloat(view, "rotation", 0f, 45f);
        anim.setDuration(10);
        anim.start();
    }


    private void showStatus() {
        handler = new MyHandler();
        windowManager = getActivity().getWindowManager();
        showAnim();
        WindowManager.LayoutParams params = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.TYPE_SYSTEM_ERROR,
                WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN
                        | WindowManager.LayoutParams.FLAG_FULLSCREEN,
                PixelFormat.TRANSLUCENT);

        params.gravity = Gravity.TOP | Gravity.LEFT;
        params.y = 0;
        params.x = 0;

        windowManager.addView(statusView, params);
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                handler.sendEmptyMessage(0x123);
            }
        }, 2000);
    }

    /**
     * 方法描述：添加动画
     */
    private void showAnim() {
        ObjectAnimator a = ObjectAnimator.ofFloat(statusView, "translationY", -700, 0);
        a.setDuration(600);
        a.start();
    }

    public class MyHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0x123) {
                windowManager.removeView(statusView);
            }
        }
    }

}
