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

public class VirtueStoryActivity extends AppCompatActivity {

    @Bind(R.id.audio_story_xuetang_back_image)
    ImageView mAudioStoryXuetangBackImage;
    @Bind(R.id.audio_twostyle_title)
    TextView mAudioTwostyleTitle;
    @Bind(R.id.audio_virtuestory_textview1)
    TextView mAudioVirtuestoryTextview1;
    @Bind(R.id.virtue_story_ancient_textview)
    TextView mVirtueStoryAncientTextview;
    @Bind(R.id.virtue_story_forgin_textview)
    TextView mVirtueStoryForginTextview;
    @Bind(R.id.virtue_story_recent_textview)
    TextView mVirtueStoryRecentTextview;
    @Bind(R.id.virtue_story_modern_textview)
    TextView mVirtueStoryModernTextview;
    //中华美德故事
    private String type1 = "中华美德";
    private String type2 = "古代美德";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_virtue_story);
        ButterKnife.bind(this);
        initWordStyleType();
        mAudioTwostyleTitle.setText(type1);
    }

    private void initWordStyleType() {
        mAudioTwostyleTitle.setTypeface(MyApplication.sTypeface);
        mAudioVirtuestoryTextview1.setTypeface(MyApplication.sTypeface);
        mVirtueStoryAncientTextview.setTypeface(MyApplication.sTypeface);
        mVirtueStoryForginTextview.setTypeface(MyApplication.sTypeface);
        mVirtueStoryRecentTextview.setTypeface(MyApplication.sTypeface);
        mVirtueStoryModernTextview.setTypeface(MyApplication.sTypeface);
    }

    @OnClick({R.id.audio_story_xuetang_back_image, R.id.virtue_story_ancient_textview, R.id.virtue_story_forgin_textview, R.id.virtue_story_recent_textview, R.id.virtue_story_modern_textview})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.audio_story_xuetang_back_image:
                finish();
                break;
            case R.id.virtue_story_ancient_textview:
                type2 = mVirtueStoryAncientTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.virtue_story_forgin_textview:
                type2 = mVirtueStoryForginTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.virtue_story_recent_textview:
                type2 = mVirtueStoryRecentTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.virtue_story_modern_textview:
                type2 = mVirtueStoryModernTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
        }
    }
}
