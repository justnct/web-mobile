package com.laptrinhjavaweb.converter;

import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.dto.RoleDTO;
import com.laptrinhjavaweb.entity.RoleEntity;

@Component
public class RoleConverter {

	public RoleDTO toDto(RoleEntity entity) {
		RoleDTO result = new RoleDTO();
		result.setCode(entity.getCode());
		result.setName(entity.getName());
		return result;
	}
	
	public RoleEntity toEntity(RoleDTO role) {
		RoleEntity result = new RoleEntity();	
		result.setCode(role.getCode());
		result.setName(null);
		return result;
	}
}
