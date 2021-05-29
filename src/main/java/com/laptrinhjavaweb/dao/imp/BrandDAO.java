package com.laptrinhjavaweb.dao.imp;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.laptrinhjavaweb.dao.IBrandDAO;
import com.laptrinhjavaweb.mapper.BrandMapper;
import com.laptrinhjavaweb.mapper.RowMapper;
import com.laptrinhjavaweb.model.Brand;

@Repository
public class BrandDAO extends AbstractDAO<Brand> implements IBrandDAO{

	@Override
	public List<Brand> findAll() {
		StringBuilder sql = new StringBuilder("SELECT * FROM brand");
		return query(sql.toString(), new BrandMapper());
	}

}
