package com.yutai.exuetang.model.beans.exuetang;

import java.io.Serializable;

public class Child implements Serializable{

	/**
	 * 宝宝表
	 */
	private static final long serialVersionUID = 1L;
	
	private int child_id;
	private int user_id;//(外键)
	private String child_birthday;//(宝宝生日)
	private String child_name;//(姓名)
	private String child_photo;//(头像)
	private String child_sex;//(性别)
	private String child_school_class_name;//(学校名称及班级)
	private String child_home_province;//(家庭住址省)
	private String child_home_city;//(家庭住址市)
	private String child_home_county;//(家庭住址区)
	private String child_home_address;//(家庭住址)
	private String child_dream;//(孩子梦想)
	private String child_hobby;//(宝宝特长)
	private String child_trainplan;//(宝宝培训计划)
	private String child_remarks;//（备注）
	public Child() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Child(int child_id, int user_id, String child_birthday,
			String child_name, String child_photo, String child_sex,
			String child_school_class_name, String child_home_province,
			String child_home_city, String child_home_county,
			String child_home_address, String child_dream, String child_hobby,
			String child_trainplan, String child_remarks) {
		super();
		this.child_id = child_id;
		this.user_id = user_id;
		this.child_birthday = child_birthday;
		this.child_name = child_name;
		this.child_photo = child_photo;
		this.child_sex = child_sex;
		this.child_school_class_name = child_school_class_name;
		this.child_home_province = child_home_province;
		this.child_home_city = child_home_city;
		this.child_home_county = child_home_county;
		this.child_home_address = child_home_address;
		this.child_dream = child_dream;
		this.child_hobby = child_hobby;
		this.child_trainplan = child_trainplan;
		this.child_remarks = child_remarks;
	}
	public Child(int user_id, String child_birthday,
			String child_name, String child_photo, String child_sex,
			String child_school_class_name, String child_home_province,
			String child_home_city, String child_home_county,
			String child_home_address, String child_dream, String child_hobby,
			String child_trainplan, String child_remarks) {
		super();
		this.user_id = user_id;
		this.child_birthday = child_birthday;
		this.child_name = child_name;
		this.child_photo = child_photo;
		this.child_sex = child_sex;
		this.child_school_class_name = child_school_class_name;
		this.child_home_province = child_home_province;
		this.child_home_city = child_home_city;
		this.child_home_county = child_home_county;
		this.child_home_address = child_home_address;
		this.child_dream = child_dream;
		this.child_hobby = child_hobby;
		this.child_trainplan = child_trainplan;
		this.child_remarks = child_remarks;
	}
	public int getChild_id() {
		return child_id;
	}
	public void setChild_id(int child_id) {
		this.child_id = child_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getChild_birthday() {
		return child_birthday;
	}
	public void setChild_birthday(String child_birthday) {
		this.child_birthday = child_birthday;
	}
	public String getChild_name() {
		return child_name;
	}
	public void setChild_name(String child_name) {
		this.child_name = child_name;
	}
	public String getChild_photo() {
		return child_photo;
	}
	public void setChild_photo(String child_photo) {
		this.child_photo = child_photo;
	}
	public String getChild_sex() {
		return child_sex;
	}
	public void setChild_sex(String child_sex) {
		this.child_sex = child_sex;
	}
	public String getChild_school_class_name() {
		return child_school_class_name;
	}
	public void setChild_school_class_name(String child_school_class_name) {
		this.child_school_class_name = child_school_class_name;
	}
	public String getChild_home_province() {
		return child_home_province;
	}
	public void setChild_home_province(String child_home_province) {
		this.child_home_province = child_home_province;
	}
	public String getChild_home_city() {
		return child_home_city;
	}
	public void setChild_home_city(String child_home_city) {
		this.child_home_city = child_home_city;
	}
	public String getChild_home_county() {
		return child_home_county;
	}
	public void setChild_home_county(String child_home_county) {
		this.child_home_county = child_home_county;
	}
	public String getChild_home_address() {
		return child_home_address;
	}
	public void setChild_home_address(String child_home_address) {
		this.child_home_address = child_home_address;
	}
	public String getChild_dream() {
		return child_dream;
	}
	public void setChild_dream(String child_dream) {
		this.child_dream = child_dream;
	}
	public String getChild_hobby() {
		return child_hobby;
	}
	public void setChild_hobby(String child_hobby) {
		this.child_hobby = child_hobby;
	}
	public String getChild_trainplan() {
		return child_trainplan;
	}
	public void setChild_trainplan(String child_trainplan) {
		this.child_trainplan = child_trainplan;
	}
	public String getChild_remarks() {
		return child_remarks;
	}
	public void setChild_remarks(String child_remarks) {
		this.child_remarks = child_remarks;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Child [child_id=" + child_id + ", user_id=" + user_id
				+ ", child_birthday=" + child_birthday + ", child_name="
				+ child_name + ", child_photo=" + child_photo + ", child_sex="
				+ child_sex + ", child_school_class_name="
				+ child_school_class_name + ", child_home_province="
				+ child_home_province + ", child_home_city=" + child_home_city
				+ ", child_home_county=" + child_home_county
				+ ", child_home_address=" + child_home_address
				+ ", child_dream=" + child_dream + ", child_hobby="
				+ child_hobby + ", child_trainplan=" + child_trainplan
				+ ", child_remarks=" + child_remarks + "]";
	}
	
}
