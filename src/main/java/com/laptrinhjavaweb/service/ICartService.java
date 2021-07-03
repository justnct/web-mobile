package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.dto.CartDTO;
import com.laptrinhjavaweb.dto.ProductDTO;


public interface ICartService {
	CartDTO saveProduct(Long id);
	CartDTO getData();
	void delete(Long id);
	void deleteAll();
	void addCart(String name);
	void updateProduct(ProductDTO productDTO);
}
