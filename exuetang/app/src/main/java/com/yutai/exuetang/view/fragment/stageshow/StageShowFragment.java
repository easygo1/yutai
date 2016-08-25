package com.yutai.exuetang.view.fragment.stageshow;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yutai.exuetang.R;

/**
 * Created by ZFG on 2016/8/17.
 */
public class StageShowFragment extends Fragment {
    View mView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_stageshow,null);
        /*getintentdata();
        initViews();
        initData();
        addListeners();*/
        return mView;
    }
}
