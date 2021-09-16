package com.laptrinhjavaweb.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.entity.RoleEntity;
import com.laptrinhjavaweb.repository.RoleRepository;
import com.laptrinhjavaweb.service.IRoleService;

@Service
public class RoleService implements IRoleService{

	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public void addRole() {
		RoleEntity roleEntity = new RoleEntity();
		roleEntity.setCode("USER");
		roleEntity.setName("Nguời dùng");
		roleRepository.save(roleEntity);
	}

}
