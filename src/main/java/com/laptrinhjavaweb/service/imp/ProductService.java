package com.laptrinhjavaweb.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.converter.ProductConverter;
import com.laptrinhjavaweb.dto.BrandDTO;
import com.laptrinhjavaweb.dto.ProductDTO;
import com.laptrinhjavaweb.entity.BrandEntity;
import com.laptrinhjavaweb.entity.ProductEntity;
import com.laptrinhjavaweb.repository.ProductRepository;
import com.laptrinhjavaweb.service.IProductService;

@Service
public class ProductService implements IProductService{
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ProductConverter productConverter;

	@Override
	public List<ProductDTO> getAllProduct() {
		List<ProductDTO> mListProduct = new ArrayList<ProductDTO>();
		List<ProductEntity> mListProductEntities = productRepository.findAll();
		for(ProductEntity item : mListProductEntities) {
			ProductDTO product = productConverter.converterToDTO(item);
			mListProduct.add(product);
		}
		return mListProduct;
	}

	
	@Override
	public List<ProductDTO> getAllProductNewest() {
		List<ProductDTO> mListProduct = new ArrayList<ProductDTO>();
		List<ProductEntity> mListProductEntities = productRepository.findAll();
		for(ProductEntity item : mListProductEntities) {
			if(item.getNewest() == 1) {
			ProductDTO product = productConverter.converterToDTO(item);
			mListProduct.add(product);
			}
		}
		return mListProduct;
	}
	@Override
	public List<ProductDTO> getAllProductIsChoice() {
		List<ProductDTO> mListProduct = new ArrayList<ProductDTO>();
		List<ProductEntity> mListProductEntities = productRepository.findAll();
		for(ProductEntity item : mListProductEntities) {
			if(item.getIsChoice() == 1) {
			ProductDTO product = productConverter.converterToDTO(item);
			mListProduct.add(product);
			}
		}
		return mListProduct;
	}
	
	
	@Override
	public List<ProductDTO> getAllProductSalest() {
		List<ProductDTO> mListProduct = new ArrayList<ProductDTO>();
		List<ProductEntity> mListProductEntities = productRepository.findAll();
		for(ProductEntity item : mListProductEntities) {
			if(item.getSalest() == 1) {
			ProductDTO product = productConverter.converterToDTO(item);
			mListProduct.add(product);
			}
		}
		return mListProduct;
	}


	@Override
	public int countProduct() {
		return getAllProduct().size();
	}


	@Override
	public List<ProductDTO> getAllProductDiscount() {
		List<ProductDTO> mListProduct = new ArrayList<ProductDTO>();
		List<ProductEntity> mListProductEntities = productRepository.findAll();
		for(ProductEntity item : mListProductEntities) {
			if(item.getDiscount() > 0) {
			ProductDTO product = productConverter.converterToDTO(item);
			mListProduct.add(product);
			}
		}
		return mListProduct;
	}
	@Override
	public List<ProductDTO> getBestProduct() {
		List<ProductDTO> mListProduct = new ArrayList<ProductDTO>();
		List<ProductEntity> mListProductEntities = productRepository.findAll();
		for(ProductEntity item : mListProductEntities) {
			if(item.getPrice() > 20000000) {
			ProductDTO product = productConverter.converterToDTO(item);
			mListProduct.add(product);
			}
		}
		return mListProduct;
	}


	@Override
	public ProductDTO getProduct(long id) {
		// TODO Auto-generated method stub
		ProductEntity productEntity = productRepository.findOne(id);
		ProductDTO product = productConverter.converterToDTO(productEntity);
		return product;
	}
}
