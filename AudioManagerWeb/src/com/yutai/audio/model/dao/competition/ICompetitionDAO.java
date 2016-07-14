package com.yutai.audio.model.dao.competition;

import java.util.List;

import com.yutai.audio.model.beans.competition.Competition;

public interface ICompetitionDAO {
    //添加报名
	public abstract boolean addCompetition(Competition competition);
	//根据ID查找报名
	public abstract Competition selectCompetitionByID(int competition_id);
	//查找所有的报名
	public abstract List<Competition> selectAllCompetition();
}
