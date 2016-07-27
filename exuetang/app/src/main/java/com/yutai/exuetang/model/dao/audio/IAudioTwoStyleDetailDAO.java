package com.yutai.exuetang.model.dao.audio;

import com.yutai.exuetang.model.beans.audio.music.Music;
import com.yutai.exuetang.presenter.dao.audio.AudioTwoStyleDetailPresenter;

import java.util.List;

/**
 * Created by Administrator on 2016/7/26.
 */
public interface IAudioTwoStyleDetailDAO {
    //得到数据 分页显示
    List<Music> getData(String type1,String type2,int tabstyle, int cur, AudioTwoStyleDetailPresenter twoStyleDetailPresenter);
}
