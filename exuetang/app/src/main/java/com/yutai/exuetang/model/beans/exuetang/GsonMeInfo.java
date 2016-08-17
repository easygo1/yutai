package com.yutai.exuetang.model.beans.exuetang;

import java.io.Serializable;

public class GsonMeInfo implements Serializable {
	/**
	 * 用户在我的fragment中的个人信息
	 */
	private static final long serialVersionUID = 1L;
	private int user_id;
	private String user_nickname;
	private String child_photo;
	private String user_newphone;
	private double user_coins;
	private int code;
	public GsonMeInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GsonMeInfo(int user_id, String user_nickname, String child_photo,
			String user_newphone, double user_coins) {
		super();
		this.user_id = user_id;
		this.user_nickname = user_nickname;
		this.child_photo = child_photo;
		this.user_newphone = user_newphone;
		this.user_coins = user_coins;
	}
	public GsonMeInfo(int user_id, String user_nickname, String child_photo,
			String user_newphone, double user_coins, int code) {
		super();
		this.user_id = user_id;
		this.user_nickname = user_nickname;
		this.child_photo = child_photo;
		this.user_newphone = user_newphone;
		this.user_coins = user_coins;
		this.code = code;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_nickname() {
		return user_nickname;
	}
	public void setUser_nickname(String user_nickname) {
		this.user_nickname = user_nickname;
	}
	public String getChild_photo() {
		return child_photo;
	}
	public void setChild_photo(String child_photo) {
		this.child_photo = child_photo;
	}
	public String getUser_newphone() {
		return user_newphone;
	}
	public void setUser_newphone(String user_newphone) {
		this.user_newphone = user_newphone;
	}
	public double getUser_coins() {
		return user_coins;
	}
	public void setUser_coins(double user_coins) {
		this.user_coins = user_coins;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	@Override
	public String toString() {
		return "GsonMeInfo [user_id=" + user_id + ", user_nickname="
				+ user_nickname + ", child_photo=" + child_photo
				+ ", user_newphone=" + user_newphone + ", user_coins="
				+ user_coins + ", code=" + code + "]";
	}
}
