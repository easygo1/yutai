package com.yutai.audio.model.dao;

import com.yutai.audio.model.beans.music.Music;
import com.yutai.audio.presenters.dao.AudioTwoStyleDetailPresenter;

import java.util.List;

/**
 * Created by ZFG on 2016/7/16.
 */
public interface AudioTwoStyleDetailDAO {
    //得到数据 分页显示
    List<Music> getData(int tabstyle, int cur, AudioTwoStyleDetailPresenter twoStyleDetailPresenter);
}
