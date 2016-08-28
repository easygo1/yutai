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

public class AnimalWorldActivity extends AppCompatActivity {

    @Bind(R.id.audio_story_xuetang_back_image)
    ImageView mAudioStoryXuetangBackImage;
    @Bind(R.id.audio_twostyle_title)
    TextView mAudioTwostyleTitle;
    @Bind(R.id.audio_animal_world_textview1)
    TextView mAudioAnimalWorldTextview1;
    @Bind(R.id.animal_world_crawl_textview)
    TextView mAnimalWorldCrawlTextview;
    @Bind(R.id.animal_world_insect_textview)
    TextView mAnimalWorldInsectTextview;
    @Bind(R.id.animal_world_fly_textview)
    TextView mAnimalWorldFlyTextview;
    @Bind(R.id.animal_world_poultry_textview)
    TextView mAnimalWorldPoultryTextview;
    @Bind(R.id.animal_world_lactation_textview)
    TextView mAnimalWorldLactationTextview;
    @Bind(R.id.animal_world_fish_textview)
    TextView mAnimalWorldFishTextview;
    @Bind(R.id.animal_world_carnivorous_textview)
    TextView mAnimalWorldCarnivorousTextview;
    @Bind(R.id.animal_world_amphibious_textview)
    TextView mAnimalWorldAmphibiousTextview;
    @Bind(R.id.audio_animal_world_banner1)
    Banner mAudioHomeBanner;
    @Bind(R.id.audio_animal_world_banner0)
    Banner mAudioHomeBanner1;
    private String type1 = "动物世界";
    private String type2 = "爬行类动物";
    //轮播图的图片地址
    String[] images1 = new String[]{"http://pic15.nipic.com/20110803/7929674_090036056357_2.jpg", "http://pic21.nipic.com/20120525/9894811_180438440328_2.jpg", "http://pic.58pic.com/58pic/11/30/16/73d58PICPIZ.jpg", "http://i0.letvimg.com/cms/201406/04/0b35ddfe94174f03a7bf984e63309a0e.jpg"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_world);
        ButterKnife.bind(this);
        initWordStyleType();
        mAudioTwostyleTitle.setText(type1);
    }

    private void initWordStyleType() {
        mAudioTwostyleTitle.setTypeface(MyApplication.sTypeface);
        mAudioAnimalWorldTextview1.setTypeface(MyApplication.sTypeface);
        mAnimalWorldCrawlTextview.setTypeface(MyApplication.sTypeface);
        mAnimalWorldInsectTextview.setTypeface(MyApplication.sTypeface);
        mAnimalWorldFlyTextview.setTypeface(MyApplication.sTypeface);
        mAnimalWorldPoultryTextview.setTypeface(MyApplication.sTypeface);
        mAnimalWorldLactationTextview.setTypeface(MyApplication.sTypeface);
        mAnimalWorldFishTextview.setTypeface(MyApplication.sTypeface);
        mAnimalWorldCarnivorousTextview.setTypeface(MyApplication.sTypeface);
        mAnimalWorldAmphibiousTextview.setTypeface(MyApplication.sTypeface);
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
                Glide.with(AnimalWorldActivity.this).load(url).into(view);
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
                Glide.with(AnimalWorldActivity.this).load(url).into(view);
            }
        });
    }

    @OnClick({R.id.audio_story_xuetang_back_image, R.id.animal_world_crawl_textview, R.id.animal_world_insect_textview, R.id.animal_world_fly_textview, R.id.animal_world_poultry_textview, R.id.animal_world_lactation_textview, R.id.animal_world_fish_textview, R.id.animal_world_carnivorous_textview, R.id.animal_world_amphibious_textview})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.audio_story_xuetang_back_image:
                finish();
                break;
            case R.id.animal_world_crawl_textview:
                type2 = mAnimalWorldCrawlTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.animal_world_insect_textview:
                type2 = mAnimalWorldInsectTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.animal_world_fly_textview:
                type2 = mAnimalWorldFlyTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.animal_world_poultry_textview:
                type2 = mAnimalWorldPoultryTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.animal_world_lactation_textview:
                type2 = mAnimalWorldLactationTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.animal_world_fish_textview:
                type2 = mAnimalWorldFishTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.animal_world_carnivorous_textview:
                type2 = mAnimalWorldCarnivorousTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.animal_world_amphibious_textview:
                type2 = mAnimalWorldAmphibiousTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
        }
    }
}
