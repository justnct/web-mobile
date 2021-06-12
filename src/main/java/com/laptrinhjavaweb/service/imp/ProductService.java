package com.laptrinhjavaweb.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.laptrinhjavaweb.converter.ProductConverter;
import com.laptrinhjavaweb.dto.ProductDTO;
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
			ProductDTO product = productConverter.toDto(item);
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


	@Override
	public List<ProductDTO> getBestProduct() {
		List<ProductDTO> mListProduct = new ArrayList<ProductDTO>();
		List<ProductEntity> mListProductEntities = productRepository.findAll();
		for(ProductEntity item : mListProductEntities) {
			if(item.getPrice() > 20000000) {
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
	public ProductDTO findById(Long id) {
		ProductEntity entity = productRepository.findOne(id);
		return productConverter.toDto(entity);
	}


	@Override
	@Transactional
	public ProductDTO insert(ProductDTO dto) {
		ProductEntity entity = productConverter.toEntity(dto);
		return productConverter.toDto(productRepository.save(entity));
	}


	@Override
	@Transactional
	public ProductDTO update(ProductDTO dto) {
		ProductEntity oldProduct = productRepository.findOne(dto.getId());
		ProductEntity updateProduct = productConverter.toEntity(oldProduct,dto);
		return productConverter.toDto(productRepository.save(updateProduct));
	}


	@Override
	@Transactional
	public void delete(long[] ids) {
		for (long id: ids) {
			productRepository.delete(id);
		}
	}

	/*
	 * @Override
	 * 
	 * @Transactional public ProductDTO save(ProductDTO dto) { ProductEntity entity
	 * = new ProductEntity(); if(dto.getId() > 0) { ProductEntity oldProduct =
	 * productRepository.findOne(dto.getId()); entity =
	 * productConverter.toEntity(oldProduct,dto); }else { entity =
	 * productConverter.toEntity(dto); } return
	 * productConverter.toDto(productRepository.save(entity)); }
	 */


	
}
