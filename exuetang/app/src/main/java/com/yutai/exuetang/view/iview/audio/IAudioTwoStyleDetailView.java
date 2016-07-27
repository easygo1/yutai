package com.yutai.exuetang.view.iview.audio;

/**
 * Created by ZFG on 2016/7/16.
 * 二级分类详情
 */
public interface IAudioTwoStyleDetailView {
    //item跳转的页面
    void intentNextActivity(int music_id);

    //
    void showToast(String msg);

    //单击tab显示不同的listview
    void tabShow();

    int gettabStyle();

    int getmusicListCur();

    String getmusicTYype1();

    String getmusicTYype2();

}
