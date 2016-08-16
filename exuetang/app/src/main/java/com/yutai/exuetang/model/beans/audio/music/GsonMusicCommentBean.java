package com.yutai.exuetang.model.beans.audio.music;

import java.io.Serializable;

/**
 * Created by ZFG on 2016/8/16.
 */
public class GsonMusicCommentBean implements Serializable {

    /**
     * 音乐评论(Gson)
     */
    private static final long serialVersionUID = 1L;
    private int comment_id;
    private int music_id;
    private int user_id;
    private String user_photo;
    private String user_nickname;
    private String comment_content;// 评论内容
    private String comment_time;// 评论时间精确到秒
    private int commentssize;

    public GsonMusicCommentBean() {
        super();
    }

   

    public GsonMusicCommentBean(int comment_id, int music_id, int user_id,
			String user_photo, String user_nickname, String comment_content,
			String comment_time, int commentssize) {
		super();
		this.comment_id = comment_id;
		this.music_id = music_id;
		this.user_id = user_id;
		this.user_photo = user_photo;
		this.user_nickname = user_nickname;
		this.comment_content = comment_content;
		this.comment_time = comment_time;
		this.commentssize = commentssize;
	}

	public String getComment_time() {
        return comment_time;
    }

    public void setComment_time(String comment_time) {
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

    public String getUser_photo() {
        return user_photo;
    }

    public void setUser_photo(String user_photo) {
        this.user_photo = user_photo;
    }

    public String getUser_nickname() {
        return user_nickname;
    }

    public void setUser_nickname(String user_nickname) {
        this.user_nickname = user_nickname;
    }

    public String getComment_content() {
        return comment_content;
    }

    public void setComment_content(String comment_content) {
        this.comment_content = comment_content;
    }

	public int getCommentssize() {
		return commentssize;
	}

	public void setCommentssize(int commentssize) {
		this.commentssize = commentssize;
	}

	@Override
	public String toString() {
		return "GsonMusicCommentBean [comment_id=" + comment_id + ", music_id="
				+ music_id + ", user_id=" + user_id + ", user_photo="
				+ user_photo + ", user_nickname=" + user_nickname
				+ ", comment_content=" + comment_content + ", comment_time="
				+ comment_time + ", commentssize=" + commentssize + "]";
	}

    
}
