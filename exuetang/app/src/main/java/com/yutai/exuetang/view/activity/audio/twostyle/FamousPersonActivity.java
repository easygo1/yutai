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

public class FamousPersonActivity extends AppCompatActivity {

    @Bind(R.id.audio_story_xuetang_back_image)
    ImageView mAudioStoryXuetangBackImage;
    @Bind(R.id.audio_twostyle_title)
    TextView mAudioTwostyleTitle;
    @Bind(R.id.audio_famous_person_textview1)
    TextView mAudioFamousPersonTextview1;
    @Bind(R.id.famous_person_history_textview)
    TextView mFamousPersonHistoryTextview;
    @Bind(R.id.famous_person_famous_textview)
    TextView mFamousPersonFamousTextview;
    @Bind(R.id.famous_person_contemporary_luomiou_textview)
    TextView mFamousPersonContemporaryLuomiouTextview;
    @Bind(R.id.famous_person_sucess_textview)
    TextView mFamousPersonSucessTextview;
    @Bind(R.id.famous_person_world_aosailuo_textview)
    TextView mFamousPersonWorldAosailuoTextview;
    @Bind(R.id.famous_person_hero_textview)
    TextView mFamousPersonHeroTextview;
    @Bind(R.id.famous_person_star_textview)
    TextView mFamousPersonStarTextview;
    private String type1 = "名人传";
    private String type2 = "历史名人";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_famous_person);
        ButterKnife.bind(this);
        initWordStyleType();
        mAudioTwostyleTitle.setText(type1);
    }

    private void initWordStyleType() {
        mAudioTwostyleTitle.setTypeface(MyApplication.sTypeface);
        mAudioFamousPersonTextview1.setTypeface(MyApplication.sTypeface);
        mFamousPersonHistoryTextview.setTypeface(MyApplication.sTypeface);
        mFamousPersonFamousTextview.setTypeface(MyApplication.sTypeface);
        mFamousPersonContemporaryLuomiouTextview.setTypeface(MyApplication.sTypeface);
        mFamousPersonSucessTextview.setTypeface(MyApplication.sTypeface);
        mFamousPersonWorldAosailuoTextview.setTypeface(MyApplication.sTypeface);
        mFamousPersonHeroTextview.setTypeface(MyApplication.sTypeface);
        mFamousPersonStarTextview.setTypeface(MyApplication.sTypeface);
    }

    @OnClick({R.id.audio_story_xuetang_back_image, R.id.famous_person_history_textview, R.id.famous_person_famous_textview, R.id.famous_person_contemporary_luomiou_textview, R.id.famous_person_sucess_textview, R.id.famous_person_world_aosailuo_textview, R.id.famous_person_hero_textview, R.id.famous_person_star_textview})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.audio_story_xuetang_back_image:
                finish();
                break;
            case R.id.famous_person_history_textview:
                type2 = mFamousPersonHistoryTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.famous_person_famous_textview:
                type2 = mFamousPersonFamousTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.famous_person_contemporary_luomiou_textview:
                type2 = mFamousPersonContemporaryLuomiouTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.famous_person_sucess_textview:
                type2 = mFamousPersonSucessTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.famous_person_world_aosailuo_textview:
                type2 = mFamousPersonWorldAosailuoTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.famous_person_hero_textview:
                type2 = mFamousPersonHeroTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.famous_person_star_textview:
                type2 = mFamousPersonStarTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
        }
    }
}
