package me.mehdi.myflinganimation;

import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;

import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.FlingAnimation;

public class CustomGestureListener extends GestureDetector.SimpleOnGestureListener {

    View mTargetView;
    float mMin;
    float mMax;
    public CustomGestureListener(View targetView, float min, float max){
        mTargetView = targetView;
        mMin = min;
        mMax = max;
        Log.d("CustomGestureListener", "CustomGestureListener: " + String.format("min: %s, max: %s", min, max));
    }

    @Override
    public boolean onDown(MotionEvent e) {
        Log.d("CustomGestureListener", "onDown: ");
        return true;
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        FlingAnimation fling = new FlingAnimation(mTargetView, DynamicAnimation.Y);
        Log.d("CustomGestureListener", String.format("velocityX: %s, velocityY: %s", velocityX, velocityY));
        fling.setMinValue(mMin);
        fling.setMaxValue(mMax);
        fling.setStartVelocity(velocityY);
        fling.start();

//        VelocityTracker tracker = VelocityTracker.obtain();
//        tracker.addMovement(e1);
//        tracker.addMovement(e2);
//        tracker.computeCurrentVelocity();

        return true;
    }
}
