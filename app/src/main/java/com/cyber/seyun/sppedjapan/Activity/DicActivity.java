package com.cyber.seyun.sppedjapan.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.cyber.seyun.sppedjapan.Adapter.ListviewAdapter;
import com.cyber.seyun.sppedjapan.Database.DBController;
import com.cyber.seyun.sppedjapan.Model.ListViewSetting;
import com.cyber.seyun.sppedjapan.R;

import java.util.List;

public class DicActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private ListView listView;
    private ListviewAdapter mAdapter;
    private DBController db = new DBController();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dic);
        init();
    }


    private void init() {
        find();
        setAdater();
    }

    private void setAdater() {
        mAdapter = new ListviewAdapter(this);


        bind(db.selectAll());


        listView.setAdapter(mAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }

    private void bind(List<ListViewSetting> items) {
        for (ListViewSetting item: items) {
            mAdapter.AddItem(item);
        }
    }

    private void find() {
        listView = (ListView) findViewById(R.id.tmpdiclistview);
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
