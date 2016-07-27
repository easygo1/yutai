package com.yutai.exuetang.view.activity.audio.twostyle;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.yutai.exuetang.R;
import com.yutai.exuetang.utils.IntentTwoStyleActivityUtils;
import com.yutai.exuetang.view.application.MyApplication;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class JokeRiddleActivity extends AppCompatActivity {
    @Bind(R.id.audio_story_xuetang_back_image)
    ImageView mAudioStoryXuetangBackImage;
    @Bind(R.id.audio_twostyle_title)
    TextView mAudioTwostyleTitle;
    @Bind(R.id.audio_jokeriddle_textview1)
    TextView mAudioJokeriddleTextview1;
    @Bind(R.id.jokeriddle_animal_textview)
    TextView mJokeriddleAnimalTextview;
    @Bind(R.id.jokeriddle_words_textview)
    TextView mJokeriddleWordsTextview;
    @Bind(R.id.jokeriddle_plant_textview)
    TextView mJokeriddlePlantTextview;
    @Bind(R.id.jokeriddle_place_textview)
    TextView mJokeriddlePlaceTextview;
    @Bind(R.id.jokeriddle_goods_textview)
    TextView mJokeriddleGoodsTextview;
    @Bind(R.id.jokeriddle_name_textview)
    TextView mJokeriddleNameTextview;
    @Bind(R.id.jokeriddle_brain_teaser_textview)
    TextView mJokeriddleBrainTeaserTextview;
    @Bind(R.id.jokeriddle_idiom_textview)
    TextView mJokeriddleIdiomTextview;
    @Bind(R.id.jokeriddle_teaser_textview)
    TextView mJokeriddleTeaserTextview;
    @Bind(R.id.audio_joke_riddle_textview2)
    TextView mAudioJokeRiddleTextview2;
    @Bind(R.id.jokeriddle_witty_textview)
    TextView mJokeriddleWittyTextview;
    @Bind(R.id.jokeriddle_story_textview)
    TextView mJokeriddleStoryTextview;
    @Bind(R.id.jokeriddle_child_textview)
    TextView mJokeriddleChildTextview;
    @Bind(R.id.jokeriddle_afanty_textview)
    TextView mJokeriddleAfantyTextview;
    private String type1 = "笑话谜语";
    private String type2 = "动物类谜语";

    //笑话谜语
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_riddle);
        ButterKnife.bind(this);
        initWordStyleType();
        mAudioTwostyleTitle.setText(type1);
    }

    private void initWordStyleType() {
        mAudioTwostyleTitle.setTypeface(MyApplication.sTypeface);
        mAudioJokeriddleTextview1.setTypeface(MyApplication.sTypeface);
        mJokeriddleAnimalTextview.setTypeface(MyApplication.sTypeface);
        mJokeriddleWordsTextview.setTypeface(MyApplication.sTypeface);
        mJokeriddlePlantTextview.setTypeface(MyApplication.sTypeface);
        mJokeriddlePlaceTextview.setTypeface(MyApplication.sTypeface);
        mJokeriddleGoodsTextview.setTypeface(MyApplication.sTypeface);
        mJokeriddleNameTextview.setTypeface(MyApplication.sTypeface);
        mJokeriddleBrainTeaserTextview.setTypeface(MyApplication.sTypeface);
        mJokeriddleIdiomTextview.setTypeface(MyApplication.sTypeface);
        mJokeriddleTeaserTextview.setTypeface(MyApplication.sTypeface);
        mAudioJokeRiddleTextview2.setTypeface(MyApplication.sTypeface);
        mJokeriddleWittyTextview.setTypeface(MyApplication.sTypeface);
        mJokeriddleStoryTextview.setTypeface(MyApplication.sTypeface);
        mJokeriddleChildTextview.setTypeface(MyApplication.sTypeface);
        mJokeriddleAfantyTextview.setTypeface(MyApplication.sTypeface);
    }

    @OnClick({R.id.audio_story_xuetang_back_image, R.id.jokeriddle_animal_textview, R.id.jokeriddle_words_textview, R.id.jokeriddle_plant_textview, R.id.jokeriddle_place_textview, R.id.jokeriddle_goods_textview, R.id.jokeriddle_name_textview, R.id.jokeriddle_brain_teaser_textview, R.id.jokeriddle_idiom_textview, R.id.jokeriddle_teaser_textview, R.id.jokeriddle_witty_textview, R.id.jokeriddle_story_textview, R.id.jokeriddle_child_textview, R.id.jokeriddle_afanty_textview})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.audio_story_xuetang_back_image:
                finish();
                break;
            case R.id.jokeriddle_animal_textview:
                type2 = mJokeriddleAnimalTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.jokeriddle_words_textview:
                type2 = mJokeriddleAnimalTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.jokeriddle_plant_textview:
                type2 = mJokeriddleAnimalTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.jokeriddle_place_textview:
                type2 = mJokeriddleAnimalTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.jokeriddle_goods_textview:
                type2 = mJokeriddleAnimalTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.jokeriddle_name_textview:
                type2 = mJokeriddleAnimalTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.jokeriddle_brain_teaser_textview:
                type2 = mJokeriddleAnimalTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.jokeriddle_idiom_textview:
                type2 = mJokeriddleAnimalTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.jokeriddle_teaser_textview:
                type2 = mJokeriddleAnimalTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.jokeriddle_witty_textview:
                type2 = mJokeriddleAnimalTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.jokeriddle_story_textview:
                type2 = mJokeriddleAnimalTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.jokeriddle_child_textview:
                type2 = mJokeriddleAnimalTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.jokeriddle_afanty_textview:
                type2 = mJokeriddleAnimalTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
        }
    }
}
