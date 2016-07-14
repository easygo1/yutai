package com.yutai.audio.model.beans.video;

import java.io.Serializable;

public class VideoType implements Serializable{
	/**
	 * 视频2级分类
	 */
	private static final long serialVersionUID = 1L;
	
	private String video_type1;//视频一级类型
	private String video_type2;//视频二级类型
	private String video_type_photo;//视频二级类型图片
	private int video_type2number;//视频二级类型数量
	public VideoType() {
		super();
		// TODO Auto-generated constructor stub
	}
	public VideoType(String video_type1, String video_type2,
			String video_type_photo, int video_type2number) {
		super();
		this.video_type1 = video_type1;
		this.video_type2 = video_type2;
		this.video_type_photo = video_type_photo;
		this.video_type2number = video_type2number;
	}
	public String getVideo_type1() {
		return video_type1;
	}
	public void setVideo_type1(String video_type1) {
		this.video_type1 = video_type1;
	}
	public String getVideo_type2() {
		return video_type2;
	}
	public void setVideo_type2(String video_type2) {
		this.video_type2 = video_type2;
	}
	public String getVideo_type_photo() {
		return video_type_photo;
	}
	public void setVideo_type_photo(String video_type_photo) {
		this.video_type_photo = video_type_photo;
	}
	public int getVideo_type2number() {
		return video_type2number;
	}
	public void setVideo_type2number(int video_type2number) {
		this.video_type2number = video_type2number;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "VideoType [video_type1=" + video_type1 + ", video_type2="
				+ video_type2 + ", video_type_photo=" + video_type_photo
				+ ", video_type2number=" + video_type2number + "]";
	}
	
}
