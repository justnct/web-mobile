package com.laptrinhjavaweb.service.imp;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
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
	public boolean register(UserDTO user) {
		HttpServletRequest request;
		UserEntity checkUser = userRepository.findOneByUserNameAndStatus(user.getUserName(), 1);
		if(checkUser == null) {
			List<RoleEntity> list = new ArrayList<RoleEntity>();
			RoleEntity roleEntity = roleRepository.findFirstByCode("USER");
			list.add(roleEntity);
			checkUser = userConverter.toEntity(user);
			checkUser.setRoles(list);
			checkUser.setStatus(1);
			userRepository.save(checkUser);
			return true;
		}
		return false;
	}

}
