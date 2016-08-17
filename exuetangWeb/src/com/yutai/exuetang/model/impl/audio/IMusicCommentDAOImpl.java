package com.yutai.exuetang.model.impl.audio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yutai.exuetang.model.beans.audio.GsonMusicCommentBean;
import com.yutai.exuetang.model.beans.audio.Music;
import com.yutai.exuetang.model.beans.audio.MusicComment;
import com.yutai.exuetang.model.dao.audio.IMusicCommentDAO;
import com.yutai.exuetang.utils.C3P0Utils;
import com.yutai.exuetang.utils.Paging;

public class IMusicCommentDAOImpl implements IMusicCommentDAO{
	private Connection connection = null;
	private PreparedStatement statement = null;
	private ResultSet resultSet = null;
	
	private List<MusicComment> musiccommentList = null;
	String sql = null;
	//Paging paging = new Paging();
	@Override
	public boolean addMusicComment(MusicComment musicComment) {
		// TODO Auto-generated method stub
				boolean result = false;
				connection = C3P0Utils.getConnection();
				// 向表中加入该音乐一条评论
				sql = "insert INTO musiccomment(music_id,user_id,comment_content,comment_time) values(?,?,?,?);";
				try {
					statement = connection.prepareStatement(sql);
					statement.setInt(1, musicComment.getMusic_id());
					statement.setInt(2, musicComment.getUser_id());
					statement.setString(3, musicComment.getComment_content());
					statement.setString(4, musicComment.getComment_time());
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
	public MusicComment selectMusicCommentByID(int musiccomment_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MusicComment> selectMusicCommentByMusicID(int music_id) {
		musiccommentList=new ArrayList<>();
		connection = C3P0Utils.getConnection();
		sql = "select * from musiccomment where music_id=?";
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, music_id);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				int comment_id = resultSet.getInt(1);
				int music_id1 = resultSet.getInt(2);
				int user_id = resultSet.getInt(3);
				String comment_content = resultSet.getString(4);
				String comment_time = resultSet.getString(5);
				MusicComment musicComment =new MusicComment(comment_id, music_id1, user_id, comment_content, comment_time);
				musiccommentList.add(musicComment);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			C3P0Utils.close(resultSet, statement, connection);
		}
		return musiccommentList;
	}

	@Override
	public List<MusicComment> selectMusicCommentList(int music_id,
			int cur) {
		// TODO Auto-generated method stub
		musiccommentList=new ArrayList<>();
		connection = C3P0Utils.getConnection();
		sql = "select * from musiccomment where music_id=? ORDER BY comment_time desc limit ?,?;";
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, music_id);
			int pagesize=5;
			// 分页处理
			statement.setInt(2, (cur - 1) * pagesize);
			statement.setInt(3, pagesize);

			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				int comment_id = resultSet.getInt(1);
				int music_id1 = resultSet.getInt(2);
				int user_id = resultSet.getInt(3);
				String comment_content = resultSet.getString(4);
				String comment_time = resultSet.getString(5);
				MusicComment musicComment =new MusicComment(comment_id, music_id1, user_id, comment_content, comment_time);
				musiccommentList.add(musicComment);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			C3P0Utils.close(resultSet, statement, connection);
		}
		return musiccommentList;
	}
}
