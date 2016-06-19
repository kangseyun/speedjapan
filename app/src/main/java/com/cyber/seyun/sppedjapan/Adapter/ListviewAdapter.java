package com.cyber.seyun.sppedjapan.Adapter;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.cyber.seyun.sppedjapan.Model.ListViewSetting;
import com.cyber.seyun.sppedjapan.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by 590 on 2015-12-29.
 */
public class ListviewAdapter extends BaseAdapter {
    private Context mContext;
    private TextView text1,text2,text3;
    private ArrayList<ListViewSetting> item;
    public ListviewAdapter(Context mContext){
        this.mContext = mContext;
        item = new ArrayList<ListViewSetting>();
    }

    public int AddItem(ListViewSetting item){
        this.item.add(item);
        return 1;
    }

    @Override
    public int getCount() {
        return item.size();
    }

    @Override
    public Object getItem(int position) {
        return item.get(position);
    }


    @Override
    public long getItemId(int position) {
        return getItem(position).hashCode();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.listview_test,parent,false);

        text1 = (TextView)convertView.findViewById(R.id.listview_test1);


        text1.setText(item.get(position).menu1);



        return convertView;
    }
}
