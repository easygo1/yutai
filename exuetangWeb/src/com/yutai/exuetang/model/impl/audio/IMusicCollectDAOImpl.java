package com.yutai.exuetang.model.impl.audio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yutai.exuetang.model.beans.audio.MusicCollect;
import com.yutai.exuetang.model.dao.audio.IMusicCollectDAO;
import com.yutai.exuetang.utils.C3P0Utils;

public class IMusicCollectDAOImpl implements IMusicCollectDAO{
	private Connection connection = null;
	private PreparedStatement statement = null;
	private ResultSet resultSet = null;
	
	private List<MusicCollect> musicCollectList = null;
	String sql = null;
	@Override
	public List<MusicCollect> selectMusicCollectByUserId(int user_id) {
		// TODO Auto-generated method stub
		musicCollectList = new ArrayList<>();
		connection = C3P0Utils.getConnection();
		sql = "select * from music_collect where user_id=?";
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, user_id);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				int music_collect_id = resultSet.getInt(1);
				int user_id1 = resultSet.getInt(2);
				int music_id = resultSet.getInt(3);
				MusicCollect musicCollect = new MusicCollect(music_collect_id, user_id1, music_id);
				musicCollectList.add(musicCollect);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return musicCollectList;
	}

}
