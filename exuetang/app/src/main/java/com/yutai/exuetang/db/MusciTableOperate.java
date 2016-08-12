package com.yutai.exuetang.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.yutai.exuetang.model.beans.audio.music.Music;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/30.
 */
public class MusciTableOperate {
    //声明数据库辅助类对象
    public MusicDatabaseHelper mHelper;
    //声明一个数据库操作类
    private SQLiteDatabase db = null;
    //声明一个游标接口对象，用来遍历查询结果
    public Cursor mCursor = null;
    public MusciTableOperate(Context context){
        mHelper = new MusicDatabaseHelper(context);
    }
    //向music表中添加数据
    public void insertData(Music music){
        //使用sqlitedatabase自带的插入方法
        db = mHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("music_id",music.getMusic_id() );
        cv.put("music_name",music.getMusic_name() );
        cv.put("music_path_mp3",music.getMusic_path_mp3() );
        cv.put("music_path_lrc",music.getMusic_path_lrc() );
        cv.put("music_type1",music.getMusic_type1() );
        cv.put("music_type2",music.getMusic_type2() );
        cv.put("music_audition_sum_number",music.getMusic_audition_sum_number() );
        cv.put("music_audition_month_number",music.getMusic_audition_month_number() );
        cv.put("music_audition_week_number",music.getMusic_audition_week_number() );
        cv.put("music_audition_day_number",music.getMusic_audition_day_number() );
        cv.put("music_download_sum_number",music.getMusic_download_sum_number() );
        cv.put("music_download_month_number",music.getMusic_download_month_number() );
        cv.put("music_download_week_number",music.getMusic_download_week_number() );
        cv.put("music_download_day_number",music.getMusic_download_day_number() );
        cv.put("music_type_photo",music.getMusic_type_photo() );
        cv.put("music_photo",music.getMusic_photo() );
        cv.put("music_coins",music.getMusic_coins() );
        cv.put("music_upload_time",music.getMusic_upload_time() );
        cv.put("music_remarks",music.getMusic_remarks() );
        db.insert(MusicDatabaseHelper.getTablenameMusic(), null,cv);
        System.out.print("music数据插入成功");
        //关闭连接，释放资源
        db.close();

        //使用sql语句的方法插入数据
        /*db = mHelper.getWritableDatabase();
        db.execSQL("insert into music(music_id,music_name,music_path_mp3,music_path_lrc,music_type1,music_type2,\"\n" +
                "\t\t\t\t+ \"music_audition_sum_number,music_audition_month_number,music_audition_week_number,\"\n" +
                "\t\t\t\t+ \"music_audition_day_number,music_download_sum_number,music_download_month_number,\"\n" +
                "\t\t\t\t+ \"music_download_week_number,music_download_day_number,music_type_photo,music_photo,\"\n" +
                "\t\t\t\t+ \"music_coins,music_upload_time,music_remarks) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",
                new Object[]{music.getMusic_id(),music.getMusic_name(),music.getMusic_path_mp3(),music.getMusic_path_lrc(),music.getMusic_type1(),
                        music.getMusic_type2(),music.getMusic_audition_sum_number(),music.getMusic_audition_month_number(),
                        music.getMusic_audition_week_number(),music.getMusic_audition_day_number(),music.getMusic_download_sum_number(),
                        music.getMusic_download_month_number(),music.getMusic_download_week_number(),music.getMusic_download_day_number(),
                        music.getMusic_type_photo(),music.getMusic_photo(),music.getMusic_coins(),music.getMusic_upload_time(),
                        music.getMusic_remarks()});
        db.close();*/

    }
    //删除music表中的一条数据
    public void deleteMusicByMusicid(int music_id){
        db = mHelper.getWritableDatabase();
        String whereClause = "music_id = ?";
        String whereArgs[]= new String[]{String.valueOf(music_id)};
        db.delete(MusicDatabaseHelper.getTablenameMusic(), whereClause, whereArgs);
        db.close();
        //使用sql语句进行删除
        /*db = mHelper.getWritableDatabase();
        db.execSQL("delete from music where music_id = ?",new Object[]{music_id});
        db.close();*/
    }
    //删除music表中的所有数据
    public void deleteAllMusic(){
        db = mHelper.getWritableDatabase();
        db.delete(MusicDatabaseHelper.getTablenameMusic(), null, null);
        db.close();
        //使用sql语句进行删除
        /*db = mHelper.getWritableDatabase();
        db.execSQL("delete from music where music_id = ?",new Object[]{music_id});
        db.close();*/
    }
    //查询 music表中的所有数据
    public List<Music> selectAllMusic(){
        List<Music> mList = new ArrayList<>();
        Music music = null;
        db = mHelper.getWritableDatabase();
        mCursor = db.rawQuery("select * from music order by id desc",null);
        while (mCursor.moveToNext()){
            int id = mCursor.getInt(0);
            int music_id = mCursor.getInt(1);
            String music_name = mCursor.getString(2);
            String music_path_mp3 = mCursor.getString(3);
            String music_path_lrc = mCursor.getString(4);
            String music_type1 = mCursor.getString(5);
            String music_type2 = mCursor.getString(6);
            int music_audition_sum_number = mCursor.getInt(7);
            int music_audition_month_number = mCursor.getInt(8);
            int music_audition_week_number = mCursor.getInt(9);
            int music_audition_day_number = mCursor.getInt(10);
            int music_download_sum_number = mCursor.getInt(11);
            int music_download_month_number = mCursor.getInt(12);
            int music_download_week_number = mCursor.getInt(13);
            int music_download_day_number = mCursor.getInt(14);
            String music_type_photo = mCursor.getString(15);
            String music_photo = mCursor.getString(16);
            double music_coins = mCursor.getDouble(17);
            String music_upload_time = mCursor.getString(18);
            String music_remarks = mCursor.getString(19);
            music = new Music(music_id,music_name,music_path_mp3,music_path_lrc,music_type1,music_type2,
                    music_audition_sum_number,music_audition_month_number,music_audition_week_number,
                    music_audition_day_number,music_download_sum_number,music_download_month_number,
                    music_download_week_number,music_download_day_number,music_type_photo,music_photo,
                    music_coins,music_upload_time,music_remarks);
            mList.add(music);
        }
        mCursor.close();
        db.close();
        return mList;
    }
}
