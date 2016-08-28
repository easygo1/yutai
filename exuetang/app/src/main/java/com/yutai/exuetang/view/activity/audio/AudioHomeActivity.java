package com.yutai.exuetang.view.activity.audio;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.yutai.exuetang.R;
import com.yutai.exuetang.utils.ToastUtils;
import com.yutai.exuetang.view.activity.audio.twostyle.AnimalWorldActivity;
import com.yutai.exuetang.view.activity.audio.twostyle.ChildSongXuetangActivity;
import com.yutai.exuetang.view.activity.audio.twostyle.ChinaLiteratureActivity;
import com.yutai.exuetang.view.activity.audio.twostyle.EnglishXuetangActivity;
import com.yutai.exuetang.view.activity.audio.twostyle.FamousAphorismActivity;
import com.yutai.exuetang.view.activity.audio.twostyle.FamousPersonActivity;
import com.yutai.exuetang.view.activity.audio.twostyle.FamousQuotesActivity;
import com.yutai.exuetang.view.activity.audio.twostyle.GoodWordsActivity;
import com.yutai.exuetang.view.activity.audio.twostyle.GuoXueXuetangActivity;
import com.yutai.exuetang.view.activity.audio.twostyle.IdiomStoryActivity;
import com.yutai.exuetang.view.activity.audio.twostyle.JokeRiddleActivity;
import com.yutai.exuetang.view.activity.audio.twostyle.PlantWorldActivity;
import com.yutai.exuetang.view.activity.audio.twostyle.PomeXuetangActivity;
import com.yutai.exuetang.view.activity.audio.twostyle.ReciteXuetangActivity;
import com.yutai.exuetang.view.activity.audio.twostyle.SafetyEducationActivity;
import com.yutai.exuetang.view.activity.audio.twostyle.StoryXuetangActivity;
import com.yutai.exuetang.view.activity.audio.twostyle.VirtueStoryActivity;
import com.yutai.exuetang.view.activity.audio.twostyle.WhysActivity;
import com.yutai.exuetang.view.activity.audio.twostyle.WordKnowActivity;
import com.yutai.exuetang.view.activity.audio.twostyle.WorldClassicActivity;
import com.yutai.exuetang.view.activity.exuetang.LoginActivity;
import com.yutai.exuetang.view.application.MyApplication;

public class AudioHomeActivity extends AppCompatActivity implements View.OnClickListener {
    private LinearLayout mGushixuetangLinearlayout;//故事学堂
    private TextView mGushixuetangTextview;
    private LinearLayout mErgexuetangLinearlayout;//儿歌学堂
    private TextView mErgexuetangTextview;
    private LinearLayout mGuoxuexuetangLinearlayout;//国学学堂
    private TextView mGuoxuexuetangTextview;
    private LinearLayout mPoemxuetangLinearlayout;//诗词学堂
    private TextView mPoemxuetangTextview;
    private LinearLayout mSafeeducationLinearlayout;
    private TextView mSafeeducationTextview;
    private LinearLayout mXiaohuamiyuLinearlayout;
    private TextView mXiaohuamiyuTextview;
    private LinearLayout mWhyLinearlayout;
    private TextView mWhyTextview;
    private LinearLayout mReadxuetangLinearlayout;
    private TextView mReadxuetangTextview;
    private LinearLayout mHaocihaojuLinearlayout;
    private TextView mHaocihaojuTextview;
    private LinearLayout mEnglishLinearlayout;
    private TextView mEnglishTextview;
    private LinearLayout mMeideLinearlayout;
    private TextView mMeideTextview;
    private LinearLayout mChinamingzhuLinearlayout;
    private TextView mChinamingzhuTextview;
    private Banner mAudioHomeBanner;
    private LinearLayout mChengyuLinearlayout;
    private TextView mChengyuTextview;
    private LinearLayout mMingyanjingjuLinearlayout;
    private TextView mMingyanjingjuTextview;
    private LinearLayout mMingrenmingyanLinearlayout;
    private TextView mMingrenmingyanTextview;
    private LinearLayout mWorldmingzhuLinearlayout;
    private TextView mWorldmingzhuTextview;
    private LinearLayout mZicizhishiLinearlayout;
    private TextView mZicizhishiTextview;
    private LinearLayout mMingrenzhuanLinearlayout;
    private TextView mMingrenzhuanTextview;
    private LinearLayout mAnimalworldLinearlayout;
    private TextView mAnimalworldTextview;
    private LinearLayout mPlantworldLinearlayout;
    private TextView mPlantworldTextview;

