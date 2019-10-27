package com.travel.mapper;

import java.util.HashMap;
import java.util.List;

import com.travel.entity.Seller;
import org.springframework.stereotype.Repository;

public interface SellerMapper {
	//查询商家
	List<Seller> getSellerListByPage(HashMap<String,Object> map);
	
	//增加商家
	boolean insertSeller(Seller seller);

	//修改商家
	boolean updateSeller(Seller seller);
	
	//删除商家
	boolean deleteSeller(String id);
}
