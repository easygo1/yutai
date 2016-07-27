package com.yutai.exuetang.model.beans.audio.music;

import java.io.Serializable;

public class Music implements Serializable {

    /**
     * 音乐
     */
    private static final long serialVersionUID = 1L;

    private int music_id;
    private String music_name;// 音乐名称
    private String music_path_mp3;// 音乐文件路径
    private String music_path_lrc;// 歌词文件路径
    private String music_type1;// 音乐一级类型
    private String music_type2;// 音乐二级类型
    private int music_audition_sum_number;// 在线总量
    private int music_audition_month_number;// 月在线总量
    private int music_audition_week_number;// 周在线总量
    private int music_audition_day_number;// 天在线总量
    private int music_download_sum_number;// 总下载量
    private int music_download_month_number;// 月下载量
    private int music_download_week_number;// 周下载量
    private int music_download_day_number;// 天下载量
    private String music_type_photo;// 音乐二级类型图片
    private String music_photo;// 音乐图片地址
    private int music_coins;// (下载所需金币)
    private String music_upload_time;//音乐上传时间
    private String music_remarks;// 备注

    public Music() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Music(int music_id, String music_name, String music_path_mp3, String music_path_lrc, String music_type1, String music_type2, int music_audition_sum_number, int music_audition_month_number, int music_audition_week_number, int music_audition_day_number, int music_download_sum_number, int music_download_month_number, int music_download_week_number, int music_download_day_number, String music_type_photo, String music_photo, int music_coins, String music_upload_time, String music_remarks) {
        this.music_id = music_id;
        this.music_name = music_name;
        this.music_path_mp3 = music_path_mp3;
        this.music_path_lrc = music_path_lrc;
        this.music_type1 = music_type1;
        this.music_type2 = music_type2;
        this.music_audition_sum_number = music_audition_sum_number;
        this.music_audition_month_number = music_audition_month_number;
        this.music_audition_week_number = music_audition_week_number;
        this.music_audition_day_number = music_audition_day_number;
        this.music_download_sum_number = music_download_sum_number;
        this.music_download_month_number = music_download_month_number;
        this.music_download_week_number = music_download_week_number;
        this.music_download_day_number = music_download_day_number;
        this.music_type_photo = music_type_photo;
        this.music_photo = music_photo;
        this.music_coins = music_coins;
        this.music_upload_time = music_upload_time;
        this.music_remarks = music_remarks;
    }

    public Music(int music_id, String music_name, String music_photo, String music_path_mp3, String music_path_lrc, String music_type1, String music_type2) {
        this.music_type2 = music_type2;
        this.music_name = music_name;
        this.music_photo = music_photo;
        this.music_path_mp3 = music_path_mp3;
        this.music_path_lrc = music_path_lrc;
        this.music_type1 = music_type1;
        this.music_id = music_id;
    }

    public Music(int music_id, String music_photo, String music_name, int music_audition_sum_number, int music_download_sum_number) {
        this.music_id = music_id;
        this.music_photo = music_photo;
        this.music_name = music_name;
        this.music_audition_sum_number = music_audition_sum_number;
        this.music_download_sum_number = music_download_sum_number;
    }

    public int getMusic_id() {
        return music_id;
    }

    public void setMusic_id(int music_id) {
        this.music_id = music_id;
    }

    public String getMusic_name() {
        return music_name;
    }

    public void setMusic_name(String music_name) {
        this.music_name = music_name;
    }

    public String getMusic_path_mp3() {
        return music_path_mp3;
    }

    public void setMusic_path_mp3(String music_path_mp3) {
        this.music_path_mp3 = music_path_mp3;
    }

    public String getMusic_path_lrc() {
        return music_path_lrc;
    }

    public void setMusic_path_lrc(String music_path_lrc) {
        this.music_path_lrc = music_path_lrc;
    }

    public String getMusic_type1() {
        return music_type1;
    }

    public void setMusic_type1(String music_type1) {
        this.music_type1 = music_type1;
    }

    public String getMusic_type2() {
        return music_type2;
    }

    public void setMusic_type2(String music_type2) {
        this.music_type2 = music_type2;
    }

    public int getMusic_audition_sum_number() {
        return music_audition_sum_number;
    }

    public void setMusic_audition_sum_number(int music_audition_sum_number) {
        this.music_audition_sum_number = music_audition_sum_number;
    }

    public int getMusic_audition_month_number() {
        return music_audition_month_number;
    }

    public void setMusic_audition_month_number(int music_audition_month_number) {
        this.music_audition_month_number = music_audition_month_number;
    }

    public int getMusic_audition_week_number() {
        return music_audition_week_number;
    }

    public void setMusic_audition_week_number(int music_audition_week_number) {
        this.music_audition_week_number = music_audition_week_number;
    }

    public int getMusic_audition_day_number() {
        return music_audition_day_number;
    }

    public void setMusic_audition_day_number(int music_audition_day_number) {
        this.music_audition_day_number = music_audition_day_number;
    }

    public int getMusic_download_sum_number() {
        return music_download_sum_number;
    }

    public void setMusic_download_sum_number(int music_download_sum_number) {
        this.music_download_sum_number = music_download_sum_number;
    }

    public int getMusic_download_month_number() {
        return music_download_month_number;
    }

    public void setMusic_download_month_number(int music_download_month_number) {
        this.music_download_month_number = music_download_month_number;
    }

    public int getMusic_download_week_number() {
        return music_download_week_number;
    }

    public void setMusic_download_week_number(int music_download_week_number) {
        this.music_download_week_number = music_download_week_number;
    }

    public int getMusic_download_day_number() {
        return music_download_day_number;
    }

    public void setMusic_download_day_number(int music_download_day_number) {
        this.music_download_day_number = music_download_day_number;
    }

    public String getMusic_type_photo() {
        return music_type_photo;
    }

    public void setMusic_type_photo(String music_type_photo) {
        this.music_type_photo = music_type_photo;
    }

    public String getMusic_photo() {
        return music_photo;
    }

    public void setMusic_photo(String music_photo) {
        this.music_photo = music_photo;
    }

    public int getMusic_coins() {
        return music_coins;
    }

    public void setMusic_coins(int music_coins) {
        this.music_coins = music_coins;
    }

    public String getMusic_upload_time() {
        return music_upload_time;
    }

    public void setMusic_upload_time(String music_upload_time) {
        this.music_upload_time = music_upload_time;
    }

    public String getMusic_remarks() {
        return music_remarks;
    }

    public void setMusic_remarks(String music_remarks) {
        this.music_remarks = music_remarks;
    }



    @Override
    public String toString() {
        return "Music [music_id=" + music_id + ", music_name=" + music_name
                + ", music_path_mp3=" + music_path_mp3 + ", music_path_lrc="
                + music_path_lrc + ", music_type1=" + music_type1
                + ", music_type2=" + music_type2
                + ", music_audition_sum_number=" + music_audition_sum_number
                + ", music_audition_month_number="
                + music_audition_month_number + ", music_audition_week_number="
                + music_audition_week_number + ", music_audition_day_number="
                + music_audition_day_number + ", music_download_sum_number="
                + music_download_sum_number + ", music_download_month_number="
                + music_download_month_number + ", music_download_week_number="
                + music_download_week_number + ", music_download_day_number="
                + music_download_day_number + ", music_type_photo="
                + music_type_photo + ", music_photo=" + music_photo
                + ", music_coins=" + music_coins + ", music_upload_time="
                + music_upload_time + ", music_remarks=" + music_remarks + "]";
    }

}
