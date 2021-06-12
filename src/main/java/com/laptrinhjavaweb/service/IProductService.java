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
<<<<<<< HEAD

	ProductDTO findById(Long id);

	ProductDTO insert(ProductDTO dto);

	ProductDTO update(ProductDTO dto);

	void delete(long[] ids); 
=======
	
	ProductDTO getProduct(long id);
>>>>>>> ad42afb8038d3b2d03f67f8f3dbd5317a4193497
}
