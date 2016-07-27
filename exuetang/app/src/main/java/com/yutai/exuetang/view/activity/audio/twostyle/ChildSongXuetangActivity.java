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

public class ChildSongXuetangActivity extends AppCompatActivity {
    /**
     * 儿歌学堂页面
     */
    @Bind(R.id.audio_childsong_xuetang_back_image)
    ImageView mAudioChildsongXuetangBackImage;
    @Bind(R.id.audio_childsongxuetang_textview1)
    TextView mAudioChildsongxuetangTextview1;
    @Bind(R.id.childsong_jingdian_textview)
    TextView mChildsongJingdianTextview;
    @Bind(R.id.childsong_dance_textview)
    TextView mChildsongDanceTextview;
    @Bind(R.id.childsong_chuanshao_textview)
    TextView mChildsongChuanshaoTextview;
    @Bind(R.id.childsong_english_textview)
    TextView mChildsongEnglishTextview;
    @Bind(R.id.childsong_fashion_textview)
    TextView mChildsongFashionTextview;
    @Bind(R.id.childsong_pome_textview)
    TextView mChildsongPomeTextview;
    private String type1 = "儿歌学堂";
    private String type2 = "经典儿歌";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_song_xuetang);
        ButterKnife.bind(this);
        initWordStyleType();
    }

    private void initWordStyleType() {
        mAudioChildsongxuetangTextview1.setTypeface(MyApplication.sTypeface);
        mChildsongJingdianTextview.setTypeface(MyApplication.sTypeface);
        mChildsongDanceTextview.setTypeface(MyApplication.sTypeface);
        mChildsongChuanshaoTextview.setTypeface(MyApplication.sTypeface);
        mChildsongEnglishTextview.setTypeface(MyApplication.sTypeface);
        mChildsongFashionTextview.setTypeface(MyApplication.sTypeface);
        mChildsongPomeTextview.setTypeface(MyApplication.sTypeface);
    }

    @OnClick({R.id.audio_childsong_xuetang_back_image, R.id.childsong_jingdian_textview, R.id.childsong_dance_textview, R.id.childsong_chuanshao_textview, R.id.childsong_english_textview, R.id.childsong_fashion_textview, R.id.childsong_pome_textview})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.audio_childsong_xuetang_back_image:
                finish();
                break;
            case R.id.childsong_jingdian_textview:
                type2 = mChildsongJingdianTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.childsong_dance_textview:
                type2 = mChildsongDanceTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.childsong_chuanshao_textview:
                type2 = mChildsongChuanshaoTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.childsong_english_textview:
                type2 = mChildsongEnglishTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.childsong_fashion_textview:
                type2 = mChildsongFashionTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.childsong_pome_textview:
                type2 = mChildsongPomeTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
        }
    }
}
