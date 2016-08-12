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

public class PlantWorldActivity extends AppCompatActivity {
    @Bind(R.id.audio_story_xuetang_back_image)
    ImageView mAudioStoryXuetangBackImage;
    @Bind(R.id.audio_twostyle_title)
    TextView mAudioTwostyleTitle;
    @Bind(R.id.audio_plant_world_textview1)
    TextView mAudioPlantWorldTextview1;
    @Bind(R.id.plant_world_angiosperm_textview)
    TextView mPlantWorldAngiospermTextview;
    @Bind(R.id.plant_world_gymnosperms_textview)
    TextView mPlantWorldGymnospermsTextview;
    @Bind(R.id.plant_world_dicotyledon_textview)
    TextView mPlantWorldDicotyledonTextview;
    @Bind(R.id.plant_world_fern_textview)
    TextView mPlantWorldFernTextview;
    @Bind(R.id.plant_world_monocotyledon_textview)
    TextView mPlantWorldMonocotyledonTextview;
    @Bind(R.id.plant_world_moss_textview)
    TextView mPlantWorldMossTextview;
    @Bind(R.id.audio_plant_world_textview2)
    TextView mAudioPlantWorldTextview2;
    @Bind(R.id.plant_world_algae_textview)
    TextView mPlantWorldAlgaeTextview;
    @Bind(R.id.plant_world_bacteria_textview)
    TextView mPlantWorldBacteriaTextview;
    @Bind(R.id.plant_world_fungus_textview)
    TextView mPlantWorldFungusTextview;
    @Bind(R.id.plant_world_blue_textview)
    TextView mPlantWorldBlueTextview;
    @Bind(R.id.plant_world_lichens_textview)
    TextView mPlantWorldLichensTextview;
    private String type1 = "植物世界";
    private String type2 = "被子植物";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant_world);
        ButterKnife.bind(this);
        initWordStyleType();
        mAudioTwostyleTitle.setText(type1);
    }

    private void initWordStyleType() {
        mAudioTwostyleTitle.setTypeface(MyApplication.sTypeface);
        mAudioPlantWorldTextview1.setTypeface(MyApplication.sTypeface);
        mPlantWorldAngiospermTextview.setTypeface(MyApplication.sTypeface);
        mPlantWorldGymnospermsTextview.setTypeface(MyApplication.sTypeface);
        mPlantWorldDicotyledonTextview.setTypeface(MyApplication.sTypeface);
        mPlantWorldFernTextview.setTypeface(MyApplication.sTypeface);
        mPlantWorldMonocotyledonTextview.setTypeface(MyApplication.sTypeface);
        mPlantWorldMossTextview.setTypeface(MyApplication.sTypeface);
        mAudioPlantWorldTextview2.setTypeface(MyApplication.sTypeface);
        mPlantWorldAlgaeTextview.setTypeface(MyApplication.sTypeface);
        mPlantWorldBacteriaTextview.setTypeface(MyApplication.sTypeface);
        mPlantWorldFungusTextview.setTypeface(MyApplication.sTypeface);
        mPlantWorldBlueTextview.setTypeface(MyApplication.sTypeface);
        mPlantWorldLichensTextview.setTypeface(MyApplication.sTypeface);
    }

    @OnClick({R.id.audio_story_xuetang_back_image, R.id.plant_world_angiosperm_textview, R.id.plant_world_gymnosperms_textview, R.id.plant_world_dicotyledon_textview, R.id.plant_world_fern_textview, R.id.plant_world_monocotyledon_textview, R.id.plant_world_moss_textview, R.id.plant_world_algae_textview, R.id.plant_world_bacteria_textview, R.id.plant_world_fungus_textview, R.id.plant_world_blue_textview, R.id.plant_world_lichens_textview})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.audio_story_xuetang_back_image:
                finish();
                break;
            case R.id.plant_world_angiosperm_textview:
                type2 = mPlantWorldAngiospermTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.plant_world_gymnosperms_textview:
                type2 = mPlantWorldGymnospermsTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.plant_world_dicotyledon_textview:
                type2 = mPlantWorldDicotyledonTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.plant_world_fern_textview:
                type2 = mPlantWorldFernTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.plant_world_monocotyledon_textview:
                type2 = mPlantWorldMonocotyledonTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.plant_world_moss_textview:
                type2 = mPlantWorldMossTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.plant_world_algae_textview:
                type2 = mPlantWorldAlgaeTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.plant_world_bacteria_textview:
                type2 = mPlantWorldBacteriaTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.plant_world_fungus_textview:
                type2 = mPlantWorldFungusTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.plant_world_blue_textview:
                type2 = mPlantWorldBlueTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
            case R.id.plant_world_lichens_textview:
                type2 = mPlantWorldLichensTextview.getText().toString();
                IntentTwoStyleActivityUtils.intentTwoStyleActivity(this, type1, type2);
                break;
        }
    }
}
