package com.yutai.exuetang.view.activity.audio.twostyle;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.yutai.exuetang.R;
import com.yutai.exuetang.utils.IntentTwoStyleActivityUtils;
import com.yutai.exuetang.utils.ToastUtils;
import com.yutai.exuetang.view.application.MyApplication;

/**
 * 音频管家的二级页面----故事学堂
 */
public class StoryXuetangActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView mAudioGushixuetangTextview1;
    private TextView mStoryTonghuTextview;
    private TextView mStoryGelinTextview;
    private TextView mStoryYizhiTextview;
    private TextView mStory1001Textview;
    private TextView mStoryMinjianTextview;
    private TextView mStoryZhengyuanjieTextview;
    private TextView mStoryAntushengTextview;
    private TextView mStoryXilaTextview;
    private TextView mStoryMingrenTextview;
    private TextView mStoryAiguoTextview;
    private TextView mAudioGushixuetangTextview2;
    private TextView mStoryChuanqiTextview;
    private TextView mStoryJingxianTextview;
    private TextView mStoryKingTextview;
    private TextView mStoryGongzhuTextview;
    private TextView mStoryAnimalTextview;
    private TextView mStoryWangziTextview;
    private TextView mAudioGushixuetangTextview3;
    private TextView mStoryGuowangTextview;
    private TextView mStoryQiyuTextview;
    private TextView mStoryLoveTextview;
    private TextView mStoryYongshiTextview;
    private TextView mStoryGodTextview;
    private TextView mStoryBaowuTextview;
    private TextView mStoryBrotherTextview;
    private TextView mStoryShaneTextview;
    private TextView mStoryViewTextview;
    private TextView mAudioGushixuetangTextview4;
    private TextView mStoryShenxianTextview;
    private TextView mFoolishTextview;
    private TextView mStoryDemonTextview;
    private TextView mStorySatireTextview;
    private TextView mStoryWisdomTextview;
    private TextView mStoryWarTextview;

    private ImageView mImageView;

    private String type1 = "故事学堂";
    private String type2 = "童话故事";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_xuetang);
        initViews();
