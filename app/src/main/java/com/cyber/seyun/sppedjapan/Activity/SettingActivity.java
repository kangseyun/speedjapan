package com.cyber.seyun.sppedjapan.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.cyber.seyun.sppedjapan.Adapter.ListviewAdapter;
import com.cyber.seyun.sppedjapan.Model.ListViewSetting;
import com.cyber.seyun.sppedjapan.R;

import java.util.ArrayList;

public class SettingActivity extends Activity implements View.OnClickListener{
    private ListView listView;
    private ListviewAdapter mAdapter;
    private Button back;
    private Intent PageMove;
    ArrayList<String> data = new ArrayList<>();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);


        init();
    }

    private void init()
    {
        find();
        setAdater();
    }


    private void setAdater()
    {
        mAdapter = new ListviewAdapter(this);
        mAdapter.AddItem(new ListViewSetting("켜자마자 단어","셋팅","test"));
        mAdapter.AddItem(new ListViewSetting("초기화 ","언어셋팅","test"));
        mAdapter.AddItem(new ListViewSetting("Setting","셋팅","test"));

        listView.setAdapter(mAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }

    private void find(){
        listView = (ListView)findViewById(R.id.Setting_Listview);
        back = (Button)findViewById(R.id.setting_back);
        back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id)
        {
            case R.id.setting_back:
                PageMove = new Intent(SettingActivity.this,MainActivity.class);
                break;
        }
        startActivity(PageMove);
    }
}
