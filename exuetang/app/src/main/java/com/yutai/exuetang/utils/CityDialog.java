package com.yutai.exuetang.utils;

import android.app.Dialog;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import com.yutai.exuetang.R;
import com.yutai.exuetang.db.SpinnerDBManager;
import com.yutai.exuetang.model.beans.exuetang.SpinnerListItem;
import com.yutai.exuetang.view.adapter.exuetang.MySpinnerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zzia on 2016/6/1.
 */
public class CityDialog extends Dialog {
    private SpinnerDBManager dbm;
    private SQLiteDatabase db;
    private Spinner spinner1 = null;
    private Spinner spinner2 = null;
    private Spinner spinner3 = null;
    private TextView bt_ok;
    private TextView bt_cancel;
    private String province = null;
    private String city = null;
    private String district = null;
    private Context context;
    private InputListener IListener;

    public CityDialog(Context context) {
        super(context);
        this.context = context;
    }

    public CityDialog(Context context,
                      InputListener inputListener) {
        super(context);
        this.context = context;
        IListener = inputListener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.city_spinner_dialog);
        spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        spinner3 = (Spinner) findViewById(R.id.spinner3);
        bt_ok = (TextView) findViewById(R.id.city_dialog_ok);
        bt_cancel = (TextView) findViewById(R.id.city_dialog_cancle);
        bt_ok.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String address = province + "-" + city + "-" + district;
                IListener.getText(address);
                dismiss();
            }
        });
        bt_cancel.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        spinner1.setPrompt("省");
        spinner2.setPrompt("城市");
        spinner3.setPrompt("地区");
        initSpinner1();
    }

    //定义回调接口
    public interface InputListener {
        void getText(String str);
    }

    public void initSpinner1() {
        dbm = new SpinnerDBManager(context);
        dbm.openDatabase();
        db = dbm.getDatabase();
        List<SpinnerListItem> list = new ArrayList<SpinnerListItem>();

        try {
            String sql = "select * from province";
            Cursor cursor = db.rawQuery(sql, null);
            cursor.moveToFirst();
            while (!cursor.isLast()) {
                String code = cursor.getString(cursor.getColumnIndex("code"));
                byte bytes[] = cursor.getBlob(2);
                String name = new String(bytes, "gbk");
                SpinnerListItem myListItem = new SpinnerListItem();
                myListItem.setName(name);
                myListItem.setPcode(code);
                list.add(myListItem);
                cursor.moveToNext();
            }
            String code = cursor.getString(cursor.getColumnIndex("code"));
            byte bytes[] = cursor.getBlob(2);
            String name = new String(bytes, "gbk");
            SpinnerListItem myListItem = new SpinnerListItem();
            myListItem.setName(name);
            myListItem.setPcode(code);
            list.add(myListItem);

        } catch (Exception e) {
        }
        dbm.closeDatabase();
        db.close();
        MySpinnerAdapter mySpinnerAdapter=new MySpinnerAdapter(context,android.R.layout.simple_spinner_item,list);
        mySpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner1.setAdapter(mySpinnerAdapter);
        spinner1.setOnItemSelectedListener(new SpinnerOnSelectedListener1());
    }

    public void initSpinner2(String pcode) {
        dbm = new SpinnerDBManager(context);
        dbm.openDatabase();
        db = dbm.getDatabase();
        List<SpinnerListItem> list = new ArrayList<SpinnerListItem>();

        try {
            String sql = "select * from city where pcode='" + pcode + "'";
            Cursor cursor = db.rawQuery(sql, null);
            cursor.moveToFirst();
            while (!cursor.isLast()) {
                String code = cursor.getString(cursor.getColumnIndex("code"));
                byte bytes[] = cursor.getBlob(2);
                String name = new String(bytes, "gbk");
                SpinnerListItem myListItem = new SpinnerListItem();
                myListItem.setName(name);
                myListItem.setPcode(code);
                list.add(myListItem);
                cursor.moveToNext();
            }
            String code = cursor.getString(cursor.getColumnIndex("code"));
            byte bytes[] = cursor.getBlob(2);
            String name = new String(bytes, "gbk");
            SpinnerListItem myListItem = new SpinnerListItem();
            myListItem.setName(name);
            myListItem.setPcode(code);
            list.add(myListItem);

        } catch (Exception e) {
        }
        dbm.closeDatabase();
        db.close();
        MySpinnerAdapter mySpinnerAdapter=new MySpinnerAdapter(context,android.R.layout.simple_spinner_item,list);
        mySpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner2.setAdapter(mySpinnerAdapter);
//Spinner中文框显示样式

        spinner2.setOnItemSelectedListener(new SpinnerOnSelectedListener2());
    }

    public void initSpinner3(String pcode) {
        dbm = new SpinnerDBManager(context);
        dbm.openDatabase();
        db = dbm.getDatabase();
        List<SpinnerListItem> list = new ArrayList<SpinnerListItem>();

        try {
            String sql = "select * from district where pcode='" + pcode + "'";
            Cursor cursor = db.rawQuery(sql, null);
            cursor.moveToFirst();
            while (!cursor.isLast()) {
                String code = cursor.getString(cursor.getColumnIndex("code"));
                byte bytes[] = cursor.getBlob(2);
                String name = new String(bytes, "gbk");
                SpinnerListItem myListItem = new SpinnerListItem();
                myListItem.setName(name);
                myListItem.setPcode(code);
                list.add(myListItem);
                cursor.moveToNext();
            }
            String code = cursor.getString(cursor.getColumnIndex("code"));
            byte bytes[] = cursor.getBlob(2);
            String name = new String(bytes, "gbk");
            SpinnerListItem myListItem = new SpinnerListItem();
            myListItem.setName(name);
            myListItem.setPcode(code);
            list.add(myListItem);

        } catch (Exception e) {
        }
        dbm.closeDatabase();
        db.close();
        MySpinnerAdapter mySpinnerAdapter=new MySpinnerAdapter(context,android.R.layout.simple_spinner_item,list);
        mySpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner3.setAdapter(mySpinnerAdapter);
        spinner3.setOnItemSelectedListener(new SpinnerOnSelectedListener3());
    }

    class SpinnerOnSelectedListener1 implements AdapterView.OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> adapterView, View view, int position,
                                   long id) {
            province = ((SpinnerListItem) adapterView.getItemAtPosition(position)).getName();
            String pcode = ((SpinnerListItem) adapterView.getItemAtPosition(position)).getPcode();
            initSpinner2(pcode);
            initSpinner3(pcode);
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    class SpinnerOnSelectedListener2 implements AdapterView.OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> adapterView, View view, int position,
                                   long id) {
            city = ((SpinnerListItem) adapterView.getItemAtPosition(position)).getName();
            String pcode = ((SpinnerListItem) adapterView.getItemAtPosition(position)).getPcode();
            initSpinner3(pcode);
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    class SpinnerOnSelectedListener3 implements AdapterView.OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> adapterView, View view, int position,
                                   long id) {
            district = ((SpinnerListItem) adapterView.getItemAtPosition(position)).getName();
            }

        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }
   
}
