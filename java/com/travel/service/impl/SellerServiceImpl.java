package com.travel.service.impl;

import java.util.HashMap;
import java.util.List;

import com.travel.entity.Seller;
import com.travel.mapper.SellerMapper;
import com.travel.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerServiceImpl implements SellerService{

	@Autowired
	private SellerMapper sellerMapper;

	@Override
	public List<Seller> getSellerListByPage(HashMap<String,Object> map) {
		return sellerMapper.getSellerListByPage(map);
	}

	@Override
	public boolean insertSeller(Seller seller) {
		return sellerMapper.insertSeller(seller);
	}

	@Override
	public boolean updateSeller(Seller seller) {
		return sellerMapper.updateSeller(seller);
	}

	@Override
	public boolean deleteSeller(String id) {
		return sellerMapper.deleteSeller(id);
	}

}
