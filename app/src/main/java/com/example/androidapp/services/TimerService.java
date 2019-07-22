package com.example.androidapp.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.example.androidapp.data.TimerRunningTask;

import java.util.Timer;
import java.util.TimerTask;

public class TimerService extends Service {
    private static final int DELAY = 0;
    private static final int PERIOD = 3000;
    private Timer timer = new Timer();
    private TimerTask timerTask = new TimerRunningTask();


    @Override
    public void onCreate() {
        super.onCreate();
        timer.schedule(timerTask, DELAY, PERIOD);
    }

    @Override
    public void onDestroy() {
        timer.cancel();
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}