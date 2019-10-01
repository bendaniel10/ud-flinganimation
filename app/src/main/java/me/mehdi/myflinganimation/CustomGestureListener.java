package me.mehdi.myflinganimation;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.FlingAnimation;

public class CustomGestureListener extends GestureDetector.SimpleOnGestureListener {

    View mAnimatedView;
    float mMin;
    float mMax;

    public CustomGestureListener(View view, float min, float max) {
        mAnimatedView = view;
        mMin = min;
        mMax = max;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return true;
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        FlingAnimation fling = new FlingAnimation(mAnimatedView, DynamicAnimation.Y);
        if(Math.abs(velocityX) > Math.abs(velocityY)){
            fling = new FlingAnimation(mAnimatedView, DynamicAnimation.X);
            fling.setStartVelocity(velocityX);
            fling.setMaxValue(mMax / 2);
        }
        else {
            fling = new FlingAnimation(mAnimatedView, DynamicAnimation.Y);
            fling.setStartVelocity(velocityY);
            fling.setMaxValue(mMax);
        }
        fling.setMinValue(mMin);

        fling.start();
        return super.onFling(e1, e2, velocityX, velocityY);

    }
}
