package com.travel.controller;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.travel.entity.UserVO;
import com.travel.service.UserVOService;
import com.travel.util.Page;
import com.travel.util.SecurityUtils;
import com.travel.validate.UserVOValidate;

//用户控制层
@Controller
public class UserVOController {
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private UserVOService userVOService;
	
	
	//登录
	@PostMapping("login")
	public void loginSubmit(UserVO userVO,PrintWriter out,HttpServletResponse response) {
		if("true".equals(request.getParameter("checkTxt"))) {
			Cookie userCookie=new Cookie("username",userVO.getName());
			userCookie.setMaxAge(24*60*60*7);
			response.addCookie(userCookie);
		}else {
			for (Cookie cookie : request.getCookies()) {
				if(cookie.getName().equals("username")) {
					cookie.setMaxAge(0);
					break;
				}
			}
		}
		userVO.setPassword(SecurityUtils.md5Hex(userVO.getPassword()));
		userVO=userVOService.getUser(userVO);//获取用户信息
		if(userVO!=null) {//判断用户是否登录成功
			request.getSession().setAttribute("userVO", userVO);
			if(userVO.getRights()==2) {
				out.print("manage");
			}else {
				out.print(true);
			}
		}else {
			out.print(false);
		}
	}
	//注销
	@RequestMapping("logout")
	public String logout() {
		request.getSession().invalidate();
		return "redirect:/home.do";
	}
	//验证信息是否已存在
	@PostMapping("validate")
	public void validate(HashMap<String,String> map,PrintWriter out) {
		String table=request.getParameter("table");
		if(table.contains(";")) {
			return;
		}
		map.put("table", table);//设置表名
		map.put("param", request.getParameter("param"));//设置字段名
		map.put("value", request.getParameter("value"));//设置字段值
		if(userVOService.getUserValidate(map)==0) {//动态验证用户注册的信息是否已存在于数据库
			out.print(true);
		}else {
			out.print(false);
		}
	}
	
	//注册(增加用户)
	@PostMapping("userAdd")
	public void register(UserVO userVO,Errors e,UserVOValidate uv,PrintWriter out) {
		uv.validate(userVO, e);
		if(e.hasErrors()) {//验证传入的用户信息是否有错误
			System.out.println(e.getFieldError());
			return;
		}
		userVO.setPassword(SecurityUtils.md5Hex(userVO.getPassword()));//给密码加密
		out.print(userVOService.insertUserVO(userVO)); //增加用户记录
	}
	
	//获取用户列表
	@PostMapping("userList")
	public void getUserList(Page page,HashMap<String,Object> map,PrintWriter out) {
		UserVO userVO=(UserVO)request.getSession().getAttribute("userVO");
		map.put("startPage", page.getStartPage());
		map.put("pageSize", page.getPageSize());
		map.put("rights", userVO.getRights());
		map.put("name", userVO.getName());
		map.put("keyword", request.getParameter("keyword"));
		List<UserVO> userList=userVOService.getUserListByPage(map);//查询用户信息分页列表
		request.getSession().setAttribute("travelList", userList);
	}
	
	//修改用户
	@PostMapping("userMod")
	public void modUser(UserVO userVO,PrintWriter out) {
		out.print(userVOService.updateUserVO(userVO));
	}
	
	//删除用户
	@PostMapping("userDel")
	public void delUser(@RequestParam("id")String id,PrintWriter out) {
		out.print(userVOService.deleteUserVO(id));
	}

}
