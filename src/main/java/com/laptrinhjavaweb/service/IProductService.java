package com.laptrinhjavaweb.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.laptrinhjavaweb.dto.ProductDTO;

public interface IProductService {
	List<ProductDTO> getAllProduct();

	List<ProductDTO> getAllProduct(Pageable pageable);
	
	List<ProductDTO> getAllProductOrderByPrice(Pageable pageable);

	List<ProductDTO> getAllProductIsChoice();

	List<ProductDTO> getAllProductNewest();

	List<ProductDTO> getAllProductSalest();

	int countProduct();

	List<ProductDTO> getAllProductDiscount();

	List<ProductDTO> getBestProduct(String name);

	ProductDTO findById(Long id);

	ProductDTO insert(ProductDTO dto);

	ProductDTO update(ProductDTO dto);

	void delete(long[] ids);

	ProductDTO getProduct(long id);

	int getTotalItem();

}
