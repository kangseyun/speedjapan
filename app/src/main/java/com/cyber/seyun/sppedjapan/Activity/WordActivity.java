package com.cyber.seyun.sppedjapan.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.cyber.seyun.sppedjapan.Model.GameItem;
import com.cyber.seyun.sppedjapan.R;

public class WordActivity extends AppCompatActivity implements View.OnClickListener {
    private Toolbar toolbar;
    private TextView btn1, btn2, btn3, btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word);
        init();
    }


    private void init() {
        toolbarSetup();
        findLayout();
    }

    private void toolbarSetup() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("단어");
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    private void findLayout() {
        btn1 = (TextView) findViewById(R.id.word_button1);
        btn2 = (TextView) findViewById(R.id.word_button2);
        btn3 = (TextView) findViewById(R.id.word_button3);
        btn4 = (TextView) findViewById(R.id.word_button4);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
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
            case R.id.word_button1:
                i = new Intent(WordActivity.this, GameStart.class);
                GameItem.Timer = false;
                GameItem.Flag = 3;
                break;
            case R.id.word_button2:
                i = new Intent(WordActivity.this, GameStart.class);
                GameItem.Timer = false;
                GameItem.Flag = 4;
                break;
            case R.id.word_button3:
                i = new Intent(WordActivity.this, GameStart.class);
                GameItem.Timer = false;
                GameItem.Flag = 5;
                break;
            case R.id.word_button4:
                i = new Intent(WordActivity.this, GameStart.class);
                GameItem.Timer = false;
                GameItem.Flag = 6;
                break;
        }

        startActivity(i);
    }
}
