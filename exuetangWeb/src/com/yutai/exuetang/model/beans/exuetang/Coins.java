package com.yutai.exuetang.model.beans.exuetang;

import java.io.Serializable;

public class Coins implements Serializable {

	/**
	 *学习币
	 */
	private static final long serialVersionUID = 1L;

	private int coins_id;
	private int user_id;//(用户ID，外键)
	private int coins_num;//(学习币数)
	private String coins_remarks;//##(备注)
	public Coins() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Coins(int coins_id, int user_id, int coins_num, String coins_remarks) {
		super();
		this.coins_id = coins_id;
		this.user_id = user_id;
		this.coins_num = coins_num;
		this.coins_remarks = coins_remarks;
	}
	public int getCoins_id() {
		return coins_id;
	}
	public void setCoins_id(int coins_id) {
		this.coins_id = coins_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getCoins_num() {
		return coins_num;
	}
	public void setCoins_num(int coins_num) {
		this.coins_num = coins_num;
	}
	public String getCoins_remarks() {
		return coins_remarks;
	}
	public void setCoins_remarks(String coins_remarks) {
		this.coins_remarks = coins_remarks;
	}
	@Override
	public String toString() {
		return "Coins [coins_id=" + coins_id + ", user_id=" + user_id
				+ ", coins_num=" + coins_num + ", coins_remarks="
				+ coins_remarks + "]";
	}
	
	
}
