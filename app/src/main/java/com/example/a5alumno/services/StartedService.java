package com.example.a5alumno.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.util.Log;

public class StartedService extends Service {
    private String TAG = "StartedService";

    @Override
    public void onCreate() {
        Log.e(TAG,"onCreate");
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        Log.e(TAG,"onDestroy");
        super.onDestroy();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.e(TAG,"onUnbind");
        return super.onUnbind(intent);
    }

    @Override
    public void onRebind(Intent intent) {
        Log.e(TAG,"onRebind");
        super.onRebind(intent);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e(TAG,"onStartCommand Executat");
        long currentTime = System.currentTimeMillis();
        long endTime = currentTime + (3*1000);
        while (currentTime<endTime){
            currentTime = System.currentTimeMillis();
        }
        stopSelf();
        return Service.START_NOT_STICKY;

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.e(TAG + " Ibinder","onBind");
        return null;
    }
}
