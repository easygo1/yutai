package com.yutai.audio.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.yutai.audio.R;
import com.yutai.audio.model.beans.music.Music;
import com.yutai.audio.utils.ToastUtils;
import com.yutai.audio.view.adapter.MeLocalAudioAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 崔凯 on 2016/7/15.
 */
public class MeLocalAudioFragment extends Fragment{
    View mMeLocalAudioView;
    private ListView meLocalaudioListview;
    //定义适配器
    MeLocalAudioAdapter mMelocalAudioAdapter;
    List<Music> mMusicList = null;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mMeLocalAudioView = inflater.inflate(R.layout.me_localaudio,null);
        initViews();
        initAdapter();
        return mMeLocalAudioView;
    }

    private void initAdapter() {
        mMusicList = new ArrayList<>();
        Music music = new Music(001,"一只老虎","两只老虎MP3文件路径","两只老虎歌词文件路径","儿歌","经典儿歌",1,1,1,1,1,1,1,1,
                "http://img4.imgtn.bdimg.com/it/u=2474703108,3781290758&fm=11&gp=0.jpg","http://img4.imgtn.bdimg.com/it/u=2474703108,3781290758&fm=11&gp=0.jpg",
                5,"2016-07-15","备注");
        Music music2 = new Music(002,"两只老虎","两只老虎MP3文件路径","两只老虎歌词文件路径","儿歌","经典儿歌",1,1,1,1,1,1,1,1,
                "http://img4.imgtn.bdimg.com/it/u=2474703108,3781290758&fm=11&gp=0.jpg","http://img4.imgtn.bdimg.com/it/u=2474703108,3781290758&fm=11&gp=0.jpg",
                5,"2016-07-15","备注");
        Music music3 = new Music(003,"三只老虎","两只老虎MP3文件路径","两只老虎歌词文件路径","儿歌","经典儿歌",1,1,1,1,1,1,1,1,
                "http://img4.imgtn.bdimg.com/it/u=2474703108,3781290758&fm=11&gp=0.jpg","http://img4.imgtn.bdimg.com/it/u=2474703108,3781290758&fm=11&gp=0.jpg",
                5,"2016-07-15","备注");
        mMusicList.add(music);
        mMusicList.add(music2);
        mMusicList.add(music3);
        mMelocalAudioAdapter = new MeLocalAudioAdapter(getActivity(),mMusicList);
        meLocalaudioListview.setAdapter(mMelocalAudioAdapter);
        meLocalaudioListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ToastUtils.showToast(getActivity(),"点击了第"+position+"个");
            }
        });
        meLocalaudioListview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                ToastUtils.showToast(getActivity(),"长按删除该item");
                return true;
            }
        });
    }

    private void initViews() {
        meLocalaudioListview = (ListView) mMeLocalAudioView.findViewById(R.id.me_localaudio_listview);
    }
}
