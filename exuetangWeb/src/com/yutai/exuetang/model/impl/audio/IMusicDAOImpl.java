package com.yutai.exuetang.model.impl.audio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yutai.exuetang.model.beans.audio.Music;
import com.yutai.exuetang.model.dao.audio.IMusicDAO;
import com.yutai.exuetang.utils.C3P0Utils;


public class IMusicDAOImpl implements IMusicDAO {
	private Connection connection = null;
	private PreparedStatement statement = null;
	private ResultSet resultSet = null;
	@Override
	public boolean addMusic(Music music) {
		// TODO Auto-generated method stub
		boolean result = false;
		connection = C3P0Utils.getConnection();
		//向表中加入该音乐
		String sql = "INSERT INTO music(music_name,music_path_mp3,music_path_lrc,music_type1,music_type2,"
				+ "music_audition_sum_number,music_audition_month_number,music_audition_week_number,"
				+ "music_audition_day_number,music_download_sum_number,music_download_month_number,"
				+ "music_download_week_number,music_download_day_number,music_type_photo,music_photo,"
				+ "music_coins,music_upload_time,music_remarks) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, music.getMusic_name());
			statement.setString(2, music.getMusic_path_mp3());
			statement.setString(3, music.getMusic_path_lrc());
			statement.setString(4, music.getMusic_type1());
			statement.setString(5, music.getMusic_type2());
			statement.setInt(6, music.getMusic_audition_sum_number());
			statement.setInt(7, music.getMusic_audition_month_number());
			statement.setInt(8, music.getMusic_audition_week_number());
			statement.setInt(9, music.getMusic_audition_day_number());
			statement.setInt(10, music.getMusic_download_sum_number());
			statement.setInt(11, music.getMusic_download_month_number());
			statement.setInt(12, music.getMusic_download_week_number());
			statement.setInt(13, music.getMusic_download_day_number());
			statement.setString(14, music.getMusic_type_photo());
			statement.setString(15, music.getMusic_photo());
			statement.setInt(16, music.getMusic_coins());
			statement.setString(17, music.getMusic_upload_time());
			statement.setString(18, music.getMusic_remarks());
			statement.executeQuery();
			result = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = false;
		}finally{
			C3P0Utils.close(resultSet, statement, connection);
		}
		return result;
	}

	@Override
	public Music selectMusicByID(int music_id) {
		// TODO Auto-generated method stub
		Music music = null;
		connection = C3P0Utils.getConnection();
		String sql = "select * from music where music_id=?";
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, music_id);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				music = new Music(resultSet.getInt(1), resultSet.getString(2),
						resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6),
						resultSet.getInt(7), resultSet.getInt(8), resultSet.getInt(9), resultSet.getInt(10), resultSet.getInt(11),
						resultSet.getInt(12), resultSet.getInt(13), resultSet.getInt(14), resultSet.getString(15),
						resultSet.getString(16), resultSet.getInt(17), resultSet.getString(18),resultSet.getString(19));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			C3P0Utils.close(resultSet, statement, connection);
		}
		return music;
	}



	@Override
	public List<Music> selectMusicByMusictype2(String music_type2) {
		// TODO Auto-generated method stub
		List<Music> musicList = new ArrayList<>();
		connection = C3P0Utils.getConnection();
		String sql = "select * from music where music_type2 =?";
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, music_type2);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Music music = new Music(resultSet.getInt(1), resultSet.getString(2),
						resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6),
						resultSet.getInt(7), resultSet.getInt(8), resultSet.getInt(9), resultSet.getInt(10), resultSet.getInt(11),
						resultSet.getInt(12), resultSet.getInt(13), resultSet.getInt(14), resultSet.getString(15),
						resultSet.getString(16), resultSet.getInt(17), resultSet.getString(18), resultSet.getString(19));
				musicList.add(music);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			C3P0Utils.close(resultSet, statement, connection);
		}
		
		return musicList;
	}

	@Override
	public List<Music> selectAllMusic() {
		// TODO Auto-generated method stub
		List<Music> musicList = new ArrayList<>();
		connection = C3P0Utils.getConnection();
		String sql = "select * from music";
		try {
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Music music = new Music(resultSet.getInt(1), resultSet.getString(2),
						resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6),
						resultSet.getInt(7), resultSet.getInt(8), resultSet.getInt(9), resultSet.getInt(10), resultSet.getInt(11),
						resultSet.getInt(12), resultSet.getInt(13), resultSet.getInt(14), resultSet.getString(15),
						resultSet.getString(16), resultSet.getInt(17), resultSet.getString(18), resultSet.getString(19));
				musicList.add(music);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			C3P0Utils.close(resultSet, statement, connection);
		}
		
		return musicList;
	}

}
