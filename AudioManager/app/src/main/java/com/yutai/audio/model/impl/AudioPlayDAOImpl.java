package com.yutai.audio.model.impl;

import com.yutai.audio.model.beans.music.Music;
import com.yutai.audio.model.dao.IAudioPlayDAO;

/**
 * Created by Administrator on 2016/7/19.
 */
public class AudioPlayDAOImpl implements IAudioPlayDAO {
    private Music mMusic;
    @Override
    public Music getMusic(int music_id) {
        //网络请求
        //根据ID得到音乐的信息
        mMusic =new Music(1,"两只老虎","http://img0.imgtn.bdimg.com/it/u=3001458640,323133104&fm=21&gp=0.jpg","http://easygo.b0.upaiyun.com/yutaimp3/林俊杰 - 她说.mp3","http://easygo.b0.upaiyun.com/yutaimp3/她说.lrc","幼儿故事","童话故事");
        return mMusic;
    }
}
