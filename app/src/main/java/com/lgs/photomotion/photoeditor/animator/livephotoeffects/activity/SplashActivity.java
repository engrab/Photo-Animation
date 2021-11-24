package com.lgs.photomotion.photoeditor.animator.livephotoeffects.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import com.example.photomotion.R;
import com.lgs.photomotion.photoeditor.animator.livephotoeffects.tutorial.TutorialActivity;

public class SplashActivity extends BaseParentActivity {

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        setContentView(R.layout.activity_splash_screen);


        startMain();
    }


    public void startMain() {
        new Handler(Looper.myLooper()).postDelayed(() -> {

            SharedPreferences editor = getSharedPreferences("FirstTimePref", MODE_PRIVATE);
            boolean firstTimeKey = editor.getBoolean("FirstTimeKey", false);
            if (!firstTimeKey) {
                startActivity(new Intent(SplashActivity.this, TutorialActivity.class));
                finish();
            } else {

                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();
            }
        }, 1500);
    }

}
