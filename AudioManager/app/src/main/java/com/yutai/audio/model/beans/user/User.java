package com.yutai.audio.model.beans.user;

import java.io.Serializable;

public class User implements Serializable{

	/**
	 * 用户
	 */
	private static final long serialVersionUID = 1L;
	
	private int user_id;
	private String user_phone;//(用户手机号，唯一)
	private String user_password;//(用户密码)
	private String user_nickname;//(用户昵称)
	private String user_token;//(短信验证token)
	private String user_openid;//(第三方登录token)
	private String user_realname;//(用户的真实姓名)
	private String user_sex;//(用户性别)
	private int user_type;//(是否为会员)
	private String user_remarks;//(备注)
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int user_id, String user_phone, String user_password,
			String user_nickname, String user_token, String user_openid,
			String user_realname, String user_sex, int user_type,
			String user_remarks) {
		super();
		this.user_id = user_id;
		this.user_phone = user_phone;
		this.user_password = user_password;
		this.user_nickname = user_nickname;
		this.user_token = user_token;
		this.user_openid = user_openid;
		this.user_realname = user_realname;
		this.user_sex = user_sex;
		this.user_type = user_type;
		this.user_remarks = user_remarks;
	}

	public User(String user_phone, String user_password, String user_nickname,
			String user_token, String user_openid, String user_realname,
			String user_sex, int user_type, String user_remarks) {
		super();
		this.user_phone = user_phone;
		this.user_password = user_password;
		this.user_nickname = user_nickname;
		this.user_token = user_token;
		this.user_openid = user_openid;
		this.user_realname = user_realname;
		this.user_sex = user_sex;
		this.user_type = user_type;
		this.user_remarks = user_remarks;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_phone() {
		return user_phone;
	}
	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public String getUser_nickname() {
		return user_nickname;
	}
	public void setUser_nickname(String user_nickname) {
		this.user_nickname = user_nickname;
	}
	public String getUser_token() {
		return user_token;
	}
	public void setUser_token(String user_token) {
		this.user_token = user_token;
	}
	public String getUser_openid() {
		return user_openid;
	}
	public void setUser_openid(String user_openid) {
		this.user_openid = user_openid;
	}
	public String getUser_realname() {
		return user_realname;
	}
	public void setUser_realname(String user_realname) {
		this.user_realname = user_realname;
	}
	public String getUser_sex() {
		return user_sex;
	}
	public void setUser_sex(String user_sex) {
		this.user_sex = user_sex;
	}
	public int getUser_type() {
		return user_type;
	}
	public void setUser_type(int user_type) {
		this.user_type = user_type;
	}
	public String getUser_remarks() {
		return user_remarks;
	}
	public void setUser_remarks(String user_remarks) {
		this.user_remarks = user_remarks;
	}
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", user_phone=" + user_phone
				+ ", user_password=" + user_password + ", user_nickname="
				+ user_nickname + ", user_token=" + user_token
				+ ", user_openid=" + user_openid + ", user_realname="
				+ user_realname + ", user_sex=" + user_sex + ", user_type="
				+ user_type + ", user_remarks=" + user_remarks + "]";
	}
	
}
