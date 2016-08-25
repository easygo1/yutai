package com.yutai.exuetang;

import android.graphics.Color;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.yutai.exuetang.view.adapter.exuetang.FragmentAdapter;
import com.yutai.exuetang.view.fragment.exuetang.CommunityFragment;
import com.yutai.exuetang.view.fragment.exuetang.ExuetangFragment;
import com.yutai.exuetang.view.fragment.exuetang.MeFragment;
import com.yutai.exuetang.view.fragment.exuetang.ScienceFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ViewPager mViewPager;
    private RadioGroup mRadioGroup;
    private List<Fragment> mFragmentList;
    Fragment mExuetangFragment, mScienceFragment, mCommunityFragment, mMeFragment;
    FragmentManager mFragmentManager;
    FragmentAdapter mFragmentAdapter;
    private RadioButton mExuetangRadio;
    private RadioButton mScienceRadio;
    private RadioButton mCommunityRadio;
    private RadioButton mMyRadio;

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        addListeners();
        initData();
    }

    //初始化布局控件
    private void initViews() {
        mViewPager = (ViewPager) findViewById(R.id.middle_viewpager);
        mRadioGroup = (RadioGroup) findViewById(R.id.stageshow_radiogroup);
        mExuetangRadio = (RadioButton) findViewById(R.id.exuetang_radio);
        mScienceRadio = (RadioButton) findViewById(R.id.science_radio);
        mCommunityRadio = (RadioButton) findViewById(R.id.community_radio);
        mMyRadio = (RadioButton) findViewById(R.id.my_radio);
    }

    private void addListeners() {
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                resetViewPager(checkedId);
            }
        });
        //滑动viewPager的时候及时修改底部导航栏的字体颜色
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                //根据当前位置设置选中的单选按钮
                resetRadioButton(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
    //重置viewpager
    private void resetViewPager(int checkedId){
        switch (checkedId){
            case R.id.exuetang_radio:
                mViewPager.setCurrentItem(0);
                break;
            case R.id.science_radio:
                mViewPager.setCurrentItem(1);
                break;
            case R.id.community_radio:
                mViewPager.setCurrentItem(2);
                break;
            case R.id.my_radio:
                mViewPager.setCurrentItem(3);
                break;
        }
    }
    //重置radioButton
    private void resetRadioButton(int position){
        //获取position位置处对应的单选按钮
        RadioButton radioButton = (RadioButton) mRadioGroup.getChildAt(position);
        //设置当前单选按钮默认选中
        radioButton.setChecked(true);
    }
    //初始化数据
    private void initData() {
        mFragmentList = new ArrayList<>();
        mExuetangFragment = new ExuetangFragment();
        mScienceFragment = new ScienceFragment();
        mCommunityFragment = new CommunityFragment();
        mMeFragment = new MeFragment();
        mFragmentList.add(mExuetangFragment);
        mFragmentList.add(mScienceFragment);
        mFragmentList.add(mCommunityFragment);
        mFragmentList.add(mMeFragment);

        //初始化适配器
        mFragmentManager = getSupportFragmentManager();
        mFragmentAdapter = new FragmentAdapter(mFragmentManager, mFragmentList);
        mViewPager.setAdapter(mFragmentAdapter);
    }
}
