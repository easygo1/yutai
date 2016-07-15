package com.yutai.audio.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.yutai.audio.R;
import com.yutai.audio.utils.ToastUtils;
import com.yutai.audio.view.activity.AudioTwoStyleActivity;

/**
 * Created by ZFG on 2016/7/13.
 */
public class AudioFragment extends Fragment implements View.OnClickListener {
    private Banner banner1, banner2;//上下轮播图
    //轮播图的图片地址
    String[] images1 = new String[]{"http://pic.yesky.com/uploadImages/2015/126/48/0S0NK034NU00.jpg", "http://pic1a.nipic.com/2008-12-01/2008121175139413_2.jpg", "http://pic56.nipic.com/file/20141227/19674963_215052431000_2.jpg"};
    String[] images2 = new String[]{"http://img3.imgtn.bdimg.com/it/u=3674146550,234257485&fm=21&gp=0.jpg", "http://img5.imgtn.bdimg.com/it/u=2225210172,4016732493&fm=21&gp=0.jpg"};
    // String[] titles=new String[]{"标题"};
    View mView;
    private TextView mCompetitionTextView;
    private LinearLayout mStyle1LinearLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_audio, null);
        initViews();
        initListener();
        return mView;
    }

    private void initViews() {
        banner1 = (Banner) mView.findViewById(R.id.banner);
        //显示小圆点
        banner1.setBannerStyle(Banner.CIRCLE_INDICATOR);
        //设置小圆点在中间
        banner1.setIndicatorGravity(Banner.CENTER);
        //设置轮播图片间隔时间（默认为2000）
        banner1.setDelayTime(5000);
        //设置点击事件
        banner1.setOnBannerClickListener(new Banner.OnBannerClickListener() {
            @Override
            public void OnBannerClick(View view, int position) {
                //position从1开始
                ToastUtils.showToast(getActivity(), "单击了广告" + position);
            }
        });
        //设置轮播图片（所有设置参数方法都放在此方法之前执行）
        banner1.setImages(images1, new Banner.OnLoadImageListener() {
            @Override
            public void OnLoadImage(ImageView view, Object url) {
                Glide.with(getActivity().getApplicationContext()).load(url).into(view);
            }
        });

        banner2 = (Banner) mView.findViewById(R.id.banner2);
        //显示小圆点
        banner2.setBannerStyle(Banner.CIRCLE_INDICATOR);
        //设置小圆点在中间
        banner2.setIndicatorGravity(Banner.CENTER);
        //设置轮播图片间隔时间（默认为2000）
        banner2.setDelayTime(3000);
        //设置点击事件
        banner2.setOnBannerClickListener(new Banner.OnBannerClickListener() {
            @Override
            public void OnBannerClick(View view, int position) {
                //position从1开始
                ToastUtils.showToast(getActivity(), "单击了广告" + position);
            }
        });
        //设置轮播图片（所有设置参数方法都放在此方法之前执行）
        banner2.setImages(images2, new Banner.OnLoadImageListener() {
            @Override
            public void OnLoadImage(ImageView view, Object url) {
                Glide.with(getActivity().getApplicationContext()).load(url).into(view);
            }
        });
        mCompetitionTextView = (TextView) mView.findViewById(R.id.competition_textview);
        mStyle1LinearLayout = (LinearLayout) mView.findViewById(R.id.style1_linelayout);
    }

    private void initListener() {
        mCompetitionTextView.setOnClickListener(this);
        mStyle1LinearLayout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.competition_textview:
                //大赛
                ToastUtils.showToast(getActivity(), "大赛");
                break;
            case R.id.style1_linelayout:
                //分类一
                ToastUtils.showToast(getActivity(), "分类一");
                //跳转页面
                Intent intent = new Intent();
                intent.setClass(getActivity(), AudioTwoStyleActivity.class);
                startActivity(intent);
                break;
        }
    }
}
