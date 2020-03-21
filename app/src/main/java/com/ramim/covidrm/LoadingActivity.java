package com.ramim.covidrm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import com.agrawalsuneet.dotsloader.loaders.LazyLoader;

public class LoadingActivity extends AppCompatActivity {

    private static  int timeout =6000;
    LazyLoader lazyLoader;

    TextView textView1,textView2;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);






        textView1 = findViewById(R.id.textViewID);
        textView2 = findViewById(R.id.textViewID2);
        imageView = findViewById(R.id.imageViewID);

        lazyLoader = findViewById(R.id.lazyloderID);

        LazyLoader loader = new LazyLoader(this, 30, 20,
                ContextCompat.getColor(this, R.color.red),
                ContextCompat.getColor(this, R.color.green1),
                ContextCompat.getColor(this, R.color.yellow2));
        loader.setAnimDuration(500);
        loader.setFirstDelayDuration(100);
        loader.setSecondDelayDuration(200);
        loader.setInterpolator(new LinearInterpolator());

        Animation animation = AnimationUtils.loadAnimation(LoadingActivity.this,R.anim.myanimation);
        imageView.startAnimation(animation);
        textView1.startAnimation(animation);
        textView2.startAnimation(animation);


        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(LoadingActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        },timeout);
    }
}