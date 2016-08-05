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

public class FamousQuotesActivity extends AppCompatActivity {

    @Bind(R.id.audio_story_xuetang_back_image)
    ImageView mAudioStoryXuetangBackImage;
    @Bind(R.id.audio_twostyle_title)
    TextView mAudioTwostyleTitle;
    @Bind(R.id.audio_famous_quotes_textview1)
    TextView mAudioFamousQuotesTextview1;
    @Bind(R.id.famous_quotes_life_textview)
    TextView mFamousQuotesLifeTextview;
    @Bind(R.id.famous_quotes_dothing_textview)
    TextView mFamousQuotesDothingTextview;
    @Bind(R.id.famous_quotes_truth_textview)
    TextView mFamousQuotesTruthTextview;
    @Bind(R.id.famous_quotes_happiness_textview)
    TextView mFamousQuotesHappinessTextview;
    @Bind(R.id.famous_quotes_virtue_textview)
    TextView mFamousQuotesVirtueTextview;
    @Bind(R.id.famous_quotes_friendship_textview)
    TextView mFamousQuotesFriendshipTextview;
    @Bind(R.id.famous_quotes_lizhi_teaser_textview)
    TextView mFamousQuotesLizhiTeaserTextview;
    @Bind(R.id.famous_quotes_talent_textview)
    TextView mFamousQuotesTalentTextview;
    @Bind(R.id.famous_quotes_youth_textview)
    TextView mFamousQuotesYouthTextview;
    @Bind(R.id.famous_quotes_treasure_time_textview)
    TextView mFamousQuotesTreasureTimeTextview;
    @Bind(R.id.audio_famous_quotes_textview2)
    TextView mAudioFamousQuotesTextview2;
    @Bind(R.id.famous_quotes_seekknow_textview)
    TextView mFamousQuotesSeekknowTextview;
    @Bind(R.id.famous_quotes_collective_textview)
    TextView mFamousQuotesCollectiveTextview;
    @Bind(R.id.famous_quotes_labour_textview)
    TextView mFamousQuotesLabourTextview;
    @Bind(R.id.famous_quotes_patriotic_textview)
    TextView mFamousQuotesPatrioticTextview;
//    名人名言
    private String type1 = "名人名言";
    private String type2 = "人生篇";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_famous_quotes);
        ButterKnife.bind(this);
        initWordStyleType();
        mAudioTwostyleTitle.setText(type1);
    }

    private void initWordStyleType() {
        mAudioTwostyleTitle.setTypeface(MyApplication.sTypeface);
        mAudioFamousQuotesTextview1.setTypeface(MyApplication.sTypeface);
        mFamousQuotesLifeTextview.setTypeface(MyApplication.sTypeface);
        mFamousQuotesDothingTextview.setTypeface(MyApplication.sTypeface);
        mFamousQuotesTruthTextview.setTypeface(MyApplication.sTypeface);
        mFamousQuotesHappinessTextview.setTypeface(MyApplication.sTypeface);
        mFamousQuotesVirtueTextview.setTypeface(MyApplication.sTypeface);
        mFamousQuotesFriendshipTextview.setTypeface(MyApplication.sTypeface);
        mFamousQuotesLizhiTeaserTextview.setTypeface(MyApplication.sTypeface);
        mFamousQuotesTalentTextview.setTypeface(MyApplication.sTypeface);
        mFamousQuotesYouthTextview.setTypeface(MyApplication.sTypeface);
        mFamousQuotesTreasureTimeTextview.setTypeface(MyApplication.sTypeface);
        mAudioFamousQuotesTextview2.setTypeface(MyApplication.sTypeface);
        mFamousQuotesSeekknowTextview.setTypeface(MyApplication.sTypeface);
        mFamousQuotesCollectiveTextview.setTypeface(MyApplication.sTypeface);
        mFamousQuotesLabourTextview.setTypeface(MyApplication.sTypeface);
        mFamousQuotesPatrioticTextview.setTypeface(MyApplication.sTypeface);
    }

    @OnClick({R.id.audio_story_xuetang_back_image, R.id.famous_quotes_life_textview, R.id.famous_quotes_dothing_textview, R.id.famous_quotes_truth_textview, R.id.famous_quotes_happiness_textview, R.id.famous_quotes_virtue_textview, R.id.famous_quotes_friendship_textview, R.id.famous_quotes_lizhi_teaser_textview, R.id.famous_quotes_talent_textview, R.id.famous_quotes_youth_textview, R.id.famous_quotes_treasure_time_textview, R.id.famous_quotes_seekknow_textview, R.id.famous_quotes_collective_textview, R.id.famous_quotes_labour_textview, R.id.famous_quotes_patriotic_textview})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.audio_story_xuetang_back_image:
                finish();
                break;
            case R.id.famous_quotes_life_textview:
                type2 = mFamousQuotesLifeTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.famous_quotes_dothing_textview:
                type2 = mFamousQuotesDothingTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.famous_quotes_truth_textview:
                type2 = mFamousQuotesTruthTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.famous_quotes_happiness_textview:
                type2 = mFamousQuotesHappinessTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.famous_quotes_virtue_textview:
                type2 = mFamousQuotesVirtueTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.famous_quotes_friendship_textview:
                type2 = mFamousQuotesFriendshipTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.famous_quotes_lizhi_teaser_textview:
                type2 = mFamousQuotesLizhiTeaserTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.famous_quotes_talent_textview:
                type2 = mFamousQuotesTalentTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.famous_quotes_youth_textview:
                type2 = mFamousQuotesYouthTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.famous_quotes_treasure_time_textview:
                type2 = mFamousQuotesTreasureTimeTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.famous_quotes_seekknow_textview:
                type2 = mFamousQuotesSeekknowTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.famous_quotes_collective_textview:
                type2 = mFamousQuotesCollectiveTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.famous_quotes_labour_textview:
                type2 = mFamousQuotesLabourTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.famous_quotes_patriotic_textview:
                type2 = mFamousQuotesPatrioticTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
        }
    }
}
