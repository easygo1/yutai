package com.yutai.exuetang.model.beans.exuetang;

import java.io.Serializable;

public class GsonUserInfo implements Serializable{

	/**
	 * 返回GSON数据 我的信息的全部信息
	 */
	private static final long serialVersionUID = 1L;
	private User user;
	private Child child;
	private int code;
	public GsonUserInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GsonUserInfo(User user, Child child, int code) {
		super();
		this.user = user;
		this.child = child;
		this.code = code;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Child getChild() {
		return child;
	}
	public void setChild(Child child) {
		this.child = child;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	@Override
	public String toString() {
		return "GsonUserInfo [user=" + user + ", child=" + child + ", code="
				+ code + "]";
	}
	
}
