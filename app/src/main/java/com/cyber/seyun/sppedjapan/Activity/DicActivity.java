package com.cyber.seyun.sppedjapan.Activity;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import com.cyber.seyun.sppedjapan.Adapter.DicAdapter;
import com.cyber.seyun.sppedjapan.Database.DBController;
import com.cyber.seyun.sppedjapan.Model.ListViewSetting;
import com.cyber.seyun.sppedjapan.R;

import java.util.ArrayList;
import java.util.List;

public class DicActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    private Toolbar toolbar;
    private DBController db = new DBController();
    private RecyclerView mRecyclerView;
    private DicAdapter mAdapter;
    private LinearLayoutManager mLayoutManager;
    private List<String> myDataset;
    private EditText search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dic);

        myDataset = new ArrayList<String>();
        setToolbar();
        init();
        addTextListener();
    }

    private void setToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("검색");
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    private void init() {
        search = (EditText) findViewById( R.id.floating_search_view);
        setAdater();

    }

    private void setAdater() {
        mRecyclerView = (RecyclerView) findViewById(R.id.dicRecyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        myDataset = new ArrayList<>();
        mAdapter = new DicAdapter(myDataset, getApplicationContext());
        mRecyclerView.setAdapter(mAdapter);
        setData();

        mAdapter.setOnItemClickListener(new DicAdapter.ClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                Intent i = new Intent(v.getContext(), DicDetailActivity.class);
                startActivity(i);
            }

            @Override
            public void onItemLongClick(int position, View v) {

            }
        });
    }

    private void setData() {
        List<ListViewSetting> data = db.selectAll();
        for (ListViewSetting obj: data) {
            myDataset.add(obj.getKorean());
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



    public void addTextListener(){

        search.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {}

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            public void onTextChanged(CharSequence query, int start, int before, int count) {

                query = query.toString().toLowerCase();

                final List<String> filteredList = new ArrayList<>();

                for (int i = 0; i < myDataset.size(); i++) {

                    final String text = myDataset.get(i).toLowerCase();
                    if (text.contains(query)) {

                        filteredList.add(myDataset.get(i));
                    }
                }

                mRecyclerView.setLayoutManager(new LinearLayoutManager(DicActivity.this));
                mAdapter = new DicAdapter(filteredList, DicActivity.this);
                mRecyclerView.setAdapter(mAdapter);
                mAdapter.notifyDataSetChanged();  // data set changed
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
