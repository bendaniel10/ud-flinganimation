package me.mehdi.myflinganimation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.FlingAnimation;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout mPlayground;
    ImageView mImage1, mImage2, mImage3;

    static int mVelocity = 500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPlayground = findViewById(R.id.playground);
        mImage1 = findViewById(R.id.image1);
        mImage2 = findViewById(R.id.image2);
        mImage3 = findViewById(R.id.image3);

    }

    public void initFling(View view) {
        ImageView [] images = {mImage1, mImage2, mImage3};
        int index = (int) (Math.random() * 3);
        ImageView animatingImage = images[index];

        FlingAnimation fling = new FlingAnimation(animatingImage, DynamicAnimation.Y);
        fling.setMinValue(0);
        fling.setMaxValue(mPlayground.getHeight() - animatingImage.getHeight());

        if(animatingImage.getY() == (mPlayground.getHeight() - animatingImage.getHeight()) ||
          animatingImage.getY() == 0){
            mVelocity *= -1;
        }

        fling.setStartVelocity(mVelocity);

        fling.start();

    }
}
