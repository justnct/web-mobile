package com.laptrinhjavaweb.api.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
		for (int i = 0; i < productDTO.getCount(); i++) {
			cartService.saveProduct(productDTO.getId());
		}
		return productDTO;
	}

	@PostMapping("/api/updateProduct")
	public int updateProduct(@RequestBody ProductDTO[] listProductDTO) {
		cartService.updateProduct(listProductDTO);
		return cartService.updateProduct(listProductDTO);
	}

	@PostMapping("/api/removeproduct")
	public int deleteProduct(@RequestBody long id) {
		cartService.delete(id);
		return (int) id;
	}

	@PostMapping("/api/removeAllProduct")
	public void removeAllProduct() {
		cartService.deleteAll();
	}

}
