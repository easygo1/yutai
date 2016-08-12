package com.yutai.exuetang.view.adapter.exuetang;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.yutai.exuetang.model.beans.exuetang.SpinnerListItem;

import java.util.List;

/**
 * Created by ZFG on 2016/8/11.
 */
public class MySpinnerAdapter extends ArrayAdapter<SpinnerListItem> {
    private Context context;
    private List<SpinnerListItem> myList;

    public MySpinnerAdapter(Context context, int resource, List<SpinnerListItem> objects) {
        super(context, resource, objects);
        this.myList = objects;
        this.context = context;
    }
    @Override
    public View getDropDownView(int position, View convertView,
                                ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(
                    android.R.layout.simple_spinner_dropdown_item, parent, false);
        }

        TextView tv = (TextView) convertView
                .findViewById(android.R.id.text1);
        tv.setText(myList.get(position).getName());
        tv.setGravity(Gravity.CENTER);
//        tv.setPadding(0, 10, 0, 0);
        tv.setTextColor(Color.GRAY);
        tv.setTextSize(16);
        return convertView;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(
                    android.R.layout.simple_spinner_dropdown_item, parent, false);
        }
        TextView tv = (TextView) convertView
                .findViewById(android.R.id.text1);
        tv.setText(myList.get(position).getName());
        tv.setGravity(Gravity.CENTER);
        tv.setTextSize(16);
        tv.setTextColor(Color.GRAY);
        return convertView;
    }
}
