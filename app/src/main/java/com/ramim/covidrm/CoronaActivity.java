package com.ramim.covidrm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class CoronaActivity extends AppCompatActivity {

    private static  int timeout =4000;

    public TextView textView1,textView2,textView3,textView4,textView5,textView6,textView7,textView8
            ,textView9,textView10,textView11,textView12;

    ImageView View1,View2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_corona);

        textView1=findViewById(R.id.id1);
        textView2=findViewById(R.id.id2);
        textView3=findViewById(R.id.id3);
        textView4=findViewById(R.id.id4);
        textView5=findViewById(R.id.id5);
        textView6=findViewById(R.id.id6);
        textView7=findViewById(R.id.id7);
        textView8=findViewById(R.id.id8);
        textView9=findViewById(R.id.id9);
        textView10=findViewById(R.id.id10);
        textView11=findViewById(R.id.id11);
        textView12=findViewById(R.id.id12);




        Animation animation = AnimationUtils.loadAnimation(CoronaActivity.this,R.anim.myanimation);

        textView1.startAnimation(animation);
        textView2.startAnimation(animation);
        textView3.startAnimation(animation);
        textView4.startAnimation(animation);
        textView5.startAnimation(animation);
        textView6.startAnimation(animation);
        textView7.startAnimation(animation);
        textView8.startAnimation(animation);
        textView9.startAnimation(animation);
        textView10.startAnimation(animation);
        textView11.startAnimation(animation);
        textView12.startAnimation(animation);



    }
}
