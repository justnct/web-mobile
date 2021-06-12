package com.laptrinhjavaweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laptrinhjavaweb.entity.CartEntity;

public interface CartRepository extends JpaRepository<CartEntity, Long>{
	CartEntity findOneByName(String userName);
}
