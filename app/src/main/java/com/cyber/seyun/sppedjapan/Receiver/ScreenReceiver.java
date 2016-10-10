package com.cyber.seyun.sppedjapan.Receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by vcs-server on 10/10/16.
 */

public class ScreenReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO Auto-generated method stub
        Log.i("[BroadcastReceiver]", "MyReceiver");

        if (intent.getAction().equals(Intent.ACTION_SCREEN_ON)) {
            Log.i("[BroadcastReceiver]", "Screen ON");
        }
        else if (intent.getAction().equals(Intent.ACTION_SCREEN_OFF)) {
            Log.i("[BroadcastReceiver]", "Screen OFF");
        }
    }
}
