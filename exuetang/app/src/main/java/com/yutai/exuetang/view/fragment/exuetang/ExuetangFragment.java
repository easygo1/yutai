package com.yutai.exuetang.view.fragment.exuetang;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.yutai.exuetang.R;
import com.yutai.exuetang.utils.ToastUtils;
import com.yutai.exuetang.view.activity.audio.AudioHomeActivity;
import com.yutai.exuetang.view.activity.stageshow.StageShowActivity;
import com.yutai.exuetang.view.application.MyApplication;


/**
 * Created by Administrator on 2016/7/25.
 */
public class ExuetangFragment extends Fragment implements View.OnClickListener{
    private ImageView mIndexStageshow;
    private TextView mIndexStageshowText;
    private ImageView mIndexCelebrityforum;
    private TextView mIndexCelebrityforumText;
    private ImageView mIndexEvaluation;
    private TextView mIndexEvaluationText;
    private ImageView mIndexHabit;
    private TextView mIndexHabitText;
    private ImageView mIndexAudio;
    private TextView mIndexAudioText;
    private ImageView mIndexStudy;
    private TextView mIndexStudyText;
   /* private ImageView mIndexTrain;
    private TextView mIndexTrainText;
    private ImageView mIndexHome;
    private TextView mIndexHomeText;
    private ImageView mIndexShop;
    private TextView mIndexShopText;*/
    View mView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_exuetang,null);
        initViews();
        addListeners();
        return mView;
    }
    private void initViews() {
        mIndexStageshow = (ImageView) mView.findViewById(R.id.index_stageshow);
        mIndexStageshowText = (TextView) mView.findViewById(R.id.index_stageshow_text);
        mIndexCelebrityforum = (ImageView) mView.findViewById(R.id.index_celebrityforum);
        mIndexCelebrityforumText = (TextView) mView.findViewById(R.id.index_celebrityforum_text);
        mIndexEvaluation = (ImageView) mView.findViewById(R.id.index_evaluation);
        mIndexEvaluationText = (TextView) mView.findViewById(R.id.index_evaluation_text);
        mIndexHabit = (ImageView) mView.findViewById(R.id.index_habit);
        mIndexHabitText = (TextView) mView.findViewById(R.id.index_habit_text);
        mIndexAudio = (ImageView) mView.findViewById(R.id.index_audio);
        mIndexAudioText = (TextView) mView.findViewById(R.id.index_audio_text);
        mIndexStudy = (ImageView) mView.findViewById(R.id.index_study);
        mIndexStudyText = (TextView) mView.findViewById(R.id.index_study_text);
       /* mIndexTrain = (ImageView) mView.findViewById(R.id.index_train);
        mIndexTrainText = (TextView) mView.findViewById(R.id.index_train_text);
        mIndexHome = (ImageView) mView.findViewById(R.id.index_home);
        mIndexHomeText = (TextView) mView.findViewById(R.id.index_home_text);
        mIndexShop = (ImageView) mView.findViewById(R.id.index_shop);
        mIndexShopText = (TextView) mView.findViewById(R.id.index_shop_text);
      */  //设置字体为自定义字体
        mIndexStageshowText.setTypeface(MyApplication.sTypeface);
        mIndexCelebrityforumText.setTypeface(MyApplication.sTypeface);
        mIndexEvaluationText.setTypeface(MyApplication.sTypeface);
        mIndexHabitText.setTypeface(MyApplication.sTypeface);
        mIndexAudioText.setTypeface(MyApplication.sTypeface);
        mIndexStudyText.setTypeface(MyApplication.sTypeface);
      /*  mIndexTrainText.setTypeface(MyApplication.sTypeface);
        mIndexHomeText.setTypeface(MyApplication.sTypeface);
        mIndexShopText.setTypeface(MyApplication.sTypeface);*/
    }
    private void addListeners() {
        mIndexStageshow.setOnClickListener(this);
        mIndexCelebrityforum.setOnClickListener(this);
        mIndexEvaluation.setOnClickListener(this);
        mIndexHabit.setOnClickListener(this);
        mIndexAudio.setOnClickListener(this);
        mIndexStudy.setOnClickListener(this);
       /* mIndexTrain.setOnClickListener(this);
        mIndexHome.setOnClickListener(this);
        mIndexShop.setOnClickListener(this);*/
    }
    @Override
    public void onClick(View v) {
        int id = v.getId();
        Intent intent = new Intent();
        switch (id){
            case R.id.index_stageshow:
                ToastUtils.showToast(getActivity(),"点击了舞台秀");
                intent.setClass(getActivity(), StageShowActivity.class);
                startActivity(intent);
                break;
            case R.id.index_celebrityforum:
                ToastUtils.showToast(getActivity(),"点击了音频宝");
                intent.setClass(getActivity(), AudioHomeActivity.class);
                startActivity(intent);
                break;
            case R.id.index_evaluation:
                ToastUtils.showToast(getActivity(),"点击了幼教宝");
                break;
            case R.id.index_habit:
                ToastUtils.showToast(getActivity(),"点击了优培宝");
                break;
            case R.id.index_audio:
                ToastUtils.showToast(getActivity(),"点击了搜培宝");
                break;
            case R.id.index_study:
                ToastUtils.showToast(getActivity(),"点击了淘宝阁");
                break;
         /*   case R.id.index_train:
                ToastUtils.showToast(getActivity(),"点击了e培宝");
                break;*/
        }
    }
}
