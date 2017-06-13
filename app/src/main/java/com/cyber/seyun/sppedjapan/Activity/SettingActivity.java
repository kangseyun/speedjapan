package com.cyber.seyun.sppedjapan.Activity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.cyber.seyun.sppedjapan.Model.ListViewSetting;
import com.cyber.seyun.sppedjapan.R;
import com.cyber.seyun.sppedjapan.Reaml.SettingRealm;
import com.cyber.seyun.sppedjapan.Receiver.ScreenService;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmQuery;
import io.realm.RealmResults;

public class SettingActivity extends AppCompatActivity implements View.OnClickListener{
    private CheckBox word_checkbox;
    private Toolbar toolbar;
    private CoordinatorLayout layout;
    private Realm realm;
    private LinearLayout setLevel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        init();
    }

    private void init()
    {

        /* realm */
        RealmConfiguration realmConfig = new RealmConfiguration.Builder(getApplication()).build();
        Realm.setDefaultConfiguration(realmConfig);
        realm = Realm.getDefaultInstance();

        /* addview */
        MobileAds.initialize(getApplicationContext(), "ca-app-pub-3940256099942544~3347511713");
        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        toolbarSetup();
        find();
    }

    private void toolbarSetup() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        toolbar.setTitle("설정");
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    private void find(){
        word_checkbox = (CheckBox) findViewById(R.id.setting_screenword_checkbox);
        layout = (CoordinatorLayout) findViewById(R.id.layout_setting);

        word_checkbox.setChecked(ScreenWordCheck());
        word_checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    switch (buttonView.getId()) {
                        case R.id.setting_screenword_checkbox:
                            ScreenWordSetting(isChecked);
                            break;
                    }
            }
        });

        setLevel = (LinearLayout) findViewById(R.id.setting_level);
        setLevel.setOnClickListener(this);
    }

    private void ScreenWordSetting(boolean checked) {
        Intent i = new Intent(SettingActivity.this, ScreenService.class);
        Snackbar snack;

        if (checked) {
            startService(i);
            snack = Snackbar.make(layout, "켜자마자 단어가 실행됩니다.", Snackbar.LENGTH_SHORT);
            setFlagScreenWorld(true);
        } else {
            stopService(i);
            snack = Snackbar.make(layout, "켜자마자 단어가 실행되지않습니다.", Snackbar.LENGTH_SHORT);
            setFlagScreenWorld(false);
        }

        snack.show();
    }

    private void setDialogLevel() {
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(
                SettingActivity.this);
        alertBuilder.setIcon(R.drawable.ic_launcher);
        alertBuilder.setTitle("항목중에 하나를 선택하세요.");

        // List Adapter 생성
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                SettingActivity.this,
                android.R.layout.select_dialog_singlechoice);
        adapter.add("5");
        adapter.add("10");
        adapter.add("15");

        // 버튼 생성
        alertBuilder.setNegativeButton("취소",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,
                                        int which) {
                        dialog.dismiss();
                    }
                });

        // Adapter 셋팅
        alertBuilder.setAdapter(adapter,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,
                                        int id) {

                        // AlertDialog 안에 있는 AlertDialog
                        String strName = adapter.getItem(id);
                        AlertDialog.Builder innBuilder = new AlertDialog.Builder(
                                SettingActivity.this);
                        innBuilder.setMessage(strName);
                        innBuilder.setTitle("당신이 선택한 것은 ");
                        innBuilder
                                .setPositiveButton(
                                        "확인",
                                        new DialogInterface.OnClickListener() {
                                            public void onClick(
                                                    DialogInterface dialog,
                                                    int which) {
                                                dialog.dismiss();
                                            }
                                        });
                        innBuilder.show();
                    }
                });
        alertBuilder.show();
    }

    private void setFlagScreenWorld(boolean flag) {
        realm.beginTransaction();
        SettingRealm result = realm.where(SettingRealm.class).findFirst();
        result.setScreenWord(flag);
        realm.commitTransaction();
    }

    private boolean ScreenWordCheck() {
        SettingRealm query = realm.where(SettingRealm.class).findFirst();
        return query.isScreenWord();
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id) {
            case R.id.setting_level:
                setDialogLevel();
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        realm.close();
    }
}
