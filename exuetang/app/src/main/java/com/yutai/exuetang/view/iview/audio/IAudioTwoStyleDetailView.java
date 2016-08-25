package com.yutai.exuetang.view.iview.audio;

import android.app.Activity;

import com.yutai.exuetang.model.beans.audio.music.Music;

import java.util.List;

/**
 * Created by ZFG on 2016/7/16.
 * 二级分类详情
 */
public interface IAudioTwoStyleDetailView {
    //item跳转的页面
    void intentNextActivity(Music music);
    //
    void showToast(String msg);

    //单击tab显示不同的listview
    void tabShow();

    int gettabStyle();

    int getmusicListCur();

    String getmusicTYype1();

    String getmusicTYype2();

    Activity getactivity();

    void toActivity(List<Music> musicList);

    int UpdateAuditionRequest();

   void gettypepath(String type_path);
}
