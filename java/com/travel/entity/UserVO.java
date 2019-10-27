package com.travel.entity;

import java.io.Serializable;

//用户类
public class UserVO implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;//用户ID
	private String name;//登录名
	private String password;//密码
	private int rights;//权限（默认为0即普通用户）
	private int isDelete;//是否被删（逻辑删除，1为删除，默认为0为不删除）
	private String realname;//真实姓名
	private String telephone;//电话号码
	private String address;//地址
	private int userId;//用户ID

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getRights() {
		return rights;
	}
	public void setRights(int rights) {
		this.rights = rights;
	}
	public int getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "UserVO [id=" + id + ", name=" + name + ", password=" + password + ", rights=" + rights + ", realname="
				+ realname + ", telephone=" + telephone + ", address=" + address + ", userId=" + userId + "]";
	}
}
