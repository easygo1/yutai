package com.yutai.exuetang.utils;

import android.content.Context;
import android.content.Intent;

import com.yutai.exuetang.view.activity.audio.AudioTwoStyleDetailActivity;

/**
 * Created by Administrator on 2016/7/26.
 */
public class IntentTwoStyleActivityUtils {
    public static void intentTwoStyleActivity(final Context context, final String type1, final String type2) {
//        进入下个页面时需要传两个值 一级分类和二级分类
        Intent intent = new Intent();
        intent.putExtra("type1", type1);
        intent.putExtra("type2", type2);
        intent.setClass(context, AudioTwoStyleDetailActivity.class);
        context.startActivity(intent);
    }
}
