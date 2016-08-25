package com.yutai.exuetang.view.activity.stageshow;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.yutai.exuetang.R;
import com.yutai.exuetang.view.adapter.exuetang.FragmentAdapter;
import com.yutai.exuetang.view.fragment.stageshow.CompetitionFragment;
import com.yutai.exuetang.view.fragment.stageshow.NewsFragment;
import com.yutai.exuetang.view.fragment.stageshow.PersonalShowFragment;
import com.yutai.exuetang.view.fragment.stageshow.StageShowFragment;

import java.util.ArrayList;
import java.util.List;

public class StageShowActivity extends AppCompatActivity {
    private List<Fragment> mFragmentList;
    Fragment mStageShowFragment, mCompetitionFragment, mNewsFragment, mPersonalShowFragment;
    FragmentManager mFragmentManager;
    FragmentAdapter mFragmentAdapter;
    private ViewPager mMiddleViewpager;
    private RadioGroup mRadiogroup;
    private RadioButton mStageshowRadio;
    private RadioButton mCompetitionRadio;
    private RadioButton mNewsRadio;
    private RadioButton mPersonshowRadio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stage_show);
        initViews();
        initData();
        addListeners();
    }

    private void initViews() {
        mMiddleViewpager = (ViewPager) findViewById(R.id.stageshow_viewpager);
        mRadiogroup = (RadioGroup) findViewById(R.id.stageshow_radiogroup);
        mStageshowRadio = (RadioButton) findViewById(R.id.stageshow_radio);
        mCompetitionRadio = (RadioButton) findViewById(R.id.competition_radio);
        mNewsRadio = (RadioButton) findViewById(R.id.news_radio);
        mPersonshowRadio = (RadioButton) findViewById(R.id.personshow_radio);
    }

    private void addListeners() {
        mRadiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                resetViewPager(checkedId);
            }
        });
        //滑动viewPager的时候及时修改底部导航栏的字体颜色
        mMiddleViewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
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
    private void resetViewPager(int checkedId) {
        switch (checkedId) {
            case R.id.stageshow_radio:
                mMiddleViewpager.setCurrentItem(0);
                break;
            case R.id.competition_radio:
                mMiddleViewpager.setCurrentItem(1);
                break;
            case R.id.news_radio:
                mMiddleViewpager.setCurrentItem(2);
                break;
            case R.id.personshow_radio:
                mMiddleViewpager.setCurrentItem(3);
                break;
        }
    }

    //重置radioButton
    private void resetRadioButton(int position) {
        //获取position位置处对应的单选按钮
        RadioButton radioButton = (RadioButton) mRadiogroup.getChildAt(position);
        //设置当前单选按钮默认选中
        radioButton.setChecked(true);
    }

    //初始化数据
    private void initData() {
        mFragmentList = new ArrayList<>();
        mStageShowFragment = new StageShowFragment();
        mCompetitionFragment = new CompetitionFragment();
        mNewsFragment = new NewsFragment();
        mPersonalShowFragment = new PersonalShowFragment();
        mFragmentList.add(mStageShowFragment);
        mFragmentList.add(mCompetitionFragment);
        mFragmentList.add(mNewsFragment);
        mFragmentList.add(mPersonalShowFragment);

        //初始化适配器
        mFragmentManager = getSupportFragmentManager();
        mFragmentAdapter = new FragmentAdapter(mFragmentManager, mFragmentList);
        mMiddleViewpager.setAdapter(mFragmentAdapter);
    }
}
