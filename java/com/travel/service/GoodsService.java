package com.travel.service;

import java.util.HashMap;
import java.util.List;

import com.travel.entity.Goods;

public interface GoodsService {
	//查询商品
	public List<Goods> getGoodsListByPage(HashMap<String,Object> map);
		
	//增加商品
	public boolean insertGoods(Goods goods);
	
	//修改商品
	public boolean updateGoods(Goods goods);

	//删除商品
	public boolean deleteGoods(String id);
	
}
