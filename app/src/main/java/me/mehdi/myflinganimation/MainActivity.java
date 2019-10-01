package me.mehdi.myflinganimation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.FlingAnimation;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {

    LinearLayout mPlayground;
    ImageView mImage1, mImage2, mImage3;

    static int mVelocity = 500;

    GestureDetectorCompat mGestureDetector1, mGestureDetector2, mGestureDetector3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPlayground = findViewById(R.id.playground);
        mImage1 = findViewById(R.id.image1);
        mImage2 = findViewById(R.id.image2);
        mImage3 = findViewById(R.id.image3);

        mImage1.setOnTouchListener(this);
        mImage2.setOnTouchListener(this);
        mImage3.setOnTouchListener(this);

        mPlayground.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                if(mPlayground.getHeight() > 0){
                    float max = mPlayground.getHeight() - mImage1.getHeight();
                    mGestureDetector1 = new GestureDetectorCompat(MainActivity.this, new CustomGestureListener(mImage1, 0, max));
                    mGestureDetector2 = new GestureDetectorCompat(MainActivity.this, new CustomGestureListener(mImage2, 0, max));
                    mGestureDetector3 = new GestureDetectorCompat(MainActivity.this, new CustomGestureListener(mImage3, 0, max));
                    mPlayground.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
            }
        });



    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        switch(v.getId()){
            case R.id.image1:
                return mGestureDetector1.onTouchEvent(event);
            case R.id.image2:
                return mGestureDetector2.onTouchEvent(event);
            case R.id.image3:
                return mGestureDetector3.onTouchEvent(event);
        }
        return super.onTouchEvent(event);
    }
}
