package com.laptrinhjavaweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.laptrinhjavaweb.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long>{
	 @Query(value = "SELECT c FROM ProductEntity c WHERE c.name LIKE '%' || :keyword || '%'"
	            + " OR c.price LIKE '%' || :keyword || '%'")
	public List<ProductEntity> search(@Param("keyword") String keyword);
	 
	 @Query(value = "SELECT c FROM ProductEntity c WHERE c.name LIKE :brand||'%'")
	 public List<ProductEntity> findProductByBrand(@Param("brand") String keyword);
}
