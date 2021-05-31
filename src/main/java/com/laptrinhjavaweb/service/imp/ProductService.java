package com.laptrinhjavaweb.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	@Override
	public List<ProductDTO> getAllProduct() {
		List<ProductDTO> mListProduct = new ArrayList<ProductDTO>();
		List<ProductEntity> mListProductEntities = productRepository.findAll();
		for(ProductEntity item : mListProductEntities) {
			ProductDTO product = new ProductDTO();
			product.setId(item.getId_product());
			product.setName(item.getName());
			product.setNameImg(item.getImgBig());
			product.setNameLittleImg(item.getImgLittle());
			product.setNewest(item.getNewest());
			product.setIsChoice(item.getIsChoice());
			product.setSalest(item.getSalest());
			product.setPrice(item.getPrice());
			product.setDiscount(item.getDiscount());
			product.setDiscountPrice(item.getDiscountPrice());
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
			ProductDTO product = new ProductDTO();
			product.setId(item.getId_product());
			product.setName(item.getName());
			product.setNameImg(item.getImgBig());
			product.setNameLittleImg(item.getImgLittle());
			product.setNewest(item.getNewest());
			product.setIsChoice(item.getIsChoice());
			product.setSalest(item.getSalest());
			product.setPrice(item.getPrice());
			product.setDiscount(item.getDiscount());
			product.setDiscountPrice(item.getDiscountPrice());
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
			ProductDTO product = new ProductDTO();
			product.setId(item.getId_product());
			product.setName(item.getName());
			product.setNameImg(item.getImgBig());
			product.setNameLittleImg(item.getImgLittle());
			product.setNewest(item.getNewest());
			product.setIsChoice(item.getIsChoice());
			product.setSalest(item.getSalest());
			product.setPrice(item.getPrice());
			product.setDiscount(item.getDiscount());
			product.setDiscountPrice(item.getDiscountPrice());
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
			ProductDTO product = new ProductDTO();
			product.setId(item.getId_product());
			product.setName(item.getName());
			product.setNameImg(item.getImgBig());
			product.setNameLittleImg(item.getImgLittle());
			product.setNewest(item.getNewest());
			product.setIsChoice(item.getIsChoice());
			product.setSalest(item.getSalest());
			product.setPrice(item.getPrice());
			product.setDiscount(item.getDiscount());
			product.setDiscountPrice(item.getDiscountPrice());
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
			ProductDTO product = new ProductDTO();
			product.setId(item.getId_product());
			product.setName(item.getName());
			product.setNameImg(item.getImgBig());
			product.setNameLittleImg(item.getImgLittle());
			product.setNewest(item.getNewest());
			product.setIsChoice(item.getIsChoice());
			product.setSalest(item.getSalest());
			product.setPrice(item.getPrice());
			product.setDiscount(item.getDiscount());
			product.setDiscountPrice(item.getDiscountPrice());
			mListProduct.add(product);
			}
		}
		return mListProduct;
	}
	
}
