package com.yutai.exuetang.model.dao.audio;

import java.util.List;

import com.yutai.exuetang.model.beans.audio.GsonMusicCommentBean;
import com.yutai.exuetang.model.beans.audio.MusicComment;

public interface IMusicCommentDAO {
	// 增加音乐评论
	public abstract boolean addMusicComment(MusicComment musicComment);
	// 根据ID查找音乐评论
	public abstract MusicComment selectMusicCommentByID(int musiccomment_id);
	// 根据音乐ID查找所有音乐评论
	public abstract List<MusicComment> selectMusicCommentByMusicID(int music_id);
	//根据music_id 分页查出评论（联表查询）
	public abstract List<MusicComment> selectMusicCommentList(int music_id,int cur);
}
