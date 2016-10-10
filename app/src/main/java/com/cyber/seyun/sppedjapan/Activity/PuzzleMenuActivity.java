package com.cyber.seyun.sppedjapan.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.cyber.seyun.sppedjapan.R;

public class PuzzleMenuActivity extends AppCompatActivity implements View.OnClickListener {
    private Toolbar toolbar;
    private Button start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puzzle_menu);
        init();
    }

    void init() {
        toolbarSetup();
        findLayout();
    }

    private void findLayout() {
        start = (Button) findViewById(R.id.puzzle_start);
        start.setOnClickListener(this);
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
            case R.id.puzzle_start:
                Intent i = new Intent(PuzzleMenuActivity.this, PuzzleActivity.class);
                startActivity(i);
                break;
        }
    }
}
