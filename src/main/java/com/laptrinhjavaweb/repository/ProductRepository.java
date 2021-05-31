package com.laptrinhjavaweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laptrinhjavaweb.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long>{

}
