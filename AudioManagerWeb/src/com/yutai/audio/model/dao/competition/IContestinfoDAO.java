package com.yutai.audio.model.dao.competition;

import java.util.List;

import com.yutai.audio.model.beans.competition.Contestinfo;

public interface IContestinfoDAO {
	//添加比赛
	public abstract boolean addContestinfo(Contestinfo contestinfo);
	//根据ID查找比赛
	public abstract Contestinfo selectContestinfoByID(int contestinfo_id);
	//查找所有的比赛
	public abstract List<Contestinfo> selectAllContestinfo();
}
