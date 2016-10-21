package com.cyber.seyun.sppedjapan.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

import com.cyber.seyun.sppedjapan.Model.GameItem;
import com.cyber.seyun.sppedjapan.R;

public class ChineseActivity extends AppCompatActivity implements View.OnClickListener {
    private Toolbar toolbar;
    private RelativeLayout layout_1, layout_2, layout_3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chinese);
        init();
    }

    void init() {
        toolbarSetup();
        findLayout();
    }

    void findLayout() {
        layout_1 = (RelativeLayout) findViewById(R.id.chinese_1);
        layout_2 = (RelativeLayout) findViewById(R.id.chinese_2);
        layout_3 = (RelativeLayout) findViewById(R.id.chinese_3);
        layout_1.setOnClickListener(this);
        layout_2.setOnClickListener(this);
        layout_3.setOnClickListener(this);
    }

    private void toolbarSetup() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("한자");
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
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
    public void onClick(View v) {
        int id = v.getId();

        Intent i = null;

        switch (id) {
            case R.id.chinese_1:
                i = new Intent(ChineseActivity.this, GameStart.class);
                GameItem.Timer = false;
                GameItem.Flag = 7;
                break;
            case R.id.chinese_2:
                i = new Intent(ChineseActivity.this, GameStart.class);
                GameItem.Timer = false;
                GameItem.Flag = 8;
                break;
            case R.id.chinese_3:
                i = new Intent(ChineseActivity.this, GameStart.class);
                GameItem.Timer = false;
                GameItem.Flag = 9;
                break;
        }

        startActivity(i);
    }
}
