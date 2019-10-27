package com.travel.mapper;

import java.util.HashMap;
import java.util.List;

import com.travel.entity.GoodsType;
import org.springframework.stereotype.Repository;

public interface GoodsTypeMapper {
	//查询商品分类
	List<GoodsType> getGoodsTypeListByPage(HashMap<String,Object> map);
	
	//增加商品分类
	boolean insertGoodsType(GoodsType goodsType);

	//修改商品分类
	boolean updateGoodsType(GoodsType goodsType);
	
	//删除商品分类
	boolean deleteGoodsType(String id);
}
