package com.laptrinhjavaweb.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.laptrinhjavaweb.converter.CartConverter;
import com.laptrinhjavaweb.dto.CartDTO;
import com.laptrinhjavaweb.entity.CartEntity;
import com.laptrinhjavaweb.repository.CartRepository;
import com.laptrinhjavaweb.service.ICartService;
import com.laptrinhjavaweb.util.SecurityUtils;

@Service
public class CartService implements ICartService {

	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private CartConverter cartConverter;

	@Autowired
	private SecurityUtils securityUtils;

	@Override
	@Transactional
	public CartDTO saveProduct(Long id) {
		CartEntity cartEntity = cartRepository.findOneByName(SecurityUtils.getPrincipal().getUsername());
		String list = cartEntity.getList_product();
		if(list.equals("")) {
			list += String.valueOf(id);
		} else {
			list += "," + String.valueOf(id);
		}
		cartEntity.setList_product(list);
		return cartConverter.converterToDTO(cartRepository.save(cartEntity));
	}

	@Override
	public CartDTO getData() {
		return cartConverter.converterToDTO(cartRepository.findOneByName(SecurityUtils.getPrincipal().getUsername()));
	}

	@Override
	public void delete(Long id) {
		CartEntity cartEntity = cartRepository.findOneByName(SecurityUtils.getPrincipal().getUsername());
		String listAfter = "";
		boolean match = false;
		for(String result: cartEntity.getList_product().split(",")) {
			
		}
	}
}
