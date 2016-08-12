package com.yutai.exuetang.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2016/7/30.
 */
public class MusicDatabaseHelper extends SQLiteOpenHelper {
    //数据库名称，为了使用第三方软件打开数据库，最后加上后缀
    private static final String DATABASENAME = "exuetang.db";
    private static final int DATABASEVERSION = 1;
    private static final String TABLENAME_MUSIC = "music";

    public MusicDatabaseHelper(Context context){
        super(context,DATABASENAME,null,DATABASEVERSION);
    }
    //第一次创建数据库的时候调用，如果数据库已经存在，此方法不会调用
    @Override
    public void onCreate(SQLiteDatabase db) {
        System.out.println("开始创建表");
        //创建music表
        String sql="create table "+TABLENAME_MUSIC+"("
                +"id   integer     primary key ,"
                +"music_id   integer,"
                +"music_name varchar(200),"
                +"music_path_mp3  varchar(300),"
                +"music_path_lrc  varchar(300),"
                +"music_type1     varchar(20),"
                +"music_type2     varchar(20),"
                +"music_audition_sum_number    integer,"
                +"music_audition_month_number  integer,"
                +"music_audition_week_number   integer,"
                +"music_audition_day_number    integer,"
                +"music_download_sum_number    integer,"
                +"music_download_month_number  integer,"
                +"music_download_week_number   integer,"
                +"music_download_day_number    integer,"
                +"music_type_photo varchar(300),"
                +"music_photo varchar(300),"
                +"music_coins double,"
                +"music_upload_time datetime,"
                +"music_remarks  varchar(100))";
        //execSQL用来执行出了查询之外的数据库操作，例如增、删、改
        db.execSQL(sql);
        System.out.println("创建表完成");
    }
    //升级数据库的时候使用，当发现两次数据库的DATABASEVERSION值不一致的时候，则认为数据库会升级
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql="drop table if exists "+TABLENAME_MUSIC;
        db.execSQL(sql);
        onCreate(db);
    }
    //访问器
    public static String getDataBasename() {
        return DATABASENAME;
    }

    public static int getDataBaseversion() {
        return DATABASEVERSION;
    }

    public static String getTablenameMusic() {
        return TABLENAME_MUSIC;
    }
}
