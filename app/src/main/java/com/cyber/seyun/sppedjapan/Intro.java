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
import com.cyber.seyun.sppedjapan.Reaml.SettingRealm;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;


public class Intro extends Activity {
    private final String TAG = Intro.class.getSimpleName();
    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        RealmConfiguration realmConfig = new RealmConfiguration.Builder(getApplication()).build();
        Realm.setDefaultConfiguration(realmConfig);
        realm = Realm.getDefaultInstance();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(firstLoadFlag()) {
                    FirstStartAppSetting();
                } else {
                    Intent intent = new Intent(Intro.this, MainActivity.class);
                    startActivity(intent);
                }
                finish();
            }
        }, 2000);
    }

    private void FirstStartAppSetting() {
        DBInit DBCreate = new DBInit(Intro.this);

        try {
            DBCreate.createDataBase();
        } catch (Exception e) {
            Log.i("Error", e.toString());
        } finally {
            DBCreate.close();
        }

        Intent intent = new Intent(Intro.this, FirstSettingActivity.class);
        startActivity(intent);
    }


    private boolean firstLoadFlag() {
        RealmResults query = realm.where(SettingRealm.class).findAll();
        return query.size() == 0 ?  true : false;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        realm.close();
    }
}
