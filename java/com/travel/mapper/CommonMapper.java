package com.travel.mapper;

import org.springframework.stereotype.Repository;

import java.util.HashMap;

public interface CommonMapper {

	//获取记录数量
	int getCount(HashMap<String,Object> map);
}
