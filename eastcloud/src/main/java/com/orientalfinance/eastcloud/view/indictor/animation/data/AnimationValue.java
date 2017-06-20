package com.orientalfinance.eastcloud.view.indictor.animation.data;

import android.support.annotation.NonNull;

import com.orientalfinance.eastcloud.view.indictor.animation.data.type.ColorAnimationValue;
import com.orientalfinance.eastcloud.view.indictor.animation.data.type.DropAnimationValue;
import com.orientalfinance.eastcloud.view.indictor.animation.data.type.FillAnimationValue;
import com.orientalfinance.eastcloud.view.indictor.animation.data.type.ScaleAnimationValue;
import com.orientalfinance.eastcloud.view.indictor.animation.data.type.SwapAnimationValue;
import com.orientalfinance.eastcloud.view.indictor.animation.data.type.ThinWormAnimationValue;
import com.orientalfinance.eastcloud.view.indictor.animation.data.type.WormAnimationValue;

public class AnimationValue {

    private ColorAnimationValue colorAnimationValue;
    private ScaleAnimationValue scaleAnimationValue;
    private WormAnimationValue wormAnimationValue;
    private FillAnimationValue fillAnimationValue;
    private ThinWormAnimationValue thinWormAnimationValue;
    private DropAnimationValue dropAnimationValue;
    private SwapAnimationValue swapAnimationValue;

    @NonNull
    public ColorAnimationValue getColorAnimationValue() {
        if (colorAnimationValue == null) {
            colorAnimationValue = new ColorAnimationValue();
        }
        return colorAnimationValue;
    }

    @NonNull
    public ScaleAnimationValue getScaleAnimationValue() {
        if (scaleAnimationValue == null) {
            scaleAnimationValue = new ScaleAnimationValue();
        }
        return scaleAnimationValue;
    }

    @NonNull
    public WormAnimationValue getWormAnimationValue() {
        if (wormAnimationValue == null) {
            wormAnimationValue = new WormAnimationValue();
        }
        return wormAnimationValue;
    }

    @NonNull
    public FillAnimationValue getFillAnimationValue() {
        if (fillAnimationValue == null) {
            fillAnimationValue = new FillAnimationValue();
        }
        return fillAnimationValue;
    }

    @NonNull
    public ThinWormAnimationValue getThinWormAnimationValue() {
        if (thinWormAnimationValue == null) {
            thinWormAnimationValue = new ThinWormAnimationValue();
        }
        return thinWormAnimationValue;
    }

    @NonNull
    public DropAnimationValue getDropAnimationValue() {
        if (dropAnimationValue == null) {
            dropAnimationValue = new DropAnimationValue();
        }
        return dropAnimationValue;
    }

    @NonNull
    public SwapAnimationValue getSwapAnimationValue() {
        if (swapAnimationValue == null) {
            swapAnimationValue = new SwapAnimationValue();
        }
        return swapAnimationValue;
    }
}
