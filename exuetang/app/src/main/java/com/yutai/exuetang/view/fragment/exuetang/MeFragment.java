package com.yutai.exuetang.view.fragment.exuetang;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yolanda.nohttp.NoHttp;
import com.yolanda.nohttp.RequestMethod;
import com.yolanda.nohttp.rest.OnResponseListener;
import com.yolanda.nohttp.rest.Request;
import com.yolanda.nohttp.rest.Response;
import com.yutai.exuetang.R;
import com.yutai.exuetang.model.beans.exuetang.GsonMeInfo;
import com.yutai.exuetang.utils.RequestManager;
import com.yutai.exuetang.utils.ToastUtils;
import com.yutai.exuetang.view.activity.exuetang.LoginActivity;
import com.yutai.exuetang.view.activity.exuetang.MyInfoActivity;
import com.yutai.exuetang.view.application.MyApplication;

import java.lang.reflect.Type;

import jp.wasabeef.glide.transformations.CropCircleTransformation;

/**
 * Created by Administrator on 2016/7/25.
 */
public class MeFragment extends Fragment implements View.OnClickListener {
    public static final int GET_USERMEINFO_WHAT = 1;
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
    //服务端的URL
    public String mPath = MyApplication.url + "/exuetangservlet";
    private int user_id;//偏好设置中获取
    SharedPreferences mSharedPreferences;
    public static final String USER = "user";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_me, null);
        getintentdata();
        initViews();
        initData();
        addListeners();
        return mView;
    }

    private void getintentdata() {
        mSharedPreferences = getActivity().getSharedPreferences(USER, Context.MODE_PRIVATE);
        user_id = mSharedPreferences.getInt("user_id", 0);//整个页面要用
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

    private void initData() {
        Request<String> request = NoHttp.createStringRequest(mPath, RequestMethod.POST);
        // 添加请求参数
        request.add("methods", "getMeInfo");
        request.add("user_id", user_id);
        RequestManager.getInstance().add(GET_USERMEINFO_WHAT, request, onResponseListener);
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
        Intent intent = new Intent();
        switch (id) {
            case R.id.me_set:
                ToastUtils.showToast(getActivity(), "点击了设置按钮");
                intent.setClass(getActivity(), LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.me_user_photo:
                ToastUtils.showToast(getActivity(), "点击了用户头像");
                intent.setClass(getActivity(), MyInfoActivity.class);
                startActivity(intent);
                break;
            case R.id.me_album:
                ToastUtils.showToast(getActivity(), "点击了相册");
                break;
            case R.id.me_qiandao:
                ToastUtils.showToast(getActivity(), "点击了签到");
                break;
            case R.id.me_coin_layout:
                ToastUtils.showToast(getActivity(), "点击了学习币");
                break;
            case R.id.me_stageshow:
                ToastUtils.showToast(getActivity(), "点击了舞台秀");
                break;
            case R.id.me_audio:
                ToastUtils.showToast(getActivity(), "点击了音频宝");
                break;
            case R.id.me_habit:
                ToastUtils.showToast(getActivity(), "点击了培养宝");
                break;
            case R.id.me_study:
                ToastUtils.showToast(getActivity(), "点击了e学宝");
                break;
            case R.id.me_home:
                ToastUtils.showToast(getActivity(), "点击了家园宝");
                break;
            case R.id.me_shop:
                ToastUtils.showToast(getActivity(), "点击了e商城");
                break;
            case R.id.me_train:
                ToastUtils.showToast(getActivity(), "点击了e培宝");
                break;
            case R.id.me_evaluation:
                ToastUtils.showToast(getActivity(), "点击了测评宝");
                break;
        }
    }

    //    网络请求的结果的处理
    public OnResponseListener<String> onResponseListener = new OnResponseListener<String>() {
        @Override
        public void onStart(int what) {

        }

        @Override
        public void onSucceed(int what, Response<String> response) {
            String result=response.get();
            switch (what) {
                case GET_USERMEINFO_WHAT:
                    //                    得到用户信息
                    Gson gson = new Gson();
                    Type type = new TypeToken<GsonMeInfo>() {
                    }.getType();
                    Log.e("meInfo",result);
                    GsonMeInfo gsonMeInfo = gson.fromJson(result, type);
                    if(gsonMeInfo.getCode()==200){
                        Log.e("myinfo",gsonMeInfo.toString());
                        if(gsonMeInfo.getChild_photo()!=null){
                            Glide.with(getContext()).load(gsonMeInfo.getChild_photo())
                                    .bitmapTransform(new CropCircleTransformation(getActivity()))
                                    .error(R.mipmap.portrait_2)
                                    .into(mMeUserPhoto);
                        }
                        if(gsonMeInfo.getUser_nickname()!=null){
                            mMeUserNickname.setText(gsonMeInfo.getUser_nickname());
                        }
                        if(gsonMeInfo.getUser_coins()!=0){
                            mMeCoinNum.setText(""+gsonMeInfo.getUser_coins()+"个");
                        }
                        if(gsonMeInfo.getUser_newphone()!=null){
                            mMeUserPhone.setText(gsonMeInfo.getUser_newphone());
                        }
                    }
                    if(gsonMeInfo.getCode()==222){
                        mMeCoinNum.setText(""+gsonMeInfo.getUser_coins()+"个");
                    }
                    break;
            }
        }

        @Override
        public void onFailed(int what, String url, Object tag, Exception exception, int responseCode, long networkMillis) {

        }

        @Override
        public void onFinish(int what) {

        }
    };


}
