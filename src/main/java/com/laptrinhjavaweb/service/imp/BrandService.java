package com.laptrinhjavaweb.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.dao.IBrandDAO;
import com.laptrinhjavaweb.dto.BrandDTO;
import com.laptrinhjavaweb.entity.BrandEntity;
import com.laptrinhjavaweb.model.Brand;
import com.laptrinhjavaweb.repository.BrandRepository;
import com.laptrinhjavaweb.service.IBrandService;

@Service
public class BrandService implements IBrandService{
	
//	@Autowired
//	private IBrandDAO iBrandDAO;
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

}
