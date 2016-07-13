package com.yutai.audio.model.dao.user;

import java.util.List;

import com.yutai.audio.model.beans.user.Coins;

public interface ICoinsDAO {
	//添加积分
	public abstract boolean addCoins(Coins coins);
	//查找积分
	public abstract Coins selectCoinsByCoinsID(int coins_id);
	//根据用户ID查找积分数量
	public abstract int selectCoinsNumByUserID(int user_id);
	//根据用户ID和积分更新积分
	public abstract boolean updateCoinsByUserID(int user_id,int coins_num);
	//查找所有积分
	public abstract List<Coins> selectAllCoins();
}
