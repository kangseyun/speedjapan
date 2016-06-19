package com.cyber.seyun.sppedjapan.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.cyber.seyun.sppedjapan.Model.FirstSettingModel;
import com.cyber.seyun.sppedjapan.R;

public class FirstSettingStartViewFragment extends android.support.v4.app.Fragment implements View.OnClickListener {
    private int flag = 0; // 0 - off , 1 - on
    private Button button;

    public FirstSettingStartViewFragment() {
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
        View v =  inflater.inflate(R.layout.fragment_first_setting_start_view, container, false);
        button = (Button)v.findViewById(R.id.first_setting_start_button);
        button.setOnClickListener(this);
        return v;
    }

    private void buttonClick(){
        if(flag == 0){
            button.setText("OFF");
            flag = 1;
            FirstSettingModel.FistView = 0;
        }
        else{
            button.setText("ON");
            flag = 0;
            FirstSettingModel.FistView = 1;
        }
    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.first_setting_start_button:
                buttonClick();
                break;
        }
    }
}
