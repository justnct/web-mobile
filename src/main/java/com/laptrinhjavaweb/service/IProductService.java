package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.dto.ProductDTO;

public interface IProductService {
	List<ProductDTO> getAllProduct();

	List<ProductDTO> getAllProductIsChoice();

	List<ProductDTO> getAllProductNewest();

	List<ProductDTO> getAllProductSalest();

	int countProduct();

	List<ProductDTO> getAllProductDiscount();

	List<ProductDTO> getBestProduct();

	ProductDTO findById(Long id);

	ProductDTO insert(ProductDTO dto);

	ProductDTO update(ProductDTO dto);

	void delete(long[] ids); 
}
