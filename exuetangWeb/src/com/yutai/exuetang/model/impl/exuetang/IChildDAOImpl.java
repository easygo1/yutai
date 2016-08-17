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
		sql = "insert into child(user_id,child_birthday,child_name,child_photo,child_sex,child_school_class_name,child_home_province,child_home_city,child_home_county,child_home_address,child_dream,child_hobby,child_trainplan,child_remarks) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, child.getUser_id());
			statement.setString(2, child.getChild_birthday());
			statement.setString(3, child.getChild_name());
			statement.setString(4, child.getChild_photo());
			statement.setString(5, child.getChild_sex());
			statement.setString(6, child.getChild_school_class_name());
			statement.setString(7, child.getChild_home_province());
			statement.setString(8, child.getChild_home_city());
			statement.setString(9, child.getChild_home_county());
			statement.setString(10, child.getChild_home_address());
			statement.setString(11, child.getChild_dream());
			statement.setString(12, child.getChild_hobby());
			statement.setString(13, child.getChild_trainplan());
			statement.setString(14, child.getChild_remarks());
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
	public Child selectChildByChildID(int user_id) {
		// TODO Auto-generated method stub
		connection = C3P0Utils.getConnection();
		sql = "select * from child where user_id=?";
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, user_id);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				int child_id1 = resultSet.getInt(1);
				int user_id1 = resultSet.getInt(2);
				String child_birthday = resultSet.getString(3);
				String child_name = resultSet.getString(4);
				String child_photo = resultSet.getString(5);
				String child_sex = resultSet.getString(6);
				String child_school_class_name = resultSet.getString(7);
				String child_home_province = resultSet.getString(8);
				String child_home_city = resultSet.getString(9);
				String child_home_county = resultSet.getString(10);
				String child_home_address = resultSet.getString(11);
				String child_dream = resultSet.getString(12);
				String child_hobby = resultSet.getString(13);
				String child_trainplan = resultSet.getString(14);
				String child_remarks = resultSet.getString(15);
				child = new Child(child_id1, user_id1, child_birthday,
						child_name, child_photo, child_sex,
						child_school_class_name, child_home_province,
						child_home_city, child_home_county, child_home_address,
						child_dream, child_hobby, child_trainplan,
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
				int child_id1 = resultSet.getInt(1);
				int user_id1 = resultSet.getInt(2);
				String child_birthday = resultSet.getString(3);
				String child_name = resultSet.getString(4);
				String child_photo = resultSet.getString(5);
				String child_sex = resultSet.getString(6);
				String child_school_class_name = resultSet.getString(7);
				String child_home_province = resultSet.getString(8);
				String child_home_city = resultSet.getString(9);
				String child_home_county = resultSet.getString(10);
				String child_home_address = resultSet.getString(11);
				String child_dream = resultSet.getString(12);
				String child_hobby = resultSet.getString(13);
				String child_trainplan = resultSet.getString(14);
				String child_remarks = resultSet.getString(15);
				child = new Child(child_id1, user_id1, child_birthday,
						child_name, child_photo, child_sex,
						child_school_class_name, child_home_province,
						child_home_city, child_home_county, child_home_address,
						child_dream, child_hobby, child_trainplan,
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
				int child_id1 = resultSet.getInt(1);
				int user_id = resultSet.getInt(2);
				String child_birthday = resultSet.getString(3);
				String child_name = resultSet.getString(4);
				String child_photo = resultSet.getString(5);
				String child_sex = resultSet.getString(6);
				String child_school_class_name = resultSet.getString(7);
				String child_home_province = resultSet.getString(8);
				String child_home_city = resultSet.getString(9);
				String child_home_county = resultSet.getString(10);
				String child_home_address = resultSet.getString(11);
				String child_dream = resultSet.getString(12);
				String child_hobby = resultSet.getString(13);
				String child_trainplan = resultSet.getString(14);
				String child_remarks = resultSet.getString(15);
				child = new Child(child_id1, user_id, child_birthday,
						child_name, child_photo, child_sex,
						child_school_class_name, child_home_province,
						child_home_city, child_home_county, child_home_address,
						child_dream, child_hobby, child_trainplan,
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

	@Override
	public boolean updateChildSex(int user_id, String child_sex) {
		connection = C3P0Utils.getConnection();
		sql = "UPDATE child SET child_sex=? where user_id = ?";
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, child_sex);
			statement.setInt(2, user_id);
			statement.executeUpdate();
			System.out.println("修改宝宝性别成功");
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("修改宝宝性别失败");
			return false;
		} finally {
			C3P0Utils.close(resultSet, statement, connection);
		}
	}

	@Override
	public boolean updateChildBirthday(int user_id, String child_birthday) {
		connection = C3P0Utils.getConnection();
		sql = "UPDATE child SET child_birthday=? where user_id = ?";
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, child_birthday);
			statement.setInt(2, user_id);
			statement.executeUpdate();
			System.out.println("修改宝宝生日成功");
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("修改宝宝生日失败");
			return false;
		} finally {
			C3P0Utils.close(resultSet, statement, connection);
		}
	}

	@Override
	public boolean updateChildSchoolClass(int user_id,
			String child_school_class_name) {
		connection = C3P0Utils.getConnection();
		sql = "UPDATE child SET child_school_class_name=? where user_id = ?";
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, child_school_class_name);
			statement.setInt(2, user_id);
			statement.executeUpdate();
			System.out.println("修改宝宝学校及班级成功");
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("修改宝宝学校及班级失败");
			return false;
		} finally {
			C3P0Utils.close(resultSet, statement, connection);
		}
	}

	@Override
	public boolean updateChildDream(int user_id, String child_dream) {
		connection = C3P0Utils.getConnection();
		sql = "UPDATE child SET child_dream=? where user_id = ?";
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, child_dream);
			statement.setInt(2, user_id);
			statement.executeUpdate();
			System.out.println("修改宝宝梦想成功");
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("修改宝宝梦想失败");
			return false;
		} finally {
			C3P0Utils.close(resultSet, statement, connection);
		}
	}

	@Override
	public boolean updateChildHobby(int user_id, String child_hobby) {
		connection = C3P0Utils.getConnection();
		sql = "UPDATE child SET child_hobby=? where user_id = ?";
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, child_hobby);
			statement.setInt(2, user_id);
			statement.executeUpdate();
			System.out.println("修改宝宝特长成功");
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("修改宝宝特长失败");
			return false;
		} finally {
			C3P0Utils.close(resultSet, statement, connection);
		}
	}

	@Override
	public boolean updateChildTrainplan(int child_id, String child_trainplan) {
		connection = C3P0Utils.getConnection();
		sql = "UPDATE child SET child_trainplan=? where child_id = ?";
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, child_trainplan);
			statement.setInt(2, child_id);
			statement.executeUpdate();
			System.out.println("修改宝宝培训计划成功");
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("修改宝宝培训计划失败");
			return false;
		} finally {
			C3P0Utils.close(resultSet, statement, connection);
		}
	}

	@Override
	public boolean updateChildAddress(int user_id, String child_address) {
		connection = C3P0Utils.getConnection();
		sql = "UPDATE child SET child_address=? where user_id = ?";
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, child_address);
			statement.setInt(2, user_id);
			statement.executeUpdate();
			System.out.println("修改宝宝地址成功");
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("修改宝宝地址失败");
			return false;
		} finally {
			C3P0Utils.close(resultSet, statement, connection);
		}
	}

	@Override
	public boolean updateChildProvinceCity(int user_id,
			String child_home_province, String child_home_city,
			String child_home_county) {
		connection = C3P0Utils.getConnection();
		sql = "UPDATE child SET child_home_province=?,child_home_city=?,child_home_county=? where user_id = ?";
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, child_home_province);
			statement.setString(2, child_home_city);
			statement.setString(3, child_home_county);
			statement.setInt(4, user_id);
			statement.executeUpdate();
			System.out.println("修改宝宝省市区成功");
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("修改宝宝省市区失败");
			return false;
		} finally {
			C3P0Utils.close(resultSet, statement, connection);
		}
	}

	@Override
	public boolean updateChildPhoto(int user_id, String child_photo) {
		connection = C3P0Utils.getConnection();
		sql = "UPDATE child SET child_photo=? where user_id = ?";
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, child_photo);
			statement.setInt(2, user_id);
			statement.executeUpdate();
			System.out.println("修改宝宝头像成功");
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("修改宝宝头像失败");
			return false;
		} finally {
			C3P0Utils.close(resultSet, statement, connection);
		}
	}
}
