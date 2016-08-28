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

public class GuoXueXuetangActivity extends AppCompatActivity {

    @Bind(R.id.audio_story_xuetang_back_image)
    ImageView mAudioStoryXuetangBackImage;
    @Bind(R.id.audio_twostyle_title)
    TextView mAudioTwostyleTitle;
    @Bind(R.id.audio_guoxue_xuetang_textview1)
    TextView mAudioGuoxueXuetangTextview1;
    @Bind(R.id.guoxue_lunyu_textview)
    TextView mGuoxueLunyuTextview;
    @Bind(R.id.guoxue_zhuangzi_textview)
    TextView mGuoxueZhuangziTextview;
    @Bind(R.id.guoxue_mengzi_textview)
    TextView mGuoxueMengziTextview;
    @Bind(R.id.guoxue_daxue_textview)
    TextView mGuoxueDaxueTextview;
    @Bind(R.id.guoxue_laozi_textview)
    TextView mGuoxueLaoziTextview;
    @Bind(R.id.guoxue_zhongyong_textview)
    TextView mGuoxueZhongyongTextview;
    @Bind(R.id.guoxue_dizigui_textview)
    TextView mGuoxueDiziguiTextview;
    @Bind(R.id.guoxue_sanzijing_textview)
    TextView mGuoxueSanzijingTextview;
    @Bind(R.id.guoxue_daodejing_textview)
    TextView mGuoxueDaodejingTextview;
    @Bind(R.id.guoxue_shijing_textview)
    TextView mGuoxueShijingTextview;
    @Bind(R.id.audio_guoxue_xuetang_textview2)
    TextView mAudioGuoxueXuetangTextview2;
    @Bind(R.id.guoxue_sunzi_textview)
    TextView mGuoxueSunziTextview;
    @Bind(R.id.guoxue_yangsheng_textview)
    TextView mGuoxueYangshengTextview;
    @Bind(R.id.guoxue_yijing_textview)
    TextView mGuoxueYijingTextview;
    @Bind(R.id.guoxue_zhuzigeyang_textview)
    TextView mGuoxueZhuzigeyangTextview;
    @Bind(R.id.guoxue_sahngshu_textview)
    TextView mGuoxueSahngshuTextview;
    @Bind(R.id.guoxue_zuoyouming_textview)
    TextView mGuoxueZuoyoumingTextview;
    @Bind(R.id.audio_guoxue_banner0)
    Banner mAudioHomeBanner;
    @Bind(R.id.audio_guoxue_banner1)
    Banner mAudioHomeBanner1;
    //轮播图的图片地址
    String[] images1 = new String[]{"http://pic15.nipic.com/20110803/7929674_090036056357_2.jpg", "http://pic21.nipic.com/20120525/9894811_180438440328_2.jpg", "http://pic.58pic.com/58pic/11/30/16/73d58PICPIZ.jpg", "http://i0.letvimg.com/cms/201406/04/0b35ddfe94174f03a7bf984e63309a0e.jpg"};

    private String type1 = "国学学堂";
    private String type2 = "论语";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guo_xue_xuetang);
        ButterKnife.bind(this);
        initWordStyleType();
        mAudioTwostyleTitle.setText(type1);
    }

    private void initWordStyleType() {
        mAudioGuoxueXuetangTextview1.setTypeface(MyApplication.sTypeface);
        mGuoxueLunyuTextview.setTypeface(MyApplication.sTypeface);
        mGuoxueZhuangziTextview.setTypeface(MyApplication.sTypeface);
        mGuoxueMengziTextview.setTypeface(MyApplication.sTypeface);
        mGuoxueDaxueTextview.setTypeface(MyApplication.sTypeface);
        mGuoxueLaoziTextview.setTypeface(MyApplication.sTypeface);
        mGuoxueZhongyongTextview.setTypeface(MyApplication.sTypeface);
        mGuoxueDiziguiTextview.setTypeface(MyApplication.sTypeface);
        mGuoxueSanzijingTextview.setTypeface(MyApplication.sTypeface);
        mGuoxueDaodejingTextview.setTypeface(MyApplication.sTypeface);
        mGuoxueShijingTextview.setTypeface(MyApplication.sTypeface);
        mAudioGuoxueXuetangTextview2.setTypeface(MyApplication.sTypeface);
        mGuoxueSunziTextview.setTypeface(MyApplication.sTypeface);
        mGuoxueYangshengTextview.setTypeface(MyApplication.sTypeface);
        mGuoxueYijingTextview.setTypeface(MyApplication.sTypeface);
        mGuoxueZhuzigeyangTextview.setTypeface(MyApplication.sTypeface);
        mGuoxueSahngshuTextview.setTypeface(MyApplication.sTypeface);
        mGuoxueZuoyoumingTextview.setTypeface(MyApplication.sTypeface);
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
                Glide.with(GuoXueXuetangActivity.this).load(url).into(view);
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
                Glide.with(GuoXueXuetangActivity.this).load(url).into(view);
            }
        });
    }

    @OnClick({R.id.audio_story_xuetang_back_image, R.id.guoxue_lunyu_textview, R.id.guoxue_zhuangzi_textview, R.id.guoxue_mengzi_textview, R.id.guoxue_daxue_textview, R.id.guoxue_laozi_textview, R.id.guoxue_zhongyong_textview, R.id.guoxue_dizigui_textview, R.id.guoxue_sanzijing_textview, R.id.guoxue_daodejing_textview, R.id.guoxue_shijing_textview, R.id.guoxue_sunzi_textview, R.id.guoxue_yangsheng_textview, R.id.guoxue_yijing_textview, R.id.guoxue_zhuzigeyang_textview, R.id.guoxue_sahngshu_textview, R.id.guoxue_zuoyouming_textview})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.audio_story_xuetang_back_image:
                finish();
                break;
            case R.id.guoxue_lunyu_textview:
                type2 = mGuoxueLunyuTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.guoxue_zhuangzi_textview:
                type2 = mGuoxueLunyuTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.guoxue_mengzi_textview:
                type2 = mGuoxueLunyuTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.guoxue_daxue_textview:
                type2 = mGuoxueLunyuTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.guoxue_laozi_textview:
                type2 = mGuoxueLunyuTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.guoxue_zhongyong_textview:
                type2 = mGuoxueLunyuTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.guoxue_dizigui_textview:
                type2 = mGuoxueLunyuTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.guoxue_sanzijing_textview:
                type2 = mGuoxueLunyuTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.guoxue_daodejing_textview:
                type2 = mGuoxueLunyuTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.guoxue_shijing_textview:
                type2 = mGuoxueLunyuTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.guoxue_sunzi_textview:
                type2 = mGuoxueLunyuTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.guoxue_yangsheng_textview:
                type2 = mGuoxueLunyuTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.guoxue_yijing_textview:
                type2 = mGuoxueLunyuTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.guoxue_zhuzigeyang_textview:
                type2 = mGuoxueLunyuTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.guoxue_sahngshu_textview:
                type2 = mGuoxueLunyuTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.guoxue_zuoyouming_textview:
                type2 = mGuoxueLunyuTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
        }
    }
}
