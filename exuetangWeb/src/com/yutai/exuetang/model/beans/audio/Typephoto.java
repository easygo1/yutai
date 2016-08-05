/**
 * 
 */
package com.yutai.exuetang.model.beans.audio;

import java.io.Serializable;

/**
 * @author Administrator 2016年8月5日 上午11:29:12
 * 
 */
public class Typephoto implements Serializable {

	/**
	 * 音乐二级图片表
	 */
	private static final long serialVersionUID = 1L;
	private int typephoto_id; // int PRIMARY KEY AUTO_INCREMENT,
	private String music_type2; // varchar(20), ##音乐二级类型
	private String music_type2_path; // varchar(300) ##音乐二级类型图片地址
	/**
	 * 
	 */
	public Typephoto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Typephoto(int typephoto_id, String music_type2,
			String music_type2_path) {
		super();
		this.typephoto_id = typephoto_id;
		this.music_type2 = music_type2;
		this.music_type2_path = music_type2_path;
	}
	
	public int getTypephoto_id() {
		return typephoto_id;
	}
	
	public void setTypephoto_id(int typephoto_id) {
		this.typephoto_id = typephoto_id;
	}
	
	public String getMusic_type2() {
		return music_type2;
	}
	
	public void setMusic_type2(String music_type2) {
		this.music_type2 = music_type2;
	}
	
	public String getMusic_type2_path() {
		return music_type2_path;
	}
	
	public void setMusic_type2_path(String music_type2_path) {
		this.music_type2_path = music_type2_path;
	}
	@Override
	public String toString() {
		return "Typephoto [typephoto_id=" + typephoto_id + ", music_type2="
				+ music_type2 + ", music_type2_path=" + music_type2_path + "]";
	}

}
