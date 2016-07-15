package com.yutai.audio.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.yutai.audio.R;
import com.yutai.audio.utils.ToastUtils;

/**
 * Created by ZFG on 2016/7/13.
 */
public class AudioFragment extends Fragment {
    private Banner banner;
    //轮播图的图片地址
    String[] images = new String[]{"http://pic.yesky.com/uploadImages/2015/126/48/0S0NK034NU00.jpg", "http://pic1a.nipic.com/2008-12-01/2008121175139413_2.jpg", "http://pic56.nipic.com/file/20141227/19674963_215052431000_2.jpg"};
    // String[] titles=new String[]{"标题"};
    View mView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_audio, null);
        initViews();
        return mView;
    }

    private void initViews() {
        banner = (Banner) mView.findViewById(R.id.banner);
        //显示小圆点
        banner.setBannerStyle(Banner.CIRCLE_INDICATOR);
        //设置小圆点在中间
        banner.setIndicatorGravity(Banner.CENTER);
        //设置轮播图片间隔时间（默认为2000）
        banner.setDelayTime(5000);
        //设置点击事件
        banner.setOnBannerClickListener(new Banner.OnBannerClickListener() {
            @Override
            public void OnBannerClick(View view, int position) {
                //position从1开始
                ToastUtils.showToast(getActivity(), "单击了" + position);
            }
        });
        //设置轮播图片（所有设置参数方法都放在此方法之前执行）
        banner.setImages(images, new Banner.OnLoadImageListener() {
            @Override
            public void OnLoadImage(ImageView view, Object url) {
                Glide.with(getActivity().getApplicationContext()).load(url).into(view);
            }
        });
    }
}
