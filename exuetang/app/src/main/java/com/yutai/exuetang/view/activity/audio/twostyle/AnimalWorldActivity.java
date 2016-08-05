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

public class AnimalWorldActivity extends AppCompatActivity {

    @Bind(R.id.audio_story_xuetang_back_image)
    ImageView mAudioStoryXuetangBackImage;
    @Bind(R.id.audio_twostyle_title)
    TextView mAudioTwostyleTitle;
    @Bind(R.id.audio_animal_world_textview1)
    TextView mAudioAnimalWorldTextview1;
    @Bind(R.id.animal_world_crawl_textview)
    TextView mAnimalWorldCrawlTextview;
    @Bind(R.id.animal_world_insect_textview)
    TextView mAnimalWorldInsectTextview;
    @Bind(R.id.animal_world_fly_textview)
    TextView mAnimalWorldFlyTextview;
    @Bind(R.id.animal_world_poultry_textview)
    TextView mAnimalWorldPoultryTextview;
    @Bind(R.id.animal_world_lactation_textview)
    TextView mAnimalWorldLactationTextview;
    @Bind(R.id.animal_world_fish_textview)
    TextView mAnimalWorldFishTextview;
    @Bind(R.id.animal_world_carnivorous_textview)
    TextView mAnimalWorldCarnivorousTextview;
    @Bind(R.id.animal_world_amphibious_textview)
    TextView mAnimalWorldAmphibiousTextview;
    private String type1 = "动物世界";
    private String type2 = "爬行类动物";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_world);
        ButterKnife.bind(this);
        initWordStyleType();
        mAudioTwostyleTitle.setText(type1);
    }

    private void initWordStyleType() {
        mAudioTwostyleTitle.setTypeface(MyApplication.sTypeface);
        mAudioAnimalWorldTextview1.setTypeface(MyApplication.sTypeface);
        mAnimalWorldCrawlTextview.setTypeface(MyApplication.sTypeface);
        mAnimalWorldInsectTextview.setTypeface(MyApplication.sTypeface);
        mAnimalWorldFlyTextview.setTypeface(MyApplication.sTypeface);
        mAnimalWorldPoultryTextview.setTypeface(MyApplication.sTypeface);
        mAnimalWorldLactationTextview.setTypeface(MyApplication.sTypeface);
        mAnimalWorldFishTextview.setTypeface(MyApplication.sTypeface);
        mAnimalWorldCarnivorousTextview.setTypeface(MyApplication.sTypeface);
        mAnimalWorldAmphibiousTextview.setTypeface(MyApplication.sTypeface);
    }

    @OnClick({R.id.audio_story_xuetang_back_image, R.id.animal_world_crawl_textview, R.id.animal_world_insect_textview, R.id.animal_world_fly_textview, R.id.animal_world_poultry_textview, R.id.animal_world_lactation_textview, R.id.animal_world_fish_textview, R.id.animal_world_carnivorous_textview, R.id.animal_world_amphibious_textview})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.audio_story_xuetang_back_image:
                finish();
                break;
            case R.id.animal_world_crawl_textview:
                type2 = mAnimalWorldCrawlTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.animal_world_insect_textview:
                type2 = mAnimalWorldInsectTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.animal_world_fly_textview:
                type2 = mAnimalWorldFlyTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.animal_world_poultry_textview:
                type2 = mAnimalWorldPoultryTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.animal_world_lactation_textview:
                type2 = mAnimalWorldLactationTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.animal_world_fish_textview:
                type2 = mAnimalWorldFishTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.animal_world_carnivorous_textview:
                type2 = mAnimalWorldCarnivorousTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.animal_world_amphibious_textview:
                type2 = mAnimalWorldAmphibiousTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
        }
    }
}
