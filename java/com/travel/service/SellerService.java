package com.travel.service;

import java.util.HashMap;
import java.util.List;

import com.travel.entity.Seller;

public interface SellerService {
	//查询商家
	public List<Seller> getSellerListByPage(HashMap<String,Object> map);
	
	//增加商家
	public boolean insertSeller(Seller scenic);

	//修改商家
	public boolean updateSeller(Seller scenic);
	
	//删除商家
	public boolean deleteSeller(String id);
}
