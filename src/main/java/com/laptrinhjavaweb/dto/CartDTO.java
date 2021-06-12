package com.laptrinhjavaweb.dto;

public class CartDTO {
	private Long id;
	private String nameCustomer;
	private String list_product;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNameCustomer() {
		return nameCustomer;
	}

	public void setNameCustomer(String nameCustomer) {
		this.nameCustomer = nameCustomer;
	}

	public String getList_product() {
		return list_product;
	}

	public void setList_product(String list_product) {
		this.list_product = list_product;
	}

}
