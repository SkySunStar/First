package com.travel.service;

import java.util.HashMap;
import java.util.List;

import com.travel.entity.GoodsType;

public interface GoodsTypeService {
	//查询商品分类
	public List<GoodsType> getGoodsTypeListByPage(HashMap<String,Object> map);
	
	//增加商品分类
	public boolean insertGoodsType(GoodsType goodsType);

	//修改商品分类
	public boolean updateGoodsType(GoodsType goodsType);
	
	//删除商品分类
	public boolean deleteGoodsType(String id);
}
