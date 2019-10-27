package com.travel.service.impl;

import java.util.HashMap;
import java.util.List;

import com.travel.entity.GoodsType;
import com.travel.mapper.GoodsTypeMapper;
import com.travel.service.GoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsTypeServiceImpl implements GoodsTypeService{

	@Autowired
	private GoodsTypeMapper goodsTypeMapper;

	@Override
	public List<GoodsType> getGoodsTypeListByPage(HashMap<String,Object> map) {
		return goodsTypeMapper.getGoodsTypeListByPage(map);
	}

	@Override
	public boolean insertGoodsType(GoodsType goodsType) {
		return goodsTypeMapper.insertGoodsType(goodsType);
	}

	@Override
	public boolean updateGoodsType(GoodsType goodsType) {
		return goodsTypeMapper.updateGoodsType(goodsType);
	}

	@Override
	public boolean deleteGoodsType(String id) {
		return goodsTypeMapper.deleteGoodsType(id);
	}

}
