package com.laptrinhjavaweb.converter;

import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.dto.BrandDTO;
import com.laptrinhjavaweb.entity.BrandEntity;

@Component
public class BrandConverter {

	public BrandDTO toDto(BrandEntity entity) {
		BrandDTO result = new BrandDTO();
		
		result.setId(entity.getId());
		result.setName(entity.getName());
		result.setNameImg(entity.getNameImg());
		 
		return result;
	}
	
	public BrandEntity toEntity(BrandDTO dto) {
		BrandEntity result = new BrandEntity();

		result.setId(dto.getId());
		result.setName(dto.getName());
		result.setNameImg(dto.getNameImg());
		
		return result;
	}
}
