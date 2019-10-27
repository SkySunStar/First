package com.travel.util;

import java.util.UUID;

import org.apache.commons.codec.digest.DigestUtils;

public class SecurityUtils {
	
	//md5加密
	public static String md5Hex(String data) {
		return DigestUtils.md5Hex(data).substring(0, 20);
	}
	
	//生成UUID
	public static String randomUUID() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString().replace("-", "");
	}
}
