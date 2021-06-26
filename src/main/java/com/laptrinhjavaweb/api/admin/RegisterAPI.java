package com.laptrinhjavaweb.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.service.ICartService;
import com.laptrinhjavaweb.service.IRoleService;
import com.laptrinhjavaweb.service.IUser;

@RestController(value = "registerAPI")
public class RegisterAPI {
	@Autowired
	private IUser userService;
	
	@Autowired
	private ICartService cartService;
	
	@Autowired
	private IRoleService roleService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	
	@PostMapping("/api/register")
	public UserDTO createUser(@RequestBody UserDTO user) {
		user.setPassword(String.valueOf(passwordEncoder.encode(user.getPassword())));
		if(userService.register(user)) {
			roleService.addRole();
			cartService.addCart(user.getUserName());
		}		
		return user;
	}
}
