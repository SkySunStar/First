package com.travel.entity;

import java.io.Serializable;

//景区类
public class Scenic implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;//景区ID
	private String name;//名称
	private String information;//信息
	private float price;//门票价格
	private String address;//地址
	private String image;//图片
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
	public String getInformation() {
		return information;
	}
	public void setInformation(String information) {
		this.information = information;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "Scenic [id=" + id + ", name=" + name + ", information=" + information + ", address=" + address
				+ ", image=" + image + "]";
	}
}
