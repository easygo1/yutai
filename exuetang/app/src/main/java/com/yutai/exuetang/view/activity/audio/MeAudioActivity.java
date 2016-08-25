package com.yutai.exuetang.view.activity.audio;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.yutai.exuetang.R;
import com.yutai.exuetang.view.fragment.audio.LocalAudioFragment;
import com.yutai.exuetang.view.fragment.audio.LoveAudioFragment;
import com.yutai.exuetang.view.fragment.audio.RecentlyAudioFragment;

import java.text.BreakIterator;

public class MeAudioActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageView meAudioReturn;
    private TextView meAudioLocalaudio;
    private TextView meAudioLoveaudio;
    private TextView meAudioRecentlyaudio;
    private FrameLayout meAudioFragment;
    private LocalAudioFragment mLocalAudioFragment;
    private LoveAudioFragment mLoveAudioFragment;
    private RecentlyAudioFragment mRecentlyAudioFragment;
    private FragmentManager mFragmentManager;
    private FragmentTransaction mFragmentTransaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me_audio);
        initViews();
        addListeners();
        //默认显示本地音频界面
        initDefault();
    }

    private void initDefault() {
        mFragmentManager = getSupportFragmentManager();
        mFragmentTransaction = mFragmentManager.beginTransaction();
        //默认显示本地音频界面
        mLocalAudioFragment = new LocalAudioFragment();
        mFragmentTransaction.add(R.id.me_audio_fragment,mLocalAudioFragment);
        mFragmentTransaction.commit();
        meAudioLocalaudio.setTextColor(getResources().getColor(R.color.me_top));
        meAudioLoveaudio.setTextColor(getResources().getColor(R.color.me_text_black));
        meAudioRecentlyaudio.setTextColor(getResources().getColor(R.color.me_text_black));
    }

    private void initViews() {
        meAudioReturn = (ImageView) findViewById(R.id.me_audio_return);
        meAudioLocalaudio = (TextView) findViewById(R.id.me_audio_localaudio);
        meAudioLoveaudio = (TextView) findViewById(R.id.me_audio_loveaudio);
        meAudioRecentlyaudio = (TextView) findViewById(R.id.me_audio_recentlyaudio);
        meAudioFragment = (FrameLayout) findViewById(R.id.me_audio_fragment);
    }
    private void addListeners() {
        meAudioReturn.setOnClickListener(this);
        meAudioLocalaudio.setOnClickListener(this);
        meAudioLoveaudio.setOnClickListener(this);
        meAudioRecentlyaudio.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.me_audio_return:
                finish();
                break;
            case R.id.me_audio_localaudio:
                //点击的本地音频
                meAudioLocalaudio.setTextColor(getResources().getColor(R.color.me_top));
                meAudioLoveaudio.setTextColor(getResources().getColor(R.color.me_text_black));
                meAudioRecentlyaudio.setTextColor(getResources().getColor(R.color.me_text_black));
                //设置当前碎片为本地音频碎片
                initFragment(R.id.me_audio_localaudio);
                break;
            case R.id.me_audio_loveaudio:
                //点击了我喜欢的
                meAudioLocalaudio.setTextColor(getResources().getColor(R.color.me_text_black));
                meAudioLoveaudio.setTextColor(getResources().getColor(R.color.me_top));
                meAudioRecentlyaudio.setTextColor(getResources().getColor(R.color.me_text_black));
                //设置当前碎片为我喜欢的碎片
                initFragment(R.id.me_audio_loveaudio);
                break;
            case R.id.me_audio_recentlyaudio:
                //点击了最近播放
                meAudioLocalaudio.setTextColor(getResources().getColor(R.color.me_text_black));
                meAudioLoveaudio.setTextColor(getResources().getColor(R.color.me_text_black));
                meAudioRecentlyaudio.setTextColor(getResources().getColor(R.color.me_top));
                //设置当前碎片为最近播放碎片
                initFragment(R.id.me_audio_recentlyaudio);
                break;
        }
    }
    private void initFragment(int id) {
        //隐藏所有已经添加到事务中的碎片
        hideChatFragments();
        mFragmentTransaction = mFragmentManager.beginTransaction();
        //判断当前碎片是哪一个
        switch (id) {
            case R.id.me_audio_localaudio:
                if(mLocalAudioFragment == null){
                    mLocalAudioFragment = new LocalAudioFragment();
                    mFragmentTransaction.add(R.id.me_audio_fragment,mLocalAudioFragment,"ibook");
                }else{
                    mFragmentTransaction.show(mLocalAudioFragment);
                }
                break;
            case R.id.me_audio_loveaudio:
                if(mLoveAudioFragment == null){
                    mLoveAudioFragment = new LoveAudioFragment();
                    mFragmentTransaction.add(R.id.me_audio_fragment,mLoveAudioFragment,"bookme");
                }else{
                    mFragmentTransaction.show(mLoveAudioFragment);
                }
                break;
            case R.id.me_audio_recentlyaudio:
                if(mRecentlyAudioFragment == null){
                    mRecentlyAudioFragment = new RecentlyAudioFragment();
                    mFragmentTransaction.add(R.id.me_audio_fragment,mRecentlyAudioFragment,"bookme");
                }else{
                    mFragmentTransaction.show(mRecentlyAudioFragment);
                }
                break;
        }
        mFragmentTransaction.commit();
    }
    //隐藏所有的碎片，首先需要知道碎片是否已经添加到事务中
    private void hideChatFragments() {
        mFragmentTransaction = mFragmentManager.beginTransaction();
        if(mLocalAudioFragment!=null && mLocalAudioFragment.isAdded()){
            mFragmentTransaction.hide(mLocalAudioFragment);
        }
        if(mLoveAudioFragment!=null && mLoveAudioFragment.isAdded()){
            mFragmentTransaction.hide(mLoveAudioFragment);
        }
        if(mRecentlyAudioFragment!=null && mRecentlyAudioFragment.isAdded()){
            mFragmentTransaction.hide(mRecentlyAudioFragment);
        }
        mFragmentTransaction.commit();
    }
}
