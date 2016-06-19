package com.cyber.seyun.sppedjapan;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;
import android.util.Log;

import com.cyber.seyun.sppedjapan.Activity.FirstSettingActivity;
import com.cyber.seyun.sppedjapan.Activity.MainActivity;
import com.cyber.seyun.sppedjapan.Database.DBController;
import com.cyber.seyun.sppedjapan.Database.DBInit;


public class Intro extends Activity {
    private final String TAG = Intro.class.getSimpleName();
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DBInit DBCreate = new DBInit(this);
        try {
            DBCreate.createDataBase();
        }catch (Exception e){}


        intent = new Intent(Intro.this, FirstSettingActivity.class);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(intent);
                finish();
            }
        }, 2000);
    }
}
