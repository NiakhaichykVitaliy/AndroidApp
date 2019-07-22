package com.example.androidapp.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.example.androidapp.data.TimerRunningTask;

import java.util.Timer;
import java.util.TimerTask;

public class TimerService extends Service {
    Timer timer = new Timer();
    TimerTask timerTask = new TimerRunningTask();
    private static final int DELAY = 0;
    private static final int PERIOD = 3000;

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
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}