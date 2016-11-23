package com.example.a5alumno.services;

import android.app.IntentService;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

public class MyIntentService extends IntentService {
    private static final String TAG = "IntentService";
    public MyIntentService() {
        super(MyIntentService.class.toString());
    }

    @Override
    public void onCreate() {
        Log.e(TAG,"onCreate");
        super.onCreate();
    }

    @Override
    public void onStart(Intent intent, int startId) {
        Log.e(TAG,"onStart");
        super.onStart(intent, startId);
    }

    @Override
    public void onDestroy() {
        Log.e(TAG,"onDestroy");
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.e(TAG,"onBind");
        return super.onBind(intent);
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
    protected void onHandleIntent(Intent intent) {
        Log.e(TAG,"onHandleIntent Executat\n" +"    Time: " + System.currentTimeMillis());
        long currentTime = System.currentTimeMillis();
        long endTime = currentTime + (3*1000);
        while (currentTime<endTime){
            currentTime = System.currentTimeMillis();
        }
    }
}
