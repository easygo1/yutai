package com.yutai.exuetang.model.beans.exuetang;

import java.io.Serializable;

public class User implements Serializable {

	/**
	 * 用户
	 */
	private static final long serialVersionUID = 1L;

	private int user_id;
	private String user_newphone;// (用户手机号，唯一)
	private String user_oldphone;// (用户旧手机号)varchar(15),
	private String user_password;// (用户密码)
	private String user_nickname;// (用户昵称)
	private String user_mood;// (个性签名(最多输入50字))varchar(100)
	private String user_qq_token;// (第三方qq登陆token)varchar(200)
	private String user_wechat_token;// (第三方微信登录openid)varchar(200)
	private String user_realname;// (用户的真实姓名)
	private String user_sex;// (用户性别)
	private int user_type;// (是否为会员)
	private String user_remarks;// (备注)
//	private int code;//返回的状态码

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int user_id, String user_newphone, String user_oldphone,
			String user_password, String user_nickname, String user_mood,
			String user_qq_token, String user_wechat_token,
			String user_realname, String user_sex, int user_type,
			String user_remarks) {
		super();
		this.user_id = user_id;
		this.user_newphone = user_newphone;
		this.user_oldphone = user_oldphone;
		this.user_password = user_password;
		this.user_nickname = user_nickname;
		this.user_mood = user_mood;
		this.user_qq_token = user_qq_token;
		this.user_wechat_token = user_wechat_token;
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

	public String getUser_newphone() {
		return user_newphone;
	}

	public void setUser_newphone(String user_newphone) {
		this.user_newphone = user_newphone;
	}

	public String getUser_oldphone() {
		return user_oldphone;
	}

	public void setUser_oldphone(String user_oldphone) {
		this.user_oldphone = user_oldphone;
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

	public String getUser_mood() {
		return user_mood;
	}

	public void setUser_mood(String user_mood) {
		this.user_mood = user_mood;
	}

	public String getUser_qq_token() {
		return user_qq_token;
	}

	public void setUser_qq_token(String user_qq_token) {
		this.user_qq_token = user_qq_token;
	}

	public String getUser_wechat_token() {
		return user_wechat_token;
	}

	public void setUser_wechat_token(String user_wechat_token) {
		this.user_wechat_token = user_wechat_token;
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

	/*public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}*/

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", user_newphone=" + user_newphone
				+ ", user_oldphone=" + user_oldphone + ", user_password="
				+ user_password + ", user_nickname=" + user_nickname
				+ ", user_mood=" + user_mood + ", user_qq_token="
				+ user_qq_token + ", user_wechat_token=" + user_wechat_token
				+ ", user_realname=" + user_realname + ", user_sex=" + user_sex
				+ ", user_type=" + user_type + ", user_remarks=" + user_remarks
				+ "]";
	}

}
