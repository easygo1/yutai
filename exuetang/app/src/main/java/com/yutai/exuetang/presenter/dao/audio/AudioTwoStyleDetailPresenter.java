package com.yutai.exuetang.presenter.dao.audio;


import com.yutai.exuetang.model.beans.audio.music.Music;

import java.util.List;

/**
 * Created by ZFG on 2016/7/16.
 * 监听器用来处理Model实现后的操作
 */
public interface AudioTwoStyleDetailPresenter {
    public List<Music> onSuccess();

    public void onFailure();
}
