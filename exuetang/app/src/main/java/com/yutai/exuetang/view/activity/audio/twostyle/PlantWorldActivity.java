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

public class PlantWorldActivity extends AppCompatActivity {
    @Bind(R.id.audio_story_xuetang_back_image)
    ImageView mAudioStoryXuetangBackImage;
    @Bind(R.id.audio_twostyle_title)
    TextView mAudioTwostyleTitle;
    @Bind(R.id.audio_plant_world_textview1)
    TextView mAudioPlantWorldTextview1;
    @Bind(R.id.plant_world_angiosperm_textview)
    TextView mPlantWorldAngiospermTextview;
    @Bind(R.id.plant_world_gymnosperms_textview)
    TextView mPlantWorldGymnospermsTextview;
    @Bind(R.id.plant_world_dicotyledon_textview)
    TextView mPlantWorldDicotyledonTextview;
    @Bind(R.id.plant_world_fern_textview)
    TextView mPlantWorldFernTextview;
    @Bind(R.id.plant_world_monocotyledon_textview)
    TextView mPlantWorldMonocotyledonTextview;
    @Bind(R.id.plant_world_moss_textview)
    TextView mPlantWorldMossTextview;
    @Bind(R.id.audio_plant_world_textview2)
    TextView mAudioPlantWorldTextview2;
    @Bind(R.id.plant_world_algae_textview)
    TextView mPlantWorldAlgaeTextview;
    @Bind(R.id.plant_world_bacteria_textview)
    TextView mPlantWorldBacteriaTextview;
    @Bind(R.id.plant_world_fungus_textview)
    TextView mPlantWorldFungusTextview;
    @Bind(R.id.plant_world_blue_textview)
    TextView mPlantWorldBlueTextview;
    @Bind(R.id.plant_world_lichens_textview)
    TextView mPlantWorldLichensTextview;
    @Bind(R.id.audio_plan_banner0)
    Banner mAudioHomeBanner;
    @Bind(R.id.audio_plan_banner1)
    Banner mAudioHomeBanner1;
    //轮播图的图片地址
    String[] images1 = new String[]{"http://pic15.nipic.com/20110803/7929674_090036056357_2.jpg", "http://pic21.nipic.com/20120525/9894811_180438440328_2.jpg", "http://pic.58pic.com/58pic/11/30/16/73d58PICPIZ.jpg", "http://i0.letvimg.com/cms/201406/04/0b35ddfe94174f03a7bf984e63309a0e.jpg"};

    private String type1 = "植物世界";
    private String type2 = "被子植物";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant_world);
        ButterKnife.bind(this);
        initWordStyleType();
        mAudioTwostyleTitle.setText(type1);
    }

    private void initWordStyleType() {
        mAudioTwostyleTitle.setTypeface(MyApplication.sTypeface);
        mAudioPlantWorldTextview1.setTypeface(MyApplication.sTypeface);
        mPlantWorldAngiospermTextview.setTypeface(MyApplication.sTypeface);
        mPlantWorldGymnospermsTextview.setTypeface(MyApplication.sTypeface);
        mPlantWorldDicotyledonTextview.setTypeface(MyApplication.sTypeface);
        mPlantWorldFernTextview.setTypeface(MyApplication.sTypeface);
        mPlantWorldMonocotyledonTextview.setTypeface(MyApplication.sTypeface);
        mPlantWorldMossTextview.setTypeface(MyApplication.sTypeface);
        mAudioPlantWorldTextview2.setTypeface(MyApplication.sTypeface);
        mPlantWorldAlgaeTextview.setTypeface(MyApplication.sTypeface);
        mPlantWorldBacteriaTextview.setTypeface(MyApplication.sTypeface);
        mPlantWorldFungusTextview.setTypeface(MyApplication.sTypeface);
        mPlantWorldBlueTextview.setTypeface(MyApplication.sTypeface);
        mPlantWorldLichensTextview.setTypeface(MyApplication.sTypeface);
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
                Glide.with(PlantWorldActivity.this).load(url).into(view);
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
                Glide.with(PlantWorldActivity.this).load(url).into(view);
            }
        });
    }

    @OnClick({R.id.audio_story_xuetang_back_image, R.id.plant_world_angiosperm_textview, R.id.plant_world_gymnosperms_textview, R.id.plant_world_dicotyledon_textview, R.id.plant_world_fern_textview, R.id.plant_world_monocotyledon_textview, R.id.plant_world_moss_textview, R.id.plant_world_algae_textview, R.id.plant_world_bacteria_textview, R.id.plant_world_fungus_textview, R.id.plant_world_blue_textview, R.id.plant_world_lichens_textview})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.audio_story_xuetang_back_image:
                finish();
                break;
            case R.id.plant_world_angiosperm_textview:
                type2 = mPlantWorldAngiospermTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.plant_world_gymnosperms_textview:
                type2 = mPlantWorldGymnospermsTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.plant_world_dicotyledon_textview:
                type2 = mPlantWorldDicotyledonTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.plant_world_fern_textview:
                type2 = mPlantWorldFernTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.plant_world_monocotyledon_textview:
                type2 = mPlantWorldMonocotyledonTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.plant_world_moss_textview:
                type2 = mPlantWorldMossTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.plant_world_algae_textview:
                type2 = mPlantWorldAlgaeTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.plant_world_bacteria_textview:
                type2 = mPlantWorldBacteriaTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.plant_world_fungus_textview:
                type2 = mPlantWorldFungusTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.plant_world_blue_textview:
                type2 = mPlantWorldBlueTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.plant_world_lichens_textview:
                type2 = mPlantWorldLichensTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
        }
    }
}
