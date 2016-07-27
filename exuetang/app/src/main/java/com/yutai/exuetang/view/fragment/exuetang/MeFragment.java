package com.yutai.exuetang.view.fragment.exuetang;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.yutai.exuetang.R;
import com.yutai.exuetang.utils.ToastUtils;
import com.yutai.exuetang.view.activity.exuetang.LoginActivity;
import com.yutai.exuetang.view.application.MyApplication;

/**
 * Created by Administrator on 2016/7/25.
 */
public class MeFragment extends Fragment implements View.OnClickListener{
    private ImageView mMeSet;
    private ImageView mMeUserPhoto;
    private TextView mMeUserNickname;
    private TextView mMeUserPhone;
    private LinearLayout mMeAlbum;
    private Button mMeQiandao;
    private RelativeLayout mMeCoinLayout;
    private TextView mMeCoinNum;
    private LinearLayout mMeStageshow;
    private LinearLayout mMeAudio;
    private LinearLayout mMeHabit;
    private LinearLayout mMeStudy;
    private LinearLayout mMeHome;
    private LinearLayout mMeShop;
    private LinearLayout mMeTrain;
    private LinearLayout mMeEvaluation;
    View mView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_me,null);
        initViews();
        addListeners();
        return mView;
    }
    private void initViews() {
        mMeSet = (ImageView) mView.findViewById(R.id.me_set);
        mMeUserPhoto = (ImageView) mView.findViewById(R.id.me_user_photo);
        mMeUserNickname = (TextView) mView.findViewById(R.id.me_user_nickname);
        mMeUserPhone = (TextView) mView.findViewById(R.id.me_user_phone);
        mMeAlbum = (LinearLayout) mView.findViewById(R.id.me_album);
        mMeQiandao = (Button) mView.findViewById(R.id.me_qiandao);
        mMeCoinLayout = (RelativeLayout) mView.findViewById(R.id.me_coin_layout);
        mMeCoinNum = (TextView) mView.findViewById(R.id.me_coin_num);
        mMeStageshow = (LinearLayout) mView.findViewById(R.id.me_stageshow);
        mMeAudio = (LinearLayout) mView.findViewById(R.id.me_audio);
        mMeHabit = (LinearLayout) mView.findViewById(R.id.me_habit);
        mMeStudy = (LinearLayout) mView.findViewById(R.id.me_study);
        mMeHome = (LinearLayout) mView.findViewById(R.id.me_home);
        mMeShop = (LinearLayout) mView.findViewById(R.id.me_shop);
        mMeTrain = (LinearLayout) mView.findViewById(R.id.me_train);
        mMeEvaluation = (LinearLayout) mView.findViewById(R.id.me_evaluation);
        mMeUserNickname.setTypeface(MyApplication.sTypeface);
        mMeQiandao.setTypeface(MyApplication.sTypeface);
    }
    private void addListeners() {
        mMeSet.setOnClickListener(this);
        mMeUserPhoto.setOnClickListener(this);
        mMeAlbum.setOnClickListener(this);
        mMeQiandao.setOnClickListener(this);
        mMeCoinLayout.setOnClickListener(this);
        mMeStageshow.setOnClickListener(this);
        mMeAudio.setOnClickListener(this);
        mMeHabit.setOnClickListener(this);
        mMeStudy.setOnClickListener(this);
        mMeHome.setOnClickListener(this);
        mMeShop.setOnClickListener(this);
        mMeTrain.setOnClickListener(this);
        mMeEvaluation.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.me_set:
                ToastUtils.showToast(getActivity(),"点击了设置按钮");
                Intent intent = new Intent();
                intent.setClass(getActivity(), LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.me_user_photo:
                ToastUtils.showToast(getActivity(),"点击了用户头像");
                break;
            case R.id.me_album:
                ToastUtils.showToast(getActivity(),"点击了相册");
                break;
            case R.id.me_qiandao:
                ToastUtils.showToast(getActivity(),"点击了签到");
                break;
            case R.id.me_coin_layout:
                ToastUtils.showToast(getActivity(),"点击了学习币");
                break;
            case R.id.me_stageshow:
                ToastUtils.showToast(getActivity(),"点击了舞台秀");
                break;
            case R.id.me_audio:
                ToastUtils.showToast(getActivity(),"点击了音频宝");
                break;
            case R.id.me_habit:
                ToastUtils.showToast(getActivity(),"点击了培养宝");
                break;
            case R.id.me_study:
                ToastUtils.showToast(getActivity(),"点击了e学宝");
                break;
            case R.id.me_home:
                ToastUtils.showToast(getActivity(),"点击了家园宝");
                break;
            case R.id.me_shop:
                ToastUtils.showToast(getActivity(),"点击了e商城");
                break;
            case R.id.me_train:
                ToastUtils.showToast(getActivity(),"点击了e培宝");
                break;
            case R.id.me_evaluation:
                ToastUtils.showToast(getActivity(),"点击了测评宝");
                break;
        }
    }
}
