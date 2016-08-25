package com.yutai.exuetang.model.beans.audio;

import java.io.Serializable;

public class MusicCollect implements Serializable {

	/**
	 * 音乐收藏表
	 */
	private static final long serialVersionUID = 1L;

	private int music_collect_id;
	private int user_id; // 用户id
	private int music_id; // 音乐id
	
	public MusicCollect() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MusicCollect(int music_collect_id, int user_id, int music_id) {
		super();
		this.music_collect_id = music_collect_id;
		this.user_id = user_id;
		this.music_id = music_id;
	}

	public int getMusic_collect_id() {
		return music_collect_id;
	}

	public void setMusic_collect_id(int music_collect_id) {
		this.music_collect_id = music_collect_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getMusic_id() {
		return music_id;
	}

	public void setMusic_id(int music_id) {
		this.music_id = music_id;
	}

	@Override
	public String toString() {
		return "MusicCollect [music_collect_id=" + music_collect_id
				+ ", user_id=" + user_id + ", music_id=" + music_id + "]";
	}
	
}
