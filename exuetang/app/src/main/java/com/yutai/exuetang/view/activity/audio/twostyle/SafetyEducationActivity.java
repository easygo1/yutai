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

public class SafetyEducationActivity extends AppCompatActivity {

    @Bind(R.id.audio_story_xuetang_back_image)
    ImageView mAudioStoryXuetangBackImage;
    @Bind(R.id.audio_twostyle_title)
    TextView mAudioTwostyleTitle;
    @Bind(R.id.audio_safetyeducation_textview1)
    TextView mAudioSafetyeducationTextview1;
    @Bind(R.id.safety_outdoor_textview)
    TextView mSafetyOutdoorTextview;
    @Bind(R.id.safety_playgame_textview)
    TextView mSafetyPlaygameTextview;
    @Bind(R.id.safety_home_textview)
    TextView mSafetyHomeTextview;
    @Bind(R.id.safety_traffic_textview)
    TextView mSafetyTrafficTextview;
    @Bind(R.id.safety_school_textview)
    TextView mSafetySchoolTextview;
    @Bind(R.id.satety_other_textview)
    TextView mSatetyOtherTextview;

    private String type1 = "安全教育";
    private String type2 = "户外安全";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_safety_education);
        ButterKnife.bind(this);
        initWordStyleType();
        mAudioTwostyleTitle.setText(type1);
    }

    private void initWordStyleType() {
        mAudioTwostyleTitle.setTypeface(MyApplication.sTypeface);
        mAudioSafetyeducationTextview1.setTypeface(MyApplication.sTypeface);
        mSafetyOutdoorTextview.setTypeface(MyApplication.sTypeface);
        mSafetyPlaygameTextview.setTypeface(MyApplication.sTypeface);
        mSafetyHomeTextview.setTypeface(MyApplication.sTypeface);
        mSafetyTrafficTextview.setTypeface(MyApplication.sTypeface);
        mSafetySchoolTextview.setTypeface(MyApplication.sTypeface);
        mSatetyOtherTextview.setTypeface(MyApplication.sTypeface);
    }

    @OnClick({R.id.audio_story_xuetang_back_image, R.id.safety_outdoor_textview, R.id.safety_playgame_textview, R.id.safety_home_textview, R.id.safety_traffic_textview, R.id.safety_school_textview, R.id.satety_other_textview})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.audio_story_xuetang_back_image:
                finish();
                break;
            case R.id.safety_outdoor_textview:
                type2 = mSafetyOutdoorTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.safety_playgame_textview:
                type2 = mSafetyPlaygameTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.safety_home_textview:
                type2 = mSafetyHomeTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.safety_traffic_textview:
                type2 = mSafetyTrafficTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.safety_school_textview:
                type2 = mSafetySchoolTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.satety_other_textview:
                type2 = mSatetyOtherTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
        }
    }
}
