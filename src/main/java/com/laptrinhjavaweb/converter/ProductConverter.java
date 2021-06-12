package com.laptrinhjavaweb.converter;

import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.dto.ProductDTO;
import com.laptrinhjavaweb.entity.ProductEntity;

@Component
public class ProductConverter {
<<<<<<< HEAD
	
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
=======
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
>>>>>>> ad42afb8038d3b2d03f67f8f3dbd5317a4193497
	}
}
