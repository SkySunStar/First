package com.travel.controller;

import com.travel.entity.UserVO;
import com.travel.mapper.CommonMapper;
import com.travel.service.GoodsService;
import com.travel.service.ScenicService;
import com.travel.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
public class CommonController {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private ScenicService scenicService;
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private CommonMapper commonMapper;

    // 首页
    @RequestMapping("/")
    public void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/index.jsp").forward( request, response);
    }

    //跳转至前端主界面
    @RequestMapping("home")
    public ModelAndView home(ModelAndView mav, HashMap<String, Object> map, Page page) {
        mav.setViewName("home");
        map.put("startPage", page.getStartPage());
        map.put("pageSize", page.getPageSize());
        mav.addObject("scenicList", scenicService.getScenicListByPage(map));
        map.put("typeId", "1");
        mav.addObject("foodList", goodsService.getGoodsListByPage(map));
        map.put("typeId", "2");
        mav.addObject("specialtyList", goodsService.getGoodsListByPage(map));
        map.put("typeId", "3");
        mav.addObject("roomList", goodsService.getGoodsListByPage(map));
        return mav;
    }

    //详情页
    @RequestMapping("front")
    public String front() {
        return "front";
    }

    //跳转至管理员界面
    @RequestMapping("manage")
    public String manage() {
        return "manage";
    }

    //计算总量
    @RequestMapping("count")
    public void count(HashMap<String, Object> map, PrintWriter out) throws ClassNotFoundException, SecurityException, InstantiationException, IllegalAccessException {
        String table = request.getParameter("table");
        if (table.contains(";")) {
            return;
        }
        map.put("table", table);
        map.put("typeId", request.getParameter("typeId"));
        if (table.equals("user")) {
            UserVO userVO = (UserVO) request.getSession().getAttribute("userVO");
            map.put("name", userVO.getName());
            map.put("rights", userVO.getRights());
            table = "userVO";
        } else if (table.equals("goods_type")) {
            table = "goodsType";
        }
        String keyword = request.getParameter("keyword");//获取模糊查询关键字
        if (keyword != null) {
            String className = "com.travel.entity." + (char) (table.charAt(0) - 32) + table.substring(1);
            Field[] fileds = Class.forName(className).newInstance().getClass().getDeclaredFields();
            List<String> fieldList = new ArrayList<>();
            for (int i = fileds.length - 1; i >= 0; i--) {
                if (fileds[i].getType() == String.class && !fileds[i].getName().equals("password") && !fileds[i].getName().equals("image")) {
                    fieldList.add(fileds[i].getName());
                }
            }
            map.put("keyword", keyword);
            map.put("fieldList", fieldList);
        }
        int count = commonMapper.getCount(map);//获取表的记录总数
        out.print(count);
    }
}
