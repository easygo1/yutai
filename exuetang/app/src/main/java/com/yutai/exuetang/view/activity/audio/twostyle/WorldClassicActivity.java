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

public class WorldClassicActivity extends AppCompatActivity {
    @Bind(R.id.audio_story_xuetang_back_image)
    ImageView mAudioStoryXuetangBackImage;
    @Bind(R.id.audio_twostyle_title)
    TextView mAudioTwostyleTitle;
    @Bind(R.id.audio_world_classic_textview1)
    TextView mAudioWorldClassicTextview1;
    @Bind(R.id.world_classic_greek_textview)
    TextView mWorldClassicGreekTextview;
    @Bind(R.id.world_classic_france_textview)
    TextView mWorldClassicFranceTextview;
    @Bind(R.id.world_classic_britain_textview)
    TextView mWorldClassicBritainTextview;
    @Bind(R.id.world_classic_russia_textview)
    TextView mWorldClassicRussiaTextview;
    @Bind(R.id.world_classic_usa_sense_textview)
    TextView mWorldClassicUsaSenseTextview;
    @Bind(R.id.world_classic_austria_poland_textview)
    TextView mWorldClassicAustriaPolandTextview;
    @Bind(R.id.world_classic_spain_textview)
    TextView mWorldClassicSpainTextview;
    @Bind(R.id.world_classic_italy_textview)
    TextView mWorldClassicItalyTextview;
    @Bind(R.id.world_classic_latin_america_textview)
    TextView mWorldClassicLatinAmericaTextview;
    @Bind(R.id.world_classic_arab_textview)
    TextView mWorldClassicArabTextview;
    @Bind(R.id.audio_world_classic_textview2)
    TextView mAudioWorldClassicTextview2;
    @Bind(R.id.world_classic_denmark_art_textview)
    TextView mWorldClassicDenmarkArtTextview;
    @Bind(R.id.world_classic_japan_textview)
    TextView mWorldClassicJapanTextview;
    @Bind(R.id.world_classic_australia_country_textview)
    TextView mWorldClassicAustraliaCountryTextview;
    @Bind(R.id.world_classic_persia_textview)
    TextView mWorldClassicPersiaTextview;
    @Bind(R.id.world_classic_india_history_textview)
    TextView mWorldClassicIndiaHistoryTextview;
    @Bind(R.id.world_classic_sweden_geography_textview)
    TextView mWorldClassicSwedenGeographyTextview;
    @Bind(R.id.world_classic_lebanon_textview)
    TextView mWorldClassicLebanonTextview;
    @Bind(R.id.audio_world_banner0)
    Banner mAudioHomeBanner;
    @Bind(R.id.audio_world_banner1)
    Banner mAudioHomeBanner1;
    //轮播图的图片地址
    String[] images1 = new String[]{"http://pic15.nipic.com/20110803/7929674_090036056357_2.jpg", "http://pic21.nipic.com/20120525/9894811_180438440328_2.jpg", "http://pic.58pic.com/58pic/11/30/16/73d58PICPIZ.jpg", "http://i0.letvimg.com/cms/201406/04/0b35ddfe94174f03a7bf984e63309a0e.jpg"};

    private String type1 = "世界名著";
    private String type2 = "古希腊";
    //世界名著
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_world_classic);
        ButterKnife.bind(this);
        initWordStyleType();
        mAudioTwostyleTitle.setText(type1);
    }

    private void initWordStyleType() {
        mAudioTwostyleTitle.setTypeface(MyApplication.sTypeface);
        mAudioWorldClassicTextview1.setTypeface(MyApplication.sTypeface);
        mWorldClassicGreekTextview.setTypeface(MyApplication.sTypeface);
        mWorldClassicFranceTextview.setTypeface(MyApplication.sTypeface);
        mWorldClassicBritainTextview.setTypeface(MyApplication.sTypeface);
        mWorldClassicRussiaTextview.setTypeface(MyApplication.sTypeface);
        mWorldClassicUsaSenseTextview.setTypeface(MyApplication.sTypeface);
        mWorldClassicAustriaPolandTextview.setTypeface(MyApplication.sTypeface);
        mWorldClassicSpainTextview.setTypeface(MyApplication.sTypeface);
        mWorldClassicItalyTextview.setTypeface(MyApplication.sTypeface);
        mWorldClassicLatinAmericaTextview.setTypeface(MyApplication.sTypeface);
        mWorldClassicArabTextview.setTypeface(MyApplication.sTypeface);
        mAudioWorldClassicTextview2.setTypeface(MyApplication.sTypeface);
        mWorldClassicDenmarkArtTextview.setTypeface(MyApplication.sTypeface);
        mWorldClassicJapanTextview.setTypeface(MyApplication.sTypeface);
        mWorldClassicAustraliaCountryTextview.setTypeface(MyApplication.sTypeface);
        mWorldClassicPersiaTextview.setTypeface(MyApplication.sTypeface);
        mWorldClassicIndiaHistoryTextview.setTypeface(MyApplication.sTypeface);
        mWorldClassicSwedenGeographyTextview.setTypeface(MyApplication.sTypeface);
        mWorldClassicLebanonTextview.setTypeface(MyApplication.sTypeface);
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
                Glide.with(WorldClassicActivity.this).load(url).into(view);
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
                Glide.with(WorldClassicActivity.this).load(url).into(view);
            }
        });
    }

    @OnClick({R.id.audio_story_xuetang_back_image, R.id.world_classic_greek_textview, R.id.world_classic_france_textview, R.id.world_classic_britain_textview, R.id.world_classic_russia_textview, R.id.world_classic_usa_sense_textview, R.id.world_classic_austria_poland_textview, R.id.world_classic_spain_textview, R.id.world_classic_italy_textview, R.id.world_classic_latin_america_textview, R.id.world_classic_arab_textview, R.id.world_classic_denmark_art_textview, R.id.world_classic_japan_textview, R.id.world_classic_australia_country_textview, R.id.world_classic_persia_textview, R.id.world_classic_india_history_textview, R.id.world_classic_sweden_geography_textview, R.id.world_classic_lebanon_textview})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.audio_story_xuetang_back_image:
                finish();
                break;
            case R.id.world_classic_greek_textview:
                type2 = mWorldClassicGreekTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.world_classic_france_textview:
                type2 = mWorldClassicFranceTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.world_classic_britain_textview:
                type2 = mWorldClassicBritainTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.world_classic_russia_textview:
                type2 = mWorldClassicRussiaTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.world_classic_usa_sense_textview:
                type2 = mWorldClassicUsaSenseTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.world_classic_austria_poland_textview:
                type2 = mWorldClassicAustriaPolandTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.world_classic_spain_textview:
                type2 = mWorldClassicSpainTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.world_classic_italy_textview:
                type2 = mWorldClassicItalyTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.world_classic_latin_america_textview:
                type2 = mWorldClassicLatinAmericaTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.world_classic_arab_textview:
                type2 = mWorldClassicArabTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.world_classic_denmark_art_textview:
                type2 = mWorldClassicDenmarkArtTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.world_classic_japan_textview:
                type2 = mWorldClassicJapanTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.world_classic_australia_country_textview:
                type2 = mWorldClassicAustraliaCountryTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.world_classic_persia_textview:
                type2 = mWorldClassicPersiaTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.world_classic_india_history_textview:
                type2 = mWorldClassicIndiaHistoryTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.world_classic_sweden_geography_textview:
                type2 = mWorldClassicSwedenGeographyTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.world_classic_lebanon_textview:
                type2 = mWorldClassicLebanonTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
        }
    }
}
