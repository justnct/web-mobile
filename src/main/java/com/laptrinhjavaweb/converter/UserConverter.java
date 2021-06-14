package com.laptrinhjavaweb.converter;

import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.entity.UserEntity;

@Component
public class UserConverter {

	public UserDTO toDto(UserEntity entity) {
		UserDTO result = new UserDTO();
		
		result.setFullName(entity.getFullName());
		result.setUserName(entity.getUserName());
		result.setPassword(entity.getPassword());
		 
		return result;
	}
	
	public UserEntity toEntity(UserDTO user) {
		UserEntity result = new UserEntity();
		result.setFullName(user.getFullName());
		result.setUserName(user.getUserName());
		result.setPassword(user.getPassword());
		
		return result;
	}
}
