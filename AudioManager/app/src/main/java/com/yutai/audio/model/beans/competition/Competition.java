package com.yutai.audio.model.beans.competition;

import java.io.Serializable;

/**
 * Created by 崔凯 on 2016/7/13.
 */
public class Competition implements Serializable{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private int competition_id;
    private String competition_name;          //VARCHAR(20),    ##报名人的姓名
    private String competition_sex;//            CHAR(2),        ##性别
    private String competition_birthday;//       date,           ##生日
    private String competition_mail_address;//   varchar(300),   ##邮寄地址
    private String competition_phone;//          varchar(15),    ##电话
    private String competition_schoolname;//     VARCHAR(100),   ##学校名称
    private String competition_weixin;//         VARCHAR(30),    ##微信号
    private String competition_group;//          VARCHAR(200),   ##参赛组别 （托班，小班，中班，大班，一年级。。）
    private String competition_grading;//        VARCHAR(200),   ##考级考证（多选）最多设置5个
    private String competition_project;//        VARCHAR(50),    ##参赛项目
    private String competition_way;//            VARCHAR(50)     ##哪种途径知晓
    public Competition() {
        super();
        // TODO Auto-generated constructor stub
    }
    public Competition(int competition_id, String competition_name,
                       String competition_sex, String competition_birthday,
                       String competition_mail_address, String competition_phone,
                       String competition_schoolname, String competition_weixin,
                       String competition_group, String competition_grading,
                       String competition_project, String competition_way) {
        super();
        this.competition_id = competition_id;
        this.competition_name = competition_name;
        this.competition_sex = competition_sex;
        this.competition_birthday = competition_birthday;
        this.competition_mail_address = competition_mail_address;
        this.competition_phone = competition_phone;
        this.competition_schoolname = competition_schoolname;
        this.competition_weixin = competition_weixin;
        this.competition_group = competition_group;
        this.competition_grading = competition_grading;
        this.competition_project = competition_project;
        this.competition_way = competition_way;
    }
    public int getCompetition_id() {
        return competition_id;
    }
    public void setCompetition_id(int competition_id) {
        this.competition_id = competition_id;
    }
    public String getCompetition_name() {
        return competition_name;
    }
    public void setCompetition_name(String competition_name) {
        this.competition_name = competition_name;
    }
    public String getCompetition_sex() {
        return competition_sex;
    }
    public void setCompetition_sex(String competition_sex) {
        this.competition_sex = competition_sex;
    }
    public String getCompetition_birthday() {
        return competition_birthday;
    }
    public void setCompetition_birthday(String competition_birthday) {
        this.competition_birthday = competition_birthday;
    }
    public String getCompetition_mail_address() {
        return competition_mail_address;
    }
    public void setCompetition_mail_address(String competition_mail_address) {
        this.competition_mail_address = competition_mail_address;
    }
    public String getCompetition_phone() {
        return competition_phone;
    }
    public void setCompetition_phone(String competition_phone) {
        this.competition_phone = competition_phone;
    }
    public String getCompetition_schoolname() {
        return competition_schoolname;
    }
    public void setCompetition_schoolname(String competition_schoolname) {
        this.competition_schoolname = competition_schoolname;
    }
    public String getCompetition_weixin() {
        return competition_weixin;
    }
    public void setCompetition_weixin(String competition_weixin) {
        this.competition_weixin = competition_weixin;
    }
    public String getCompetition_group() {
        return competition_group;
    }
    public void setCompetition_group(String competition_group) {
        this.competition_group = competition_group;
    }
    public String getCompetition_grading() {
        return competition_grading;
    }
    public void setCompetition_grading(String competition_grading) {
        this.competition_grading = competition_grading;
    }
    public String getCompetition_project() {
        return competition_project;
    }
    public void setCompetition_project(String competition_project) {
        this.competition_project = competition_project;
    }
    public String getCompetition_way() {
        return competition_way;
    }
    public void setCompetition_way(String competition_way) {
        this.competition_way = competition_way;
    }
    @Override
    public String toString() {
        return "Competition [competition_id=" + competition_id
                + ", competition_name=" + competition_name
                + ", competition_sex=" + competition_sex
                + ", competition_birthday=" + competition_birthday
                + ", competition_mail_address=" + competition_mail_address
                + ", competition_phone=" + competition_phone
                + ", competition_schoolname=" + competition_schoolname
                + ", competition_weixin=" + competition_weixin
                + ", competition_group=" + competition_group
                + ", competition_grading=" + competition_grading
                + ", competition_project=" + competition_project
                + ", competition_way=" + competition_way + "]";
    }
}
