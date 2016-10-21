package com.cyber.seyun.sppedjapan.Activity;


import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.cyber.seyun.sppedjapan.Database.DBController;
import com.cyber.seyun.sppedjapan.Fragment.FirstSettingLevelSetFragment;
import com.cyber.seyun.sppedjapan.Fragment.FirstSettingStartViewFragment;
import com.cyber.seyun.sppedjapan.Model.FirstSettingModel;
import com.cyber.seyun.sppedjapan.R;
import com.cyber.seyun.sppedjapan.Reaml.SettingRealm;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class    FirstSettingActivity extends FragmentActivity implements View.OnClickListener {
    final String TAG = "MainActivity";
    int mCurrentFragmentIndex;
    public final static int FRAGMENT_ONE = 0;
    public final static int FRAGMENT_TWO = 1;

    private Button button1, button2;
    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_setting);

        init();

        mCurrentFragmentIndex = FRAGMENT_ONE;
        fragmentReplace(mCurrentFragmentIndex);

    }

    private void init() {
        findLayout();

        RealmConfiguration realmConfig = new RealmConfiguration.Builder(getApplication()).build();
        Realm.setDefaultConfiguration(realmConfig);
        realm = Realm.getDefaultInstance();
    }

    private void findLayout() {
        button1 = (Button)findViewById(R.id.b1);
        button2 = (Button)findViewById(R.id.b2);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
    }

    public void fragmentReplace(int reqNewFragmentIndex){
        android.support.v4.app.Fragment newFragment = null;
        newFragment = getFragment(reqNewFragmentIndex);

        final android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager().
                beginTransaction().replace(R.id.first_setting_fragment,newFragment);
        transaction.commit();
    }


    private android.support.v4.app.Fragment getFragment(int idx){
        android.support.v4.app.Fragment newFragment = null;

        switch (idx){
            case FRAGMENT_ONE:
                newFragment = new FirstSettingStartViewFragment();
                break;
            case FRAGMENT_TWO:
                newFragment = new FirstSettingLevelSetFragment();
                break;
        }

        return newFragment;
    }

    private void next(){
        Log.i("mCurrentFragmentIndex", "" + mCurrentFragmentIndex);
        if(mCurrentFragmentIndex <3){
            if(mCurrentFragmentIndex == 1) {
                Finish();
            }
            else {
                mCurrentFragmentIndex += 1;
                fragmentReplace(mCurrentFragmentIndex);
            }
        }
    }

    private void down(){
        if (mCurrentFragmentIndex > 0) {
            mCurrentFragmentIndex -= 1;
            fragmentReplace(mCurrentFragmentIndex);
        }
    }

    private void Finish(){
        realm.beginTransaction();
        SettingRealm setting = realm.createObject(SettingRealm.class); // 관리 객체를 직접 만들기
        setting.setScreenWord(FirstSettingModel.FistView);
        realm.commitTransaction();

        Intent intent = new Intent(FirstSettingActivity.this,MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.b1:
                down();
                break;
            case R.id.b2:
                next();
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        realm.close();
    }
}
