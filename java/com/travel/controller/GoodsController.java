package com.travel.controller;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.travel.entity.Goods;
import com.travel.service.GoodsService;
import com.travel.util.Page;
import com.travel.util.UpLoad;

//商品控制层
@Controller
public class GoodsController {
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private GoodsService goodsService;
	
	//获取商品列表
	@PostMapping("goodsList")
	public void getGoodsList(Page page,HashMap<String,Object> map,PrintWriter out) {
		map.put("startPage", page.getStartPage());
		map.put("pageSize", page.getPageSize());
		map.put("typeId", request.getParameter("typeId"));
		map.put("keyword", request.getParameter("keyword"));
		List<Goods> goodsList=goodsService.getGoodsListByPage(map);
		request.getSession().setAttribute("goodsList", goodsList);
	}
	//增加商品
	@PostMapping("goodsAdd")
	public void addGoods(Goods goods,@RequestParam("file")MultipartFile file,PrintWriter out) {
		goods.setImage(UpLoad.upLoad(file));
		out.print(goodsService.insertGoods(goods));
	}
		
	//修改商品
	@PostMapping("goodsMod")
	public void modGoods(Goods goods,@RequestParam("file")MultipartFile file,PrintWriter out) {
		goods.setImage(UpLoad.upLoad(file));
		out.print(goodsService.updateGoods(goods));
	}
	
	//删除商品
	@PostMapping("goodsDel")
	public void delGoods(@RequestParam("id")String id,PrintWriter out) {
		out.print(goodsService.deleteGoods(id));
	}
}
