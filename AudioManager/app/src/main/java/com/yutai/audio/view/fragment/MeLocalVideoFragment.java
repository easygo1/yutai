package com.yutai.audio.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.yutai.audio.R;
import com.yutai.audio.model.beans.music.Music;
import com.yutai.audio.utils.ToastUtils;
import com.yutai.audio.view.adapter.MeLocalAudioAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 崔凯 on 2016/7/15.
 */
public class MeLocalVideoFragment extends Fragment{
    View mMeLocalVideoView;
    private ListView meLocalaudioListview;
    //定义适配器
    MeLocalAudioAdapter mMelocalAudioAdapter;
    List<Music> mMusicList = null;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mMeLocalVideoView = inflater.inflate(R.layout.me_localaudio,null);
        initViews();
        initAdapter();
        return mMeLocalVideoView;
    }

    private void initAdapter() {
        mMusicList = new ArrayList<>();
        mMelocalAudioAdapter = new MeLocalAudioAdapter(getActivity(),mMusicList);
        meLocalaudioListview.setAdapter(mMelocalAudioAdapter);
        meLocalaudioListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ToastUtils.showToast(getActivity(),"视频点击了第"+position+"个");
            }
        });
    }

    private void initViews() {
        meLocalaudioListview = (ListView) mMeLocalVideoView.findViewById(R.id.me_localaudio_listview);
    }
}
