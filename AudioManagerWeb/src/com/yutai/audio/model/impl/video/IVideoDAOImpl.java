package com.yutai.audio.model.impl.video;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yutai.audio.model.beans.video.Video;
import com.yutai.audio.model.beans.video.VideoType;
import com.yutai.audio.model.dao.video.IVideoDAO;
import com.yutai.audio.utils.C3P0Utils;

public class IVideoDAOImpl implements IVideoDAO {
	private Connection connection = null;
	private PreparedStatement statement = null;
	private ResultSet resultSet = null;
	@Override
	public boolean addVideo(Video video) {
		// TODO Auto-generated method stub
		boolean result = false;
		connection = C3P0Utils.getConnection();
		//向表中加入该视频
		String sql = "INSERT INTO video(video_name,video_path,video_type1,video_type2,"
				+ "video_audition_sum_number,video_audition_month_number,video_audition_week_number,"
				+ "video_audition_day_number,video_download_sum_number,video_download_month_number,"
				+ "video_download_week_number,video_download_day_number,video_type_photo,video_photo,"
				+ "video_coins,video_upload_time,video_remarks) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, video.getVideo_name());
			statement.setString(2, video.getVideo_path());
			statement.setString(3, video.getVideo_type1());
			statement.setString(4, video.getVideo_type2());
			statement.setInt(5, video.getVideo_audition_sum_number());
			statement.setInt(6, video.getVideo_audition_month_number());
			statement.setInt(7, video.getVideo_audition_week_number());
			statement.setInt(8, video.getVideo_audition_day_number());
			statement.setInt(9, video.getVideo_download_sum_number());
			statement.setInt(10, video.getVideo_download_month_number());
			statement.setInt(11, video.getVideo_download_week_number());
			statement.setInt(12, video.getVideo_download_day_number());
			statement.setString(13, video.getVideo_type_photo());
			statement.setString(14, video.getVideo_photo());
			statement.setInt(15, video.getVideo_coins());
			statement.setString(16, video.getVideo_upload_time());
			statement.setString(17, video.getVideo_remarks());
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
	public Video selectVideoByID(int video_id) {
		// TODO Auto-generated method stub
		Video video = null;
		connection = C3P0Utils.getConnection();
		String sql = "select * from video where video_id=?";
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, video_id);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				video = new Video(resultSet.getInt(1), resultSet.getString(2),
						resultSet.getString(3), resultSet.getString(4), resultSet.getString(5),
						resultSet.getInt(6), resultSet.getInt(7), resultSet.getInt(8), resultSet.getInt(9), resultSet.getInt(10),
						resultSet.getInt(11), resultSet.getInt(12), resultSet.getInt(13), resultSet.getString(14),
						resultSet.getString(15), resultSet.getInt(16), resultSet.getString(17), resultSet.getString(18));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			C3P0Utils.close(resultSet, statement, connection);
		}
		return video;
	}

	@Override
	public List<VideoType> selectVideoByVideotype1(String video_type1) {
		// TODO Auto-generated method stub
		List<VideoType> videoTypeList = new ArrayList<>();
		connection = C3P0Utils.getConnection();
		//根据一级分类查询出它下面的所有二级分类名称，图片及数量
		String sql = "SELECT video_type1,video_type2,video_type_photo,COUNT(video_type2) FROM video"
				+ "WHERE video_type1 = ？ GROUP BY video_type2 ORDER BY COUNT(video_type2) DESC;";
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, video_type1);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				VideoType videoType = new VideoType(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getInt(4));
				videoTypeList.add(videoType);	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return videoTypeList;
	}

	@Override
	public List<Video> selectVideoByVideotype2(String video_type2) {
		// TODO Auto-generated method stub
		List<Video> videoList = new ArrayList<>();
		connection = C3P0Utils.getConnection();
		String sql = "select * from video where video_type2 =?";
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, video_type2);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Video video = new Video(resultSet.getInt(1), resultSet.getString(2),
					    resultSet.getString(3), resultSet.getString(4), resultSet.getString(5),
						resultSet.getInt(6), resultSet.getInt(7), resultSet.getInt(8), resultSet.getInt(9), resultSet.getInt(10),
						resultSet.getInt(11), resultSet.getInt(12), resultSet.getInt(13), resultSet.getString(14),
						resultSet.getString(15), resultSet.getInt(16), resultSet.getString(17), resultSet.getString(18));
				videoList.add(video);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			C3P0Utils.close(resultSet, statement, connection);
		}
		
		return videoList;
	}

	@Override
	public List<Video> selectAllVideo() {
		// TODO Auto-generated method stub
		List<Video> videoList = new ArrayList<>();
		connection = C3P0Utils.getConnection();
		String sql = "select * from video";
		try {
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Video video = new Video(resultSet.getInt(1), resultSet.getString(2),
					    resultSet.getString(3), resultSet.getString(4), resultSet.getString(5),
						resultSet.getInt(6), resultSet.getInt(7), resultSet.getInt(8), resultSet.getInt(9), resultSet.getInt(10),
						resultSet.getInt(11), resultSet.getInt(12), resultSet.getInt(13), resultSet.getString(14),
						resultSet.getString(15), resultSet.getInt(16), resultSet.getString(17), resultSet.getString(18));
				videoList.add(video);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			C3P0Utils.close(resultSet, statement, connection);
		}
		
		return videoList;
	}

}
