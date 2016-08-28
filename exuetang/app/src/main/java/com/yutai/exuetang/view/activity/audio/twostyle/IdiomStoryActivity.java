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

public class IdiomStoryActivity extends AppCompatActivity {
    @Bind(R.id.audio_story_xuetang_back_image)
    ImageView mAudioStoryXuetangBackImage;
    @Bind(R.id.audio_twostyle_title)
    TextView mAudioTwostyleTitle;
    @Bind(R.id.audio_idiomstory_textview1)
    TextView mAudioIdiomstoryTextview1;
    @Bind(R.id.idiomstory_yuyan_textview)
    TextView mIdiomstoryYuyanTextview;
    @Bind(R.id.idiomstory_sanguo_textview)
    TextView mIdiomstorySanguoTextview;
    @Bind(R.id.idiomstory_history_textview)
    TextView mIdiomstoryHistoryTextview;
    @Bind(R.id.idiomstory_warfare_textview)
    TextView mIdiomstoryWarfareTextview;
    @Bind(R.id.idiomstory_myth_textview)
    TextView mIdiomstoryMythTextview;
    @Bind(R.id.idiomstory_lizhi_textview)
    TextView mIdiomstoryLizhiTextview;
    @Bind(R.id.audio_idio_banner0)
    Banner mAudioHomeBanner;
    @Bind(R.id.audio_idio_banner1)
    Banner mAudioHomeBanner1;
    //轮播图的图片地址
    String[] images1 = new String[]{"http://pic15.nipic.com/20110803/7929674_090036056357_2.jpg", "http://pic21.nipic.com/20120525/9894811_180438440328_2.jpg", "http://pic.58pic.com/58pic/11/30/16/73d58PICPIZ.jpg", "http://i0.letvimg.com/cms/201406/04/0b35ddfe94174f03a7bf984e63309a0e.jpg"};

    //    成语故事
    private String type1 = "成语故事";
    private String type2 = "寓言故事    ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_idiom_story);
        ButterKnife.bind(this);
        initWordStyleType();
        mAudioTwostyleTitle.setText(type1);
    }

    private void initWordStyleType() {
        mAudioTwostyleTitle.setTypeface(MyApplication.sTypeface);
        mAudioIdiomstoryTextview1.setTypeface(MyApplication.sTypeface);
        mIdiomstoryYuyanTextview.setTypeface(MyApplication.sTypeface);
        mIdiomstorySanguoTextview.setTypeface(MyApplication.sTypeface);
        mIdiomstoryHistoryTextview.setTypeface(MyApplication.sTypeface);
        mIdiomstoryWarfareTextview.setTypeface(MyApplication.sTypeface);
        mIdiomstoryMythTextview.setTypeface(MyApplication.sTypeface);
        mIdiomstoryLizhiTextview.setTypeface(MyApplication.sTypeface);
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
                Glide.with(IdiomStoryActivity.this).load(url).into(view);
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
                Glide.with(IdiomStoryActivity.this).load(url).into(view);
            }
        });
    }

    @OnClick({R.id.audio_story_xuetang_back_image, R.id.idiomstory_yuyan_textview, R.id.idiomstory_sanguo_textview, R.id.idiomstory_history_textview, R.id.idiomstory_warfare_textview, R.id.idiomstory_myth_textview, R.id.idiomstory_lizhi_textview})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.audio_story_xuetang_back_image:
                finish();
                break;
            case R.id.idiomstory_yuyan_textview:
                type2 = mIdiomstoryYuyanTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.idiomstory_sanguo_textview:
                type2 = mIdiomstorySanguoTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.idiomstory_history_textview:
                type2 = mIdiomstoryHistoryTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.idiomstory_warfare_textview:
                type2 = mIdiomstoryWarfareTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.idiomstory_myth_textview:
                type2 = mIdiomstoryMythTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.idiomstory_lizhi_textview:
                type2 = mIdiomstoryLizhiTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
        }
    }
}
