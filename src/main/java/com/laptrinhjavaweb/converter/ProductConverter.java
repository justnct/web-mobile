package com.laptrinhjavaweb.converter;

import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.dto.ProductDTO;
import com.laptrinhjavaweb.entity.ProductEntity;

@Component
public class ProductConverter {
	
	public ProductDTO toDto(ProductEntity entity) {
		ProductDTO result = new ProductDTO();
		result.setId(entity.getId_product());
		result.setName(entity.getName());
		result.setPrice(entity.getPrice());
		result.setNameImg(entity.getImgBig());
		result.setNameLittleImg(entity.getImgLittle());
		result.setDiscount(entity.getDiscount());
		result.setDiscountPrice(entity.getDiscountPrice());
		result.setIsChoice(entity.getIsChoice());
		result.setNewest(entity.getNewest());
		result.setSalest(entity.getSalest());
		result.setDescription(entity.getDescription());
		return result;
	}
	
	public ProductEntity toEntity(ProductDTO dto) {
		ProductEntity result = new ProductEntity();
		result.setId_product(dto.getId());
		result.setName(dto.getName());
		result.setPrice(dto.getPrice());
		result.setImgBig(dto.getNameImg());
		result.setImgLittle(dto.getNameLittleImg());
		result.setDiscount(dto.getDiscount());
		result.setDiscountPrice(dto.getDiscountPrice());
		result.setIsChoice(dto.getIsChoice());
		result.setNewest(dto.getNewest());
		result.setSalest(dto.getSalest());
		result.setDescription(dto.getDescription());
		return result;
	}
	
	public ProductEntity toEntity(ProductEntity result, ProductDTO dto) {
		result.setId_product(dto.getId());
		result.setName(dto.getName());
		result.setPrice(dto.getPrice());
		result.setImgBig(dto.getNameImg());
		result.setImgLittle(dto.getNameLittleImg());
		result.setDiscount(dto.getDiscount());
		result.setDiscountPrice(dto.getDiscountPrice());
		result.setIsChoice(dto.getIsChoice());
		result.setNewest(dto.getNewest());
		result.setSalest(dto.getSalest());
		result.setDescription(dto.getDescription());
		return result;
	}
}
