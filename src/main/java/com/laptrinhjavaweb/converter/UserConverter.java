package com.laptrinhjavaweb.converter;

import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.dto.RoleDTO;
import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.entity.UserEntity;

@Component
public class UserConverter {

	public UserDTO toDto(UserEntity entity) {
		UserDTO result = new UserDTO();
		result.setId(entity.getId());
		result.setFullName(entity.getFullName());
		result.setUserName(entity.getUserName());
		result.setPassword(entity.getPassword());		
		 result.setStatus(entity.getStatus());
		return result;
	}
	
	public UserEntity toEntity(UserDTO user) {
		UserEntity result = new UserEntity();
		result.setId(user.getId());
		result.setFullName(user.getFullName());
		result.setUserName(user.getUserName());
		result.setPassword(user.getPassword());
		 result.setStatus(user.getStatus());
		return result;
	}
	
	public UserEntity toEntity(UserEntity result,UserDTO user) {
		result.setId(user.getId());
		result.setFullName(user.getFullName());
		result.setUserName(user.getUserName());
		result.setPassword(user.getPassword());
		 result.setStatus(user.getStatus());
		return result;
	}
}
