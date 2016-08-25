package com.yutai.exuetang.model.dao.audio;

import java.util.List;

import com.yutai.exuetang.model.beans.audio.Music;

public interface IMusicDAO {
	// 增加音乐
	public abstract boolean addMusic(Music music);

	// 根据ID查找音乐
	public abstract Music selectMusicByID(int music_id);

	// 根据一级类型查找所有二级类型及数量
	// public abstract List<MusicType> selectMusicByMusictype1(String
	// music_type1);
	// 根据二级类型查找所有音乐
	public abstract List<Music> selectMusicByMusictype2(String music_type2);

	/*// 根据一级类型 二级类型 按照某种顺序排序(试听量 ， 下载量 ，上传时间)
    ordertype 为1时 按试听量 降序排列
	ordertype 为2时 按下载量 降序排列
	ordertype 为3时 按上传时间 降序排列*/
	public abstract List<Music> selectMusicBytypesOrder1(String type1,
			String type2, int cur,int ordertype);
	// 查询所有的音乐
	public abstract List<Music> selectAllMusic();
   // 更新音乐的下载量
	public abstract boolean updateDownloadNum(int music_id);
	//更新音乐的在线量
	public abstract boolean updateAuditionNum(int music_id);
   //根据音乐的id得到该音乐所用的金币数
	public abstract double getMusicCoins(int music_id);
	//根据音乐的名字得到这个音乐对象
	public abstract Music getMusicByName(String music_name);
}
