package com.yutai.audio.model.dao.music;

import java.util.List;

import com.yutai.audio.model.beans.music.Music;
import com.yutai.audio.model.beans.music.MusicType;

public interface IMusicDAO {
	 //增加音乐
	public abstract boolean addMusic(Music music);
	//根据ID查找音乐
	public abstract Music selectMusicByID(int music_id);
	//根据一级类型查找所有二级类型及数量
	public abstract List<MusicType> selectMusicByMusictype1(String music_type1);
	//根据二级类型查找所有音乐
	public abstract List<Music> selectMusicByMusictype2(String music_type2);	
	//查询所有的音乐
	public abstract List<Music> selectAllMusic();
}
