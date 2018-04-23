package com.test.myappfragment.fragment;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.test.myappfragment.R;
import com.test.myappfragment.adapter.commonFragmentAdapter;
import com.test.myappfragment.base.BaseFragment;

public class HomeFragment extends BaseFragment {
    public static final String TAG=HomeFragment.class.getSimpleName();
    private ListView mListView;
    private String[] datas;
    private commonFragmentAdapter mAdapter;
    @SuppressLint("ResourceAsColor")
    @Override
    protected View initView() {
        Log.d(TAG,"首页展示.....");
        View view=View.inflate (mContext,R.layout.layout_home_fragment,null);
        mListView=view.findViewById (R.id.listview);
        mListView.setOnItemClickListener (new AdapterView.OnItemClickListener () {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String data=datas[position];
                Toast.makeText (mContext,"data=="+data,Toast.LENGTH_SHORT).show ();
            }
        });
        return view;
    }


    @Override
    protected void initData() {
        super.initData();
        Log.d(TAG,"首页数据.....");
        datas=new String[]{"retrofit","okhttp","Xutils","ButterKnife","EventBus"};
        mAdapter=new commonFragmentAdapter (mContext,datas);
        mListView.setAdapter (mAdapter);
    }
}
