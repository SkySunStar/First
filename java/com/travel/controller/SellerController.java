package com.travel.controller;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.travel.entity.Seller;
import com.travel.service.SellerService;
import com.travel.util.Page;

//商家控制层
@Controller
public class SellerController {
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private SellerService sellerService;
	
	//获取商家列表
	@PostMapping("sellerList")
	public void getSellerList(Page page,HashMap<String,Object> map,PrintWriter out) {
		map.put("startPage", page.getStartPage());
		map.put("pageSize", page.getPageSize());
		map.put("keyword",request.getParameter("keyword"));
		List<Seller> sellerList=sellerService.getSellerListByPage(map);
		request.getSession().setAttribute("sellerList", sellerList);
		out.print(sellerList);
	}
	
	//增加商家
	@PostMapping("sellerAdd")
	public void addSeller(Seller seller,PrintWriter out){
		out.print(sellerService.insertSeller(seller));
	}
		
	//修改商家
	@PostMapping("sellerMod")
	public void modSeller(Seller seller,PrintWriter out) {
		out.print(sellerService.updateSeller(seller));
	}
	
	//删除商家
	@PostMapping("sellerDel")
	public void delSeller(@RequestParam("id")String id,PrintWriter out) {
		out.print(sellerService.deleteSeller(id));
	}
}
