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
import com.yutai.exuetang.utils.Paging;

public class IMusicDAOImpl implements IMusicDAO {
	private Connection connection = null;
	private PreparedStatement statement = null;
	private ResultSet resultSet = null;

	private List<Music> musicList = null;
	private Music music = null;
	String sql = null;
	Paging paging = new Paging();

	// 将数据处理，计算出需要分成几页
	@Override
	public boolean addMusic(Music music) {
		// TODO Auto-generated method stub
		boolean result = false;
		connection = C3P0Utils.getConnection();
		// 向表中加入该音乐
		sql = "INSERT INTO music(music_name,music_path_mp3,music_path_lrc,music_type1,music_type2,"
				+ "music_audition_sum_number,music_audition_month_number,music_audition_week_number,"
				+ "music_audition_day_number,music_download_sum_number,music_download_month_number,"
				+ "music_download_week_number,music_download_day_number,music_photo,music_bg_photo,music_main_photo,music_introduct,"
				+ "music_coins,music_upload_time,music_remarks) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
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
			statement.setString(14, music.getMusic_photo());
			statement.setString(15, music.getMusic_bg_photo());
			statement.setString(16, music.getMusic_main_photo());
			statement.setString(17, music.getMusic_introduct());
			statement.setDouble(18, music.getMusic_coins());
			statement.setString(19, music.getMusic_upload_time());
			statement.setString(20, music.getMusic_remarks());
			statement.execute();
			result = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = false;
		} finally {
			C3P0Utils.close(resultSet, statement, connection);
		}
		return result;
	}

	@Override
	public Music selectMusicByID(int music_id) {
		// TODO Auto-generated method stub
		connection = C3P0Utils.getConnection();
		sql = "select * from music where music_id=?";
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, music_id);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				music = new Music(resultSet.getInt(1), resultSet.getString(2),
						resultSet.getString(3), resultSet.getString(4),
						resultSet.getString(5), resultSet.getString(6),
						resultSet.getInt(7), resultSet.getInt(8),
						resultSet.getInt(9), resultSet.getInt(10),
						resultSet.getInt(11), resultSet.getInt(12),
						resultSet.getInt(13), resultSet.getInt(14),
						resultSet.getString(15), resultSet.getString(16),
						resultSet.getString(17), resultSet.getString(18),
						resultSet.getDouble(19), resultSet.getString(20),
						resultSet.getString(21));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			C3P0Utils.close(resultSet, statement, connection);
		}
		return music;
	}

	@Override
	public List<Music> selectMusicByMusictype2(String music_type2) {
		// TODO Auto-generated method stub
		musicList = new ArrayList<>();
		connection = C3P0Utils.getConnection();
		sql = "select * from music where music_type2 =?";
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, music_type2);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				music = new Music(resultSet.getInt(1), resultSet.getString(2),
						resultSet.getString(3), resultSet.getString(4),
						resultSet.getString(5), resultSet.getString(6),
						resultSet.getInt(7), resultSet.getInt(8),
						resultSet.getInt(9), resultSet.getInt(10),
						resultSet.getInt(11), resultSet.getInt(12),
						resultSet.getInt(13), resultSet.getInt(14),
						resultSet.getString(15), resultSet.getString(16),
						resultSet.getString(17), resultSet.getString(18),
						resultSet.getDouble(19), resultSet.getString(20),
						resultSet.getString(21));
				musicList.add(music);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			C3P0Utils.close(resultSet, statement, connection);
		}
		return musicList;
	}

	@Override
	public List<Music> selectAllMusic() {
		// TODO Auto-generated method stub
		musicList = new ArrayList<>();
		connection = C3P0Utils.getConnection();
		sql = "select * from music";
		try {
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				music = new Music(resultSet.getInt(1), resultSet.getString(2),
						resultSet.getString(3), resultSet.getString(4),
						resultSet.getString(5), resultSet.getString(6),
						resultSet.getInt(7), resultSet.getInt(8),
						resultSet.getInt(9), resultSet.getInt(10),
						resultSet.getInt(11), resultSet.getInt(12),
						resultSet.getInt(13), resultSet.getInt(14),
						resultSet.getString(15), resultSet.getString(16),
						resultSet.getString(17), resultSet.getString(18),
						resultSet.getDouble(19), resultSet.getString(20),
						resultSet.getString(21));
				musicList.add(music);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			C3P0Utils.close(resultSet, statement, connection);
		}

		return musicList;
	}

	// 推荐排序 根据一级类型 二级类型 按照试听量排序 分页显示
	@Override
	public List<Music> selectMusicBytypesOrder1(String type1, String type2,
			int cur, int ordertype) {
		musicList = new ArrayList<>();
		connection = C3P0Utils.getConnection();
		if (1 == ordertype) {
			sql = "select * from music where music_type1 =? and music_type2=? ORDER BY music_audition_sum_number desc limit ?,?;";
		} else if (2 == ordertype) {
			sql = "select * from music where music_type1 =? and music_type2=? ORDER BY  music_upload_time desc limit ?,?;";
		} else if (3 == ordertype) {
			sql = "select * from music where music_type1 =? and music_type2=? ORDER BY music_download_sum_number desc limit ?,?;";
		}
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, type1);
			statement.setString(2, type2);

			System.out.println("type1" + type1 + " type2" + type2 + " tab类型"
					+ ordertype + " 当前页" + cur);
			// 分页处理
			statement.setInt(3, (cur - 1) * paging.getPageSize());
			statement.setInt(4, paging.getPageSize());

			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				int music_id = resultSet.getInt(1);
				String music_name = resultSet.getString(2);
				String music_path_mp3 = resultSet.getString(3);
				String music_path_lrc = resultSet.getString(4);
				String music_type1 = resultSet.getString(5);
				String music_type2 = resultSet.getString(6);
				int music_audition_sum_number = resultSet.getInt(7);
				int music_audition_month_number = resultSet.getInt(8);
				int music_audition_week_number = resultSet.getInt(9);
				int music_audition_day_number = resultSet.getInt(10);
				int music_download_sum_number = resultSet.getInt(11);
				int music_download_month_number = resultSet.getInt(12);
				int music_download_week_number = resultSet.getInt(13);
				int music_download_day_number = resultSet.getInt(14);
				String music_photo = resultSet.getString(15);
				String music_bg_photo = resultSet.getString(16);
				String music_main_photo = resultSet.getString(17);
				String music_introduct = resultSet.getString(18);
				double music_coins = resultSet.getDouble(19);
				String music_upload_time = resultSet.getString(20);
				String music_remarks = resultSet.getString(21);
				Music music = new Music(music_id, music_name, music_path_mp3,
						music_path_lrc, music_type1, music_type2,
						music_audition_sum_number, music_audition_month_number,
						music_audition_week_number, music_audition_day_number,
						music_download_sum_number, music_download_month_number,
						music_download_week_number, music_download_day_number,
						music_photo, music_bg_photo, music_main_photo,
						music_introduct, music_coins, music_upload_time,
						music_remarks);
				musicList.add(music);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			C3P0Utils.close(resultSet, statement, connection);
		}
		return musicList;
	}

	@Override
	public boolean updateDownloadNum(int music_id) {
		// TODO Auto-generated method stub
		connection = C3P0Utils.getConnection();
		sql = "UPDATE music SET music_download_sum_number=music_download_sum_number+1,music_download_month_number=music_download_month_number+'1',music_download_week_number=music_download_week_number+1,music_download_day_number=music_download_day_number+1 where music_id=?";
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, music_id);
			statement.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {
			C3P0Utils.close(resultSet, statement, connection);
		}
	}

	@Override
	public boolean updateAuditionNum(int music_id) {
		// TODO Auto-generated method stub
		connection = C3P0Utils.getConnection();
		sql = "UPDATE music SET music_audition_sum_number=music_audition_sum_number+1,music_audition_month_number=music_audition_month_number+'1',music_audition_week_number=music_audition_week_number+1,music_audition_day_number=music_audition_day_number+1 where music_id=?";
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, music_id);
			statement.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {
			C3P0Utils.close(resultSet, statement, connection);
		}
	}

	@Override
	public double getMusicCoins(int music_id) {
		connection = C3P0Utils.getConnection();
		sql = "select music_coins from music where music_id=?";
		double coins_num = 0;
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, music_id);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				coins_num = resultSet.getDouble(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("查找失败");
			e.printStackTrace();
		} finally {
			C3P0Utils.close(resultSet, statement, connection);
		}
		return coins_num;
	}
}
