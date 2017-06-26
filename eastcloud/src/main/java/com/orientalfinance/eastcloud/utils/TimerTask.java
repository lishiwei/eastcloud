package com.orientalfinance.eastcloud.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

import java.util.Timer;

/**
 * Created by lzy on 2017/6/26.
 * email:lizy@oriental-finance.com
 */

public class TimerTask {
    private boolean isRunning;
    private Timer timer;
    private java.util.TimerTask timerTask;
    private Handler handler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1) {
                isRunning = false;
                Log.e("TAG", "定时任务状态：" + isRunning);
                if (timerFinished != null) {
                    timerFinished.onFinished();
                }
            }
        }
    };

    public TimerTask() {
        isRunning = false;
    }

    public void startTimerTask() {
        if (timer == null) {
            timer = new Timer();
        }
        if (timerTask == null) {
            timerTask = new java.util.TimerTask() {
                @Override
                public void run() {
                    Message message = new Message();
                    message.what = 1;
                    handler.sendMessage(message);
                }
            };
        }
        if (timer != null && timerTask != null) {
            isRunning = true;
            timer.schedule(timerTask, 1000);
        }
    }

    public void stopTimer() {
        isRunning = false;
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
        if (timerTask != null) {
            timerTask.cancel();
            timerTask = null;
        }
    }

    public boolean isRunning() {
        return isRunning;
    }

    private TimerFinished timerFinished;

    public void setTimerFinished(TimerFinished timerFinished) {
        this.timerFinished = timerFinished;
    }

    public interface TimerFinished {
        void onFinished();
    }
}
