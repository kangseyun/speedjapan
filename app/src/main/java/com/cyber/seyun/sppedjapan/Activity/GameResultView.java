package com.cyber.seyun.sppedjapan.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.cyber.seyun.sppedjapan.Model.GameItem;
import com.cyber.seyun.sppedjapan.R;



public class GameResultView extends AppCompatActivity implements View.OnClickListener{
    public static GameItem item;
    private Button BackButton;
    private TextView ResultView;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_result_view);

        init();
    }

    void init(){
        FindView();
    }

    void FindView()
    {
        BackButton = (Button)findViewById(R.id.ResultViewBackButton);
        BackButton.setOnClickListener(this);
        ResultView = (TextView)findViewById(R.id.ResultView);

        ResultView.setText(item.WinCount+"/10");
    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id)
        {
            case R.id.ResultViewBackButton:
                intent  = new Intent(GameResultView.this,GameMenu.class);
                startActivity(intent);
                finish();
                break;
        }
    }
}
