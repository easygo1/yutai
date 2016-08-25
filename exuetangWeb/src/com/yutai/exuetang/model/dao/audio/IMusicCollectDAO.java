package com.yutai.exuetang.model.dao.audio;

import java.util.List;

import com.yutai.exuetang.model.beans.audio.MusicCollect;


public interface IMusicCollectDAO {
	// 根据用户的id查出所有的收藏信息
	public abstract List<MusicCollect> selectMusicCollectByUserId(int user_id);

}
