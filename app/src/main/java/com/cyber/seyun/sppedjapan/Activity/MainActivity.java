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
    private TextView GameMenu, setting, Word, Dic, Puzz, Chinese;
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
    }

    private void findLayout() {
        GameMenu = (TextView) findViewById(R.id.button1);
        Word = (TextView) findViewById(R.id.main_word);
        setting = (TextView) findViewById(R.id.setting);
        Dic = (TextView) findViewById(R.id.dic);
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
            case R.id.button1:
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
            case R.id.dic:
                PageMove = new Intent(MainActivity.this, DicActivity.class);
                break;
        }
        startActivity(PageMove);
    }
}
