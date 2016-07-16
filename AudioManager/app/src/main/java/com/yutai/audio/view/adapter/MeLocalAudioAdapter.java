package com.yutai.audio.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.yutai.audio.R;
import com.yutai.audio.model.beans.music.Music;

import java.util.List;

/**
 * Created by 崔凯 on 2016/7/15.
 */
public class MeLocalAudioAdapter extends BaseAdapter{
    LayoutInflater mInflater;
    Context mContext;
    List<Music> mMusicList = null;

    public MeLocalAudioAdapter(Context context, List<Music> musicList) {
        mContext = context;
        mMusicList = musicList;
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
    //缓存布局中的控件
    class ViewHolder{
        ImageView meLocalaudioImage;
        TextView meLocalaudioName;
        TextView meLocalaudioAuditionSum;

    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;
        if(convertView == null){
            convertView = mInflater.inflate(R.layout.me_localaudio_list_item,null);
            viewHolder = new ViewHolder();
            viewHolder.meLocalaudioImage = (ImageView) convertView.findViewById(R.id.me_localaudio_image);
            viewHolder.meLocalaudioName = (TextView) convertView.findViewById(R.id.me_localaudio_name);
            viewHolder.meLocalaudioAuditionSum = (TextView) convertView.findViewById(R.id.me_localaudio_audition_sum);
            //把当前的控件缓存到布局视图中
            convertView.setTag(viewHolder);
        }else {
            //说明开始上下滑动，后面的所有行布局采用第一绘制时的缓存布局
            viewHolder = (ViewHolder) convertView.getTag();
        }
        //动态修改每一行的控件的内容
        viewHolder.meLocalaudioName.setText(mMusicList.get(position).getMusic_name());
        viewHolder.meLocalaudioAuditionSum.setText(mMusicList.get(position).getMusic_audition_sum_number()+"");
        Glide.with(mContext).load(mMusicList.get(position).getMusic_photo()).into(viewHolder.meLocalaudioImage);
        return convertView;
    }
}
