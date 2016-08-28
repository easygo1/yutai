package com.yutai.exuetang.view.activity.audio.twostyle;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.yutai.exuetang.R;
import com.yutai.exuetang.utils.IntentTwoStyleActivityUtils;
import com.yutai.exuetang.view.application.MyApplication;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ChildSongXuetangActivity extends AppCompatActivity {
    /**
     * 儿歌学堂页面
     */
    @Bind(R.id.audio_childsong_xuetang_back_image)
    ImageView mAudioChildsongXuetangBackImage;
    @Bind(R.id.audio_childsongxuetang_textview1)
    TextView mAudioChildsongxuetangTextview1;
    @Bind(R.id.childsong_jingdian_textview)
    TextView mChildsongJingdianTextview;
    @Bind(R.id.childsong_dance_textview)
    TextView mChildsongDanceTextview;
    @Bind(R.id.childsong_chuanshao_textview)
    TextView mChildsongChuanshaoTextview;
    @Bind(R.id.childsong_english_textview)
    TextView mChildsongEnglishTextview;
    @Bind(R.id.childsong_fashion_textview)
    TextView mChildsongFashionTextview;
    @Bind(R.id.childsong_pome_textview)
    TextView mChildsongPomeTextview;
    @Bind(R.id.audio_childsong_world_banner0)
    Banner mAudioHomeBanner;
    @Bind(R.id.audio_childsong_world_banner1)
    Banner mAudioHomeBanner1;
    //轮播图的图片地址
    String[] images1 = new String[]{"http://pic15.nipic.com/20110803/7929674_090036056357_2.jpg", "http://pic21.nipic.com/20120525/9894811_180438440328_2.jpg", "http://pic.58pic.com/58pic/11/30/16/73d58PICPIZ.jpg", "http://i0.letvimg.com/cms/201406/04/0b35ddfe94174f03a7bf984e63309a0e.jpg"};

    private String type1 = "儿歌学堂";
    private String type2 = "经典儿歌";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_song_xuetang);
        ButterKnife.bind(this);
        initWordStyleType();
    }

    private void initWordStyleType() {
        mAudioChildsongxuetangTextview1.setTypeface(MyApplication.sTypeface);
        mChildsongJingdianTextview.setTypeface(MyApplication.sTypeface);
        mChildsongDanceTextview.setTypeface(MyApplication.sTypeface);
        mChildsongChuanshaoTextview.setTypeface(MyApplication.sTypeface);
        mChildsongEnglishTextview.setTypeface(MyApplication.sTypeface);
        mChildsongFashionTextview.setTypeface(MyApplication.sTypeface);
        mChildsongPomeTextview.setTypeface(MyApplication.sTypeface);
        //设置轮播图圆点样式
        //显示小圆点
        mAudioHomeBanner.setBannerStyle(Banner.CIRCLE_INDICATOR);
        //设置小圆点在中间
        mAudioHomeBanner.setIndicatorGravity(Banner.CENTER);
        //设置轮播图片间隔时间（默认为2000）
        mAudioHomeBanner.setDelayTime(5000);
        //设置点击事件
        mAudioHomeBanner.setOnBannerClickListener(new Banner.OnBannerClickListener() {
            @Override
            public void OnBannerClick(View view, int position) {
//                show("单击了广告" + position);
            }
        });
        //设置轮播图片（所有设置参数方法都放在此方法之前执行）
        mAudioHomeBanner.setImages(images1, new Banner.OnLoadImageListener() {
            @Override
            public void OnLoadImage(ImageView view, Object url) {
                Glide.with(ChildSongXuetangActivity.this).load(url).into(view);
            }
        });
        //设置轮播图圆点样式
        //显示小圆点
        mAudioHomeBanner1.setBannerStyle(Banner.CIRCLE_INDICATOR);
        //设置小圆点在中间
        mAudioHomeBanner1.setIndicatorGravity(Banner.CENTER);
        //设置轮播图片间隔时间（默认为2000）
        mAudioHomeBanner1.setDelayTime(5000);
        //设置点击事件
        mAudioHomeBanner1.setOnBannerClickListener(new Banner.OnBannerClickListener() {
            @Override
            public void OnBannerClick(View view, int position) {
//                show("单击了广告" + position);
            }
        });
        //设置轮播图片（所有设置参数方法都放在此方法之前执行）
        mAudioHomeBanner1.setImages(images1, new Banner.OnLoadImageListener() {
            @Override
            public void OnLoadImage(ImageView view, Object url) {
                Glide.with(ChildSongXuetangActivity.this).load(url).into(view);
            }
        });
    }

    @OnClick({R.id.audio_childsong_xuetang_back_image, R.id.childsong_jingdian_textview, R.id.childsong_dance_textview, R.id.childsong_chuanshao_textview, R.id.childsong_english_textview, R.id.childsong_fashion_textview, R.id.childsong_pome_textview})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.audio_childsong_xuetang_back_image:
                finish();
                break;
            case R.id.childsong_jingdian_textview:
                type2 = mChildsongJingdianTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.childsong_dance_textview:
                type2 = mChildsongDanceTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.childsong_chuanshao_textview:
                type2 = mChildsongChuanshaoTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.childsong_english_textview:
                type2 = mChildsongEnglishTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.childsong_fashion_textview:
                type2 = mChildsongFashionTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.childsong_pome_textview:
                type2 = mChildsongPomeTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
        }
    }
}
