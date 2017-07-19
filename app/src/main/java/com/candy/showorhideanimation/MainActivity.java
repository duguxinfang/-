package com.candy.showorhideanimation;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.hardware.usb.UsbInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView1, imageView2, imageView3, imageView4, imageView5;
    private boolean isShow = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        UIUtils.initDip2px(this);
        isShow = true;
        initView();
    }

    private void initView() {
        imageView1 = (ImageView) findViewById(R.id.imageview1);
        imageView2 = (ImageView) findViewById(R.id.imageview2);
        imageView3 = (ImageView) findViewById(R.id.imageview3);
        imageView4 = (ImageView) findViewById(R.id.imageview4);
        imageView5 = (ImageView) findViewById(R.id.imageview5);

        imageView3.setOnClickListener(listener);
    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            isShow = !isShow;
            if (isShow)
                showBottomLeftToRight();
            else
                showBottomRightToLeft();
        }
    };

    private void showBottomRightToLeft() {
        int widht = UIUtils.getScreenWidth() - UIUtils.dip2px(this, 60);
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator animatorTranslateX1 = ObjectAnimator.ofFloat(imageView1
                , "translationX", 0.0f, widht * 0.4f);
        animatorTranslateX1.setDuration(300);
        animatorTranslateX1.setRepeatCount(0);

        ObjectAnimator animatorAlpha1 = ObjectAnimator.ofFloat(imageView1
                , "alpha", 1.0f, 0.2f);
        animatorAlpha1.setDuration(300);
        animatorAlpha1.setRepeatCount(0);

        ObjectAnimator animatorTranslateX2 = ObjectAnimator.ofFloat(imageView2
                , "translationX", 0.0f, widht * 0.2f);
        animatorTranslateX2.setDuration(300);
        animatorTranslateX2.setRepeatCount(0);

        ObjectAnimator animatorAlpha2 = ObjectAnimator.ofFloat(imageView2
                , "alpha", 1.0f, 0.2f);
        animatorAlpha2.setDuration(300);
        animatorAlpha2.setRepeatCount(0);

        animatorTranslateX2.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                if (isShow) {
                    imageView1.setVisibility(View.VISIBLE);
                    imageView2.setVisibility(View.VISIBLE);
                } else {
                    imageView1.setVisibility(View.INVISIBLE);
                    imageView2.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

        ObjectAnimator animatorTranslateX3 = ObjectAnimator.ofFloat(imageView3
                , "translationX", 0.0f, -widht * 0.4f);
        animatorTranslateX3.setDuration(500);
        animatorTranslateX3.setRepeatCount(0);


        ObjectAnimator animatorTranslateX4 = ObjectAnimator.ofFloat(imageView4
                , "translationX", 0.0f, -widht * 0.2667f);
        animatorTranslateX4.setDuration(500);
        animatorTranslateX4.setRepeatCount(0);

        ObjectAnimator animatorTranslateX5 = ObjectAnimator.ofFloat(imageView5
                , "translationX", 0.0f, -widht * 0.1333f);
        animatorTranslateX5.setDuration(500);
        animatorTranslateX5.setRepeatCount(0);

        animatorSet.play(animatorTranslateX1).with(animatorTranslateX2).with(animatorAlpha1)
                .with(animatorAlpha2)
                .before(animatorTranslateX3)
                .before(animatorTranslateX4).before(animatorTranslateX5);
        animatorSet.start();
    }

    private void showBottomLeftToRight() {
        int widht = UIUtils.getScreenWidth() - UIUtils.dip2px(this, 60);
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator animatorTranslateX1 = ObjectAnimator.ofFloat(imageView1
                , "translationX", widht * 0.4f, 0.0f);
        animatorTranslateX1.setDuration(300);
        animatorTranslateX1.setRepeatCount(0);
        ObjectAnimator animatorAlpha1 = ObjectAnimator.ofFloat(imageView1
                , "alpha", 0.2f, 1.0f);
        animatorAlpha1.setDuration(300);
        animatorAlpha1.setRepeatCount(0);

        ObjectAnimator animatorTranslateX2 = ObjectAnimator.ofFloat(imageView2
                , "translationX", widht * 0.2f, 0.0f);
        animatorTranslateX2.setDuration(300);
        animatorTranslateX2.setRepeatCount(0);
        ObjectAnimator animatorAlpha2 = ObjectAnimator.ofFloat(imageView2
                , "alpha", 0.2f, 1.0f);
        animatorAlpha1.setDuration(300);
        animatorAlpha1.setRepeatCount(0);


        ObjectAnimator animatorTranslateX3 = ObjectAnimator.ofFloat(imageView3
                , "translationX", -widht * 0.4f, 0.0f);
        animatorTranslateX3.setDuration(500);
        animatorTranslateX3.setRepeatCount(0);


        ObjectAnimator animatorTranslateX4 = ObjectAnimator.ofFloat(imageView4
                , "translationX", -widht * 0.2667f, 0.0f);
        animatorTranslateX4.setDuration(500);
        animatorTranslateX4.setRepeatCount(0);

        ObjectAnimator animatorTranslateX5 = ObjectAnimator.ofFloat(imageView5
                , "translationX", -widht * 0.1333f, 0.0f);
        animatorTranslateX5.setDuration(500);
        animatorTranslateX5.setRepeatCount(0);

        animatorTranslateX5.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                if (isShow) {
                    imageView1.setVisibility(View.VISIBLE);
                    imageView2.setVisibility(View.VISIBLE);
                } else {
                    imageView1.setVisibility(View.INVISIBLE);
                    imageView2.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

        animatorSet.play(animatorTranslateX3).with(animatorTranslateX4).with(animatorTranslateX5)
                .with(animatorAlpha1).with(animatorAlpha2)
                .before(animatorTranslateX1).before(animatorTranslateX2);
        animatorSet.start();
    }
}
