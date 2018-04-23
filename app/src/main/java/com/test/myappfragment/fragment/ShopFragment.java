package com.test.myappfragment.fragment;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.test.myappfragment.R;
import com.test.myappfragment.base.BaseFragment;

public class ShopFragment extends BaseFragment {
    public static final String TAG=ShopFragment.class.getSimpleName();
    private TextView textView;
    @SuppressLint("ResourceAsColor")
    @Override
    protected View initView() {
        Log.d(TAG,"商城展示.....");
        textView=new TextView(mContext);
        textView.setTextSize(20);
        textView.setTextColor(Color.BLUE);
        textView.setGravity(Gravity.CENTER);
        return textView;
    }

    @Override
    protected void initData() {
        super.initData();
        Log.d(TAG,"商城数据.....");
        textView.setText("商城页面");
    }
}
