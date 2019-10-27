package com.travel.controller;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.travel.entity.GoodsType;
import com.travel.service.GoodsTypeService;
import com.travel.util.Page;
import org.springframework.web.bind.annotation.RestController;

//商品分类控制层
@RestController
public class GoodsTypeController {
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private GoodsTypeService goodsTypeService;
	
	//获取商品分类列表
	@PostMapping("goods_typeList")
	public void getGoodsTypeList(Page page,HashMap<String,Object> map,PrintWriter out) {
		map.put("startPage", page.getStartPage());
		map.put("pageSize", page.getPageSize());
		map.put("typeId",request.getParameter("typeId"));
		map.put("keyword",request.getParameter("keyword"));
		List<GoodsType> goodsTypeList=goodsTypeService.getGoodsTypeListByPage(map);
		request.getSession().setAttribute("goodsTypeList", goodsTypeList);
		out.print(goodsTypeList);
	}
	
	//增加商品分类
	@PostMapping("goods_typeAdd")
	public void addGoodsType(GoodsType goodsType,PrintWriter out){
		out.print(goodsTypeService.insertGoodsType(goodsType));
	}
		
	//修改商品分类
	@PostMapping("goods_typeMod")
	public void modGoodsType(GoodsType goodsType,PrintWriter out) {
		out.print(goodsTypeService.updateGoodsType(goodsType));
	}
	
	//删除商品分类
	@PostMapping("goods_typeDel")
	public void delGoodsType(@RequestParam("id")String id,PrintWriter out) {
		out.print(goodsTypeService.deleteGoodsType(id));
	}
}
