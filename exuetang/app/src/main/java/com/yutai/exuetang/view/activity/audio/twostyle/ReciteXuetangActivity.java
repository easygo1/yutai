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

public class ReciteXuetangActivity extends AppCompatActivity {
    @Bind(R.id.audio_story_xuetang_back_image)
    ImageView mAudioStoryXuetangBackImage;
    @Bind(R.id.audio_twostyle_title)
    TextView mAudioTwostyleTitle;
    @Bind(R.id.audio_recite_textview1)
    TextView mAudioReciteTextview1;
    @Bind(R.id.recite_ancient_textview)
    TextView mReciteAncientTextview;
    @Bind(R.id.recite_foreign_textview)
    TextView mReciteForeignTextview;
    @Bind(R.id.recite_recent_textview)
    TextView mReciteRecentTextview;
    @Bind(R.id.recite_prose_textview)
    TextView mReciteProseTextview;
    @Bind(R.id.recite_modern_textview)
    TextView mReciteModernTextview;
    @Bind(R.id.recite_novel_textview)
    TextView mReciteNovelTextview;

    private String type1 = "朗诵学堂";
    private String type2 = "古代名篇";

    //朗诵学堂
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recite_xuetang);
        ButterKnife.bind(this);
        initWordStyleType();
        mAudioTwostyleTitle.setText(type1);
    }

    private void initWordStyleType() {
        mAudioTwostyleTitle.setTypeface(MyApplication.sTypeface);
        mAudioReciteTextview1.setTypeface(MyApplication.sTypeface);
        mReciteAncientTextview.setTypeface(MyApplication.sTypeface);
        mReciteForeignTextview.setTypeface(MyApplication.sTypeface);
        mReciteRecentTextview.setTypeface(MyApplication.sTypeface);
        mReciteProseTextview.setTypeface(MyApplication.sTypeface);
        mReciteModernTextview.setTypeface(MyApplication.sTypeface);
        mReciteNovelTextview.setTypeface(MyApplication.sTypeface);
    }

    @OnClick({R.id.audio_story_xuetang_back_image, R.id.recite_ancient_textview, R.id.recite_foreign_textview, R.id.recite_recent_textview, R.id.recite_prose_textview, R.id.recite_modern_textview, R.id.recite_novel_textview})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.audio_story_xuetang_back_image:
                finish();
                break;
            case R.id.recite_ancient_textview:
                type2 = mReciteAncientTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.recite_foreign_textview:
                type2 = mReciteForeignTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.recite_recent_textview:
                type2 = mReciteRecentTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.recite_prose_textview:
                type2 = mReciteProseTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.recite_modern_textview:
                type2 = mReciteModernTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.recite_novel_textview:
                type2 = mReciteNovelTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
        }
    }
}
