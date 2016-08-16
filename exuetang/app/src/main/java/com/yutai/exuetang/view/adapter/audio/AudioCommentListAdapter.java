package com.yutai.exuetang.view.adapter.audio;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.yutai.exuetang.R;
import com.yutai.exuetang.model.beans.audio.music.GsonMusicCommentBean;
import com.yutai.exuetang.view.application.MyApplication;

import java.util.List;

import jp.wasabeef.glide.transformations.CropCircleTransformation;

/**
 * Created by ZFG on 2016/8/16.
 */
public class AudioCommentListAdapter extends BaseAdapter {
    LayoutInflater mInflater;
    Context mContext;
    List<GsonMusicCommentBean> mMusicCommentList = null;

    public AudioCommentListAdapter(Context context, List<GsonMusicCommentBean> musicCommentList) {
        mContext = context;
        mMusicCommentList = musicCommentList;
        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return mMusicCommentList.size();
    }

    @Override
    public Object getItem(int position) {
        return mMusicCommentList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.musiccomment_list_item, null);
            viewHolder = new ViewHolder();
            //music
            viewHolder.mMusiccommentPhotoImage = (ImageView) convertView.findViewById(R.id.musiccomment_photo_image);
            viewHolder.mMusiccommentNicknameTextview = (TextView) convertView.findViewById(R.id.musiccomment_nickname_textview);
            viewHolder.mMusiccommentTimeTextview = (TextView) convertView.findViewById(R.id.musiccomment_time_textview);
            viewHolder.mMusiccommentContentTextview = (TextView) convertView.findViewById(R.id.musiccomment_content_textview);
            viewHolder.mMusiccommentNicknameTextview.setTypeface(MyApplication.sTypeface);
//            viewHolder.mMusiccommentTimeTextview.setTypeface(MyApplication.sTypeface);
            viewHolder.mMusiccommentContentTextview.setTypeface(MyApplication.sTypeface);
            convertView.setTag(viewHolder);
        } else {
            //说明开始上下滑动，后面的所有行布局采用第一次绘制时的缓存布局
            viewHolder = (ViewHolder) convertView.getTag();
        }
        GsonMusicCommentBean musicCommentBean = mMusicCommentList.get(position);
        Glide.with(mContext).load(musicCommentBean.getUser_photo())
                .bitmapTransform(new CropCircleTransformation(mContext))
                .error(R.mipmap.portrait_2)
                .into(viewHolder.mMusiccommentPhotoImage);
        viewHolder.mMusiccommentNicknameTextview.setText(musicCommentBean.getUser_nickname());
        viewHolder.mMusiccommentTimeTextview.setText(musicCommentBean.getComment_time());
        viewHolder.mMusiccommentContentTextview.setText(musicCommentBean.getComment_content());
        return convertView;
    }

    static class ViewHolder {
        //item布局控件
        ImageView mMusiccommentPhotoImage;
        TextView mMusiccommentNicknameTextview;
        TextView mMusiccommentTimeTextview;
        TextView mMusiccommentContentTextview;
    }
}
