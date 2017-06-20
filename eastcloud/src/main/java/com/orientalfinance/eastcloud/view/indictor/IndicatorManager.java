package com.orientalfinance.eastcloud.view.indictor;

import android.support.annotation.Nullable;

import com.orientalfinance.eastcloud.view.indictor.animation.AnimationManager;
import com.orientalfinance.eastcloud.view.indictor.animation.controller.ValueController;
import com.orientalfinance.eastcloud.view.indictor.animation.data.Value;
import com.orientalfinance.eastcloud.view.indictor.draw.DrawManager;
import com.orientalfinance.eastcloud.view.indictor.draw.data.Indicator;


public class IndicatorManager implements ValueController.UpdateListener {

    private DrawManager drawManager;
    private AnimationManager animationManager;
    private Listener listener;

    interface Listener {
        void onIndicatorUpdated();
    }

    IndicatorManager(@Nullable Listener listener) {
        this.listener = listener;
        this.drawManager = new DrawManager();
        this.animationManager = new AnimationManager(drawManager.indicator(), this);
    }

    public AnimationManager animate() {
        return animationManager;
    }

    public Indicator indicator() {
        return drawManager.indicator();
    }

    public DrawManager drawer() {
        return drawManager;
    }

    @Override
    public void onValueUpdated(@Nullable Value value) {
        drawManager.updateValue(value);
        if (listener != null) {
            listener.onIndicatorUpdated();
        }
    }
}
