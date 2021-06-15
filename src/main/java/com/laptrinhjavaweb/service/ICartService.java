package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.dto.CartDTO;


public interface ICartService {
	CartDTO saveProduct(Long id);
	CartDTO getData();
	void delete(Long id);
	void deleteAll();
}
