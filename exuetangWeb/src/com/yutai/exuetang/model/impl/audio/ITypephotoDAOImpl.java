package com.yutai.exuetang.model.impl.audio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.yutai.exuetang.model.beans.audio.Music;
import com.yutai.exuetang.model.beans.audio.Typephoto;
import com.yutai.exuetang.model.dao.audio.ITypephotoDAO;
import com.yutai.exuetang.utils.C3P0Utils;

public class ITypephotoDAOImpl implements ITypephotoDAO{
//二级类型图片的处理
	private Connection connection = null;
	private PreparedStatement statement = null;
	private ResultSet resultSet = null;
	private Typephoto typephoto;
	String sql = null;
	@Override
	public boolean addTypephoto(Typephoto typephoto) {
		boolean result = false;
		connection = C3P0Utils.getConnection();
		// 向表中加入该音乐
		sql = "insert into musictype(music_type2,music_type2_path) VALUES(?,?);";
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, typephoto.getMusic_type2());
			statement.setString(2, typephoto.getMusic_type2_path());
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
	public String selectTypephoto(String music_type2) {
		connection = C3P0Utils.getConnection();
		String type2_path="";
		sql = "select music_type2_path from musictype where music_type2=? limit 1";
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, music_type2);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				type2_path=resultSet.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			C3P0Utils.close(resultSet, statement, connection);
		}
		return type2_path;
	}
}
