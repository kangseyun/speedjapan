package com.cyber.seyun.sppedjapan.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.cyber.seyun.sppedjapan.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView GameMenu, setting, Word, Dic;
    private Intent PageMove;
    private Toolbar toolbar;
    private String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    }

    private void init() {
        toolbarSetup();
        findLayout();
    }

    private void toolbarSetup() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("스피드 일본어!");
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    private void findLayout() {
        GameMenu = (TextView) findViewById(R.id.button1);
        Word = (TextView) findViewById(R.id.test123);
        setting = (TextView) findViewById(R.id.setting);
        Dic = (TextView) findViewById(R.id.dic);
        setting.setOnClickListener(this);
        GameMenu.setOnClickListener(this);
        Word.setOnClickListener(this);
        Dic.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.button1:
                PageMove = new Intent(MainActivity.this, GameMenu.class);
                break;
            case R.id.test123:
                PageMove = new Intent(MainActivity.this, WordActivity.class);
                break;
            case R.id.setting:
                PageMove = new Intent(MainActivity.this, SettingActivity.class);
                break;
            case R.id.dic:
                PageMove = new Intent(MainActivity.this, DicActivity.class);
                break;
        }
        startActivity(PageMove);
    }
}
