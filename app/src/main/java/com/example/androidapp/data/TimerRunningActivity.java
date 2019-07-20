package com.example.androidapp.data;

import android.util.Log;

import java.util.TimerTask;

import static android.support.constraint.Constraints.TAG;

public class TimerRunningActivity extends TimerTask {
    private int timeRunning = 0;

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long stopTime = System.currentTimeMillis();
        timeRunning = timeRunning + (int) (stopTime - startTime) / 1000;
        Log.i(TAG, timeRunning + " sec");
    }
}