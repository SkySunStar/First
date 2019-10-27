package com.travel.mapper;
import java.util.HashMap;
import java.util.List;

import com.travel.entity.Scenic;
import org.springframework.stereotype.Repository;

public interface ScenicMapper {
	//查询景点
	List<Scenic> getScenicListByPage(HashMap<String,Object> map);
	
	//增加景点
	boolean insertScenic(Scenic scenic);

	//修改景点
	boolean updateScenic(Scenic scenic);
	
	//删除景点
	boolean deleteScenic(String id);
	
}