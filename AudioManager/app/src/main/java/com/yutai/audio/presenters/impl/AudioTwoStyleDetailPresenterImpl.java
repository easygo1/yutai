package com.yutai.audio.presenters.impl;

import com.yutai.audio.model.beans.music.Music;
import com.yutai.audio.model.dao.AudioTwoStyleDetailDAO;
import com.yutai.audio.model.impl.AudioTwoStyleDetailDAOImpl;
import com.yutai.audio.presenters.dao.AudioTwoStyleDetailPresenter;
import com.yutai.audio.view.iview.AudioTwoStyleDetailView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZFG on 2016/7/16.
 */
public class AudioTwoStyleDetailPresenterImpl implements AudioTwoStyleDetailPresenter {

    private AudioTwoStyleDetailDAO mAudioTwoStyleDetailDAO;
    private AudioTwoStyleDetailView mAudioTwoStyleDetailView;
    private List<Music> mMusicList;

    public AudioTwoStyleDetailPresenterImpl(AudioTwoStyleDetailView audioTwoStyleDetailView) {
        mAudioTwoStyleDetailDAO = new AudioTwoStyleDetailDAOImpl();
        mAudioTwoStyleDetailView = audioTwoStyleDetailView;
        mMusicList = new ArrayList<>();
    }

    @Override
    public List<Music> onSuccess() {
        int tabstyle = mAudioTwoStyleDetailView.gettabStyle();
        int cur = mAudioTwoStyleDetailView.getmusicListCur();
        mMusicList = mAudioTwoStyleDetailDAO.getData(tabstyle, cur, this);
        return mMusicList;
    }

    @Override
    public void onFailure() {
        mAudioTwoStyleDetailView.showToast("获取数据失败");
    }
}
