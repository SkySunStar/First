package com.travel.mapper;

import java.util.HashMap;
import java.util.List;

import com.travel.entity.UserVO;
import org.springframework.stereotype.Repository;

public interface UserVOMapper {
	//查询用户
	UserVO getUser(UserVO userVO);
	UserVO getUserInfo(String userId);
	List<UserVO> getUserListByPage(HashMap<String,Object> map);
	
	//验证用户是否已存在
	int getUserValidate(HashMap<String,String> map);
	
	//增加用户
	boolean insertUser(UserVO userVO);
	boolean insertUserInfo(UserVO userVO);
	
	//修改用户
	boolean updateUser(UserVO userVO);
	boolean updateUserInfo(UserVO userVO);

	//删除用户
	boolean deleteUser(String id);
	
}