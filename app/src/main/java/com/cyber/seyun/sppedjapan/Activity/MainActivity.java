package com.cyber.seyun.sppedjapan.Activity;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.cyber.seyun.sppedjapan.R;
import com.cyber.seyun.sppedjapan.Receiver.ScreenService;
import com.google.firebase.analytics.FirebaseAnalytics;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView GameMenu, setting, Word, Dic, Puzz, Chinese;
    private Intent PageMove;
    private Toolbar toolbar;
    private String TAG = MainActivity.class.getSimpleName();
    private FirebaseAnalytics mFirebaseAnalytics;

    private String id = "dcp.k953@gmail.com";
    private String name = "seyun";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    }

    private void init() {
        toolbarSetup();
        findLayout();

        // Google Analytics
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        Bundle params = new Bundle();
        params.putString("image_name", name);
        params.putString("full_text", "123");
        mFirebaseAnalytics.logEvent("share_image", params);

    }

    private void toolbarSetup() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("스피드 일본어!");
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(toolbar);
    }

    private void findLayout() {
        GameMenu = (TextView) findViewById(R.id.main_basic_word);
        Word = (TextView) findViewById(R.id.main_word);
        setting = (TextView) findViewById(R.id.setting);
        Dic = (TextView) findViewById(R.id.main_dic);
        Puzz = (TextView) findViewById(R.id.main_puzzle);
        Chinese = (TextView) findViewById(R.id.main_chinese);
        Chinese.setOnClickListener(this);
        Puzz.setOnClickListener(this);
        setting.setOnClickListener(this);
        GameMenu.setOnClickListener(this);
        Word.setOnClickListener(this);
        Dic.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id) {
            case R.id.main_basic_word:
                PageMove = new Intent(MainActivity.this, GameMenu.class);
                break;
            case R.id.main_word:
                PageMove = new Intent(MainActivity.this, WordActivity.class);
                break;
            case R.id.main_puzzle:
                PageMove = new Intent(MainActivity.this, PuzzleMenuActivity.class);
                break;
            case R.id.main_chinese:
                PageMove = new Intent(MainActivity.this, ChineseActivity.class);
                break;
            case R.id.setting:
                PageMove = new Intent(MainActivity.this, SettingActivity.class);
                break;
            case R.id.main_dic:
                PageMove = new Intent(MainActivity.this, DicActivity.class);
                break;
        }

        startActivity(PageMove);
    }
}
