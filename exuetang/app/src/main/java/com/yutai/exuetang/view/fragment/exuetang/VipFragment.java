package com.yutai.exuetang.view.fragment.exuetang;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yutai.exuetang.R;

/**
 * Created by Administrator on 2016/7/25.
 */
public class VipFragment extends Fragment{
    View mView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_vip,null);
        return mView;
    }
}
