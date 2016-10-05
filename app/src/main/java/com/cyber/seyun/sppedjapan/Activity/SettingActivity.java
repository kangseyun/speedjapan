package com.cyber.seyun.sppedjapan.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.cyber.seyun.sppedjapan.Adapter.ListviewAdapter;
import com.cyber.seyun.sppedjapan.Model.ListViewSetting;
import com.cyber.seyun.sppedjapan.R;

import java.util.ArrayList;

public class SettingActivity extends AppCompatActivity implements View.OnClickListener{
//    private ListView listView;
//    private ListviewAdapter mAdapter;
    private Toolbar toolbar;
    ArrayList<String> data = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        init();
    }

    private void init()
    {
        toolbarSetup();
//        find();
//        setAdater();
    }

    private void toolbarSetup() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("설정");
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

//    private void setAdater()
//    {
//        mAdapter = new ListviewAdapter(this);
//        mAdapter.AddItem(new ListViewSetting("켜자마자 단어","셋팅","test"));
//        mAdapter.AddItem(new ListViewSetting("초기화 ","언어셋팅","test"));
//        mAdapter.AddItem(new ListViewSetting("Setting","셋팅","test"));
//
//        listView.setAdapter(mAdapter);
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//            }
//        });
//    }

//    private void find(){
//        listView = (ListView)findViewById(R.id.Setting_Listview);
//    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
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
