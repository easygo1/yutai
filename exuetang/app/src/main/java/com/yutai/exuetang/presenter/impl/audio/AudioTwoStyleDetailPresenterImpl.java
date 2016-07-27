package com.yutai.exuetang.presenter.impl.audio;

import com.yutai.exuetang.model.beans.audio.music.Music;
import com.yutai.exuetang.model.dao.audio.IAudioTwoStyleDetailDAO;
import com.yutai.exuetang.model.impl.audio.AudioTwoStyleDetailDAOImpl;
import com.yutai.exuetang.presenter.dao.audio.AudioTwoStyleDetailPresenter;
import com.yutai.exuetang.view.iview.audio.IAudioTwoStyleDetailView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZFG on 2016/7/16.
 */
public class AudioTwoStyleDetailPresenterImpl implements AudioTwoStyleDetailPresenter {

    private IAudioTwoStyleDetailDAO mAudioTwoStyleDetailDAO;
    private IAudioTwoStyleDetailView mAudioTwoStyleDetailView;
    private List<Music> mMusicList;

    public AudioTwoStyleDetailPresenterImpl(IAudioTwoStyleDetailView audioTwoStyleDetailView) {
        mAudioTwoStyleDetailDAO = new AudioTwoStyleDetailDAOImpl();
        mAudioTwoStyleDetailView = audioTwoStyleDetailView;
        mMusicList = new ArrayList<>();
    }

    @Override
    public List<Music> onSuccess() {
        int tabstyle = mAudioTwoStyleDetailView.gettabStyle();
        int cur = mAudioTwoStyleDetailView.getmusicListCur();
        String type1 = mAudioTwoStyleDetailView.getmusicTYype1();
        String type2 = mAudioTwoStyleDetailView.getmusicTYype2();
        mMusicList = mAudioTwoStyleDetailDAO.getData(type1, type2, tabstyle, cur, this);
        return mMusicList;
    }

    @Override
    public void onFailure() {
        mAudioTwoStyleDetailView.showToast("获取数据失败");
    }
}
