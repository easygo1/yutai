package com.yutai.audio.model.dao.user;

import java.util.List;

import com.yutai.audio.model.beans.user.Child;

public interface IChildDAO {
	//添加宝宝
	public abstract boolean addChild(Child child);
	// 查找宝宝（通过宝宝ID查询）
	public abstract Child selectChildByChildID(int child_id);
	// 查找宝宝（通过用户ID查询）
	public abstract Child selectChildByUserID(int user_id);
	// 查找所有宝宝
	public abstract List<Child> selectAllChild();
}
