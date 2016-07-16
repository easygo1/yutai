package com.yutai.audio.presenters.dao;

import com.yutai.audio.model.beans.music.Music;

import java.util.List;

/**
 * Created by ZFG on 2016/7/16.
 * 监听器用来处理Model实现后的操作
 */
public interface AudioTwoStyleDetailPresenter {
    public List<Music> onSuccess();

    public void onFailure();
}
