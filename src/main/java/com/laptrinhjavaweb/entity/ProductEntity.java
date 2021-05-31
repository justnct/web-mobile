package com.laptrinhjavaweb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mobile")
public class ProductEntity {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "id_product")
	private long id_product;
	
	@Column(name = "name_product")
	private String name;
	
	@Column(name = "price_product")
	private int price;
	
	@Column(name = "link_big_picture", columnDefinition = "TEXT")
	private String imgBig;
	
	@Column(name = "link_img_picture", columnDefinition = "TEXT")
	private String imgLittle;
	
	@Column(name = "newest")
	private int newest;
	
	@Column(name = "isChoice")
	private int isChoice;
	
	@Column(name = "salest")
	private int salest;
	
	@Column(name = "discount")
	private int discount;
	
	@Column(name = "discountPrice")
	private int discountPrice;

	public long getId_product() {
		return id_product;
	}

	public void setId_product(long id_product) {
		this.id_product = id_product;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getImgBig() {
		return imgBig;
	}

	public void setImgBig(String imgBig) {
		this.imgBig = imgBig;
	}

	public String getImgLittle() {
		return imgLittle;
	}

	public void setImgLittle(String imgLittle) {
		this.imgLittle = imgLittle;
	}

	public int getNewest() {
		return newest;
	}

	public void setNewest(int newest) {
		this.newest = newest;
	}

	public int getIsChoice() {
		return isChoice;
	}

	public void setIsChoice(int isChoice) {
		this.isChoice = isChoice;
	}

	public int getSalest() {
		return salest;
	}

	public void setSalest(int salest) {
		this.salest = salest;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public int getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(int discountPrice) {
		this.discountPrice = discountPrice;
	}

}
