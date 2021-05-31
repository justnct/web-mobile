package com.laptrinhjavaweb.dto;

public class ProductDTO {
	private long id;
	private String name;
	private String nameImg;
	private String nameLittleImg;
	private int newest;
	private int isChoice;
	private int salest;
	private int price;
	private int discount;
	private int discountPrice;

	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNameImg() {
		return nameImg;
	}

	public void setNameImg(String nameImg) {
		this.nameImg = nameImg;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
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

	public String getNameLittleImg() {
		return nameLittleImg;
	}

	public void setNameLittleImg(String nameLittleImg) {
		this.nameLittleImg = nameLittleImg;
	}
}
