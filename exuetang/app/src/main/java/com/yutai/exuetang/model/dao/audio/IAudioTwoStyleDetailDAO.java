package com.yutai.exuetang.model.dao.audio;

import android.app.Activity;

/**
 * Created by Administrator on 2016/7/26.
 */
public interface IAudioTwoStyleDetailDAO {
    //得到数据 分页显示
    void getData(String type1, String type2, int tabstyle, int cur, TwoListener twoListener, Activity mactivity);
//    更新音乐在线量
    void updateaudition(int music_id,Activity activity);
//    得到二级类型图片
    void getTypephoto(String type2,Activity activity,TypePathListener typePathListener);
}
