package com.example.a5alumno.services;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class BoundService extends Service {
    private String TAG = "Bound Service";
    private IBinder aBinder = new Binder();
    public BoundService() {
    }

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
    public void onRebind(Intent intent) {
        Log.e(TAG,"onRebind");
        super.onRebind(intent);
    }

    public BoundService(IBinder service) {
        Log.e(TAG,"BoundService Constructor call");
        this.aBinder = service;
    }

    public class MyBinder extends Binder{
        BoundService getService(){return BoundService.this;}
    }
    private IBinder myBinder = new MyBinder();
    @Override
    public IBinder onBind(Intent intent) {
      Log.e(TAG,"onBind Executat");
        return myBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.e(TAG,"onUnbind Executat");
        return false;
    }
}
