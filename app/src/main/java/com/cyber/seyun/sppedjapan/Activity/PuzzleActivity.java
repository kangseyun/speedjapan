package com.cyber.seyun.sppedjapan.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.cyber.seyun.sppedjapan.Database.DBController;
import com.cyber.seyun.sppedjapan.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PuzzleActivity extends AppCompatActivity implements View.OnClickListener {
    private Toolbar toolbar;
    private DBController db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puzzle);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        toolbarSetup();
        db = new DBController();
        wordInit();
    }

    private void getWord() {
    }

    private void wordInit() {
        TextView t1 = (TextView) findViewById(R.id.card_view1_content);
        TextView t2 = (TextView) findViewById(R.id.card_view2_content);
        TextView t3 = (TextView) findViewById(R.id.card_view3_content);
        TextView t4 = (TextView) findViewById(R.id.card_view4_content);
        TextView t5 = (TextView) findViewById(R.id.card_view5_content);
        TextView t6 = (TextView) findViewById(R.id.card_view6_content);
        TextView t7 = (TextView) findViewById(R.id.card_view7_content);
        TextView t8 = (TextView) findViewById(R.id.card_view8_content);
        TextView t9 = (TextView) findViewById(R.id.card_view9_content);
        TextView t10 = (TextView) findViewById(R.id.card_view10_content);
        t1.setOnClickListener(this);
        t2.setOnClickListener(this);
        t3.setOnClickListener(this);
        t4.setOnClickListener(this);
        t5.setOnClickListener(this);
        t6.setOnClickListener(this);
        t7.setOnClickListener(this);
        t8.setOnClickListener(this);
        t9.setOnClickListener(this);
        t10.setOnClickListener(this);

    }


    private void toolbarSetup() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("퍼즐게임");
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

        switch (id) {
            case R.id.card_view1_content:
                break;
            case R.id.card_view2_content:
                break;
            case R.id.card_view3_content:
                break;
            case R.id.card_view4_content:
                break;
            case R.id.card_view5_content:
                break;
            case R.id.card_view6_content:
                break;
            case R.id.card_view7_content:
                break;
            case R.id.card_view8_content:
                break;
            case R.id.card_view9_content:
                break;
            case R.id.card_view10_content:
                break;
        }
    }
}
