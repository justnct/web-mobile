package com.laptrinhjavaweb.api.admin;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.dto.ProductDTO;
import com.laptrinhjavaweb.service.IProductService;

@RestController(value = "productAPIOfAdmin")
public class ProductAPI {
	@Autowired
	private IProductService productService;
	
	@PostMapping("/apiad/product")
	public ProductDTO createProduct(@RequestBody ProductDTO dto) {
		return productService.insert(dto);
	}
	
	
	@PutMapping("/apiad/product")
	public ProductDTO updateProduct(@RequestBody ProductDTO dto) {
		return productService.update(dto);
	}
	
	@DeleteMapping("/apiad/product")
	public void deleteProduct(@RequestBody long[] ids) {
		productService.delete(ids);
	}
}
