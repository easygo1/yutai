package com.yutai.exuetang.model.beans.audio;

import java.io.Serializable;

public class MusicComment implements Serializable {

	/**
	 * 音乐评论
	 */
	private static final long serialVersionUID = 1L;

	private int comment_id;
	private int music_id;// 音乐ID
	private int user_id;// 评论用户ID
	private String comment_content;// 评论内容
	private String comment_time;// 评论时间精确到秒

	public MusicComment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MusicComment(int music_id, int user_id,
			String comment_content, String comment_time) {
		super();
		this.music_id = music_id;
		this.user_id = user_id;
		this.comment_content = comment_content;
		this.comment_time = comment_time;
	}

	public MusicComment(int comment_id, int music_id, int user_id,
			String comment_content, String comment_time) {
		super();
		this.comment_id = comment_id;
		this.music_id = music_id;
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

	public int getMusic_id() {
		return music_id;
	}

	public void setMusic_id(int music_id) {
		this.music_id = music_id;
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
		return "MusicComment [comment_id=" + comment_id + ", music_id="
				+ music_id + ", user_id=" + user_id + ", comment_content="
				+ comment_content + ", comment_time=" + comment_time + "]";
	}

}
