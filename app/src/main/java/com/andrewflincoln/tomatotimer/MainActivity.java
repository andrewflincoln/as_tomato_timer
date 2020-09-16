package com.andrewflincoln.tomatotimer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = MediaPlayer.create(this, R.raw.service_bell);

        CountDownTimer tomatoTimer = new CountDownTimer(10000, 1000) {
            @Override
            public void onTick(long millLeft) {
                Log.i("Seconds left: ", String.valueOf(millLeft/1000));
            }

            @Override
            public void onFinish() {
                Log.i("Timer finished", "Time for a break!");
                mediaPlayer.start();
            }
        }.start();

    }

}