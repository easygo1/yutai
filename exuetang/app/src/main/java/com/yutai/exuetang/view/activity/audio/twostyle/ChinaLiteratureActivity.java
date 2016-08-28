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

public class ChinaLiteratureActivity extends AppCompatActivity {

    @Bind(R.id.audio_story_xuetang_back_image)
    ImageView mAudioStoryXuetangBackImage;
    @Bind(R.id.audio_twostyle_title)
    TextView mAudioTwostyleTitle;
    @Bind(R.id.audio_china_literture_textview1)
    TextView mAudioChinaLitertureTextview1;
    @Bind(R.id.china_literture_updown5000_textview)
    TextView mChinaLitertureUpdown5000Textview;
    @Bind(R.id.china_literture_shiji_textview)
    TextView mChinaLitertureShijiTextview;
    @Bind(R.id.china_literture_lvshichunqiu_textview)
    TextView mChinaLitertureLvshichunqiuTextview;
    @Bind(R.id.china_literture_hanshu_textview)
    TextView mChinaLitertureHanshuTextview;
    @Bind(R.id.china_literture_zhanguoce_textview)
    TextView mChinaLitertureZhanguoceTextview;
    @Bind(R.id.china_literture_sanguozhi_textview)
    TextView mChinaLitertureSanguozhiTextview;
    @Bind(R.id.audio_china_literture_textview2)
    TextView mAudioChinaLitertureTextview2;
    @Bind(R.id.china_literture_zizhi_textview)
    TextView mChinaLitertureZizhiTextview;
    @Bind(R.id.china_literture_xiyouji_textview)
    TextView mChinaLitertureXiyoujiTextview;
    @Bind(R.id.china_literture_sanguo_textview)
    TextView mChinaLitertureSanguoTextview;
    @Bind(R.id.china_literture_honglou_textview)
    TextView mChinaLitertureHonglouTextview;
    @Bind(R.id.china_literture_shuihu_textview)
    TextView mChinaLitertureShuihuTextview;
    @Bind(R.id.china_literture_bencao_textview)
    TextView mChinaLitertureBencaoTextview;
    @Bind(R.id.audio_china_banner0)
    Banner mAudioHomeBanner;
    @Bind(R.id.audio_china_banner1)
    Banner mAudioHomeBanner1;
    //轮播图的图片地址
    String[] images1 = new String[]{"http://pic15.nipic.com/20110803/7929674_090036056357_2.jpg", "http://pic21.nipic.com/20120525/9894811_180438440328_2.jpg", "http://pic.58pic.com/58pic/11/30/16/73d58PICPIZ.jpg", "http://i0.letvimg.com/cms/201406/04/0b35ddfe94174f03a7bf984e63309a0e.jpg"};

//    中国名著

    private String type1 = "中国名著";
    private String type2 = "上下五千年";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_china_literature);
        ButterKnife.bind(this);
        initWordStyleType();
        mAudioTwostyleTitle.setText(type1);
    }

    private void initWordStyleType() {
        mAudioTwostyleTitle.setTypeface(MyApplication.sTypeface);
        mAudioChinaLitertureTextview1.setTypeface(MyApplication.sTypeface);
        mChinaLitertureUpdown5000Textview.setTypeface(MyApplication.sTypeface);
        mChinaLitertureShijiTextview.setTypeface(MyApplication.sTypeface);
        mChinaLitertureLvshichunqiuTextview.setTypeface(MyApplication.sTypeface);
        mChinaLitertureHanshuTextview.setTypeface(MyApplication.sTypeface);
        mChinaLitertureZhanguoceTextview.setTypeface(MyApplication.sTypeface);
        mChinaLitertureSanguozhiTextview.setTypeface(MyApplication.sTypeface);
        mAudioChinaLitertureTextview2.setTypeface(MyApplication.sTypeface);
        mChinaLitertureZizhiTextview.setTypeface(MyApplication.sTypeface);
        mChinaLitertureXiyoujiTextview.setTypeface(MyApplication.sTypeface);
        mChinaLitertureSanguoTextview.setTypeface(MyApplication.sTypeface);
        mChinaLitertureHonglouTextview.setTypeface(MyApplication.sTypeface);
        mChinaLitertureShuihuTextview.setTypeface(MyApplication.sTypeface);
        mChinaLitertureBencaoTextview.setTypeface(MyApplication.sTypeface);
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
                Glide.with(ChinaLiteratureActivity.this).load(url).into(view);
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
                Glide.with(ChinaLiteratureActivity.this).load(url).into(view);
            }
        });
    }

    @OnClick({R.id.audio_story_xuetang_back_image, R.id.china_literture_updown5000_textview, R.id.china_literture_shiji_textview, R.id.china_literture_lvshichunqiu_textview, R.id.china_literture_hanshu_textview, R.id.china_literture_zhanguoce_textview, R.id.china_literture_sanguozhi_textview, R.id.china_literture_zizhi_textview, R.id.china_literture_xiyouji_textview, R.id.china_literture_sanguo_textview, R.id.china_literture_honglou_textview, R.id.china_literture_shuihu_textview, R.id.china_literture_bencao_textview})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.audio_story_xuetang_back_image:
                finish();
                break;
            case R.id.china_literture_updown5000_textview:
                type2 = mChinaLitertureUpdown5000Textview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.china_literture_shiji_textview:
                type2 = mChinaLitertureShijiTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.china_literture_lvshichunqiu_textview:
                type2 = mChinaLitertureLvshichunqiuTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.china_literture_hanshu_textview:
                type2 = mChinaLitertureHanshuTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.china_literture_zhanguoce_textview:
                type2 = mChinaLitertureZhanguoceTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.china_literture_sanguozhi_textview:
                type2 = mChinaLitertureSanguozhiTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.china_literture_zizhi_textview:
                type2 = mChinaLitertureZizhiTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.china_literture_xiyouji_textview:
                type2 = mChinaLitertureXiyoujiTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.china_literture_sanguo_textview:
                type2 = mChinaLitertureSanguoTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.china_literture_honglou_textview:
                type2 = mChinaLitertureHonglouTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.china_literture_shuihu_textview:
                type2 = mChinaLitertureShuihuTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.china_literture_bencao_textview:
                type2 = mChinaLitertureBencaoTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
        }
    }
}
