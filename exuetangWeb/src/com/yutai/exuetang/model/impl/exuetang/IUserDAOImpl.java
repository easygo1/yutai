package com.yutai.exuetang.model.impl.exuetang;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yutai.exuetang.model.beans.exuetang.GsonMeInfo;
import com.yutai.exuetang.model.beans.exuetang.User;
import com.yutai.exuetang.model.dao.exuetang.IUserDAO;
import com.yutai.exuetang.utils.C3P0Utils;

public class IUserDAOImpl implements IUserDAO {
	private Connection connection = null;
	private PreparedStatement statement = null;
	private ResultSet resultSet = null;
	private String sql = null;
	private User user = null;
	private List<User> userlist = null;
	private GsonMeInfo gsonMeInfo=null;

	@Override
	public boolean addUser(User user) {
		boolean result = false;
		connection = C3P0Utils.getConnection();
		// 向表中加入该用户
		sql = "insert into user(user_newphone,user_oldphone,user_password,user_nickname,user_mood,user_qq_token,user_wechat_token,user_realname,user_sex,user_type,user_remarks) values(?,?,?,?,?,?,?,?,?,?,?)";
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, user.getUser_newphone());
			statement.setString(2, user.getUser_oldphone());
			statement.setString(3, user.getUser_password());
			statement.setString(4, user.getUser_nickname());
			statement.setString(5, user.getUser_mood());
			statement.setString(6, user.getUser_qq_token());
			statement.setString(7, user.getUser_wechat_token());
			statement.setString(8, user.getUser_realname());
			statement.setString(9, user.getUser_sex());
			statement.setInt(10, user.getUser_type());
			statement.setString(11, user.getUser_remarks());
			statement.executeUpdate();
			System.out.println("插入用户成功");
			result = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("插入用户失败");
			result = false;
			e.printStackTrace();
		} finally {
			C3P0Utils.close(resultSet, statement, connection);
		}
		return result;
	}

	@Override
	public User selectUserByID(int user_id) {
		// TODO Auto-generated method stub
		connection = C3P0Utils.getConnection();
		sql = "select * from user where user_id=?";
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, user_id);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				int user_id1 = resultSet.getInt(1);
				String user_newphone = resultSet.getString(2);
				String user_oldphone = resultSet.getString(3);
				String user_password = resultSet.getString(4);
				String user_nickname = resultSet.getString(5);
				String user_mood = resultSet.getString(6);
				String user_qq_token = resultSet.getString(7);
				String user_wechat_token = resultSet.getString(8);
				String user_realname = resultSet.getString(9);
				String user_sex = resultSet.getString(10);
				int user_type = resultSet.getInt(11);
				String user_remarks = resultSet.getString(12);
				user = new User(user_id1, user_newphone, user_oldphone, user_password, user_nickname, user_mood, user_qq_token, user_wechat_token, user_realname, user_sex, user_type, user_remarks);
				System.out.println("查找成功");
				return user;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("查找失败");
			e.printStackTrace();
		} finally {
			C3P0Utils.close(resultSet, statement, connection);
		}
		return user;
	}

	@Override
	public User selectUserByPhone(String user_phone) {
		// TODO Auto-generated method stub
		connection = C3P0Utils.getConnection();
		sql = "select * from user where user_newphone=?";
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, user_phone);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				int user_id1 = resultSet.getInt(1);
				String user_newphone = resultSet.getString(2);
				String user_oldphone = resultSet.getString(3);
				String user_password = resultSet.getString(4);
				String user_nickname = resultSet.getString(5);
				String user_mood = resultSet.getString(6);
				String user_qq_token = resultSet.getString(7);
				String user_wechat_token = resultSet.getString(8);
				String user_realname = resultSet.getString(9);
				String user_sex = resultSet.getString(10);
				int user_type = resultSet.getInt(11);
				String user_remarks = resultSet.getString(12);
				user = new User(user_id1, user_newphone, user_oldphone, user_password, user_nickname, user_mood, user_qq_token, user_wechat_token, user_realname, user_sex, user_type, user_remarks);
				
				System.out.println("查找成功");
				return user;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("查找失败");
			e.printStackTrace();
		} finally {
			C3P0Utils.close(resultSet, statement, connection);
		}
		return user;
	}

	@Override
	public List<User> selectAllUser() {
		userlist = new ArrayList<>();
		connection = C3P0Utils.getConnection();
		sql = "select * from user";
		try {
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				int user_id1 = resultSet.getInt(1);
				String user_newphone = resultSet.getString(2);
				String user_oldphone = resultSet.getString(3);
				String user_password = resultSet.getString(4);
				String user_nickname = resultSet.getString(5);
				String user_mood = resultSet.getString(6);
				String user_qq_token = resultSet.getString(7);
				String user_wechat_token = resultSet.getString(8);
				String user_realname = resultSet.getString(9);
				String user_sex = resultSet.getString(10);
				int user_type = resultSet.getInt(11);
				String user_remarks = resultSet.getString(12);
				user = new User(user_id1, user_newphone, user_oldphone, user_password, user_nickname, user_mood, user_qq_token, user_wechat_token, user_realname, user_sex, user_type, user_remarks);
				
				userlist.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			C3P0Utils.close(resultSet, statement, connection);
		}
		return userlist;
	}

	@Override
	public boolean updateUserByID(User user, int user_id) {
		connection = C3P0Utils.getConnection();
		sql = "UPDATE user SET user_newphone=?,user_oldphone=?,user_password=?,user_nickname=?,user_mood,user_qq_token=?,user_wechat_token=?,user_realname=?,user_sex=?,user_type=?,user_remarks=? where user_id = ?";
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, user.getUser_newphone());
			statement.setString(2, user.getUser_oldphone());
			statement.setString(3, user.getUser_password());// 用户密码
			statement.setString(4, user.getUser_nickname());// 用户昵称
			statement.setString(5, user.getUser_mood());
			statement.setString(6, user.getUser_qq_token());
			statement.setString(7, user.getUser_wechat_token());
			statement.setString(8, user.getUser_realname());
			statement.setString(9, user.getUser_sex());// 个性签名
			statement.setInt(10, user.getUser_type());
			statement.setString(11, user.getUser_remarks());
			statement.setInt(12, user_id);
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
	public boolean updateUserPasswordByID(String user_password_new, int user_id) {
		connection = C3P0Utils.getConnection();
		sql = "UPDATE user SET user_password=? where user_id = ?";
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, user_password_new);
			statement.setInt(2, user_id);
			statement.executeUpdate();
			System.out.println("修改密码成功");
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("修改密码失败");
			return false;
		} finally {
			C3P0Utils.close(resultSet, statement, connection);
		}
	}

	@Override
	public boolean selectUserOKPasswordByID(String user_password_old,
			int user_id) {
		connection = C3P0Utils.getConnection();
		sql = "select user_password from user where user_id=?";
		try {
			statement = connection.prepareStatement(sql);
			String user_password = null;
			statement.setInt(1, user_id);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				user_password = resultSet.getString(1);
			}
			if (user_password_old.equals(user_password)) {
				System.out.println("密碼一致");
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("密碼不一致");
			e.printStackTrace();
			return false;
		} finally {
			C3P0Utils.close(resultSet, statement, connection);
		}
	}

	@Override
	public boolean updateUserNickname(int user_id, String new_nickname) {
		connection = C3P0Utils.getConnection();
		sql = "UPDATE user SET user_nickname=? where user_id = ?";
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, new_nickname);
			statement.setInt(2, user_id);
			statement.executeUpdate();
			System.out.println("修改昵称成功");
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("修改昵称失败");
			return false;
		} finally {
			C3P0Utils.close(resultSet, statement, connection);
		}
	}

	@Override
	public boolean updatUserSex(int user_id, String user_sex) {
		connection = C3P0Utils.getConnection();
		sql = "UPDATE user SET user_sex=? where user_id = ?";
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, user_sex);
			statement.setInt(2, user_id);
			statement.executeUpdate();
			System.out.println("修改用户性别成功");
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("修改用户性别失败");
			return false;
		} finally {
			C3P0Utils.close(resultSet, statement, connection);
		}
	}

	@Override
	public User login(String user_newphone, String user_password) {
		// TODO Auto-generated method stub
		connection = C3P0Utils.getConnection();
		sql = "select * from user where user_newphone=? and user_password=?";
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, user_newphone);
			statement.setString(2, user_password);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				int user_id1 = resultSet.getInt(1);
				String user_newphone1 = resultSet.getString(2);
				String user_oldphone = resultSet.getString(3);
				String user_password1 = resultSet.getString(4);
				String user_nickname = resultSet.getString(5);
				String user_mood = resultSet.getString(6);
				String user_qq_token = resultSet.getString(7);
				String user_wechat_token = resultSet.getString(8);
				String user_realname = resultSet.getString(9);
				String user_sex = resultSet.getString(10);
				int user_type = resultSet.getInt(11);
				String user_remarks = resultSet.getString(12);
				user = new User(user_id1, user_newphone1, user_oldphone, user_password1, user_nickname, user_mood, user_qq_token, user_wechat_token, user_realname, user_sex, user_type, user_remarks);
				System.out.println("查找成功");
				return user;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("查找失败");
			e.printStackTrace();
		} finally {
			C3P0Utils.close(resultSet, statement, connection);
		}
		return user;
	}
	@Override
	public GsonMeInfo getUserSomeInfo(int user_id) {
		connection = C3P0Utils.getConnection();
		sql = "select `user`.user_id,`user`.user_nickname,`user`.user_newphone,child.child_photo,coins.coins_num FROM `user`,child,coins WHERE `user`.user_id=? and coins.user_id=? and child.user_id=?;";
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, user_id);
			statement.setInt(2, user_id);
			statement.setInt(3, user_id);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				int user_id1 = resultSet.getInt(1);
				String user_nickname = resultSet.getString(2);
				String user_newphone = resultSet.getString(3);
				String child_photo = resultSet.getString(4);
				double coins_num = resultSet.getDouble(5);
				gsonMeInfo=new GsonMeInfo(user_id1, user_nickname, child_photo, user_newphone, coins_num);
				System.out.println("查找成功");
				return gsonMeInfo;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("查找失败");
			e.printStackTrace();
		} finally {
			C3P0Utils.close(resultSet, statement, connection);
		}
		return gsonMeInfo;

	}
}
