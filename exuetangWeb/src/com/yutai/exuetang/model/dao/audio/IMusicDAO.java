package com.yutai.exuetang.model.dao.audio;

import java.util.List;

import com.yutai.exuetang.model.beans.audio.Music;


public interface IMusicDAO {
	 //增加音乐
	public abstract boolean addMusic(Music music);
	//根据ID查找音乐
	public abstract Music selectMusicByID(int music_id);
	//根据一级类型查找所有二级类型及数量
	//public abstract List<MusicType> selectMusicByMusictype1(String music_type1);
	//根据二级类型查找所有音乐
	public abstract List<Music> selectMusicByMusictype2(String music_type2);	
	//查询所有的音乐
	public abstract List<Music> selectAllMusic();
}
