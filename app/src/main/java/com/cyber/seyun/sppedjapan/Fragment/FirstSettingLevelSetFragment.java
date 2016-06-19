package com.cyber.seyun.sppedjapan.Fragment;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.cyber.seyun.sppedjapan.Activity.FirstSettingActivity;
import com.cyber.seyun.sppedjapan.Model.FirstSettingModel;
import com.cyber.seyun.sppedjapan.R;


public class FirstSettingLevelSetFragment extends android.support.v4.app.Fragment{
    private RadioGroup rb;

    public FirstSettingLevelSetFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_first_setting_level_set, container, false);
        rb= (RadioGroup)v.findViewById(R.id.Radio);
        rb.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.radioButton_level1:
                        FirstSettingModel.FistViewLevel = 1;
                        break;
                    case R.id.radioButton_level2:
                        FirstSettingModel.FistViewLevel = 2;
                        break;
                    case R.id.radioButton_level3:
                        FirstSettingModel.FistViewLevel = 3;
                        break;
                }
            }
        });
        return v;
    }


}
