package com.yutai.exuetang.model.dao.exuetang;

import java.util.List;

import com.yutai.exuetang.model.beans.exuetang.GsonMeInfo;
import com.yutai.exuetang.model.beans.exuetang.User;

public interface IUserDAO {
	// 注册
	public abstract boolean addUser(User user);

	// 根据ID查找用户
	public abstract User selectUserByID(int user_id);

	// 根据手机号查找用户
	public abstract User selectUserByPhone(String user_phone);

	// 查询所有的用户
	public abstract List<User> selectAllUser();

	// 修改用户
	public abstract boolean updateUserByID(User user, int user_id);

	// 查找用户密码是否一致
	public abstract boolean selectUserOKPasswordByID(String user_password_old,
			int user_id);

	// 修改用户密码
	public abstract boolean updateUserPasswordByID(String user_password_new,
			int user_id);
    //修改用户昵称
	public abstract boolean updateUserNickname(int user_id,String new_nickname);
    //修改用户性别
	public abstract boolean updatUserSex(int user_id,String user_sex);
	
//	连接查询MeFragment中的个人信息
	public abstract GsonMeInfo getUserSomeInfo(int user_id);
}
