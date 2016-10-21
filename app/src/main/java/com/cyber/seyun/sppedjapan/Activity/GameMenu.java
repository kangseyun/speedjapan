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

public class GameMenu extends AppCompatActivity implements View.OnClickListener {
    private Button up, down;
    private Intent PageMove;
    private TextView GameStart,GameStart2,timer;
    private Toolbar toolbar;
    private final int MAX = 15;
    private final int MIN = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_menu);

        init();
    }

    //초기화
    private void init(){
        findLayout(); //레이아웃 적용
        GameItem.TimerCount_init(); // 타이머 카운트 0으로 초기화
        timer.setText(Integer.toString(GameItem.TimerCount));
        toolbarSetup();
    }

    private void toolbarSetup() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("단어게임");
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    private void findLayout()
    {
        GameStart = (TextView)findViewById(R.id.gameMenuGameStart);
        GameStart2 = (TextView)findViewById(R.id.gameMenuGameStart2);

        up = (Button)findViewById(R.id.time_Up);
        down = (Button)findViewById(R.id.time_Down);
        timer = (TextView)findViewById(R.id.game_menu_timer);
        GameStart.setOnClickListener(this);
        GameStart2.setOnClickListener(this);
        up.setOnClickListener(this);
        down.setOnClickListener(this);
    }

    private void Timer_UP(){ // 타이머가 MAX 이하일경우 5증가 ,
        if(GameItem.TimerCount < MAX) {
            GameItem.TimerCount += 5;
            timer.setText(Integer.toString(GameItem.TimerCount));
        }
    }

    private void Timer_DOWN(){
        if(GameItem.TimerCount > MIN) { // 현재 타이머값이 MIN  이상일경우만  감소
            GameItem.TimerCount -= 5;
            timer.setText(Integer.toString(GameItem.TimerCount));
        }
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id)
        {
            case R.id.gameMenuGameStart:
                PageMove = new Intent(GameMenu.this, GameStart.class);
                GameItem.Timer = false;
                GameItem.Flag = 2;
                startActivity(PageMove);
                break;
            case R.id.gameMenuGameStart2:
                PageMove = new Intent(GameMenu.this, GameStart.class);
                GameItem.Timer = false;
                GameItem.Flag = 1;
                startActivity(PageMove);
                break;
//            case R.id.LeftMenuButton:
//                PageMove = new Intent(GameMenu.this,MainActivity.class);
//                startActivity(PageMove);
//                break;
            case R.id.time_Up:
                Timer_UP();
                break;
            case R.id.time_Down:
                Timer_DOWN();
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
}
