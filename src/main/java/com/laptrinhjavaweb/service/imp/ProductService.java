package com.laptrinhjavaweb.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.laptrinhjavaweb.converter.ProductConverter;
import com.laptrinhjavaweb.dto.ProductDTO;
import com.laptrinhjavaweb.entity.ProductEntity;
import com.laptrinhjavaweb.repository.ProductRepository;
import com.laptrinhjavaweb.service.IProductService;

@Service
public class ProductService implements IProductService {
	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ProductConverter productConverter;

	@Override
	public List<ProductDTO> getAllProduct() {
		List<ProductDTO> mListProduct = new ArrayList<ProductDTO>();
		List<ProductEntity> mListProductEntities = productRepository.findAll();
		for (ProductEntity item : mListProductEntities) {
			ProductDTO product = productConverter.converterToDTO(item);
			mListProduct.add(product);
		}
		return mListProduct;
	}

	@Override
	public List<ProductDTO> getAllProductNewest() {
		List<ProductDTO> mListProduct = new ArrayList<ProductDTO>();
		List<ProductEntity> mListProductEntities = productRepository.findAll();
		for (ProductEntity item : mListProductEntities) {
			if (item.getNewest() == 1) {
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
		for (ProductEntity item : mListProductEntities) {
			if (item.getIsChoice() == 1) {
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
		for (ProductEntity item : mListProductEntities) {
			if (item.getSalest() == 1) {
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
		for (ProductEntity item : mListProductEntities) {
			if (item.getDiscount() > 0) {
				ProductDTO product = productConverter.converterToDTO(item);
				mListProduct.add(product);
			}
		}
		return mListProduct;
	}

	@Override
	public List<ProductDTO> getBestProduct(String brand) {
		List<ProductDTO> mListProduct = new ArrayList<ProductDTO>();
		List<ProductEntity> mListProductEntities = productRepository.findAll();
		if (brand.equals("all")) {
			for (ProductEntity item : mListProductEntities) {
				if (item.getPrice() > 20000000) {
					ProductDTO product = productConverter.converterToDTO(item);
					mListProduct.add(product);
				}
			}
		} else {
			for (ProductEntity item : mListProductEntities) {
				if (item.getPrice() > 20000000 && item.getName().toLowerCase().contains(brand.toLowerCase())) {
					ProductDTO product = productConverter.converterToDTO(item);
					mListProduct.add(product);
				}
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
		ProductEntity updateProduct = productConverter.toEntity(oldProduct, dto);
		return productConverter.toDto(productRepository.save(updateProduct));
	}

	@Override
	@Transactional
	public void delete(long[] ids) {
		for (long id : ids) {
			productRepository.delete(id);
		}
	}

	public ProductDTO getProduct(long id) {
		// TODO Auto-generated method stub
		ProductEntity productEntity = productRepository.findOne(id);
		ProductDTO product = productConverter.converterToDTO(productEntity);
		return product;
	}

	@Override
	public List<ProductDTO> getAllProduct(Pageable pageable) {
		List<ProductDTO> mListProduct = new ArrayList<ProductDTO>();
		List<ProductEntity> mListProductEntities = productRepository.findAll(pageable).getContent();
		for (ProductEntity item : mListProductEntities) {
			ProductDTO product = productConverter.converterToDTO(item);
			mListProduct.add(product);
		}
		return mListProduct;
	}
	
	@Override
	public int getTotalItem() {
		return (int) productRepository.count();
	}

	@Override
	public List<ProductEntity> search(String keyword) {
		return productRepository.search(keyword);
	}

}
