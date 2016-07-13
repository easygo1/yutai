package com.yutai.audio.model.dao.video;

import java.util.List;

import com.yutai.audio.model.beans.video.Video;
import com.yutai.audio.model.beans.video.VideoType;

public interface IVideoDAO {
	 //增加视频
	public abstract boolean addVideo(Video video);
	//根据ID查找视频
	public abstract Video selectVideoByID(int video_id);
	//根据一级类型查找所有二级类型及数量
	public abstract List<VideoType> selectVideoByVideotype1(String video_type1);
	//根据二级类型查找所有视频
	public abstract List<Video> selectVideoByVideotype2(String video_type2);	
	//查询所有的视频
	public abstract List<Video> selectAllVideo();
}
