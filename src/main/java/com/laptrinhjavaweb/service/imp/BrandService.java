package com.laptrinhjavaweb.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.dao.IBrandDAO;
import com.laptrinhjavaweb.model.Brand;
import com.laptrinhjavaweb.service.IBrandService;

@Service
public class BrandService implements IBrandService{
	
	@Autowired
	private IBrandDAO iBrandDAO;
	
	@Override
	public List<Brand> getAllBrand() {
		return iBrandDAO.findAll();
	}

}
