package com.yutai.audio.model.beans.music;

import java.io.Serializable;

public class MusicType implements Serializable{
	/**
	 * 音乐2级分类
	 */
	private static final long serialVersionUID = 1L;
	
	private String music_type1;//音乐一级类型
	private String music_type2;//音乐二级类型
	private String music_type_photo;//音乐二级类型图片
	private int music_type2number;//音乐二级类型数量
	public MusicType() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MusicType(String music_type1, String music_type2,
			String music_type_photo, int music_type2number) {
		super();
		this.music_type1 = music_type1;
		this.music_type2 = music_type2;
		this.music_type_photo = music_type_photo;
		this.music_type2number = music_type2number;
	}
	public String getMusic_type1() {
		return music_type1;
	}
	public void setMusic_type1(String music_type1) {
		this.music_type1 = music_type1;
	}
	public String getMusic_type2() {
		return music_type2;
	}
	public void setMusic_type2(String music_type2) {
		this.music_type2 = music_type2;
	}
	public String getMusic_type_photo() {
		return music_type_photo;
	}
	public void setMusic_type_photo(String music_type_photo) {
		this.music_type_photo = music_type_photo;
	}
	public int getMusic_type2number() {
		return music_type2number;
	}
	public void setMusic_type2number(int music_type2number) {
		this.music_type2number = music_type2number;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "MusicType [music_type1=" + music_type1 + ", music_type2="
				+ music_type2 + ", music_type_photo=" + music_type_photo
				+ ", music_type2number=" + music_type2number + "]";
	}
	
}
