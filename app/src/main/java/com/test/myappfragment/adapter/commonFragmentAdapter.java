package com.test.myappfragment.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class commonFragmentAdapter extends BaseAdapter {
    private final Context mContext;
    private final String[] datas;

    public commonFragmentAdapter(Context mContext, String[] datas) {
        this.mContext = mContext;
        this.datas = datas;
    }

    @Override
    public int getCount() {
        return datas.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView textView=new TextView (mContext);
        textView.setPadding (10,10,0,10);
        textView.setTextSize (20);
        textView.setTextColor (Color.BLUE);
        textView.setText (datas[position]);
        return textView;
    }
}
