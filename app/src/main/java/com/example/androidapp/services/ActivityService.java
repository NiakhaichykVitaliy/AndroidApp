package com.example.androidapp.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import com.example.androidapp.data.TimerRunningActivity;

import java.util.Timer;
import java.util.TimerTask;

import static android.support.constraint.Constraints.TAG;

public class ActivityService extends Service {
    Timer timerRunningActivity = new Timer();
    TimerTask myTimerTask = new TimerRunningActivity();
    private static final int delay = 0;
    private static final int period = 3000;

    public ActivityService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        timerRunningActivity.schedule(myTimerTask, delay, period);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        if (timerRunningActivity != null) {
            timerRunningActivity.cancel();
        }
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}