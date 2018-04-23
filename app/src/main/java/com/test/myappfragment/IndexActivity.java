package com.test.myappfragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;

import com.test.myappfragment.base.BaseFragment;
import com.test.myappfragment.fragment.HomeFragment;
import com.test.myappfragment.fragment.MallFragment;
import com.test.myappfragment.fragment.MineFragment;
import com.test.myappfragment.fragment.ShopFragment;

import java.util.ArrayList;
import java.util.List;

public class IndexActivity extends AppCompatActivity {

    private RadioGroup group;
    private List<BaseFragment> baseFragments;
    private int postion;
    private Fragment mContent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
        getSupportActionBar().hide();
        //初始化view
        initView();
        //初始化fragment
        initFragment();
        //RadioGroup的监听
        setListener();
    }

    private void initView() {
        group = findViewById(R.id.rg_index);

    }
    private void initFragment() {
        baseFragments=new ArrayList<>();
        baseFragments.add(new HomeFragment());//首页
        baseFragments.add(new MallFragment());//中心
        baseFragments.add(new ShopFragment());//商城
        baseFragments.add(new MineFragment());//我的
    }

    private void setListener() {
        group.setOnCheckedChangeListener(new myListener());
        //默认框架
        group.check(R.id.rb_common_home);
    }
    public class myListener implements RadioGroup.OnCheckedChangeListener{

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId){
                case R.id.rb_common_home://首页
                    postion=0;
                    break;
                case R.id.rb_common_mall://中心
                    postion=1;
                    break;
                case R.id.rb_common_shop://商城
                    postion=2;
                    break;
                case R.id.rb_common_mine://我的
                    postion=3;
                    break;
                default:
                    postion=0;
                    break;
            }
            //查找fragment
            Fragment to=baseFragments.get(postion);
            //替换
            switchFragment(mContent,to);
        }
    }

    /**
     * @param from 刚显示的快要隐藏
     * @param to 要切换的fragment
     */
    private void switchFragment(Fragment from,Fragment to) {
        if(from !=to){
            //才切换
            mContent=to;
            FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
            //判断有没有被添加
            if(!to.isAdded()){
                if(from !=null){
                    ft.hide(from);
                }
                if(to!=null){
                    ft.add(R.id.fl_common,to).commit();
                }
            }else{
                //to被添加,from隐藏，to显示
                if(from!=null){
                    ft.hide(from);
                }
                if(to!=null){
                    ft.show(to).commit();
                }
            }
        }
    }
//    private void switchFragment(Fragment fragment) {
//        //得到FragmentManager
//        FragmentManager fm=getSupportFragmentManager();
//        //开启事务
//        FragmentTransaction transaction=fm.beginTransaction();
//        //替换
//        transaction.replace(R.id.fl_common,fragment);
//        //提交
//        transaction.commit();
//    }

}
