package com.cyber.seyun.sppedjapan.Receiver;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.util.Log;

/**
 * Created by vcs-server on 10/10/16.
 */

public class ScreenService extends Service {
    private BroadcastReceiver myReceiver;

    public ScreenService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate(){
        Log.i("Create","Create");

        myReceiver = new ScreenReceiver();

        IntentFilter intentFilter = new IntentFilter(Intent.ACTION_SCREEN_ON);
        intentFilter.addAction(Intent.ACTION_SCREEN_OFF);

        registerReceiver(myReceiver, intentFilter);
        Log.d("onCreate()","브로드캐스트리시버 등록됨");
    }

//    @Override
//    public int onStartCommand(Intent intent, int flags, int startId) {
//        if( intent == null)
//        {
//            myReceiver = new ScreenReceiver();
//
//            IntentFilter intentFilter = new IntentFilter(Intent.ACTION_SCREEN_ON);
//            intentFilter.addAction(Intent.ACTION_SCREEN_OFF);
//
//            registerReceiver(myReceiver, intentFilter);
//            Log.d("onCreate()","브로드캐스트리시버 등록됨");
//        }
//        return START_STICKY;
//    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(myReceiver);
    }
}
