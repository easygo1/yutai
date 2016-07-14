package com.yutai.audio.model.beans.video;

import java.io.Serializable;

public class VideoComment implements Serializable{

	/**
	 * 视频评论
	 */
	private static final long serialVersionUID = 1L;

	private int comment_id;
	private int video_id;//视频ID
	private int user_id;//评论用户ID
	private String comment_content;//评论内容
	private String comment_time;//评论时间
	public VideoComment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public VideoComment(int comment_id, int video_id, int user_id,
			String comment_content, String comment_time) {
		super();
		this.comment_id = comment_id;
		this.video_id = video_id;
		this.user_id = user_id;
		this.comment_content = comment_content;
		this.comment_time = comment_time;
	}
	public int getComment_id() {
		return comment_id;
	}
	public void setComment_id(int comment_id) {
		this.comment_id = comment_id;
	}
	public int getVideo_id() {
		return video_id;
	}
	public void setVideo_id(int video_id) {
		this.video_id = video_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getComment_content() {
		return comment_content;
	}
	public void setComment_content(String comment_content) {
		this.comment_content = comment_content;
	}
	public String getComment_time() {
		return comment_time;
	}
	public void setComment_time(String comment_time) {
		this.comment_time = comment_time;
	}
	@Override
	public String toString() {
		return "VideoComment [comment_id=" + comment_id + ", video_id="
				+ video_id + ", user_id=" + user_id + ", comment_content="
				+ comment_content + ", comment_time=" + comment_time + "]";
	}
	
}
