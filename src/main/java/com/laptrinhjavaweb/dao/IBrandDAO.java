package com.laptrinhjavaweb.dao;

import java.util.List;

import com.laptrinhjavaweb.model.Brand;

public interface IBrandDAO  extends GenericDAO<Brand> {
	List<Brand> findAll();
	
}
