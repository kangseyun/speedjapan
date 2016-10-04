package com.cyber.seyun.sppedjapan.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.cyber.seyun.sppedjapan.Database.DBController;
import com.cyber.seyun.sppedjapan.R;
import com.cyber.seyun.sppedjapan.Model.GameItem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class GameStart extends AppCompatActivity implements View.OnClickListener {
    private String TAG = GameStart.class.getSimpleName();

    public static GameItem item;
    private Intent intent;
    private TextView JapanView, CountView;
    private Button button1, button2, button3, BackButton;
    private DBController db = new DBController();
    private int GanePlayCount = 0;
    private CountTimer c = new CountTimer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_start);
        init();
    }

    void init() {
        FindView();
        item.init();
        nextView(); //첫번째 단어를 셋팅해줌
        if (GameItem.TimerCount != 0) // 시간설정이 0 일경우 타이머 스레드를 실행시키지 않음
            c.start();
    }

    private void FindView() {   //레이아웃 Settion
        JapanView = (TextView) findViewById(R.id.gameStartView);
        CountView = (TextView) findViewById(R.id.text_game_start_count);
        BackButton = (Button) findViewById(R.id.EndGame);
        button1 = (Button) findViewById(R.id.gamestartButton1);
        button2 = (Button) findViewById(R.id.gamestartButton2);
        button3 = (Button) findViewById(R.id.gamestartButton3);
        button3.setOnClickListener(this);
        button2.setOnClickListener(this);
        button1.setOnClickListener(this);
        BackButton.setOnClickListener(this);
    }

    private void ButtonClick(Button b) {   //버튼 클릭시 이벤트
        if (GanePlayCount < 10) //아직 10번진행하지 않으면
        {
            if (db.Check(JapanView.getText().toString(), b.getText().toString(), GameItem.Flag)) // 클릭한 버튼과 TextView 나오는 글자를 비교함
                item.WinCount = item.WinCount + 1; //맞으면 승리카운트 1증가
            nextView();
            c.restart();
        } else {
            intent = new Intent(GameStart.this, GameResultView.class);
            startActivity(intent);
            finish();
            c.interrupt();
        }
    }

    class CountTimer extends Thread implements Runnable {
        private int NowCount = 0;
        private Boolean Loop = true;

        public void restart() {
            NowCount = 0;
        }

        @Override
        public void run() {
            super.run();
            while (Loop) {
                if (NowCount >= GameItem.TimerCount) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            nextView();
                        }
                    });
                    restart();
                }
                try {
                    NowCount++;
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            CountView.setText(Integer.toString(NowCount));
                        }
                    });
                    Thread.sleep(1000);
                } catch (Exception e) {
                    Log.i(TAG, e.toString());
                }
            }
        }
    }

    public void nextView() {
        ArrayList<String> word = db.nextView(GameItem.Flag); // 디비에서 4개 단어 배열로 가져옴 1개는 Textview용
        long seed = System.nanoTime();

        JapanView.setText(word.get(0));
        word.remove(0); //TextView용 단어 삭제하여 버튼 단어만 남겨둠
        Collections.shuffle(word, new Random(seed)); //배열 섞어서 버튼 단어가 램던하게 뜨도록 만듬

        button1.setText(word.get(0));
        button2.setText(word.get(1));
        button3.setText(word.get(2));

        GanePlayCount = GanePlayCount + 1; // 플레이카운트 증가
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.gamestartButton1:
                ButtonClick(button1);
                break;
            case R.id.gamestartButton2:
                ButtonClick(button2);
                break;
            case R.id.gamestartButton3:
                ButtonClick(button3);
                break;
            case R.id.EndGame:
                intent = new Intent(GameStart.this, GameMenu.class);
                startActivity(intent);
                c.interrupt();
                GameItem.timer_init();
                break;
        }
    }


}
