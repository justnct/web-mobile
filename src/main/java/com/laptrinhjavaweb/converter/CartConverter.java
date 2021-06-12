package com.laptrinhjavaweb.converter;

import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.dto.CartDTO;
import com.laptrinhjavaweb.dto.ProductDTO;
import com.laptrinhjavaweb.entity.CartEntity;
import com.laptrinhjavaweb.entity.ProductEntity;

@Component
public class CartConverter {
	public CartDTO converterToDTO(CartEntity cartEntity) {
		CartDTO cart = new CartDTO();
		cart.setId(cartEntity.getId());
		cart.setNameCustomer(cartEntity.getName());
		cart.setList_product(cartEntity.getList_product());
		return cart;
	}
	
	public CartEntity converterToEntity(CartDTO cartDTO) {
		CartEntity cart = new CartEntity();
		cart.setId(cartDTO.getId());
		cart.setName(cartDTO.getNameCustomer());
		cart.setList_product(cartDTO.getList_product());
		return cart;
	}
	
}
