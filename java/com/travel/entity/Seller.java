package com.travel.entity;

import java.io.Serializable;

//商家类
public class Seller implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;//商家ID
	private String name;//名称
	private String telephone;//电话号码
	private String address;//地址
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

	@Override
	public String toString() {
		return "Seller [id=" + id + ", name=" + name + ", telephone=" + telephone + ", address=" + address + "]";
	}
}
