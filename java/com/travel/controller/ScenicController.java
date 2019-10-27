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

import com.travel.entity.Scenic;
import com.travel.service.ScenicService;
import com.travel.util.Page;
import com.travel.util.UpLoad;
//景点控制层
@Controller
public class ScenicController {
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private ScenicService scenicService;
	
	//获取景点列表
	@PostMapping("scenicList")
	public void getScenicList(Page page,HashMap<String,Object> map,PrintWriter out) {
		map.put("startPage", page.getStartPage());
		map.put("pageSize", page.getPageSize());
		map.put("keyword",request.getParameter("keyword"));
		List<Scenic> scenicList=scenicService.getScenicListByPage(map);
		request.getSession().setAttribute("travelList", scenicList);
	}
	
	//增加景点
	@PostMapping("scenicAdd")
	public void addScenic(Scenic scenic,@RequestParam("file")MultipartFile file, PrintWriter out){
		scenic.setImage(UpLoad.upLoad(file));
		out.print(scenicService.insertScenic(scenic));
	}
		
	//修改景点
	@PostMapping("scenicMod")
	public void modScenic(Scenic scenic,@RequestParam("file")MultipartFile file,PrintWriter out) {
		scenic.setImage(UpLoad.upLoad(file));
		out.print(scenicService.updateScenic(scenic));
	}
	
	//删除景点
	@PostMapping("scenicDel")
	public void delScenic(@RequestParam("id")String id,PrintWriter out) {
		out.print(scenicService.deleteScenic(id));
	}
}
