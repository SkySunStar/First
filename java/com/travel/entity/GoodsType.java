package com.travel.entity;

import java.io.Serializable;

//商品类别类
public class GoodsType implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;//商品类别ID
	private String name;//类别名称
	private int typeId;//基本类别ID(1:美食；2：特产；3：旅馆)
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

	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	@Override
	public String toString() {
		return "GoodsType [id=" + id + ", name=" + name + ", typeId=" + typeId + "]";
	}
}
