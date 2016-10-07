package com.cyber.seyun.sppedjapan.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.cyber.seyun.sppedjapan.Model.ListViewSetting;
import com.cyber.seyun.sppedjapan.R;

import java.util.ArrayList;

/**
 * Created by 590 on 2015-12-29.
 */
public class ListviewAdapter extends BaseAdapter {
    private Context mContext;
    private TextView japan, korean;
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
        convertView = inflater.inflate(R.layout.dic_item,parent,false);

        japan = (TextView)convertView.findViewById(R.id.dic_title);
        japan.setText(item.get(position).japan);
        korean = (TextView)convertView.findViewById(R.id.dic_hint);
        korean.setText(item.get(position).korean);


        return convertView;
    }
}
