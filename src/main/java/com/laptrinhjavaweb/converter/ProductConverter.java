package com.laptrinhjavaweb.converter;

import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.dto.ProductDTO;
import com.laptrinhjavaweb.entity.ProductEntity;

@Component
public class ProductConverter {
	public ProductDTO converterToDTO(ProductEntity productEntity) {
		ProductDTO product = new ProductDTO();
		product.setId(productEntity.getId_product());
		product.setName(productEntity.getName());
		product.setNameImg(productEntity.getImgBig());
		product.setNameLittleImg(productEntity.getImgLittle());
		product.setNewest(productEntity.getNewest());
		product.setIsChoice(productEntity.getIsChoice());
		product.setSalest(productEntity.getSalest());
		product.setPrice(productEntity.getPrice());
		product.setDiscount(productEntity.getDiscount());
		product.setDiscountPrice(productEntity.getDiscountPrice());
		product.setDes(productEntity.getDescrip());
		return product;
	}
	
	public ProductEntity converterToEntity(ProductDTO productDTO) {
		ProductEntity product = new ProductEntity();
		product.setId_product(productDTO.getId());
		product.setName(productDTO.getName());
		product.setPrice(productDTO.getPrice());
		product.setImgBig(productDTO.getNameImg());
		product.setImgLittle(productDTO.getNameLittleImg());
		product.setNewest(productDTO.getNewest());
		product.setIsChoice(productDTO.getIsChoice());
		product.setSalest(productDTO.getSalest());
		product.setPrice(productDTO.getPrice());
		product.setDiscount(productDTO.getDiscount());
		product.setDiscountPrice(productDTO.getDiscountPrice());
		product.setDescrip(productDTO.getDes());
		return product;
	}
}
