package com.travel.service.impl;

import java.util.HashMap;
import java.util.List;

import com.travel.entity.Goods;
import com.travel.mapper.GoodsMapper;
import com.travel.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsServiceImpl implements GoodsService{

	@Autowired
	private GoodsMapper goodsMapper;

	@Override
	public List<Goods> getGoodsListByPage(HashMap<String,Object> map) {
		return goodsMapper.getGoodsListByPage(map);
	}

	@Override
	public boolean insertGoods(Goods goods) {
		return goodsMapper.insertGoods(goods);
	}

	@Override
	public boolean updateGoods(Goods goods) {
		return goodsMapper.updateGoods(goods);
	}

	@Override
	public boolean deleteGoods(String id) {
		return goodsMapper.deleteGoods(id);
	}

}
