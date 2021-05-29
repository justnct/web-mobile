package com.laptrinhjavaweb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.laptrinhjavaweb.model.Brand;

public class BrandMapper implements RowMapper<Brand>{

	@Override
	public Brand mapRow(ResultSet rs) {
		Brand brand = new Brand();
		try {
			brand.setId(rs.getInt(0));
			brand.setName(rs.getString(1));
			return brand;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
