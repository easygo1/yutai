package com.yutai.exuetang.view.activity.audio.twostyle;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.yutai.exuetang.R;

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

    //好词好句
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_good_words);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.audio_story_xuetang_back_image, R.id.goodwords_person_textview, R.id.goodwords_things_textview, R.id.goodwords_matter_textview, R.id.goodwords_imagine_textview, R.id.goodwords_scenery_textview, R.id.goodwords_other_textview})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.audio_story_xuetang_back_image:
                break;
            case R.id.goodwords_person_textview:
                break;
            case R.id.goodwords_things_textview:
                break;
            case R.id.goodwords_matter_textview:
                break;
            case R.id.goodwords_imagine_textview:
                break;
            case R.id.goodwords_scenery_textview:
                break;
            case R.id.goodwords_other_textview:
                break;
        }
    }
}
