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

public class GoodWordsActivity extends AppCompatActivity {
    @Bind(R.id.audio_story_xuetang_back_image)
    ImageView mAudioStoryXuetangBackImage;
    @Bind(R.id.audio_twostyle_title)
    TextView mAudioTwostyleTitle;
    @Bind(R.id.audio_goodwords_textview1)
    TextView mAudioGoodwordsTextview1;
    @Bind(R.id.goodwords_person_textview)
    TextView mGoodwordsPersonTextview;
    @Bind(R.id.goodwords_things_textview)
    TextView mGoodwordsThingsTextview;
    @Bind(R.id.goodwords_matter_textview)
    TextView mGoodwordsMatterTextview;
    @Bind(R.id.goodwords_imagine_textview)
    TextView mGoodwordsImagineTextview;
    @Bind(R.id.goodwords_scenery_textview)
    TextView mGoodwordsSceneryTextview;
    @Bind(R.id.goodwords_other_textview)
    TextView mGoodwordsOtherTextview;
    private String type1 = "好词好句";
    private String type2 = "人物篇";

    //好词好句
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_good_words);
        ButterKnife.bind(this);
        initWordStyleType();
        mAudioTwostyleTitle.setText(type1);
    }

    private void initWordStyleType() {
        mAudioTwostyleTitle.setTypeface(MyApplication.sTypeface);
        mAudioGoodwordsTextview1.setTypeface(MyApplication.sTypeface);
        mGoodwordsPersonTextview.setTypeface(MyApplication.sTypeface);
        mGoodwordsThingsTextview.setTypeface(MyApplication.sTypeface);
        mGoodwordsMatterTextview.setTypeface(MyApplication.sTypeface);
        mGoodwordsImagineTextview.setTypeface(MyApplication.sTypeface);
        mGoodwordsSceneryTextview.setTypeface(MyApplication.sTypeface);
        mGoodwordsOtherTextview.setTypeface(MyApplication.sTypeface);
    }

    @OnClick({R.id.audio_story_xuetang_back_image, R.id.goodwords_person_textview, R.id.goodwords_things_textview, R.id.goodwords_matter_textview, R.id.goodwords_imagine_textview, R.id.goodwords_scenery_textview, R.id.goodwords_other_textview})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.audio_story_xuetang_back_image:
                finish();
                break;
            case R.id.goodwords_person_textview:
                type2 = mGoodwordsPersonTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.goodwords_things_textview:
                type2 = mGoodwordsThingsTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.goodwords_matter_textview:
                type2 = mGoodwordsMatterTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.goodwords_imagine_textview:
                type2 = mGoodwordsImagineTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.goodwords_scenery_textview:
                type2 = mGoodwordsSceneryTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.goodwords_other_textview:
                type2 = mGoodwordsOtherTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
        }
    }
}
