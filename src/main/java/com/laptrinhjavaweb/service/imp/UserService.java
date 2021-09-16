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
import com.laptrinhjavaweb.dto.ProductDTO;
import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.entity.ProductEntity;
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

	@Override
	public UserDTO insert(UserDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public UserDTO update(UserDTO dto) {
		UserEntity oldProduct = userRepository.findOne(dto.getId());
		UserEntity updateProduct = userConverter.toEntity(oldProduct, dto);
		return userConverter.toDto(userRepository.save(updateProduct));
	}

	@Override
	@Transactional
	public void delete(long[] ids) {
		for (long id : ids) {
			userRepository.delete(id);
		}
	}

	public UserDTO getUser(long id) {
		// TODO Auto-generated method stub
		UserEntity entity = userRepository.findOne(id);
		UserDTO user = userConverter.toDto(entity);
		return user;
	}
	@Override
	public List<UserDTO> getAllUser() {
		List<UserDTO> list = new ArrayList<UserDTO>();
		List<UserEntity> listEntities = userRepository.findAll();
		for (UserEntity item : listEntities) {
			UserDTO user = userConverter.toDto(item);
			list.add(user);
		}
		return list;
	}

	@Override
	public UserDTO findById(Long id) {
		UserEntity entity = userRepository.findOne(id);
		return userConverter.toDto(entity);
	}
}
