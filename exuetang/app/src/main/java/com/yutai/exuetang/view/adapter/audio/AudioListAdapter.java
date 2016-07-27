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
import com.yutai.exuetang.model.beans.audio.music.Music;
import com.yutai.exuetang.utils.ToastUtils;
import com.yutai.exuetang.view.application.MyApplication;

import java.util.List;

/**
 * Created by ZFG on 2016/7/15.
 */
public class AudioListAdapter extends BaseAdapter implements View.OnClickListener {
    LayoutInflater mInflater;
    Context mContext;
    List<Music> mMusicList = null;

    public AudioListAdapter(List<Music> musicList, Context context) {
        mMusicList = musicList;
        mContext = context;
        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return mMusicList.size();
    }

    @Override
    public Object getItem(int position) {
        return mMusicList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.item_download_image:
                //单击下载按钮时
                ToastUtils.showToast(mContext, "下载对话框");
                break;
            case R.id.item_share_image:
                //单击分享按钮时
                ToastUtils.showToast(mContext, "分享对话框");
                break;
        }
    }

    class ViewHolder {
        //item布局控件
        ImageView itemMusicPhoto;
        TextView itemMusicName;
        TextView itemMusicAuditionSum;
        TextView itemMusicDownloadSum;
        ImageView itemDownloadImage;
        ImageView itemShareImage;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.audio_twostyle_list_item, null);
            viewHolder = new ViewHolder();
            //music
            viewHolder.itemMusicPhoto = (ImageView) convertView.findViewById(R.id.item_music_photo);
            viewHolder.itemMusicName = (TextView) convertView.findViewById(R.id.item_music_name);
            viewHolder.itemMusicAuditionSum = (TextView) convertView.findViewById(R.id.item_music_audition_sum);
            viewHolder.itemMusicDownloadSum = (TextView) convertView.findViewById(R.id.item_music_download_sum);
            viewHolder.itemDownloadImage = (ImageView) convertView.findViewById(R.id.item_download_image);
            viewHolder.itemShareImage = (ImageView) convertView.findViewById(R.id.item_share_image);
            viewHolder.itemMusicName.setTypeface(MyApplication.sTypeface);
            viewHolder.itemMusicAuditionSum.setTypeface(MyApplication.sTypeface);
            viewHolder.itemMusicDownloadSum.setTypeface(MyApplication.sTypeface);
            convertView.setTag(viewHolder);
        } else {
            //说明开始上下滑动，后面的所有行布局采用第一次绘制时的缓存布局
            viewHolder = (ViewHolder) convertView.getTag();
        }
        final ImageView downloadimageView = (ImageView) convertView.findViewById(R.id.item_download_image);
        final ImageView shareimageView = (ImageView) convertView.findViewById(R.id.item_share_image);
        downloadimageView.setOnClickListener(this);
        shareimageView.setOnClickListener(this);
        final Music music = mMusicList.get(position);
        Glide.with(mContext)
                .load(music.getMusic_photo())
                .into(viewHolder.itemMusicPhoto);
        viewHolder.itemMusicName.setText(music.getMusic_name());
        viewHolder.itemMusicAuditionSum.setText("" + music.getMusic_audition_sum_number());
        viewHolder.itemMusicDownloadSum.setText("" + music.getMusic_download_sum_number());
        return convertView;
    }
}
