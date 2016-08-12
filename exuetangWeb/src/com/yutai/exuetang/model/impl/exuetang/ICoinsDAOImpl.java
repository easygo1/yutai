package com.yutai.exuetang.model.impl.exuetang;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yutai.exuetang.model.beans.exuetang.Coins;
import com.yutai.exuetang.model.dao.exuetang.ICoinsDAO;
import com.yutai.exuetang.utils.C3P0Utils;

public class ICoinsDAOImpl implements ICoinsDAO {
	private Connection connection = null;
	private PreparedStatement statement = null;
	private ResultSet resultSet = null;
	private String sql = null;
	private Coins coins = null;
	private List<Coins> coinsList = null;

	@Override
	public boolean addCoins(Coins coins) {
		boolean result = false;
		connection = C3P0Utils.getConnection();
		// 向表中加入该用户
		sql = "insert into coins(user_id,coins_num,coins_remarks) values(?,?,?);";
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, coins.getUser_id());
			statement.setDouble(2, coins.getCoins_num());
			statement.setString(3, coins.getCoins_remarks());
			statement.executeUpdate();
			System.out.println("插入积分成功");
			result = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("插入积分失败");
			result = false;
			e.printStackTrace();
		} finally {
			C3P0Utils.close(resultSet, statement, connection);
		}
		return result;
	}

	@Override
	public Coins selectCoinsByCoinsID(int coins_id) {
		connection = C3P0Utils.getConnection();
		sql = "select * from coins where coins_id=?";
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, coins_id);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				int coins_id1 = resultSet.getInt(1);
				int user_id = resultSet.getInt(2);
				double coins_num = resultSet.getDouble(3);
				String coins_remarks = resultSet.getString(4);
				coins = new Coins(coins_id1, user_id, coins_num, coins_remarks);
				System.out.println("查找成功");
				return coins;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("查找失败");
			e.printStackTrace();
		} finally {
			C3P0Utils.close(resultSet, statement, connection);
		}
		return coins;
	}

	@Override
	public double selectCoinsNumByUserID(int user_id) {
		connection = C3P0Utils.getConnection();
		sql = "select coins_num from coins where user_id=?";
		double coins_num = 0.0;
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, user_id);
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

	@Override
	public boolean updateCoinsByUserID(int user_id, double coins_num) {
		connection = C3P0Utils.getConnection();
		sql = "UPDATE coins SET coins_num=coins_num-? where user_id = ?";
		try {
			statement = connection.prepareStatement(sql);
			statement.setDouble(1, coins_num);
			statement.setInt(2, user_id);
			statement.executeUpdate();
			System.out.println("积分更新成功");
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
	public List<Coins> selectAllCoins() {
		coinsList = new ArrayList<>();
		connection = C3P0Utils.getConnection();
		sql = "select * from coins";
		try {
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				int coins_id = resultSet.getInt(1);
				int user_id = resultSet.getInt(2);
				int coins_num = resultSet.getInt(3);
				String coins_remarks = resultSet.getString(4);
				coins = new Coins(coins_id, user_id, coins_num, coins_remarks);
				coinsList.add(coins);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			C3P0Utils.close(resultSet, statement, connection);
		}
		return coinsList;
	}
}
