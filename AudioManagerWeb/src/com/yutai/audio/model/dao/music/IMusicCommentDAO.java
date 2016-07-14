package com.yutai.audio.model.dao.music;

import java.util.List;

import com.yutai.audio.model.beans.music.MusicComment;

public interface IMusicCommentDAO {
	//添加一条音乐评论
	public abstract boolean addMusicComment(MusicComment musiccomment);
	//根据ID查找评论
	public abstract MusicComment selectMusicCommentByID(int musiccomment_id);
	//根据music_id查找全部的评论
	public abstract List<MusicComment> selectMusicCommentByMusicID(int music_id);
	//查找所有的评论
	public abstract List<MusicComment> selectAllMusicCommentByID();
}
