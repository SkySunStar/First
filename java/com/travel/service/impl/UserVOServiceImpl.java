package com.travel.service.impl;

import java.util.HashMap;
import java.util.List;

import com.travel.entity.UserVO;
import com.travel.mapper.UserVOMapper;
import com.travel.service.UserVOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserVOServiceImpl implements UserVOService{

    @Autowired
	private UserVOMapper userVOMapper;

    @Override
	public UserVO getUser(UserVO userVO) {
		return userVOMapper.getUser(userVO);
	}

	@Override
	public int getUserValidate(HashMap<String, String> map) {
		return userVOMapper.getUserValidate(map);
	}

	@Override
	public List<UserVO> getUserListByPage(HashMap<String,Object> map) {
		return userVOMapper.getUserListByPage(map);
	}

	@Override
	public boolean insertUserVO(UserVO userVO) {
		userVOMapper.insertUser(userVO);
		userVO.setUserId(userVO.getId());
		return userVOMapper.insertUserInfo(userVO);
	}

	@Override
	public boolean updateUserVO(UserVO userVO) {
		userVOMapper.updateUser(userVO);
		userVO.setUserId(userVO.getId());
		return userVOMapper.updateUserInfo(userVO);
	}

	@Override
	public boolean deleteUserVO(String id) {
		return userVOMapper.deleteUser(id);
	}



}
