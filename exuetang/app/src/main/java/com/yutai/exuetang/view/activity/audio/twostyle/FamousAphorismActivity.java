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

public class FamousAphorismActivity extends AppCompatActivity {
    @Bind(R.id.audio_story_xuetang_back_image)
    ImageView mAudioStoryXuetangBackImage;
    @Bind(R.id.audio_twostyle_title)
    TextView mAudioTwostyleTitle;
    @Bind(R.id.audio_famous_aphorism_textview1)
    TextView mAudioFamousAphorismTextview1;
    @Bind(R.id.famous_aphorism_person_textview)
    TextView mFamousAphorismPersonTextview;
    @Bind(R.id.famous_aphorism_things_textview)
    TextView mFamousAphorismThingsTextview;
    @Bind(R.id.famous_aphorism_conduct_textview)
    TextView mFamousAphorismConductTextview;
    @Bind(R.id.famous_aphorism_career_textview)
    TextView mFamousAphorismCareerTextview;
    @Bind(R.id.famous_aphorism_mentality_textview)
    TextView mFamousAphorismMentalityTextview;
    @Bind(R.id.famous_aphorism_personnel_textview)
    TextView mFamousAphorismPersonnelTextview;
    @Bind(R.id.audio_famous_aphorism_textview2)
    TextView mAudioFamousAphorismTextview2;
    @Bind(R.id.famous_aphorism_scholarship_textview)
    TextView mFamousAphorismScholarshipTextview;
    @Bind(R.id.famous_aphorism_contact_textview)
    TextView mFamousAphorismContactTextview;
    @Bind(R.id.famous_aphorism_life_textview)
    TextView mFamousAphorismLifeTextview;
    @Bind(R.id.famous_aphorism_emotion_textview)
    TextView mFamousAphorismEmotionTextview;
    @Bind(R.id.famous_aphorism_healthy_textview)
    TextView mFamousAphorismHealthyTextview;
    @Bind(R.id.famous_aphorism_wealth_textview)
    TextView mFamousAphorismWealthTextview;
    private String type1 = "名言警句";
    private String type2 = "为人篇";

    //名言警句
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_famous_aphorism);
        ButterKnife.bind(this);
        initWordStyleType();
        mAudioTwostyleTitle.setText(type1);
    }

    private void initWordStyleType() {
        mAudioTwostyleTitle.setTypeface(MyApplication.sTypeface);
        mAudioFamousAphorismTextview1.setTypeface(MyApplication.sTypeface);
        mFamousAphorismPersonTextview.setTypeface(MyApplication.sTypeface);
        mFamousAphorismThingsTextview.setTypeface(MyApplication.sTypeface);
        mFamousAphorismConductTextview.setTypeface(MyApplication.sTypeface);
        mFamousAphorismCareerTextview.setTypeface(MyApplication.sTypeface);
        mFamousAphorismMentalityTextview.setTypeface(MyApplication.sTypeface);
        mFamousAphorismPersonnelTextview.setTypeface(MyApplication.sTypeface);
        mAudioFamousAphorismTextview2.setTypeface(MyApplication.sTypeface);
        mFamousAphorismScholarshipTextview.setTypeface(MyApplication.sTypeface);
        mFamousAphorismContactTextview.setTypeface(MyApplication.sTypeface);
        mFamousAphorismLifeTextview.setTypeface(MyApplication.sTypeface);
        mFamousAphorismEmotionTextview.setTypeface(MyApplication.sTypeface);
        mFamousAphorismHealthyTextview.setTypeface(MyApplication.sTypeface);
        mFamousAphorismWealthTextview.setTypeface(MyApplication.sTypeface);
    }

    @OnClick({R.id.audio_story_xuetang_back_image, R.id.famous_aphorism_person_textview, R.id.famous_aphorism_things_textview, R.id.famous_aphorism_conduct_textview, R.id.famous_aphorism_career_textview, R.id.famous_aphorism_mentality_textview, R.id.famous_aphorism_personnel_textview, R.id.famous_aphorism_scholarship_textview, R.id.famous_aphorism_contact_textview, R.id.famous_aphorism_life_textview, R.id.famous_aphorism_emotion_textview, R.id.famous_aphorism_healthy_textview, R.id.famous_aphorism_wealth_textview})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.audio_story_xuetang_back_image:
                finish();
                break;
            case R.id.famous_aphorism_person_textview:
                type2 = mFamousAphorismPersonTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.famous_aphorism_things_textview:
                type2 = mFamousAphorismThingsTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.famous_aphorism_conduct_textview:
                type2 = mFamousAphorismConductTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.famous_aphorism_career_textview:
                type2 = mFamousAphorismCareerTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.famous_aphorism_mentality_textview:
                type2 = mFamousAphorismMentalityTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.famous_aphorism_personnel_textview:
                type2 = mFamousAphorismPersonnelTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.famous_aphorism_scholarship_textview:
                type2 = mFamousAphorismScholarshipTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.famous_aphorism_contact_textview:
                type2 = mFamousAphorismContactTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.famous_aphorism_life_textview:
                type2 = mFamousAphorismLifeTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.famous_aphorism_emotion_textview:
                type2 = mFamousAphorismEmotionTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.famous_aphorism_healthy_textview:
                type2 = mFamousAphorismHealthyTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.famous_aphorism_wealth_textview:
                type2 = mFamousAphorismWealthTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
        }
    }
}
