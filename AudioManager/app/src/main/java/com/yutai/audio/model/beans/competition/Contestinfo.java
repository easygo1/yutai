package com.yutai.audio.model.beans.competition;

import java.io.Serializable;

public class Contestinfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int contestinfo_id;
	private String contestinfo_name;//          VARCHAR(40),     ##比赛名称
	private String contestinfo_endtime;//       date,            ##比赛截止日期
	private String contestinfo_smallphoto;//    VARCHAR(300),    ##比赛小图
	private String contestinfo_largephoto;//    VARCHAR(300)     ##比赛详情大图
	public Contestinfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Contestinfo(int contestinfo_id, String contestinfo_name,
			String contestinfo_endtime, String contestinfo_smallphoto,
			String contestinfo_largephoto) {
		super();
		this.contestinfo_id = contestinfo_id;
		this.contestinfo_name = contestinfo_name;
		this.contestinfo_endtime = contestinfo_endtime;
		this.contestinfo_smallphoto = contestinfo_smallphoto;
		this.contestinfo_largephoto = contestinfo_largephoto;
	}
	public int getContestinfo_id() {
		return contestinfo_id;
	}
	public void setContestinfo_id(int contestinfo_id) {
		this.contestinfo_id = contestinfo_id;
	}
	public String getContestinfo_name() {
		return contestinfo_name;
	}
	public void setContestinfo_name(String contestinfo_name) {
		this.contestinfo_name = contestinfo_name;
	}
	public String getContestinfo_endtime() {
		return contestinfo_endtime;
	}
	public void setContestinfo_endtime(String contestinfo_endtime) {
		this.contestinfo_endtime = contestinfo_endtime;
	}
	public String getContestinfo_smallphoto() {
		return contestinfo_smallphoto;
	}
	public void setContestinfo_smallphoto(String contestinfo_smallphoto) {
		this.contestinfo_smallphoto = contestinfo_smallphoto;
	}
	public String getContestinfo_largephoto() {
		return contestinfo_largephoto;
	}
	public void setContestinfo_largephoto(String contestinfo_largephoto) {
		this.contestinfo_largephoto = contestinfo_largephoto;
	}
	@Override
	public String toString() {
		return "Contestinfo [contestinfo_id=" + contestinfo_id
				+ ", contestinfo_name=" + contestinfo_name
				+ ", contestinfo_endtime=" + contestinfo_endtime
				+ ", contestinfo_smallphoto=" + contestinfo_smallphoto
				+ ", contestinfo_largephoto=" + contestinfo_largephoto + "]";
	}
	
}