    private ImageView mAudioHomeBackImage;
    private ImageView mAudioHomeLikeImage;
    private ImageView mAudioHomeResentImage;
    private EditText mSearchEditText;
    SharedPreferences mSharedPreferences;//偏好设置
    public static final String USER = "user";
    private int user_id;//偏好设置中获取
    //轮播图的图片地址
    String[] images1 = new String[]{"http://pic15.nipic.com/20110803/7929674_090036056357_2.jpg", "http://pic21.nipic.com/20120525/9894811_180438440328_2.jpg", "http://pic.58pic.com/58pic/11/30/16/73d58PICPIZ.jpg", "http://i0.letvimg.com/cms/201406/04/0b35ddfe94174f03a7bf984e63309a0e.jpg"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_home);
        initViews();
        initwordstype();
        getintentdata();
        initListeners();
    }

    private void initViews() {
        mGushixuetangLinearlayout = (LinearLayout) findViewById(R.id.gushixuetang_linearlayout);
        mGushixuetangTextview = (TextView) findViewById(R.id.gushixuetang_textview);
        mErgexuetangLinearlayout = (LinearLayout) findViewById(R.id.ergexuetang_linearlayout);
        mErgexuetangTextview = (TextView) findViewById(R.id.ergexuetang_textview);
        mGuoxuexuetangLinearlayout = (LinearLayout) findViewById(R.id.guoxuexuetang_linearlayout);
        mGuoxuexuetangTextview = (TextView) findViewById(R.id.guoxuexuetang_textview);
        mPoemxuetangLinearlayout = (LinearLayout) findViewById(R.id.poemxuetang_linearlayout);
        mPoemxuetangTextview = (TextView) findViewById(R.id.poemxuetang_textview);
        mSafeeducationLinearlayout = (LinearLayout) findViewById(R.id.safeeducation_linearlayout);
        mSafeeducationTextview = (TextView) findViewById(R.id.safeeducation_textview);
        mXiaohuamiyuLinearlayout = (LinearLayout) findViewById(R.id.xiaohuamiyu_linearlayout);
        mXiaohuamiyuTextview = (TextView) findViewById(R.id.xiaohuamiyu_textview);
        mWhyLinearlayout = (LinearLayout) findViewById(R.id.why_linearlayout);
        mWhyTextview = (TextView) findViewById(R.id.why_textview);
        mReadxuetangLinearlayout = (LinearLayout) findViewById(R.id.readxuetang_linearlayout);
        mReadxuetangTextview = (TextView) findViewById(R.id.readxuetang_textview);
        mHaocihaojuLinearlayout = (LinearLayout) findViewById(R.id.haocihaoju_linearlayout);
        mHaocihaojuTextview = (TextView) findViewById(R.id.haocihaoju_textview);
        mEnglishLinearlayout = (LinearLayout) findViewById(R.id.english_linearlayout);
        mEnglishTextview = (TextView) findViewById(R.id.english_textview);
        mMeideLinearlayout = (LinearLayout) findViewById(R.id.meide_linearlayout);
        mMeideTextview = (TextView) findViewById(R.id.meide_textview);
        mChinamingzhuLinearlayout = (LinearLayout) findViewById(R.id.chinamingzhu_linearlayout);
        mChinamingzhuTextview = (TextView) findViewById(R.id.chinamingzhu_textview);
        mAudioHomeBanner = (Banner) findViewById(R.id.audio_home_banner);
        mChengyuLinearlayout = (LinearLayout) findViewById(R.id.chengyu_linearlayout);
        mChengyuTextview = (TextView) findViewById(R.id.chengyu_textview);
        mMingyanjingjuLinearlayout = (LinearLayout) findViewById(R.id.mingyanjingju_linearlayout);
        mMingyanjingjuTextview = (TextView) findViewById(R.id.mingyanjingju_textview);
        mMingrenmingyanLinearlayout = (LinearLayout) findViewById(R.id.mingrenmingyan_linearlayout);
        mMingrenmingyanTextview = (TextView) findViewById(R.id.mingrenmingyan_textview);
        mWorldmingzhuLinearlayout = (LinearLayout) findViewById(R.id.worldmingzhu_linearlayout);
        mWorldmingzhuTextview = (TextView) findViewById(R.id.worldmingzhu_textview);
        mZicizhishiLinearlayout = (LinearLayout) findViewById(R.id.zicizhishi_linearlayout);
        mZicizhishiTextview = (TextView) findViewById(R.id.zicizhishi_textview);
        mMingrenzhuanLinearlayout = (LinearLayout) findViewById(R.id.mingrenzhuan_linearlayout);
        mMingrenzhuanTextview = (TextView) findViewById(R.id.mingrenzhuan_textview);
        mAnimalworldLinearlayout = (LinearLayout) findViewById(R.id.animalworld_linearlayout);
        mAnimalworldTextview = (TextView) findViewById(R.id.animalworld_textview);
        mPlantworldLinearlayout = (LinearLayout) findViewById(R.id.plantworld_linearlayout);
        mPlantworldTextview = (TextView) findViewById(R.id.plantworld_textview);

        mAudioHomeBackImage = (ImageView) findViewById(R.id.audio_home_back_image);
        mAudioHomeLikeImage = (ImageView) findViewById(R.id.audio_home_like_image);
        mAudioHomeResentImage = (ImageView) findViewById(R.id.audio_home_resent_image);
        mSearchEditText = (EditText) findViewById(R.id.search_edit1);

        mAudioHomeBanner = (Banner) findViewById(R.id.audio_home_banner);
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
                show("单击了广告" + position);
            }
        });
        //设置轮播图片（所有设置参数方法都放在此方法之前执行）
        mAudioHomeBanner.setImages(images1, new Banner.OnLoadImageListener() {
            @Override
            public void OnLoadImage(ImageView view, Object url) {
                Glide.with(AudioHomeActivity.this).load(url).into(view);
            }
        });
    }

    private void initwordstype() {
        mGushixuetangTextview.setTypeface(MyApplication.sTypeface);
        mErgexuetangTextview.setTypeface(MyApplication.sTypeface);
        mGuoxuexuetangTextview.setTypeface(MyApplication.sTypeface);
        mPoemxuetangTextview.setTypeface(MyApplication.sTypeface);
        mSafeeducationTextview.setTypeface(MyApplication.sTypeface);
        mXiaohuamiyuTextview.setTypeface(MyApplication.sTypeface);
        mWhyTextview.setTypeface(MyApplication.sTypeface);
        mReadxuetangTextview.setTypeface(MyApplication.sTypeface);
        mHaocihaojuTextview.setTypeface(MyApplication.sTypeface);
        mEnglishTextview.setTypeface(MyApplication.sTypeface);
        mMeideTextview.setTypeface(MyApplication.sTypeface);
        mChinamingzhuTextview.setTypeface(MyApplication.sTypeface);
        mChengyuTextview.setTypeface(MyApplication.sTypeface);
        mMingyanjingjuTextview.setTypeface(MyApplication.sTypeface);
        mMingrenmingyanTextview.setTypeface(MyApplication.sTypeface);
        mWorldmingzhuTextview.setTypeface(MyApplication.sTypeface);
        mZicizhishiTextview.setTypeface(MyApplication.sTypeface);
        mMingrenzhuanTextview.setTypeface(MyApplication.sTypeface);
        mAnimalworldTextview.setTypeface(MyApplication.sTypeface);
        mPlantworldTextview.setTypeface(MyApplication.sTypeface);
    }

    private void initListeners() {
        mGushixuetangLinearlayout.setOnClickListener(this);
        mErgexuetangLinearlayout.setOnClickListener(this);
        mGuoxuexuetangLinearlayout.setOnClickListener(this);
        mPoemxuetangLinearlayout.setOnClickListener(this);
        mSafeeducationLinearlayout.setOnClickListener(this);
        mXiaohuamiyuLinearlayout.setOnClickListener(this);
        mWhyLinearlayout.setOnClickListener(this);
        mReadxuetangLinearlayout.setOnClickListener(this);
        mHaocihaojuLinearlayout.setOnClickListener(this);
        mEnglishLinearlayout.setOnClickListener(this);
        mMeideLinearlayout.setOnClickListener(this);
        mChinamingzhuLinearlayout.setOnClickListener(this);
        mChengyuLinearlayout.setOnClickListener(this);
        mMingyanjingjuLinearlayout.setOnClickListener(this);
        mMingrenmingyanLinearlayout.setOnClickListener(this);
        mWorldmingzhuLinearlayout.setOnClickListener(this);
        mZicizhishiLinearlayout.setOnClickListener(this);
        mMingrenzhuanLinearlayout.setOnClickListener(this);
        mAnimalworldLinearlayout.setOnClickListener(this);
        mPlantworldLinearlayout.setOnClickListener(this);

        mAudioHomeBackImage.setOnClickListener(this);

        mAudioHomeLikeImage.setOnClickListener(this);
        mAudioHomeResentImage.setOnClickListener(this);
        mSearchEditText.setOnClickListener(this);
        mSearchEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
//                if(hasFocus){
//                    获取焦点的时候就跳转到SearchMusicActivity页面
                Intent intent = new Intent();
                intent.setClass(AudioHomeActivity.this, SearchMusicActivity.class);
                startActivity(intent);
//                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.gushixuetang_linearlayout:
//                故事学堂
                show("故事学堂");
                intent.setClass(this, StoryXuetangActivity.class);
                startActivity(intent);
                break;
            case R.id.ergexuetang_linearlayout:
//                儿歌学堂
                show("儿歌学堂");
                intent.setClass(this, ChildSongXuetangActivity.class);
                startActivity(intent);
                break;
            case R.id.guoxuexuetang_linearlayout:
//                国学学堂
                show("国学学堂");
                intent.setClass(this, GuoXueXuetangActivity.class);
                startActivity(intent);
                break;
            case R.id.poemxuetang_linearlayout:
//                诗词学堂
                show("诗词学堂");
                intent.setClass(this, PomeXuetangActivity.class);
                startActivity(intent);
                break;
            case R.id.safeeducation_linearlayout:
//                安全教育
                show("安全教育");
                intent.setClass(this, SafetyEducationActivity.class);
                startActivity(intent);
                break;
            case R.id.xiaohuamiyu_linearlayout:
//                笑话谜语
                show("笑话谜语");
                intent.setClass(this, JokeRiddleActivity.class);
                startActivity(intent);
                break;
            case R.id.why_linearlayout:
//                十万个为什么
                show("十万个为什么");
                intent.setClass(this, WhysActivity.class);
                startActivity(intent);
                break;
            case R.id.readxuetang_linearlayout:
//                朗诵学堂
                show("朗诵学堂");
                intent.setClass(this, ReciteXuetangActivity.class);
                startActivity(intent);
                break;
            case R.id.haocihaoju_linearlayout:
//                好词好句
                show("好词好句");
                intent.setClass(this, GoodWordsActivity.class);
                startActivity(intent);
                break;
            case R.id.english_linearlayout:
//                英语经典学堂
                show("英语经典学堂");
                intent.setClass(this, EnglishXuetangActivity.class);
                startActivity(intent);
                break;
            case R.id.meide_linearlayout:
//                中华美德故事
                show("中华美德故事");
                intent.setClass(this, VirtueStoryActivity.class);
                startActivity(intent);
                break;
            case R.id.chinamingzhu_linearlayout:
//                中国名著
                show("中国名著");
                intent.setClass(this, ChinaLiteratureActivity.class);
                startActivity(intent);
                break;
            case R.id.chengyu_linearlayout:
//                成语故事
                show("成语故事");
                intent.setClass(this, IdiomStoryActivity.class);
                startActivity(intent);
                break;
            case R.id.mingyanjingju_linearlayout:
//                名言警句
                show("名言警句");
                intent.setClass(this, FamousAphorismActivity.class);
                startActivity(intent);
                break;
            case R.id.mingrenmingyan_linearlayout:
//                名人名言
                show("名人名言");
                intent.setClass(this, FamousQuotesActivity.class);
                startActivity(intent);
                break;
            case R.id.worldmingzhu_linearlayout:
//                世界名著
                show("世界名著");
                intent.setClass(this, WorldClassicActivity.class);
                startActivity(intent);
                break;
            case R.id.zicizhishi_linearlayout:
//                字词知识
                show("字词知识");
                intent.setClass(this, WordKnowActivity.class);
                startActivity(intent);
                break;
            case R.id.mingrenzhuan_linearlayout:
//                名人传
                show("名人传");
                intent.setClass(this, FamousPersonActivity.class);
                startActivity(intent);
                break;
            case R.id.animalworld_linearlayout:
//                动物世界
                show("动物世界");
                intent.setClass(this, AnimalWorldActivity.class);
                startActivity(intent);
                break;
            case R.id.plantworld_linearlayout:
//                植物世界
                show("植物世界");
                intent.setClass(this, PlantWorldActivity.class);
                startActivity(intent);
                break;
            case R.id.audio_home_back_image:
                finish();
                break;
            case R.id.audio_home_like_image:
                show("我的最爱");
                break;
            case R.id.audio_home_resent_image:
                show("最近播放");
                break;
            case R.id.search_edit1:
//
                if (user_id != 0) {
                    intent.setClass(AudioHomeActivity.this, SearchMusicActivity.class);
                    startActivity(intent);
                }else{
                    intent.setClass(AudioHomeActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
                break;
        }
    }

    private void getintentdata() {
        mSharedPreferences = this.getSharedPreferences(USER, Context.MODE_PRIVATE);
        user_id = mSharedPreferences.getInt("user_id", 0);//整个页面要用
    }
    private void show(String s) {
        ToastUtils.showToast(this, s);
    }
}
