package com.laptrinhjavaweb.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.service.IUser;

@RestController()
public class RegisterAPI {
	@Autowired
	private IUser userService;

	@PostMapping("/api/register")
	public UserDTO createUser(@RequestBody UserDTO user) {
		return userService.register(user);
	}
}
