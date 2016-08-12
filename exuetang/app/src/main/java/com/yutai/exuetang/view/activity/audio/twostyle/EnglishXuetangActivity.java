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

public class EnglishXuetangActivity extends AppCompatActivity {

    @Bind(R.id.audio_story_xuetang_back_image)
    ImageView mAudioStoryXuetangBackImage;
    @Bind(R.id.audio_twostyle_title)
    TextView mAudioTwostyleTitle;
    @Bind(R.id.audio_english_xuetang_textview1)
    TextView mAudioEnglishXuetangTextview1;
    @Bind(R.id.english_xuetang_zhongxia_textview)
    TextView mEnglishXuetangZhongxiaTextview;
    @Bind(R.id.english_xuetang_nothing_textview)
    TextView mEnglishXuetangNothingTextview;
    @Bind(R.id.english_xuetang_luomiou_textview)
    TextView mEnglishXuetangLuomiouTextview;
    @Bind(R.id.english_xuetang_xinbailin_textview)
    TextView mEnglishXuetangXinbailinTextview;
    @Bind(R.id.english_xuetang_aosailuo_textview)
    TextView mEnglishXuetangAosailuoTextview;
    @Bind(R.id.english_xuetang_bofengyu_textview)
    TextView mEnglishXuetangBofengyuTextview;
    @Bind(R.id.english_xuetang_maike_textview)
    TextView mEnglishXuetangMaikeTextview;
    @Bind(R.id.english_xuetang_xunhan_textview)
    TextView mEnglishXuetangXunhanTextview;
    private String type1 = "英文经典";
    private String type2 = "仲夏夜之梦";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_english_xuetang);
        ButterKnife.bind(this);
        initWordStyleType();
        mAudioTwostyleTitle.setText(type1);
    }

    private void initWordStyleType() {
        mAudioTwostyleTitle.setTypeface(MyApplication.sTypeface);
        mAudioEnglishXuetangTextview1.setTypeface(MyApplication.sTypeface);
        mEnglishXuetangZhongxiaTextview.setTypeface(MyApplication.sTypeface);
        mEnglishXuetangNothingTextview.setTypeface(MyApplication.sTypeface);
        mEnglishXuetangLuomiouTextview.setTypeface(MyApplication.sTypeface);
        mEnglishXuetangXinbailinTextview.setTypeface(MyApplication.sTypeface);
        mEnglishXuetangAosailuoTextview.setTypeface(MyApplication.sTypeface);
        mEnglishXuetangBofengyuTextview.setTypeface(MyApplication.sTypeface);
        mEnglishXuetangMaikeTextview.setTypeface(MyApplication.sTypeface);
        mEnglishXuetangXunhanTextview.setTypeface(MyApplication.sTypeface);
    }

    @OnClick({R.id.audio_story_xuetang_back_image, R.id.english_xuetang_zhongxia_textview, R.id.english_xuetang_nothing_textview, R.id.english_xuetang_luomiou_textview, R.id.english_xuetang_xinbailin_textview, R.id.english_xuetang_aosailuo_textview, R.id.english_xuetang_bofengyu_textview, R.id.english_xuetang_maike_textview, R.id.english_xuetang_xunhan_textview})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.audio_story_xuetang_back_image:
                finish();
                break;
            case R.id.english_xuetang_zhongxia_textview:
                type2 = mEnglishXuetangZhongxiaTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.english_xuetang_nothing_textview:
                type2 = mEnglishXuetangNothingTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.english_xuetang_luomiou_textview:
                type2 = mEnglishXuetangLuomiouTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.english_xuetang_xinbailin_textview:
                type2 = mEnglishXuetangXinbailinTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.english_xuetang_aosailuo_textview:
                type2 = mEnglishXuetangAosailuoTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.english_xuetang_bofengyu_textview:
                type2 = mEnglishXuetangBofengyuTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.english_xuetang_maike_textview:
                type2 = mEnglishXuetangMaikeTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.english_xuetang_xunhan_textview:
                type2 = mEnglishXuetangXunhanTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
        }
    }
}
