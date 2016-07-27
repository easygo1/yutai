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

public class PomeXuetangActivity extends AppCompatActivity {

    @Bind(R.id.audio_story_xuetang_back_image)
    ImageView mAudioStoryXuetangBackImage;
    @Bind(R.id.audio_twostyle_title)
    TextView mAudioTwostyleTitle;
    @Bind(R.id.audio_pome_xuetang_textview1)
    TextView mAudioPomeXuetangTextview1;
    @Bind(R.id.pome_shijing_textview)
    TextView mPomeShijingTextview;
    @Bind(R.id.pome_tangshi_textview)
    TextView mPomeTangshiTextview;
    @Bind(R.id.pome_chuci_textview)
    TextView mPomeChuciTextview;
    @Bind(R.id.pome_songci_textview)
    TextView mPomeSongciTextview;
    @Bind(R.id.pome_hanfu_textview)
    TextView mPomeHanfuTextview;
    @Bind(R.id.pome_yuanqu_textview)
    TextView mPomeYuanquTextview;
    @Bind(R.id.pome_mingqing_textview)
    TextView mPomeMingqingTextview;
    private String type1 = "诗词学堂";
    private String type2 = "诗经";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pome_xuetang);
        ButterKnife.bind(this);
        initWordStyleType();
        mAudioTwostyleTitle.setText(type1);
    }

    private void initWordStyleType() {
        mAudioTwostyleTitle.setTypeface(MyApplication.sTypeface);
        mAudioPomeXuetangTextview1.setTypeface(MyApplication.sTypeface);
        mPomeShijingTextview.setTypeface(MyApplication.sTypeface);
        mPomeTangshiTextview.setTypeface(MyApplication.sTypeface);
        mPomeChuciTextview.setTypeface(MyApplication.sTypeface);
        mPomeSongciTextview.setTypeface(MyApplication.sTypeface);
        mPomeHanfuTextview.setTypeface(MyApplication.sTypeface);
        mPomeYuanquTextview.setTypeface(MyApplication.sTypeface);
        mPomeMingqingTextview.setTypeface(MyApplication.sTypeface);
    }

    @OnClick({R.id.audio_story_xuetang_back_image, R.id.pome_shijing_textview, R.id.pome_tangshi_textview, R.id.pome_chuci_textview, R.id.pome_songci_textview, R.id.pome_hanfu_textview, R.id.pome_yuanqu_textview, R.id.pome_mingqing_textview})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.audio_story_xuetang_back_image:
                finish();
                break;
            case R.id.pome_shijing_textview:
                type2 = mPomeShijingTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.pome_tangshi_textview:
                type2 = mPomeTangshiTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.pome_chuci_textview:
                type2 = mPomeChuciTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.pome_songci_textview:
                type2 = mPomeSongciTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.pome_hanfu_textview:
                type2 = mPomeHanfuTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.pome_yuanqu_textview:
                type2 = mPomeYuanquTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.pome_mingqing_textview:
                type2 = mPomeMingqingTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
        }
    }
}
