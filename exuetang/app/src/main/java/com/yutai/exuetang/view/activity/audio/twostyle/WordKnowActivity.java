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

public class WordKnowActivity extends AppCompatActivity {

    @Bind(R.id.audio_story_xuetang_back_image)
    ImageView mAudioStoryXuetangBackImage;
    @Bind(R.id.audio_twostyle_title)
    TextView mAudioTwostyleTitle;
    @Bind(R.id.audio_wordkonw_textview1)
    TextView mAudioWordkonwTextview1;
    @Bind(R.id.wordkonw_homoionym_textview)
    TextView mWordkonwHomoionymTextview;
    @Bind(R.id.wordkonw_sentence_textview)
    TextView mWordkonwSentenceTextview;
    @Bind(R.id.wordkonw_antonym_textview)
    TextView mWordkonwAntonymTextview;
    @Bind(R.id.wordkonw_bookreview_textview)
    TextView mWordkonwBookreviewTextview;
    @Bind(R.id.wordkonw_synonym_textview)
    TextView mWordkonwSynonymTextview;
    @Bind(R.id.wordkonw_xiehouyu_textview)
    TextView mWordkonwXiehouyuTextview;
    @Bind(R.id.audio_know_banner0)
    Banner mAudioHomeBanner;
    @Bind(R.id.audio_know_banner1)
    Banner mAudioHomeBanner1;
    //轮播图的图片地址
    String[] images1 = new String[]{"http://pic15.nipic.com/20110803/7929674_090036056357_2.jpg", "http://pic21.nipic.com/20120525/9894811_180438440328_2.jpg", "http://pic.58pic.com/58pic/11/30/16/73d58PICPIZ.jpg", "http://i0.letvimg.com/cms/201406/04/0b35ddfe94174f03a7bf984e63309a0e.jpg"};

    private String type1 = "字词知识";
    private String type2 = "近义词";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_know);
        ButterKnife.bind(this);
        initWordStyleType();
        mAudioTwostyleTitle.setText(type1);
    }

    private void initWordStyleType() {
        mAudioTwostyleTitle.setTypeface(MyApplication.sTypeface);
        mAudioWordkonwTextview1.setTypeface(MyApplication.sTypeface);
        mWordkonwHomoionymTextview.setTypeface(MyApplication.sTypeface);
        mWordkonwSentenceTextview.setTypeface(MyApplication.sTypeface);
        mWordkonwAntonymTextview.setTypeface(MyApplication.sTypeface);
        mWordkonwBookreviewTextview.setTypeface(MyApplication.sTypeface);
        mWordkonwSynonymTextview.setTypeface(MyApplication.sTypeface);
        mWordkonwXiehouyuTextview.setTypeface(MyApplication.sTypeface);
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
                Glide.with(WordKnowActivity.this).load(url).into(view);
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
                Glide.with(WordKnowActivity.this).load(url).into(view);
            }
        });
    }

    @OnClick({R.id.audio_story_xuetang_back_image, R.id.wordkonw_homoionym_textview, R.id.wordkonw_sentence_textview, R.id.wordkonw_antonym_textview, R.id.wordkonw_bookreview_textview, R.id.wordkonw_synonym_textview, R.id.wordkonw_xiehouyu_textview})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.audio_story_xuetang_back_image:
                finish();
                break;
            case R.id.wordkonw_homoionym_textview:
                type2 = mWordkonwHomoionymTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.wordkonw_sentence_textview:
                type2 = mWordkonwSentenceTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.wordkonw_antonym_textview:
                type2 = mWordkonwAntonymTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.wordkonw_bookreview_textview:
                type2 = mWordkonwBookreviewTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.wordkonw_synonym_textview:
                type2 = mWordkonwSynonymTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.wordkonw_xiehouyu_textview:
                type2 = mWordkonwXiehouyuTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
        }
    }
}
