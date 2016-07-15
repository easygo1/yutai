package com.yutai.audio.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by 崔凯 on 2016/7/15.
 */
public class MyTextView extends TextView {
    private Context mContext;
    public MyTextView(Context context) {
        super(context);
        this.mContext = context;
        setTypeface();
    }

    public MyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        setTypeface();
    }

    public MyTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        setTypeface();
    }

    public void setTypeface() {
        /*if (style == Typeface.BOLD) {
            super.setTypeface(Typeface.createFromAsset(getContext().getAssets(), "fonts/myFont_Bol"));
        } else {
            super.setTypeface(Typeface.createFromAsset(getContext().getAssets(), "fonts/myFont.ttf"));
        }*/
        super.setTypeface(Typeface.createFromAsset(mContext.getAssets(), "fonts/myFont.ttf"));
    }
}
