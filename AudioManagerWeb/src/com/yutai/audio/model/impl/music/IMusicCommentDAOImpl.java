package com.yutai.audio.model.impl.music;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yutai.audio.model.beans.music.Music;
import com.yutai.audio.model.beans.music.MusicComment;
import com.yutai.audio.model.dao.music.IMusicCommentDAO;
import com.yutai.audio.utils.C3P0Utils;

public class IMusicCommentDAOImpl implements IMusicCommentDAO {
	private Connection connection = null;
	private PreparedStatement statement = null;
	private ResultSet resultSet = null;
	@Override
	public boolean addMusicComment(MusicComment musiccomment) {
		// TODO Auto-generated method stub
		boolean result = false;
		connection = C3P0Utils.getConnection();
		//向表中加入该音乐的评论
		String sql = "INSERT INTO musiccomment(music_id,user_id,comment_content,comment_time VALUES(?,?,?,?);";
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, musiccomment.getMusic_id());
			statement.setInt(2, musiccomment.getUser_id());
			statement.setString(3, musiccomment.getComment_content());
			statement.setString(4, musiccomment.getComment_time());
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
	public MusicComment selectMusicCommentByID(int musiccomment_id) {
		// TODO Auto-generated method stub
		MusicComment musicComment = null;
		connection = C3P0Utils.getConnection();
		String sql = "select * from musiccomment where musiccomment_id=?";
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, musiccomment_id);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				musicComment = new MusicComment(resultSet.getInt(1), resultSet.getInt(2),
						resultSet.getInt(3), resultSet.getString(4), resultSet.getString(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			C3P0Utils.close(resultSet, statement, connection);
		}
		return musicComment;
	}

	@Override
	public List<MusicComment> selectMusicCommentByMusicID(int music_id) {
		// TODO Auto-generated method stub
		List<MusicComment> musicCommentList = new ArrayList<>();
		MusicComment musicComment = null;
		connection = C3P0Utils.getConnection();
		String sql = "select * from musiccomment where music_id=?";
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, music_id);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				musicComment = new MusicComment(resultSet.getInt(1), resultSet.getInt(2),
						resultSet.getInt(3), resultSet.getString(4), resultSet.getString(5));
				musicCommentList.add(musicComment);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			C3P0Utils.close(resultSet, statement, connection);
		}
		return musicCommentList;
	}

	@Override
	public List<MusicComment> selectAllMusicCommentByID() {
		// TODO Auto-generated method stub
		List<MusicComment> musicCommentList = new ArrayList<>();
		MusicComment musicComment = null;
		connection = C3P0Utils.getConnection();
		String sql = "select * from musiccomment;";
		try {
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				musicComment = new MusicComment(resultSet.getInt(1), resultSet.getInt(2),
						resultSet.getInt(3), resultSet.getString(4), resultSet.getString(5));
				musicCommentList.add(musicComment);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			C3P0Utils.close(resultSet, statement, connection);
		}
		return musicCommentList;
	}
	
}
