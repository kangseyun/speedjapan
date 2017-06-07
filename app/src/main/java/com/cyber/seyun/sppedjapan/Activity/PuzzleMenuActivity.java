package com.cyber.seyun.sppedjapan.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.cyber.seyun.sppedjapan.Model.GameItem;
import com.cyber.seyun.sppedjapan.R;

public class PuzzleMenuActivity extends AppCompatActivity implements View.OnClickListener {
    private Toolbar toolbar;
    private Button start, Level_up, Level_down;
    private TextView level;

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
        //start = (Button) findViewById(R.id.puzzle_start);
        //start.setOnClickListener(this);
        level = (TextView) findViewById(R.id.puzzle_level);
        Level_up = (Button) findViewById(R.id.puzzle_level_up);
        Level_down = (Button) findViewById(R.id.puzzle_level_down);
        Level_up.setOnClickListener(this);
        Level_down.setOnClickListener(this);
    }

    private void toolbarSetup() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("퍼즐게임");
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    private void GameLevel_UP() {
        level.setText("LEVEL 2");
    }

    private void GameLevel_Down() {
        level.setText("LEVEL 1");
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
                //Intent i = new Intent(PuzzleMenuActivity.this, PuzzleActivity.class);
                //startActivity(i);
                break;
            case R.id.puzzle_level_down:
                GameLevel_Down();
                break;
            case R.id.puzzle_level_up:
                GameLevel_UP();
                break;
        }
    }
}
