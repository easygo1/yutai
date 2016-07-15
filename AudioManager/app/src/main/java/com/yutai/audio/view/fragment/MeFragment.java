package com.yutai.audio.view.fragment;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yutai.audio.R;
import com.yutai.audio.utils.MyTextView;

/**
 * Created by ZFG on 2016/7/13.
 */
public class MeFragment extends Fragment {
    View mView;
    private LinearLayout mePerimeter;
    private ImageView meSet;
    private ImageView meUserPhoto;
    private MyTextView meUserNickname;
    private TextView meUserContent;
    private LinearLayout meLike;
    private LinearLayout meRecentplay;
    private LinearLayout meDownloading;
    private LinearLayout meTiming;
    private LinearLayout meCoins;
    private TextView meLocalaudio;
    private TextView meLocalvideo;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_me, null);
        initViews();
        return mView;
    }

    private void initViews() {

        Typeface customFont = Typeface.createFromAsset(getActivity().getAssets(), "fonts/myFont.ttf");
        mePerimeter = (LinearLayout) mView.findViewById(R.id.me_perimeter);
        meSet = (ImageView) mView.findViewById(R.id.me_set);
        meUserPhoto = (ImageView) mView.findViewById(R.id.me_user_photo);
        meUserNickname = (MyTextView) mView.findViewById(R.id.me_user_nickname);
        meUserContent = (TextView) mView.findViewById(R.id.me_user_content);
        meLike = (LinearLayout) mView.findViewById(R.id.me_like);
        meRecentplay = (LinearLayout) mView.findViewById(R.id.me_recentplay);
        meDownloading = (LinearLayout) mView.findViewById(R.id.me_downloading);
        meTiming = (LinearLayout) mView.findViewById(R.id.me_timing);
        meCoins = (LinearLayout) mView.findViewById(R.id.me_coins);
        meLocalaudio = (TextView) mView.findViewById(R.id.me_localaudio);
        meLocalvideo = (TextView) mView.findViewById(R.id.me_localvideo);
        meLocalaudio.setTypeface(customFont);
        meLocalvideo.setTypeface(customFont);
    }
}
