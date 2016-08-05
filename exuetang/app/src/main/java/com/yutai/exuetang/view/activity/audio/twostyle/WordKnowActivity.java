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

public class WordKnowActivity extends AppCompatActivity {

    @Bind(R.id.audio_story_xuetang_back_image)
    ImageView mAudioStoryXuetangBackImage;
    @Bind(R.id.audio_twostyle_title)
    TextView mAudioTwostyleTitle;
    @Bind(R.id.audio_wordkonw_textview1)
    TextView mAudioWordkonwTextview1;
    @Bind(R.id.wordkonw_homoionym_textview)
    TextView mWordkonwHomoionymTextview;
    @Bind(R.id.wordkonw_sentence_textview)
    TextView mWordkonwSentenceTextview;
    @Bind(R.id.wordkonw_antonym_textview)
    TextView mWordkonwAntonymTextview;
    @Bind(R.id.wordkonw_bookreview_textview)
    TextView mWordkonwBookreviewTextview;
    @Bind(R.id.wordkonw_synonym_textview)
    TextView mWordkonwSynonymTextview;
    @Bind(R.id.wordkonw_xiehouyu_textview)
    TextView mWordkonwXiehouyuTextview;
    private String type1 = "字词知识";
    private String type2 = "近义词";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_know);
        ButterKnife.bind(this);
        initWordStyleType();
        mAudioTwostyleTitle.setText(type1);
    }

    private void initWordStyleType() {
        mAudioTwostyleTitle.setTypeface(MyApplication.sTypeface);
        mAudioWordkonwTextview1.setTypeface(MyApplication.sTypeface);
        mWordkonwHomoionymTextview.setTypeface(MyApplication.sTypeface);
        mWordkonwSentenceTextview.setTypeface(MyApplication.sTypeface);
        mWordkonwAntonymTextview.setTypeface(MyApplication.sTypeface);
        mWordkonwBookreviewTextview.setTypeface(MyApplication.sTypeface);
        mWordkonwSynonymTextview.setTypeface(MyApplication.sTypeface);
        mWordkonwXiehouyuTextview.setTypeface(MyApplication.sTypeface);
    }

    @OnClick({R.id.audio_story_xuetang_back_image, R.id.wordkonw_homoionym_textview, R.id.wordkonw_sentence_textview, R.id.wordkonw_antonym_textview, R.id.wordkonw_bookreview_textview, R.id.wordkonw_synonym_textview, R.id.wordkonw_xiehouyu_textview})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.audio_story_xuetang_back_image:
                finish();
                break;
            case R.id.wordkonw_homoionym_textview:
                type2 = mWordkonwHomoionymTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.wordkonw_sentence_textview:
                type2 = mWordkonwSentenceTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.wordkonw_antonym_textview:
                type2 = mWordkonwAntonymTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.wordkonw_bookreview_textview:
                type2 = mWordkonwBookreviewTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.wordkonw_synonym_textview:
                type2 = mWordkonwSynonymTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.wordkonw_xiehouyu_textview:
                type2 = mWordkonwXiehouyuTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
        }
    }
}