//        初始化字体样式
        initWordtype();
        initListeners();
    }

    private void initViews() {
        mAudioGushixuetangTextview1 = (TextView) findViewById(R.id.audio_gushixuetang_textview1);
        mStoryTonghuTextview = (TextView) findViewById(R.id.story_tonghu_textview);
        mStoryGelinTextview = (TextView) findViewById(R.id.story_gelin_textview);
        mStoryYizhiTextview = (TextView) findViewById(R.id.story_yizhi_textview);
        mStory1001Textview = (TextView) findViewById(R.id.story_1001_textview);
        mStoryMinjianTextview = (TextView) findViewById(R.id.story_minjian_textview);
        mStoryZhengyuanjieTextview = (TextView) findViewById(R.id.story_zhengyuanjie_textview);
        mStoryAntushengTextview = (TextView) findViewById(R.id.story_antusheng_textview);
        mStoryXilaTextview = (TextView) findViewById(R.id.story_xila_textview);
        mStoryMingrenTextview = (TextView) findViewById(R.id.story_mingren_textview);
        mStoryAiguoTextview = (TextView) findViewById(R.id.story_aiguo_textview);
        mAudioGushixuetangTextview2 = (TextView) findViewById(R.id.audio_gushixuetang_textview2);
        mStoryChuanqiTextview = (TextView) findViewById(R.id.story_chuanqi_textview);
        mStoryJingxianTextview = (TextView) findViewById(R.id.story_jingxian_textview);
        mStoryKingTextview = (TextView) findViewById(R.id.story_king_textview);
        mStoryGongzhuTextview = (TextView) findViewById(R.id.story_gongzhu_textview);
        mStoryAnimalTextview = (TextView) findViewById(R.id.story_animal_textview);
        mStoryWangziTextview = (TextView) findViewById(R.id.story_wangzi_textview);
        mAudioGushixuetangTextview3 = (TextView) findViewById(R.id.audio_gushixuetang_textview3);
        mStoryGuowangTextview = (TextView) findViewById(R.id.story_guowang_textview);
        mStoryQiyuTextview = (TextView) findViewById(R.id.story_qiyu_textview);
        mStoryLoveTextview = (TextView) findViewById(R.id.story_love_textview);
        mStoryYongshiTextview = (TextView) findViewById(R.id.story_yongshi_textview);
        mStoryGodTextview = (TextView) findViewById(R.id.story_god_textview);
        mStoryBaowuTextview = (TextView) findViewById(R.id.story_baowu_textview);
        mStoryBrotherTextview = (TextView) findViewById(R.id.story_brother_textview);
        mStoryShaneTextview = (TextView) findViewById(R.id.story_shane_textview);
        mStoryViewTextview = (TextView) findViewById(R.id.story_view_textview);
        mAudioGushixuetangTextview4 = (TextView) findViewById(R.id.audio_gushixuetang_textview4);
        mStoryShenxianTextview = (TextView) findViewById(R.id.story_shenxian_textview);
        mFoolishTextview = (TextView) findViewById(R.id.story_foolish_textview);
        mStoryDemonTextview = (TextView) findViewById(R.id.story_demon_textview);
        mStorySatireTextview = (TextView) findViewById(R.id.story_satire_textview);
        mStoryWisdomTextview = (TextView) findViewById(R.id.story_wisdom_textview);
        mStoryWarTextview = (TextView) findViewById(R.id.story_war_textview);
        mImageView = (ImageView) findViewById(R.id.audio_story_xuetang_back_image);
    }

    //设置字体的样式
    private void initWordtype() {
        mAudioGushixuetangTextview1.setTypeface(MyApplication.sTypeface);
        mStoryTonghuTextview.setTypeface(MyApplication.sTypeface);
        mStoryGelinTextview.setTypeface(MyApplication.sTypeface);
        mStoryYizhiTextview.setTypeface(MyApplication.sTypeface);
        mStory1001Textview.setTypeface(MyApplication.sTypeface);
        mStoryMinjianTextview.setTypeface(MyApplication.sTypeface);
        mStoryZhengyuanjieTextview.setTypeface(MyApplication.sTypeface);
        mStoryAntushengTextview.setTypeface(MyApplication.sTypeface);
        mStoryXilaTextview.setTypeface(MyApplication.sTypeface);
        mStoryMingrenTextview.setTypeface(MyApplication.sTypeface);
        mStoryAiguoTextview.setTypeface(MyApplication.sTypeface);
        mAudioGushixuetangTextview2.setTypeface(MyApplication.sTypeface);
        mStoryChuanqiTextview.setTypeface(MyApplication.sTypeface);
        mStoryJingxianTextview.setTypeface(MyApplication.sTypeface);
        mStoryKingTextview.setTypeface(MyApplication.sTypeface);
        mStoryGongzhuTextview.setTypeface(MyApplication.sTypeface);
        mStoryAnimalTextview.setTypeface(MyApplication.sTypeface);
        mStoryWangziTextview.setTypeface(MyApplication.sTypeface);
        mAudioGushixuetangTextview3.setTypeface(MyApplication.sTypeface);
        mStoryGuowangTextview.setTypeface(MyApplication.sTypeface);
        mStoryQiyuTextview.setTypeface(MyApplication.sTypeface);
        mStoryLoveTextview.setTypeface(MyApplication.sTypeface);
        mStoryYongshiTextview.setTypeface(MyApplication.sTypeface);
        mStoryGodTextview.setTypeface(MyApplication.sTypeface);
        mStoryBaowuTextview.setTypeface(MyApplication.sTypeface);
        mStoryBrotherTextview.setTypeface(MyApplication.sTypeface);
        mStoryShaneTextview.setTypeface(MyApplication.sTypeface);
        mStoryViewTextview.setTypeface(MyApplication.sTypeface);
        mAudioGushixuetangTextview4.setTypeface(MyApplication.sTypeface);
        mStoryShenxianTextview.setTypeface(MyApplication.sTypeface);
        mFoolishTextview.setTypeface(MyApplication.sTypeface);
        mStoryDemonTextview.setTypeface(MyApplication.sTypeface);
        mStorySatireTextview.setTypeface(MyApplication.sTypeface);
        mStoryWisdomTextview.setTypeface(MyApplication.sTypeface);
        mStoryWarTextview.setTypeface(MyApplication.sTypeface);
    }

    private void initListeners() {
        mStoryTonghuTextview.setOnClickListener(this);
        mStoryGelinTextview.setOnClickListener(this);
        mStoryYizhiTextview.setOnClickListener(this);
        mStory1001Textview.setOnClickListener(this);
        mStoryMinjianTextview.setOnClickListener(this);
        mStoryZhengyuanjieTextview.setOnClickListener(this);
        mStoryAntushengTextview.setOnClickListener(this);
        mStoryXilaTextview.setOnClickListener(this);
        mStoryMingrenTextview.setOnClickListener(this);
        mStoryAiguoTextview.setOnClickListener(this);
        mStoryChuanqiTextview.setOnClickListener(this);
        mStoryJingxianTextview.setOnClickListener(this);
        mStoryKingTextview.setOnClickListener(this);
        mStoryGongzhuTextview.setOnClickListener(this);
        mStoryAnimalTextview.setOnClickListener(this);
        mStoryWangziTextview.setOnClickListener(this);
        mStoryGuowangTextview.setOnClickListener(this);
        mStoryQiyuTextview.setOnClickListener(this);
        mStoryLoveTextview.setOnClickListener(this);
        mStoryYongshiTextview.setOnClickListener(this);
        mStoryGodTextview.setOnClickListener(this);
        mStoryBaowuTextview.setOnClickListener(this);
        mStoryBrotherTextview.setOnClickListener(this);
        mStoryShaneTextview.setOnClickListener(this);
        mStoryViewTextview.setOnClickListener(this);
        mStoryShenxianTextview.setOnClickListener(this);
        mFoolishTextview.setOnClickListener(this);
        mStoryDemonTextview.setOnClickListener(this);
        mStorySatireTextview.setOnClickListener(this);
        mStoryWisdomTextview.setOnClickListener(this);
        mStoryWarTextview.setOnClickListener(this);
        mImageView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.audio_story_xuetang_back_image:
                finish();
                break;
            case R.id.story_tonghu_textview:
//                童话故事
                type2 = mStoryTonghuTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.story_gelin_textview:
                type2 = mStoryGelinTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.story_yizhi_textview:
                type2 = mStoryYizhiTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.story_1001_textview:
                type2 = mStory1001Textview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.story_minjian_textview:
                type2 = mStoryMinjianTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.story_zhengyuanjie_textview:
                type2 = mStoryZhengyuanjieTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.story_antusheng_textview:
                type2 = mStoryAntushengTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.story_xila_textview:
                type2 = mStoryXilaTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.story_mingren_textview:
                type2 = mStoryMingrenTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.story_aiguo_textview:
                type2 = mStoryAiguoTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.story_chuanqi_textview:
                type2 = mStoryChuanqiTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.story_jingxian_textview:
                type2 = mStoryJingxianTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.story_king_textview:
                type2 = mStoryKingTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.story_gongzhu_textview:
                type2 = mStoryGongzhuTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.story_animal_textview:
                type2 = mStoryAnimalTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.story_wangzi_textview:
                type2 = mStoryWangziTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.story_guowang_textview:
                type2 = mStoryGuowangTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.story_qiyu_textview:
                type2 = mStoryQiyuTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.story_yongshi_textview:
                type2 = mStoryYongshiTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.story_god_textview:
                type2 = mStoryGodTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.story_baowu_textview:
                type2 = mStoryBaowuTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.story_brother_textview:
                type2 = mStoryBrotherTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.story_shane_textview:
                type2 = mStoryShaneTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.story_view_textview:
                type2 = mStoryViewTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.story_shenxian_textview:
                type2 = mStoryShenxianTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.story_foolish_textview:
                type2 = mFoolishTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.story_demon_textview:
                type2 = mStoryDemonTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.story_satire_textview:
                type2 = mStorySatireTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.story_wisdom_textview:
                type2 = mStoryWisdomTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.story_war_textview:
                type2 = mStoryWarTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
        }
    }

    private void show(String s) {
        ToastUtils.showToast(this, s);
    }
}
