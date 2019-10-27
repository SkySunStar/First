package com.travel.service.impl;

import java.util.HashMap;
import java.util.List;

import com.travel.entity.Scenic;
import com.travel.mapper.ScenicMapper;
import com.travel.service.ScenicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScenicServiceImpl implements ScenicService{

	@Autowired
	private ScenicMapper scenicMapper;

	@Override
	public List<Scenic> getScenicListByPage(HashMap<String,Object> map) {
		return scenicMapper.getScenicListByPage(map);
	}

	@Override
	public boolean insertScenic(Scenic scenic) {
		return scenicMapper.insertScenic(scenic);
	}

	@Override
	public boolean updateScenic(Scenic scenic) {
		return scenicMapper.updateScenic(scenic);
	}

	@Override
	public boolean deleteScenic(String id) {
		return scenicMapper.deleteScenic(id);
	}

}
