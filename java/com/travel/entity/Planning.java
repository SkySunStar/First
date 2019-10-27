package com.travel.entity;
//旅游预订类
public class Planning {
	private int id;//预订ID
	private String name;//订单号
	private String username;//用户登录名
	private int scenic_id;//景点ID
	private int goods_id;//商品ID
	private Scenic scenic;//预订景点
	private Goods goods;//预订住宿
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getScenic_id() {
		return scenic_id;
	}
	public void setScenic_id(int scenic_id) {
		this.scenic_id = scenic_id;
	}
	public int getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}
	public Scenic getScenic() {
		return scenic;
	}
	public void setScenic(Scenic scenic) {
		this.scenic = scenic;
	}
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	
}
