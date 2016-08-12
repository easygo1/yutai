package com.yutai.exuetang.view.adapter.audio;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuAdapter;
import com.yutai.exuetang.R;
import com.yutai.exuetang.model.beans.audio.music.Music;
import com.yutai.exuetang.view.application.MyApplication;

import java.util.List;

/**
 * Created by Administrator on 2016/8/6.
 */
public class PlayDialogAdapter extends SwipeMenuAdapter<PlayDialogAdapter.DefaultViewHolder> {
    private List<Music> mMusicList;
    LayoutInflater mInflater;
    Context mContext;
    private OnItemClickListener mOnItemClickListener;

    public PlayDialogAdapter(List<Music> mMusicList,Context context) {
        this.mMusicList = mMusicList;
        mContext = context;
        mInflater = LayoutInflater.from(mContext);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    @Override
    public int getItemCount() {
        return mMusicList == null ? 0 : mMusicList.size();
    }

    @Override
    public View onCreateContentView(ViewGroup parent, int viewType) {
        return LayoutInflater.from(parent.getContext()).inflate(R.layout.play_dialog_item, parent, false);
    }

    @Override
    public PlayDialogAdapter.DefaultViewHolder onCompatCreateViewHolder(View realContentView, int viewType) {
        return new DefaultViewHolder(realContentView);
    }

    @Override
    public void onBindViewHolder(PlayDialogAdapter.DefaultViewHolder holder, int position) {
        //holder.setData(titles.get(position));
        Glide.with(mContext)
                .load(mMusicList.get(position).getMusic_photo())
                .into(holder.mDialogItemMusicPhoto);
        holder.mDialogItemMusicName.setText(mMusicList.get(position).getMusic_name());
        holder.mDialogItemMusicAuditionSum.setText("" + mMusicList.get(position).getMusic_audition_sum_number());
        holder.mDialogItemMusicDownloadSum.setText("" + mMusicList.get(position).getMusic_download_sum_number());
        holder.setOnItemClickListener(mOnItemClickListener);
    }

    static class DefaultViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView mDialogItemMusicPhoto;
        TextView mDialogItemMusicName;
        TextView mDialogItemMusicDescribe;
        TextView mDialogItemMusicNum;
        TextView mDialogItemMusicAuditionSum;
        TextView mDialogItemMusicDownloadSum;
        OnItemClickListener mOnItemClickListener;

        public DefaultViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            mDialogItemMusicPhoto = (ImageView) itemView.findViewById(R.id.dialog_item_music_photo);
            mDialogItemMusicName = (TextView) itemView.findViewById(R.id.dialog_item_music_name);
            mDialogItemMusicDescribe = (TextView) itemView.findViewById(R.id.dialog_item_music_describe);
            mDialogItemMusicNum = (TextView) itemView.findViewById(R.id.dialog_item_music_num);
            mDialogItemMusicAuditionSum = (TextView) itemView.findViewById(R.id.dialog_item_music_audition_sum);
            mDialogItemMusicDownloadSum = (TextView) itemView.findViewById(R.id.dialog_item_music_download_sum);
            mDialogItemMusicName.setTypeface(MyApplication.sTypeface);
            mDialogItemMusicAuditionSum.setTypeface(MyApplication.sTypeface);
            mDialogItemMusicDownloadSum.setTypeface(MyApplication.sTypeface);
        }

        public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
            this.mOnItemClickListener = onItemClickListener;
        }

        @Override
        public void onClick(View v) {
            if (mOnItemClickListener != null) {
                mOnItemClickListener.onItemClick(getAdapterPosition());
            }
        }
    }

}
