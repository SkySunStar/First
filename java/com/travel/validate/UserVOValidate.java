
package com.travel.validate;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.travel.entity.UserVO;

public class UserVOValidate implements Validator{
	
	//验证的类
	@Override
	public boolean supports(Class<?> clazz) {
		return UserVO.class.equals(clazz);
	}
	
	//验证方法
	@Override
	public void validate(Object target, Errors errors) {
		UserVO userVO=(UserVO)target;
		if(!userVO.getName().matches("^\\w{2,10}$")) {
			errors.rejectValue("name", null);
		}else if(!userVO.getPassword().trim().matches("^\\S{6,16}$")){
			errors.rejectValue("password", null);
		}
	}

}
