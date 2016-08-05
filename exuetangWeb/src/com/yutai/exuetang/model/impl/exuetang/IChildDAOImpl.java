package com.yutai.exuetang.model.impl.exuetang;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yutai.exuetang.model.beans.exuetang.Child;
import com.yutai.exuetang.model.dao.exuetang.IChildDAO;
import com.yutai.exuetang.utils.C3P0Utils;

public class IChildDAOImpl implements IChildDAO {
	private Connection connection = null;
	private PreparedStatement statement = null;
	private ResultSet resultSet = null;
	private String sql = null;
	private Child child = null;
	private List<Child> childList = null;

	@Override
	public boolean addChild(Child child) {
		boolean result = false;
		connection = C3P0Utils.getConnection();
		// 向表中加入该用户
		sql = "insert into child(child_birthday,child_name,child_photo,child_sex,child_school_province,child_school_city,child_school_county,child_school_town,child_school_name,child_school_class,child_home_province,child_home_city,child_home_county,child_home_address,child_hobby,child_remarks) values"
				+ "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, child.getChild_birthday());
			statement.setString(2, child.getChild_name());
			statement.setString(3, child.getChild_photo());
			statement.setString(4, child.getChild_sex());
			statement.setString(5, child.getChild_school_province());
			statement.setString(6, child.getChild_school_city());
			statement.setString(7, child.getChild_school_county());
			statement.setString(8, child.getChild_school_town());
			statement.setString(9, child.getChild_school_name());
			statement.setString(10, child.getChild_school_class());
			statement.setString(11, child.getChild_home_province());
			statement.setString(12, child.getChild_home_city());
			statement.setString(13, child.getChild_home_county());
			statement.setString(14, child.getChild_home_address());
			statement.setString(15, child.getChild_hobby());
			statement.setString(16, child.getChild_remarks());
			statement.executeUpdate();
			System.out.println("插入宝宝成功");
			result = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("插入宝宝失败");
			result = false;
			e.printStackTrace();
		} finally {
			C3P0Utils.close(resultSet, statement, connection);
		}
		return result;
	}

	@Override
	public Child selectChildByChildID(int child_id) {
		// TODO Auto-generated method stub
		connection = C3P0Utils.getConnection();
		sql = "select * from child where child_id=?";
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, child_id);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				int child_id1 = resultSet.getInt(1);
				int user_id = resultSet.getInt(2);
				String child_birthday = resultSet.getString(3);
				String child_name = resultSet.getString(4);
				String child_photo = resultSet.getString(5);
				String child_sex = resultSet.getString(6);
				String child_school_province = resultSet.getString(7);
				String child_school_city = resultSet.getString(8);
				String child_school_county = resultSet.getString(9);
				String child_school_town = resultSet.getString(10);
				String child_school_name = resultSet.getString(11);
				String child_school_class = resultSet.getString(12);
				String child_home_province = resultSet.getString(13);
				String child_home_city = resultSet.getString(14);
				String child_home_county = resultSet.getString(15);
				String child_home_address = resultSet.getString(16);
				String child_hobby = resultSet.getString(17);
				String child_remarks = resultSet.getString(18);
				child = new Child(child_id1, user_id, child_birthday,
						child_name, child_photo, child_sex,
						child_school_province, child_school_city,
						child_school_county, child_school_town,
						child_school_name, child_school_class,
						child_home_province, child_home_city,
						child_home_county, child_home_address, child_hobby,
						child_remarks);
				System.out.println("查找成功");
				return child;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("查找失败");
			e.printStackTrace();
		} finally {
			C3P0Utils.close(resultSet, statement, connection);
		}
		return child;
	}

	@Override
	public Child selectChildByUserID(int user_id) {
		connection = C3P0Utils.getConnection();
		sql = "select * from child where user_id=?";
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, user_id);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				int child_id = resultSet.getInt(1);
				int user_id1 = resultSet.getInt(2);
				String child_birthday = resultSet.getString(3);
				String child_name = resultSet.getString(4);
				String child_photo = resultSet.getString(5);
				String child_sex = resultSet.getString(6);
				String child_school_province = resultSet.getString(7);
				String child_school_city = resultSet.getString(8);
				String child_school_county = resultSet.getString(9);
				String child_school_town = resultSet.getString(10);
				String child_school_name = resultSet.getString(11);
				String child_school_class = resultSet.getString(12);
				String child_home_province = resultSet.getString(13);
				String child_home_city = resultSet.getString(14);
				String child_home_county = resultSet.getString(15);
				String child_home_address = resultSet.getString(16);
				String child_hobby = resultSet.getString(17);
				String child_remarks = resultSet.getString(18);
				child = new Child(child_id, user_id1, child_birthday,
						child_name, child_photo, child_sex,
						child_school_province, child_school_city,
						child_school_county, child_school_town,
						child_school_name, child_school_class,
						child_home_province, child_home_city,
						child_home_county, child_home_address, child_hobby,
						child_remarks);
				System.out.println("查找成功");
				return child;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("查找失败");
			e.printStackTrace();
		} finally {
			C3P0Utils.close(resultSet, statement, connection);
		}
		return child;
	}

	@Override
	public List<Child> selectAllChild() {
		// TODO Auto-generated method stub
		childList = new ArrayList<>();
		connection = C3P0Utils.getConnection();
		sql = "select * from child";
		try {
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				int child_id = resultSet.getInt(1);
				int user_id1 = resultSet.getInt(2);
				String child_birthday = resultSet.getString(3);
				String child_name = resultSet.getString(4);
				String child_photo = resultSet.getString(5);
				String child_sex = resultSet.getString(6);
				String child_school_province = resultSet.getString(7);
				String child_school_city = resultSet.getString(8);
				String child_school_county = resultSet.getString(9);
				String child_school_town = resultSet.getString(10);
				String child_school_name = resultSet.getString(11);
				String child_school_class = resultSet.getString(12);
				String child_home_province = resultSet.getString(13);
				String child_home_city = resultSet.getString(14);
				String child_home_county = resultSet.getString(15);
				String child_home_address = resultSet.getString(16);
				String child_hobby = resultSet.getString(17);
				String child_remarks = resultSet.getString(18);
				child = new Child(child_id, user_id1, child_birthday,
						child_name, child_photo, child_sex,
						child_school_province, child_school_city,
						child_school_county, child_school_town,
						child_school_name, child_school_class,
						child_home_province, child_home_city,
						child_home_county, child_home_address, child_hobby,
						child_remarks);
				childList.add(child);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			C3P0Utils.close(resultSet, statement, connection);
		}
		return childList;
	}
}
