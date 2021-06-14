package com.laptrinhjavaweb.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.laptrinhjavaweb.converter.UserConverter;
import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.repository.UserRepository;
import com.laptrinhjavaweb.service.IUser;

@Service
public class UserService implements IUser {
	@Autowired
	private UserConverter userConverter;
	@Autowired
	private UserRepository userRepository;

	@Override
	@Transactional
	public UserDTO register(UserDTO user) {
		UserEntity entity = userConverter.toEntity(user);
		entity.setStatus(1);
		return userConverter.toDto(userRepository.save(entity));
	}

}
