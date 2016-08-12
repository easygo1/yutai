package com.yutai.exuetang.model.impl.audio;

import com.yutai.exuetang.model.beans.audio.music.Music;
import com.yutai.exuetang.model.dao.audio.IAudioTwoStyleDetailDAO;
import com.yutai.exuetang.presenter.dao.audio.AudioTwoStyleDetailPresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZFG on 2016/7/16.
 */
public class AudioTwoStyleDetailDAOImpl implements IAudioTwoStyleDetailDAO {
    private List<Music> mMusicList;

    @Override
    public List<Music> getData(String type1, String type2, int tabstyle, int cur, AudioTwoStyleDetailPresenter twoStyleDetailPresenter) {
        mMusicList = new ArrayList<>();
        //网络请求 得到数据
        switch (tabstyle) {
            case 1:
                //人气推荐（按照试听量排序）
                Music music1 = new Music(1, "http://video.234.cn/234/ly/%B6%F9%B8%E8%CD%AF%D2%A5/%D6%D0%CE%C4%B6%F9%B8%E8/%C1%BD%D6%BB%C0%CF%BB%A2.jpg", "两只老虎-人气","http://easygo.b0.upaiyun.com/music/1469771068619.mp3", "http://easygo.b0.upaiyun.com/music/1469771070544.lrc",12000, 13000);
                Music music2 = new Music(2, "http://video.234.cn/234/ly/%B6%F9%B8%E8%CD%AF%D2%A5/%D6%D0%CE%C4%B6%F9%B8%E8/%C1%BD%D6%BB%C0%CF%BB%A2.jpg", "春天来了-人气", "http://easygo.b0.upaiyun.com/music/1469772498860.mp3","http://easygo.b0.upaiyun.com/music/1469772500356.lrc",12000, 13000);
                Music music3 = new Music(3, "http://video.234.cn/234/ly/%B6%F9%B8%E8%CD%AF%D2%A5/%D6%D0%CE%C4%B6%F9%B8%E8/%C1%BD%D6%BB%C0%CF%BB%A2.jpg", "小白船-人气", "http://easygo.b0.upaiyun.com/music/1469843033616.mp3","http://easygo.b0.upaiyun.com/music/1469843035506.lrc",12000, 13000);
                Music music4 = new Music(4, "http://video.234.cn/234/ly/%B6%F9%B8%E8%CD%AF%D2%A5/%D6%D0%CE%C4%B6%F9%B8%E8/%C1%BD%D6%BB%C0%CF%BB%A2.jpg", "两只老虎1-人气", "http://easygo.b0.upaiyun.com/music/1469773802602.mp3","http://easygo.b0.upaiyun.com/music/1469773804410.lrc",12000, 13000);
                mMusicList.add(music1);
                mMusicList.add(music2);
                mMusicList.add(music3);
                mMusicList.add(music4);
                break;
            case 2:
                // 最近更新（按照上传时间排序）
                Music music5 = new Music(5, "http://www.baby-cloud.com/attachments/2011/12/1_201112161602541KtvV.png", "两只老虎-最近", "http://easygo.b0.upaiyun.com/yutaimp3/林俊杰-她说.mp3","http://easygo.b0.upaiyun.com/music/1469773804410.lrc",12000, 13000);
                Music music6 = new Music(6, "http://www.baby-cloud.com/attachments/2011/12/1_201112161602541KtvV.png", "两只老虎-最近", "http://easygo.b0.upaiyun.com/yutaimp3/林俊杰-她说.mp3","http://easygo.b0.upaiyun.com/music/1469773804410.lrc",12000, 13000);
                Music music7 = new Music(7, "http://video.234.cn/234/ly/%B6%F9%B8%E8%CD%AF%D2%A5/%D6%D0%CE%C4%B6%F9%B8%E8/%C1%BD%D6%BB%C0%CF%BB%A2.jpg", "两只老虎-最近", "http://easygo.b0.upaiyun.com/yutaimp3/林俊杰-她说.mp3","http://easygo.b0.upaiyun.com/music/1469773804410.lrc",12000, 13000);
                Music music8 = new Music(8, "http://video.234.cn/234/ly/%B6%F9%B8%E8%CD%AF%D2%A5/%D6%D0%CE%C4%B6%F9%B8%E8/%C1%BD%D6%BB%C0%CF%BB%A2.jpg", "两只老虎-最近", "http://easygo.b0.upaiyun.com/yutaimp3/林俊杰-她说.mp3","http://easygo.b0.upaiyun.com/music/1469773804410.lrc",12000, 13000);
                mMusicList.add(music5);
                mMusicList.add(music6);
                mMusicList.add(music7);
                mMusicList.add(music8);
                break;
            case 3:
                //最受欢迎（按照下载量排序）
                Music music9 = new Music(9, "http://video.234.cn/234/ly/%B6%F9%B8%E8%CD%AF%D2%A5/%D6%D0%CE%C4%B6%F9%B8%E8/%C1%BD%D6%BB%C0%CF%BB%A2.jpg", "两只老虎-最受欢迎", "http://easygo.b0.upaiyun.com/yutaimp3/林俊杰-她说.mp3","http://easygo.b0.upaiyun.com/music/1469773804410.lrc",12000, 13000);
                Music music10 = new Music(10, "http://video.234.cn/234/ly/%B6%F9%B8%E8%CD%AF%D2%A5/%D6%D0%CE%C4%B6%F9%B8%E8/%C1%BD%D6%BB%C0%CF%BB%A2.jpg", "两只老虎-最受欢迎", "http://easygo.b0.upaiyun.com/yutaimp3/林俊杰-她说.mp3","http://easygo.b0.upaiyun.com/music/1469773804410.lrc",12000, 13000);
                Music music11 = new Music(11, "http://video.234.cn/234/ly/%B6%F9%B8%E8%CD%AF%D2%A5/%D6%D0%CE%C4%B6%F9%B8%E8/%C1%BD%D6%BB%C0%CF%BB%A2.jpg", "两只老虎-最受欢迎", "http://easygo.b0.upaiyun.com/yutaimp3/林俊杰-她说.mp3","http://easygo.b0.upaiyun.com/music/1469773804410.lrc",12000, 13000);
                Music music12 = new Music(12, "http://video.234.cn/234/ly/%B6%F9%B8%E8%CD%AF%D2%A5/%D6%D0%CE%C4%B6%F9%B8%E8/%C1%BD%D6%BB%C0%CF%BB%A2.jpg", "两只老虎-最受欢迎", "http://easygo.b0.upaiyun.com/yutaimp3/林俊杰-她说.mp3","http://easygo.b0.upaiyun.com/music/1469773804410.lrc",12000, 13000);
                Music music13 = new Music(13, "http://video.234.cn/234/ly/%B6%F9%B8%E8%CD%AF%D2%A5/%D6%D0%CE%C4%B6%F9%B8%E8/%C1%BD%D6%BB%C0%CF%BB%A2.jpg", "两只老虎-最受欢迎", "http://easygo.b0.upaiyun.com/yutaimp3/林俊杰-她说.mp3","http://easygo.b0.upaiyun.com/music/1469773804410.lrc",12000, 13000);
                Music music14 = new Music(14, "http://video.234.cn/234/ly/%B6%F9%B8%E8%CD%AF%D2%A5/%D6%D0%CE%C4%B6%F9%B8%E8/%C1%BD%D6%BB%C0%CF%BB%A2.jpg", "两只老虎-最受欢迎", "http://easygo.b0.upaiyun.com/yutaimp3/林俊杰-她说.mp3","http://easygo.b0.upaiyun.com/music/1469773804410.lrc",12000, 13000);
                mMusicList.add(music9);
                mMusicList.add(music10);
                mMusicList.add(music11);
                mMusicList.add(music12);
                mMusicList.add(music13);
                mMusicList.add(music14);
                break;
        }
        return mMusicList;
    }
}
