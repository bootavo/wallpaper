package com.wallpaper.wallpapers;

import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Display;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SplashActivity extends AppCompatActivity {

    @BindView(R.id.iv_icon) ImageView mLogo;
    private String TAG = SplashActivity.class.getSimpleName();
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        init();
    }

    public void init(){

        ButterKnife.bind(this);
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x/4;
        int height = size.y;

        Animation anim = new TranslateAnimation(0, 0, height/2, 0);
        anim.setStartOffset(100);
        anim.setInterpolator(new DecelerateInterpolator());
        anim.setFillEnabled(true);
        anim.setFillAfter(true);
        anim.setDuration(1000);

        mLogo.setAnimation(anim);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                nextActivity();
            }
        }, 1800);
    }

    public void nextActivity(){
        Log.d(TAG, " ----------------> nextActivity");
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }

}
