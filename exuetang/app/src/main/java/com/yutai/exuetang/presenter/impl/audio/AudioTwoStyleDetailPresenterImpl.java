package com.yutai.exuetang.presenter.impl.audio;

import android.app.Activity;

import com.yutai.exuetang.model.beans.audio.music.Music;
import com.yutai.exuetang.model.dao.audio.IAudioTwoStyleDetailDAO;
import com.yutai.exuetang.model.dao.audio.TwoListener;
import com.yutai.exuetang.model.dao.audio.TypePathListener;
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
    public void onSuccess() {
        int tabstyle = mAudioTwoStyleDetailView.gettabStyle();
        int cur = mAudioTwoStyleDetailView.getmusicListCur();
        String type1 = mAudioTwoStyleDetailView.getmusicTYype1();
        String type2 = mAudioTwoStyleDetailView.getmusicTYype2();
        Activity mactivity=mAudioTwoStyleDetailView.getactivity();
//        int music_id=mAudioTwoStyleDetailView.
        mAudioTwoStyleDetailDAO.getData(type1, type2, tabstyle, cur, new TwoListener() {
            @Override
            public void test(List<Music> musicList) {
                mAudioTwoStyleDetailView.toActivity(musicList);
            }
        }, mactivity);
        /*mMusicList =mAudioTwoStyleDetailDAO.getMusicList();*/
    }

    @Override
    public void onUpdateAudition() {
        Activity mactivity=mAudioTwoStyleDetailView.getactivity();
        int music_id=mAudioTwoStyleDetailView.UpdateAuditionRequest();
        mAudioTwoStyleDetailDAO.updateaudition(music_id,mactivity);
    }

    @Override
    public void onFailure() {
        mAudioTwoStyleDetailView.showToast("获取数据失败");
    }

    @Override
    public void onGetTypePhoto() {
        Activity mactivity=mAudioTwoStyleDetailView.getactivity();
        String type2 = mAudioTwoStyleDetailView.getmusicTYype2();
        mAudioTwoStyleDetailDAO.getTypephoto(type2, mactivity, new TypePathListener() {
            @Override
            public void test(String type2_path) {
                mAudioTwoStyleDetailView.gettypepath(type2_path);
            }
        });
    }
}
