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
	private long price;
	
	@Column(name = "link_big_picture", columnDefinition = "TEXT")
	private String imgBig;
	
	@Column(name = "link_img_picture", columnDefinition = "TEXT")
	private String imgLittle;
	
	@Column(name = "id")
	private long id;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
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

	public long getId_product() {
		return id_product;
	}

	public long getId() {
		return id;
	}
}
