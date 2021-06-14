package com.laptrinhjavaweb.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.laptrinhjavaweb.converter.BrandConverter;
import com.laptrinhjavaweb.converter.UserConverter;
import com.laptrinhjavaweb.dao.IBrandDAO;
import com.laptrinhjavaweb.dto.BrandDTO;
import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.entity.BrandEntity;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.model.Brand;
import com.laptrinhjavaweb.repository.BrandRepository;
import com.laptrinhjavaweb.repository.UserRepository;
import com.laptrinhjavaweb.service.IBrandService;

@Service
public class BrandService implements IBrandService{
	
	@Autowired
	private BrandConverter brandConverter;
	@Autowired
	private BrandRepository brandRepository;
	
	@Override
	public List<BrandDTO> getAllBrand() {
		List<BrandDTO> mListBrand = new ArrayList<BrandDTO>();
		List<BrandEntity> mListBrandEntities = brandRepository.findAll();
		for(BrandEntity item : mListBrandEntities) {
			BrandDTO brand = new BrandDTO();
			brand.setId(item.getId());
			brand.setName(item.getName());
			brand.setNameImg(item.getNameImg());
			mListBrand.add(brand);
		}
		return mListBrand;
	}

	@Override
	@Transactional
	public BrandDTO test(BrandDTO dto) {
		BrandEntity entity = brandConverter.toEntity(dto);
		return brandConverter.toDto(brandRepository.save(entity));
	}


}
