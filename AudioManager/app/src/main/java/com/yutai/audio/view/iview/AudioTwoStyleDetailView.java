package com.yutai.audio.view.iview;

/**
 * Created by ZFG on 2016/7/16.
 * 二级分类详情
 */
public interface AudioTwoStyleDetailView {
    //item跳转的页面
    void intentNextActivity();
    //
    void showToast(String msg);

    //单击tab显示不同的listview
    void tabShow();

    int gettabStyle();

    int getmusicListCur();


}
