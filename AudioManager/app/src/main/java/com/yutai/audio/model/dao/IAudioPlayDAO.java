package com.yutai.audio.model.dao;

import com.yutai.audio.model.beans.music.Music;

/**
 * Created by Administrator on 2016/7/19.
 */
public interface IAudioPlayDAO {
    //根据上一个页面传过来的musicid获取该音乐的全部信息
    Music getMusic(int music_id);
}
