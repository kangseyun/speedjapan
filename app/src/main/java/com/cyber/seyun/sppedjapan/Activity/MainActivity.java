package com.cyber.seyun.sppedjapan.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.cyber.seyun.sppedjapan.R;

public class MainActivity extends Activity implements View.OnClickListener {
    private TextView GameMenu, setting, Word;
    private Intent PageMove;
    private String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findLayout();
    }

    private void findLayout() {
        GameMenu = (TextView) findViewById(R.id.button1);
        Word = (TextView) findViewById(R.id.test123);
        setting = (TextView) findViewById(R.id.setting);
        setting.setOnClickListener(this);
        GameMenu.setOnClickListener(this);
        Word.setOnClickListener(this);
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
        }
        startActivity(PageMove);
    }
}
