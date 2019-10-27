package com.travel.entity;
import java.io.Serializable;

//商品信息类
/**
 * 商品信息类javadoc
 */
/*
 * 商品信息类normal
 */
public class Goods implements Serializable{
	private static final long serialVersionUID = 1L;
	/**商品ID*/
	private int id;
	/**商品名称*/
	private String name;
	/**商品信息*/
	private String information;
	private float price;//价格
	private String image;//图片路径
	private int goodsTypeId;//商品类别ID
	private int sellerId;//所属商家ID
	private int typeId;//基本类别ID
	private GoodsType goodsType;//商品类别
	private Seller seller;//所属商家
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
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getGoodsTypeId() {
		return goodsTypeId;
	}
	public void setGoodsTypeId(int goodsTypeId) {
		this.goodsTypeId = goodsTypeId;
	}
	public int getSellerId() {
		return sellerId;
	}
	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	public GoodsType getGoodsType() {
		return goodsType;
	}
	public void setGoodsType(GoodsType goodsType) {
		this.goodsType = goodsType;
	}
	public Seller getSeller() {
		return seller;
	}
	public void setSeller(Seller seller) {
		this.seller = seller;
	}
	@Override
	public String toString() {
		return "Goods [id=" + id + ", name=" + name + ", information=" + information + ", price=" + price + ", image="
				+ image + ", goodsTypeId=" + goodsTypeId + ", sellerId=" + sellerId + ", typeId=" + typeId
				+ ", goodsType=" + goodsType + ", seller=" + seller + "]";
	}
	
	
}
