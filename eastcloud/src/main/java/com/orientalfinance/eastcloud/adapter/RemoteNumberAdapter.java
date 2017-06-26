package com.orientalfinance.eastcloud.adapter;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.orientalfinance.R;
import com.orientalfinance.eastcloud.utils.TimerTask;

import java.util.List;
import java.util.Timer;

/**
 * Created by lzy on 2017/6/26.
 * email:lizy@oriental-finance.com
 */

public class RemoteNumberAdapter extends RecyclerView.Adapter<RemoteNumberAdapter.NumberViewHolder> implements TimerTask.TimerFinished {
    private Context mContext;
    private Integer[] mResIds;
    private StringBuffer stringBuffer = new StringBuffer();
    private final TimerTask timerTask;


    public RemoteNumberAdapter(Context context, Integer[] integers) {
        this.mContext = context;
        this.mResIds = integers;
        timerTask = new TimerTask();
        timerTask.setTimerFinished(this);
    }

    @Override
    public NumberViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.item_grid_number, null);
        return new NumberViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(NumberViewHolder holder, final int position) {
        holder.imageView.setImageResource(mResIds[position]);
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (position) {
                    case 0:
                        callbackData("1");
                        break;
                    case 1:
                        callbackData("2");
                        break;
                    case 2:
                        callbackData("3");
                        break;
                    case 3:
                        callbackData("4");
                        break;
                    case 4:
                        callbackData("5");
                        break;
                    case 5:
                        callbackData("6");
                        break;
                    case 6:
                        callbackData("7");
                        break;
                    case 7:
                        callbackData("8");
                        break;
                    case 8:
                        callbackData("9");
                        break;
                    case 9:
                        break;
                    case 10:
                        callbackData("0");
                        break;
                    case 11:
                        if (timerTask.isRunning()) {
                            timerTask.stopTimer();
                            if (stringBuffer.length() != 0) {
                                stringBuffer.delete(stringBuffer.length() - 1, stringBuffer.length());
                                timerTask.startTimerTask();
                            }
                        }

                        break;
                }
            }
        });
    }

    private void callbackData(String string) {
        if (timerTask.isRunning()) {
            timerTask.stopTimer();
            stringBuffer.append(string);
            timerTask.startTimerTask();
        } else {
            stringBuffer.append(string);
            timerTask.startTimerTask();
        }
    }

    @Override
    public int getItemCount() {
        return mResIds.length;
    }


    public static class NumberViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public NumberViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.iv_number);
        }
    }

    private ChannelValueCallback channelValueCallback;

    public void setChannelValueCallback(ChannelValueCallback channelValueCallback) {
        this.channelValueCallback = channelValueCallback;
    }

    @Override
    public void onFinished() {
        timerTask.stopTimer();
        if (channelValueCallback != null) {
            channelValueCallback.onChannelValue(stringBuffer.toString());
            stringBuffer.delete(0,stringBuffer.length());
        }
    }

    public interface ChannelValueCallback {
        void onChannelValue(String value);
    }

//    public class TimerTask {
//        private boolean isRunning;
//        private Timer timer;
//        private java.util.TimerTask timerTask;
//        private Handler handler = new Handler(Looper.getMainLooper()) {
//            @Override
//            public void handleMessage(Message msg) {
//                super.handleMessage(msg);
//                if (msg.what == 1) {
//                    isRunning = false;
//                }
//            }
//        };
//
//        public TimerTask() {
//            isRunning = false;
//        }
//
//        public void startTimerTask() {
//            if (timer == null) {
//                timer = new Timer();
//            }
//            if (timerTask == null) {
//                timerTask = new java.util.TimerTask() {
//                    @Override
//                    public void run() {
//                        Message message = new Message();
//                        message.what = 1;
//                        handler.sendMessage(message);
//                    }
//                };
//            }
//            if (timer != null && timerTask != null) {
//                isRunning = true;
//                timer.schedule(timerTask, 1000);
//            }
//        }
//
//        public void stopTimer() {
//            isRunning = false;
//            if (timer != null) {
//                timer.cancel();
//                timer = null;
//            }
//            if (timerTask != null) {
//                timerTask.cancel();
//                timerTask = null;
//            }
//        }
//
//        public boolean isRunning() {
//            return isRunning;
//        }
//    }
}
