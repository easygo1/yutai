package com.yutai.audio.view.activity;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.yutai.audio.view.adapter.FragmentAdapter;
import com.yutai.audio.view.fragment.AudioFragment;
import com.yutai.audio.view.fragment.MeFragment;
import com.yutai.audio.view.fragment.VideoFragment;

import java.util.ArrayList;
import java.util.List;

import com.yutai.audio.R;

public class MainActivity extends AppCompatActivity {
    private ViewPager mViewPager;
    private RadioGroup mRadioGroup;
    private List<Fragment> mFragmentList;
    Fragment mAudioFragment, mVideoFragment, mMeFragment;
    FragmentManager mFragmentManager;
    FragmentAdapter mFragmentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initListeners();
        initData();
    }

    //初始化布局控件
    private void initViews() {
        mViewPager = (ViewPager) findViewById(R.id.middle_viewpager);
        mRadioGroup = (RadioGroup) findViewById(R.id.radiogroup);
    }

    private void initListeners() {
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                resetViewPager(checkedId);
            }
        });

        //滑动viewpager的时候及时修改底部导航栏对应图标
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                //根据当前位置设置默认选中单选按钮
                resetRadioButton(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }

        });
    }

    //重置viewpager
    private void resetViewPager(int checkedId) {
        switch (checkedId) {
            case R.id.audio_radio:
                mViewPager.setCurrentItem(0);
                break;
            case R.id.video_radio:
                mViewPager.setCurrentItem(1);
                break;
            case R.id.my_radio:
                mViewPager.setCurrentItem(2);
                break;
        }
    }

    //重置radio
    private void resetRadioButton(int position) {
        //获取position位置处对应的单选按钮
        RadioButton radioButton = (RadioButton) mRadioGroup.getChildAt(position);
        //设置当前单选按钮默认选中
        radioButton.setChecked(true);
    }

    //初始化数据
    private void initData() {
        mFragmentList = new ArrayList<>();
        mAudioFragment = new AudioFragment();
        mVideoFragment = new VideoFragment();
        mMeFragment = new MeFragment();
        mFragmentList.add(mAudioFragment);
        mFragmentList.add(mVideoFragment);
        mFragmentList.add(mMeFragment);

        //初始化适配器
        mFragmentManager = getSupportFragmentManager();
        mFragmentAdapter = new FragmentAdapter(mFragmentManager, mFragmentList);
        mViewPager.setAdapter(mFragmentAdapter);
    }
}
