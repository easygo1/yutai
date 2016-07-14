package com.yutai.audio.model.dao.video;

import java.util.List;

import com.yutai.audio.model.beans.video.VideoComment;

public interface IVideoCommentDAO {
	//添加一条视频评论
	public abstract boolean addVideoComment(VideoComment videocomment);
	//根据ID查找评论
	public abstract VideoComment selectVideoCommentByID(int videocomment_id);
	//根据music_id查找全部的评论
	public abstract List<VideoComment> selectVideoCommentByVideoID(int video_id);
	//查找所有的评论
	public abstract List<VideoComment> selectAllVideoCommentByID();
}
