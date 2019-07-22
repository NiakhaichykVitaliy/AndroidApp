package com.example.androidapp.data;

import android.util.Log;

import java.util.TimerTask;

import static android.support.constraint.Constraints.TAG;

public class TimerRunningTask extends TimerTask {
    private long startTime = System.currentTimeMillis();

    @Override
    public void run() {
        long currentTime = System.currentTimeMillis();
        long timeRunning = (currentTime - startTime) / 1000;
        Log.i(TAG, timeRunning + " sec");
    }
}