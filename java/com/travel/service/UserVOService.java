package com.travel.service;

import java.util.HashMap;
import java.util.List;

import com.travel.entity.UserVO;

public interface UserVOService {
	//查询用户
	public UserVO getUser(UserVO userVO);
	public List<UserVO> getUserListByPage(HashMap<String,Object> map);
		
	//验证用户是否已存在
	public int getUserValidate(HashMap<String,String> map);
		
	//增加用户
	public boolean insertUserVO(UserVO userVO);
	
	//修改用户
	public boolean updateUserVO(UserVO userVO);

	//删除用户
	public boolean deleteUserVO(String id);
	
}
