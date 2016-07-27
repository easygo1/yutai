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

public class WhysActivity extends AppCompatActivity {

    @Bind(R.id.audio_story_xuetang_back_image)
    ImageView mAudioStoryXuetangBackImage;
    @Bind(R.id.audio_twostyle_title)
    TextView mAudioTwostyleTitle;
    @Bind(R.id.audio_whys_textview1)
    TextView mAudioWhysTextview1;
    @Bind(R.id.whys_body_textview)
    TextView mWhysBodyTextview;
    @Bind(R.id.whys_animal_textview)
    TextView mWhysAnimalTextview;
    @Bind(R.id.whys_life_textview)
    TextView mWhysLifeTextview;
    @Bind(R.id.whys_plant_textview)
    TextView mWhysPlantTextview;
    @Bind(R.id.whys_common_sense_textview)
    TextView mWhysCommonSenseTextview;
    @Bind(R.id.whys_earth_textview)
    TextView mWhysEarthTextview;
    @Bind(R.id.whys_technology_textview)
    TextView mWhysTechnologyTextview;
    @Bind(R.id.whys_universe_textview)
    TextView mWhysUniverseTextview;
    @Bind(R.id.whys_militarytraffic_textview)
    TextView mWhysMilitarytrafficTextview;
    @Bind(R.id.whys_mpc_textview)
    TextView mWhysMpcTextview;
    @Bind(R.id.audio_whys_textview2)
    TextView mAudioWhysTextview2;
    @Bind(R.id.whys_culture_art_textview)
    TextView mWhysCultureArtTextview;
    @Bind(R.id.whys_military_textview)
    TextView mWhysMilitaryTextview;
    @Bind(R.id.whys_sport_country_textview)
    TextView mWhysSportCountryTextview;
    @Bind(R.id.whys_science_textview)
    TextView mWhysScienceTextview;
    @Bind(R.id.whys_chinaforeign_history_textview)
    TextView mWhysChinaforeignHistoryTextview;
    @Bind(R.id.whys_astronomy_geography_textview)
    TextView mWhysAstronomyGeographyTextview;
    @Bind(R.id.whys_animal_plant_textview)
    TextView mWhysAnimalPlantTextview;
    @Bind(R.id.whys_subject_textview)
    TextView mWhysSubjectTextview;
    private String type1 = "十万个为什么";
    private String type2 = "奇妙的人体";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whys);
        ButterKnife.bind(this);
        initWordStyleType();
        mAudioTwostyleTitle.setText(type1);
    }

    private void initWordStyleType() {
        mAudioTwostyleTitle.setTypeface(MyApplication.sTypeface);
        mAudioWhysTextview1.setTypeface(MyApplication.sTypeface);
        mWhysBodyTextview.setTypeface(MyApplication.sTypeface);
        mWhysAnimalTextview.setTypeface(MyApplication.sTypeface);
        mWhysLifeTextview.setTypeface(MyApplication.sTypeface);
        mWhysPlantTextview.setTypeface(MyApplication.sTypeface);
        mWhysCommonSenseTextview.setTypeface(MyApplication.sTypeface);
        mWhysEarthTextview.setTypeface(MyApplication.sTypeface);
        mWhysTechnologyTextview.setTypeface(MyApplication.sTypeface);
        mWhysUniverseTextview.setTypeface(MyApplication.sTypeface);
        mWhysMilitarytrafficTextview.setTypeface(MyApplication.sTypeface);
        mWhysMpcTextview.setTypeface(MyApplication.sTypeface);
        mAudioWhysTextview2.setTypeface(MyApplication.sTypeface);
        mWhysCultureArtTextview.setTypeface(MyApplication.sTypeface);
        mWhysMilitaryTextview.setTypeface(MyApplication.sTypeface);
        mWhysSportCountryTextview.setTypeface(MyApplication.sTypeface);
        mWhysScienceTextview.setTypeface(MyApplication.sTypeface);
        mWhysChinaforeignHistoryTextview.setTypeface(MyApplication.sTypeface);
        mWhysAstronomyGeographyTextview.setTypeface(MyApplication.sTypeface);
        mWhysAnimalPlantTextview.setTypeface(MyApplication.sTypeface);
        mWhysSubjectTextview.setTypeface(MyApplication.sTypeface);
    }

    @OnClick({R.id.audio_story_xuetang_back_image, R.id.whys_body_textview, R.id.whys_animal_textview, R.id.whys_life_textview, R.id.whys_plant_textview, R.id.whys_common_sense_textview, R.id.whys_earth_textview, R.id.whys_technology_textview, R.id.whys_universe_textview, R.id.whys_militarytraffic_textview, R.id.whys_mpc_textview, R.id.whys_culture_art_textview, R.id.whys_military_textview, R.id.whys_sport_country_textview, R.id.whys_science_textview, R.id.whys_chinaforeign_history_textview, R.id.whys_astronomy_geography_textview, R.id.whys_animal_plant_textview, R.id.whys_subject_textview})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.audio_story_xuetang_back_image:
                finish();
                break;
            case R.id.whys_body_textview:
                type2 = mWhysBodyTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.whys_animal_textview:
                type2 = mWhysAnimalTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.whys_life_textview:
                type2 = mWhysLifeTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.whys_plant_textview:
                type2 = mWhysPlantTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.whys_common_sense_textview:
                type2 = mWhysCommonSenseTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.whys_earth_textview:
                type2 = mWhysEarthTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.whys_technology_textview:
                type2 = mWhysTechnologyTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.whys_universe_textview:
                type2 = mWhysUniverseTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.whys_militarytraffic_textview:
                type2 = mWhysMilitarytrafficTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.whys_mpc_textview:
                type2 = mWhysMpcTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.whys_culture_art_textview:
                type2 = mWhysCultureArtTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.whys_military_textview:
                type2 = mWhysMilitaryTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.whys_sport_country_textview:
                type2 = mWhysSportCountryTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.whys_science_textview:
                type2 = mWhysScienceTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.whys_chinaforeign_history_textview:
                type2 = mWhysChinaforeignHistoryTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.whys_astronomy_geography_textview:
                type2 = mWhysAstronomyGeographyTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.whys_animal_plant_textview:
                type2 = mWhysAnimalPlantTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.whys_subject_textview:
                type2 = mWhysSubjectTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
        }
    }
}
