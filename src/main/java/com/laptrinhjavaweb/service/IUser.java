package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.dto.UserDTO;

public interface IUser{

	boolean register(UserDTO user);

	UserDTO insert(UserDTO dto);

	UserDTO update(UserDTO dto);

	void delete(long[] ids);
	
	List<UserDTO> getAllUser();

	UserDTO findById(Long id);
}
