package com.yutai.audio.view.fragment;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.yutai.audio.R;
import com.yutai.audio.utils.MyTextView;
import com.yutai.audio.utils.ToastUtils;
import com.yutai.audio.view.activity.LoginActivity;
import com.yutai.audio.view.adapter.MeFragmentAdapter;

import java.util.ArrayList;

/**
 * Created by ZFG on 2016/7/13.
 */
public class MeFragment extends Fragment implements View.OnClickListener{
    View mView;
    private LinearLayout mePerimeter;
    private ImageView meSet;
    private RelativeLayout meUserInfolayout;
    private ImageView meUserPhoto;
    private MyTextView meUserNickname;
    private MyTextView meUserContent;
    private LinearLayout meLike;
    private LinearLayout meRecentplay;
    private LinearLayout meDownloading;
    private LinearLayout meTiming;
    private LinearLayout meCoins;
    private MyTextView meLocalaudio;
    private MyTextView meLocalvideo;
    private ArrayList fragments;
    private ViewPager meAudioViewpager;
    MeFragmentAdapter mMeFragmentAdapter;
    FragmentManager mFragmentManager;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_me, null);
        initViews();
        addListeners();
        initViewPager();
        return mView;
    }



    private void addListeners() {
        mePerimeter.setOnClickListener(this);
        meSet.setOnClickListener(this);
        meUserInfolayout.setOnClickListener(this);
        meLike.setOnClickListener(this);
        meRecentplay.setOnClickListener(this);
        meDownloading.setOnClickListener(this);
        meTiming.setOnClickListener(this);
        meCoins.setOnClickListener(this);
        meLocalaudio.setOnClickListener(this);
        meLocalvideo.setOnClickListener(this);
    }

    private void initViews() {
        //设置字体为自定义字体
        //Typeface customFont = Typeface.createFromAsset(getActivity().getAssets(), "fonts/myFont.ttf");
        mePerimeter = (LinearLayout) mView.findViewById(R.id.me_perimeter);
        meSet = (ImageView) mView.findViewById(R.id.me_set);
        meUserInfolayout = (RelativeLayout) mView.findViewById(R.id.me_user_infolayout);
        meUserPhoto = (ImageView) mView.findViewById(R.id.me_user_photo);
        meUserNickname = (MyTextView) mView.findViewById(R.id.me_user_nickname);
        meUserContent = (MyTextView) mView.findViewById(R.id.me_user_content);
        meLike = (LinearLayout) mView.findViewById(R.id.me_like);
        meRecentplay = (LinearLayout) mView.findViewById(R.id.me_recentplay);
        meDownloading = (LinearLayout) mView.findViewById(R.id.me_downloading);
        meTiming = (LinearLayout) mView.findViewById(R.id.me_timing);
        meCoins = (LinearLayout) mView.findViewById(R.id.me_coins);
        meLocalaudio = (MyTextView) mView.findViewById(R.id.me_localaudio);
        meLocalvideo = (MyTextView) mView.findViewById(R.id.me_localvideo);
        meAudioViewpager = (ViewPager) mView.findViewById(R.id.me_audio_viewpager);
        //设置字体为自定义字体
        //meLocalaudio.setTypeface(customFont);
    }
    private void initViewPager() {
        fragments = new ArrayList<Fragment>();
        Fragment meLocalAudioFragment = new MeLocalAudioFragment();
        Fragment meLocalVideoFragment = new MeLocalVideoFragment();
        fragments.add(meLocalAudioFragment);
        fragments.add(meLocalVideoFragment);
        mFragmentManager = getActivity().getSupportFragmentManager();
        mMeFragmentAdapter = new MeFragmentAdapter(mFragmentManager,fragments);
        meAudioViewpager.setAdapter(mMeFragmentAdapter);
        meAudioViewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                //滑动时设置监听
            }

            @Override
            public void onPageSelected(int position) {
                //选择时
                if(position == 0){
                    meLocalaudio.setTextColor(getResources().getColor(R.color.me_text_color));
                    meLocalvideo.setTextColor(getResources().getColor(R.color.me_text_black));
                }else if(position == 1){
                    meLocalaudio.setTextColor(getResources().getColor(R.color.me_text_black));
                    meLocalvideo.setTextColor(getResources().getColor(R.color.me_text_color));
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                //更改滑动状态时
            }
        });
    }
    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.me_perimeter:
                //点击了周边的事件监听
                ToastUtils.showToast(getActivity(),"点击了周边");
                break;
            case R.id.me_set:
                //点击了设置的事件监听
                ToastUtils.showToast(getActivity(),"点击了设置");
                Intent intent = new Intent();
                intent.setClass(getActivity(), LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.me_user_infolayout:
                //点击了用户信息的事件监听
                ToastUtils.showToast(getActivity(),"点击了用户信息");
                break;
            case R.id.me_like:
                //点击了喜欢的事件监听
                ToastUtils.showToast(getActivity(),"点击了喜欢");
                break;
            case R.id.me_recentplay:
                //点击了最近播放的事件监听
                ToastUtils.showToast(getActivity(),"点击了最近播放");
                break;
            case R.id.me_downloading:
                //点击了正在下载的事件监听
                ToastUtils.showToast(getActivity(),"点击了正在下载");
                break;
            case R.id.me_timing:
                //点击了定时的事件监听
                ToastUtils.showToast(getActivity(),"点击了定时");
                break;
            case R.id.me_coins:
                //点击了金币的事件监听
                ToastUtils.showToast(getActivity(),"点击了金币");
                break;
            case R.id.me_localaudio:
                //点击了本地音频的事件监听
                ToastUtils.showToast(getActivity(),"点击了本地音频");
                meLocalaudio.setTextColor(getResources().getColor(R.color.me_text_color));
                meLocalvideo.setTextColor(getResources().getColor(R.color.me_text_black));
                meAudioViewpager.setCurrentItem(0);
                break;
            case R.id.me_localvideo:
                //点击了本地视频的事件监听
                ToastUtils.showToast(getActivity(),"点击了本地视频");
                meLocalaudio.setTextColor(getResources().getColor(R.color.me_text_black));
                meLocalvideo.setTextColor(getResources().getColor(R.color.me_text_color));
                meAudioViewpager.setCurrentItem(1);
                break;
        }
    }
}
