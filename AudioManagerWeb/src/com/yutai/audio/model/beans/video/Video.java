package com.yutai.audio.model.beans.video;

import java.io.Serializable;

public class Video implements Serializable{

	/**
	 * 视频
	 */
	private static final long serialVersionUID = 1L;
	
	private int video_id;
	private String video_name;//视频名称         
	private String video_path;//视频文件地址
	private String video_type1;//视频一级类型
	private String video_type2;//视频二级类型
	private int video_audition_sum_number;//在线观看总量
	private int video_audition_month_number;//月在线观看量
	private int video_audition_week_number;//周在线观看量
	private int video_audition_day_number;//日在线观看量
	private int video_download_sum_number;//总下载量
	private int video_download_month_number;//月下载量
	private int video_download_week_number;//周下载量
	private int video_download_day_number;//天下载量
	private String video_type_photo;//视频二级类型图片
	private String video_photo;//视频图片
	private int video_coins;//(下载所需金币)
	private String video_remarks;//(备注)
	public Video() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Video(int video_id, String video_name, String video_path,
			String video_type1, String video_type2,
			int video_audition_sum_number, int video_audition_month_number,
			int video_audition_week_number, int video_audition_day_number,
			int video_download_sum_number, int video_download_month_number,
			int video_download_week_number, int video_download_day_number,
			String video_type_photo, String video_photo, int video_coins,
			String video_remarks) {
		super();
		this.video_id = video_id;
		this.video_name = video_name;
		this.video_path = video_path;
		this.video_type1 = video_type1;
		this.video_type2 = video_type2;
		this.video_audition_sum_number = video_audition_sum_number;
		this.video_audition_month_number = video_audition_month_number;
		this.video_audition_week_number = video_audition_week_number;
		this.video_audition_day_number = video_audition_day_number;
		this.video_download_sum_number = video_download_sum_number;
		this.video_download_month_number = video_download_month_number;
		this.video_download_week_number = video_download_week_number;
		this.video_download_day_number = video_download_day_number;
		this.video_type_photo = video_type_photo;
		this.video_photo = video_photo;
		this.video_coins = video_coins;
		this.video_remarks = video_remarks;
	}
	public int getVideo_id() {
		return video_id;
	}
	public void setVideo_id(int video_id) {
		this.video_id = video_id;
	}
	public String getVideo_name() {
		return video_name;
	}
	public void setVideo_name(String video_name) {
		this.video_name = video_name;
	}
	public String getVideo_path() {
		return video_path;
	}
	public void setVideo_path(String video_path) {
		this.video_path = video_path;
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
	public int getVideo_audition_sum_number() {
		return video_audition_sum_number;
	}
	public void setVideo_audition_sum_number(int video_audition_sum_number) {
		this.video_audition_sum_number = video_audition_sum_number;
	}
	public int getVideo_audition_month_number() {
		return video_audition_month_number;
	}
	public void setVideo_audition_month_number(int video_audition_month_number) {
		this.video_audition_month_number = video_audition_month_number;
	}
	public int getVideo_audition_week_number() {
		return video_audition_week_number;
	}
	public void setVideo_audition_week_number(int video_audition_week_number) {
		this.video_audition_week_number = video_audition_week_number;
	}
	public int getVideo_audition_day_number() {
		return video_audition_day_number;
	}
	public void setVideo_audition_day_number(int video_audition_day_number) {
		this.video_audition_day_number = video_audition_day_number;
	}
	public int getVideo_download_sum_number() {
		return video_download_sum_number;
	}
	public void setVideo_download_sum_number(int video_download_sum_number) {
		this.video_download_sum_number = video_download_sum_number;
	}
	public int getVideo_download_month_number() {
		return video_download_month_number;
	}
	public void setVideo_download_month_number(int video_download_month_number) {
		this.video_download_month_number = video_download_month_number;
	}
	public int getVideo_download_week_number() {
		return video_download_week_number;
	}
	public void setVideo_download_week_number(int video_download_week_number) {
		this.video_download_week_number = video_download_week_number;
	}
	public int getVideo_download_day_number() {
		return video_download_day_number;
	}
	public void setVideo_download_day_number(int video_download_day_number) {
		this.video_download_day_number = video_download_day_number;
	}
	public String getVideo_type_photo() {
		return video_type_photo;
	}
	public void setVideo_type_photo(String video_type_photo) {
		this.video_type_photo = video_type_photo;
	}
	public String getVideo_photo() {
		return video_photo;
	}
	public void setVideo_photo(String video_photo) {
		this.video_photo = video_photo;
	}
	public int getVideo_coins() {
		return video_coins;
	}
	public void setVideo_coins(int video_coins) {
		this.video_coins = video_coins;
	}
	public String getVideo_remarks() {
		return video_remarks;
	}
	public void setVideo_remarks(String video_remarks) {
		this.video_remarks = video_remarks;
	}
	@Override
	public String toString() {
		return "Video [video_id=" + video_id + ", video_name=" + video_name
				+ ", video_path=" + video_path + ", video_type1=" + video_type1
				+ ", video_type2=" + video_type2
				+ ", video_audition_sum_number=" + video_audition_sum_number
				+ ", video_audition_month_number="
				+ video_audition_month_number + ", video_audition_week_number="
				+ video_audition_week_number + ", video_audition_day_number="
				+ video_audition_day_number + ", video_download_sum_number="
				+ video_download_sum_number + ", video_download_month_number="
				+ video_download_month_number + ", video_download_week_number="
				+ video_download_week_number + ", video_download_day_number="
				+ video_download_day_number + ", video_type_photo="
				+ video_type_photo + ", video_photo=" + video_photo
				+ ", video_coins=" + video_coins + ", video_remarks="
				+ video_remarks + "]";
	}
	
}
