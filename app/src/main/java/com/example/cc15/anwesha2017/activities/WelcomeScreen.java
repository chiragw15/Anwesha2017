package com.example.cc15.anwesha2017.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cc15.anwesha2017.R;


public class WelcomeScreen extends AppCompatActivity {

    ImageView logo;
    TextView tdl,anwesha;
    public int count=0;
    int tempInt = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        count = readSharedPreferenceInt("cntSP","cntKey");
        if(count==0){
            Intent intent = new Intent();
            intent.setClass(WelcomeScreen.this, RegistrationActivity.class);
            startActivity(intent);
            count++;
            writeSharedPreference(count, "cntSP", "cntKey");
        }

        else {
        setContentView(R.layout.activity_welcome_screen);

        AnimationSet s1 = new AnimationSet(false);

        logo = (ImageView) findViewById(R.id.anwesha_logo);
        tdl= (TextView) findViewById(R.id.tdl);
        anwesha = (TextView) findViewById(R.id.anwesha_text);


        final Animation r1,r2,r3,r4,r5,r6;

        r1 = AnimationUtils.loadAnimation(this, R.anim.rotator1);
        r2 = AnimationUtils.loadAnimation(this, R.anim.rotator2);
        r3 = AnimationUtils.loadAnimation(this, R.anim.rotator3);
        r4 = AnimationUtils.loadAnimation(this, R.anim.fadein);
        r5 = AnimationUtils.loadAnimation(this, R.anim.fadein);
        r6 = AnimationUtils.loadAnimation(this, R.anim.fadein);

        r4.setStartOffset(700);

        s1.addAnimation(r1);
        s1.addAnimation(r2);
        s1.addAnimation(r3);

        logo.startAnimation(s1);
            tdl.setText("Think");
            tdl.startAnimation(r4);

            r4.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationEnd(Animation fade1) {

                    tdl.setText("Dream");
                    tdl.startAnimation(r5);
                }

                @Override
                public void onAnimationRepeat(Animation animation) {
                }

                @Override
                public void onAnimationStart(Animation animation) {
                }
            });


            r5.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationEnd(Animation fade1) {
                    tdl.setText("Live");
                    tdl.startAnimation(r6);
                }

                @Override
                public void onAnimationRepeat(Animation animation) {
                }

                @Override
                public void onAnimationStart(Animation animation) {
                }
            });


            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                public void run() {
                    Intent i3 = new Intent(WelcomeScreen.this, Home.class);
                    startActivity(i3);
                    finish();
                }
            }, 5800);
        }
    }

    //Read from Shared Preferance
    public int readSharedPreferenceInt(String spName,String key){
        SharedPreferences sharedPreferences = getSharedPreferences(spName, Context.MODE_PRIVATE);
        return tempInt = sharedPreferences.getInt(key, 0);
    }

    //write shared preferences in integer
    public void writeSharedPreference(int ammount,String spName,String key ){

        SharedPreferences sharedPreferences = getSharedPreferences(spName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putInt(key, ammount);
        editor.commit();
    }

    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }
}
