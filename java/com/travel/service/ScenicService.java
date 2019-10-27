package com.travel.service;

import java.util.HashMap;
import java.util.List;

import com.travel.entity.Scenic;

public interface ScenicService {
	//查询景点
	public List<Scenic> getScenicListByPage(HashMap<String,Object> map);
	
	//增加景点
	public boolean insertScenic(Scenic scenic);

	//修改景点
	public boolean updateScenic(Scenic scenic);
	
	//删除景点
	public boolean deleteScenic(String id);
}
