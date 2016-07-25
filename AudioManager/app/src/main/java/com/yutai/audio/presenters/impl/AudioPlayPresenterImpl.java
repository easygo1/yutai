package com.yutai.audio.presenters.impl;

import com.yutai.audio.model.beans.music.Music;
import com.yutai.audio.model.dao.IAudioPlayDAO;
import com.yutai.audio.model.impl.AudioPlayDAOImpl;
import com.yutai.audio.presenters.dao.AudioPlayPresenter;
import com.yutai.audio.view.iview.IAudioPlayView;

/**
 * Created by Administrator on 2016/7/19.
 */
public class AudioPlayPresenterImpl implements AudioPlayPresenter {
    private IAudioPlayDAO mIAudioplayDAO;
    private IAudioPlayView mIAudioPlayView;

    public AudioPlayPresenterImpl(IAudioPlayView IAudioPlayView) {
        mIAudioPlayView = IAudioPlayView;
        mIAudioplayDAO=new AudioPlayDAOImpl();
    }

    @Override
    public Music onSucess() {
        int music_id=mIAudioPlayView.getMusicID();
        Music music=mIAudioplayDAO.getMusic(music_id);
        return music;
    }
}
