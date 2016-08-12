package com.yutai.exuetang.model.dao.audio;

import com.yutai.exuetang.model.beans.audio.Typephoto;

public interface ITypephotoDAO {
    //二级图片
	// 增加二级类型图片
	public abstract boolean addTypephoto(Typephoto typephoto);
    //根据二级类型的名称查找该类型的图片
	public abstract String selectTypephoto(String music_type2);
}
