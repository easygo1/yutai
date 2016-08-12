package com.yutai.exuetang.model.dao.exuetang;

import java.util.List;

import com.yutai.exuetang.model.beans.exuetang.Child;

public interface IChildDAO {
	// 添加宝宝
	public abstract boolean addChild(Child child);

	// 查找宝宝（通过宝宝ID查询）
	public abstract Child selectChildByChildID(int child_id);

	// 查找宝宝（通过用户ID查询）
	public abstract Child selectChildByUserID(int user_id);

	// 查找所有宝宝
	public abstract List<Child> selectAllChild();

	// 修改宝宝性别
	public abstract boolean updateChildSex(int child_id, String child_sex);

	// 修改宝宝生日
	public abstract boolean updateChildBirthday(int child_id,
			String child_birthday);

	// 修改宝宝学校及班级
	public abstract boolean updateChildSchoolClass(int child_id,
			String child_school_class_name);

	// 修改宝宝梦想
	public abstract boolean updateChildDream(int child_id, String child_dream);

	// 修改宝宝特长
	public abstract boolean updateChildHobby(int child_id, String child_hobby);

	// 修改宝宝培训计划
	public abstract boolean updateChildTrainplan(int child_id,
			String child_trainplan);
	// 修改省市区
	public abstract boolean updateChildProvinceCity(int child_id,
				String child_home_province,String child_home_city,String child_home_county);
	// 修改通讯地址
	public abstract boolean updateChildAddress(int child_id,
			String child_address);
}
