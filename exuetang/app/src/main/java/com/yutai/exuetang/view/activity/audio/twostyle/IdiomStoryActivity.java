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

public class IdiomStoryActivity extends AppCompatActivity {
    @Bind(R.id.audio_story_xuetang_back_image)
    ImageView mAudioStoryXuetangBackImage;
    @Bind(R.id.audio_twostyle_title)
    TextView mAudioTwostyleTitle;
    @Bind(R.id.audio_idiomstory_textview1)
    TextView mAudioIdiomstoryTextview1;
    @Bind(R.id.idiomstory_yuyan_textview)
    TextView mIdiomstoryYuyanTextview;
    @Bind(R.id.idiomstory_sanguo_textview)
    TextView mIdiomstorySanguoTextview;
    @Bind(R.id.idiomstory_history_textview)
    TextView mIdiomstoryHistoryTextview;
    @Bind(R.id.idiomstory_warfare_textview)
    TextView mIdiomstoryWarfareTextview;
    @Bind(R.id.idiomstory_myth_textview)
    TextView mIdiomstoryMythTextview;
    @Bind(R.id.idiomstory_lizhi_textview)
    TextView mIdiomstoryLizhiTextview;
//    成语故事
    private String type1 = "成语故事";
    private String type2 = "寓言故事    ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_idiom_story);
        ButterKnife.bind(this);
        initWordStyleType();
        mAudioTwostyleTitle.setText(type1);
    }

    private void initWordStyleType() {
        mAudioTwostyleTitle.setTypeface(MyApplication.sTypeface);
        mAudioIdiomstoryTextview1.setTypeface(MyApplication.sTypeface);
        mIdiomstoryYuyanTextview.setTypeface(MyApplication.sTypeface);
        mIdiomstorySanguoTextview.setTypeface(MyApplication.sTypeface);
        mIdiomstoryHistoryTextview.setTypeface(MyApplication.sTypeface);
        mIdiomstoryWarfareTextview.setTypeface(MyApplication.sTypeface);
        mIdiomstoryMythTextview.setTypeface(MyApplication.sTypeface);
        mIdiomstoryLizhiTextview.setTypeface(MyApplication.sTypeface);
    }

    @OnClick({R.id.audio_story_xuetang_back_image, R.id.idiomstory_yuyan_textview, R.id.idiomstory_sanguo_textview, R.id.idiomstory_history_textview, R.id.idiomstory_warfare_textview, R.id.idiomstory_myth_textview, R.id.idiomstory_lizhi_textview})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.audio_story_xuetang_back_image:
                finish();
                break;
            case R.id.idiomstory_yuyan_textview:
                type2 = mIdiomstoryYuyanTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.idiomstory_sanguo_textview:
                type2 = mIdiomstorySanguoTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.idiomstory_history_textview:
                type2 = mIdiomstoryHistoryTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.idiomstory_warfare_textview:
                type2 = mIdiomstoryWarfareTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.idiomstory_myth_textview:
                type2 = mIdiomstoryMythTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.idiomstory_lizhi_textview:
                type2 = mIdiomstoryLizhiTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
        }
    }
}
