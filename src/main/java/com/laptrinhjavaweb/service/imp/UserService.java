package com.laptrinhjavaweb.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.laptrinhjavaweb.converter.RoleConverter;
import com.laptrinhjavaweb.converter.UserConverter;
import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.entity.RoleEntity;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.repository.RoleRepository;
import com.laptrinhjavaweb.repository.UserRepository;
import com.laptrinhjavaweb.service.IUser;

@Service
public class UserService implements IUser {
	@Autowired
	private UserConverter userConverter;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleConverter roleConverter;
	@Autowired
	private RoleRepository roleRepository;

	@Override
	@Transactional
	public UserDTO register(UserDTO user) {
		List<RoleEntity> list = new ArrayList<RoleEntity>();
		RoleEntity roleEntity = roleRepository.findOneByCode("USER");
		list.add(roleEntity);
		UserEntity entity = userConverter.toEntity(user);
		entity.setRoles(list);
		entity.setStatus(1);
		userRepository.save(entity);
		return user;
	}

}
