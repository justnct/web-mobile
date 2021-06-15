package com.laptrinhjavaweb.api.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.dto.ProductDTO;
import com.laptrinhjavaweb.service.ICartService;

@RestController(value = "cartAPI")
public class CartAPI {
	
	@Autowired
	private ICartService cartService;
	
	@PostMapping("/api/product")
	public ProductDTO createProduct(@RequestBody ProductDTO productDTO) {
		cartService.saveProduct(productDTO.getId());
		return productDTO;
	}
	
	@PutMapping("/api/product")
	public ProductDTO updateProduct(@RequestBody ProductDTO productDTO) {
		return productDTO;
	}
	
	@PostMapping("/api/removeproduct")
	public void deleteProduct(@RequestBody long id) {
		cartService.delete(id);
	}
	
	@PostMapping("/api/removeAllProduct")
	public void removeAllProduct() {
		cartService.deleteAll();
	}

}
