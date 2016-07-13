package com.yutai.audio.model.impl.video;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yutai.audio.model.beans.video.VideoComment;
import com.yutai.audio.model.dao.video.IVideoCommentDAO;
import com.yutai.audio.utils.C3P0Utils;

public class IVideoCommentDAOImpl implements IVideoCommentDAO {
	private Connection connection = null;
	private PreparedStatement statement = null;
	private ResultSet resultSet = null;
	@Override
	public boolean addVideoComment(VideoComment videocomment) {
		// TODO Auto-generated method stub
		boolean result = false;
		connection = C3P0Utils.getConnection();
		//向表中加入该音乐的评论
		String sql = "INSERT INTO videocomment(video_id,user_id,comment_content,comment_time VALUES(?,?,?,?);";
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, videocomment.getVideo_id());
			statement.setInt(2, videocomment.getUser_id());
			statement.setString(3, videocomment.getComment_content());
			statement.setString(4, videocomment.getComment_time());
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
	public VideoComment selectVideoCommentByID(int videocomment_id) {
		// TODO Auto-generated method stub
		VideoComment videoComment = null;
		connection = C3P0Utils.getConnection();
		String sql = "select * from videocomment where videocomment_id=?";
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, videocomment_id);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				videoComment = new VideoComment(resultSet.getInt(1), resultSet.getInt(2),
						resultSet.getInt(3), resultSet.getString(4), resultSet.getString(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			C3P0Utils.close(resultSet, statement, connection);
		}
		return videoComment;
	}

	@Override
	public List<VideoComment> selectVideoCommentByVideoID(int video_id) {
		// TODO Auto-generated method stub
		List<VideoComment> videoCommentList = new ArrayList<>();
		VideoComment videoComment = null;
		connection = C3P0Utils.getConnection();
		String sql = "select * from videocomment where video_id=?";
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, video_id);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				videoComment = new VideoComment(resultSet.getInt(1), resultSet.getInt(2),
						resultSet.getInt(3), resultSet.getString(4), resultSet.getString(5));
				videoCommentList.add(videoComment);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			C3P0Utils.close(resultSet, statement, connection);
		}
		return videoCommentList;
	}

	@Override
	public List<VideoComment> selectAllVideoCommentByID() {
		// TODO Auto-generated method stub
		List<VideoComment> videoCommentList = new ArrayList<>();
		VideoComment videoComment = null;
		connection = C3P0Utils.getConnection();
		String sql = "select * from videocomment;";
		try {
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				videoComment = new VideoComment(resultSet.getInt(1), resultSet.getInt(2),
						resultSet.getInt(3), resultSet.getString(4), resultSet.getString(5));
				videoCommentList.add(videoComment);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			C3P0Utils.close(resultSet, statement, connection);
		}
		return videoCommentList;
	}

}
