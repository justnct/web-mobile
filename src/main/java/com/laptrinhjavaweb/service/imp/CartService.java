package com.laptrinhjavaweb.service.imp;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.laptrinhjavaweb.converter.CartConverter;
import com.laptrinhjavaweb.dto.CartDTO;
import com.laptrinhjavaweb.dto.ProductDTO;
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
	private SecurityUtils ser;
	

	@Override
	@Transactional
	public CartDTO saveProduct(Long id) {
		CartEntity cartEntity = cartRepository.findOneByName(SecurityUtils.getPrincipal().getUsername());
		String list = cartEntity.getList_product();
		if (list.equals("")) {
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
		String result = "";
		ArrayList<String> arr = new ArrayList<String>();
		for (String charAt : cartEntity.getList_product().split(",")) {
			arr.add(charAt);
		}
		ArrayList<String> arr2 = new ArrayList<String>();
		arr2.add(String.valueOf(id));
		arr.removeAll(arr2);
		if (arr.size() == 0) {
			cartEntity.setList_product("");
		} else {
			for (int i = 0; i < arr.size(); i++) {
				result += arr.get(i) + ",";
			}
			result = result.substring(0, result.length() - 1);
			cartEntity.setList_product(result);
		}
		cartRepository.save(cartEntity);
	}

	@Override
	public void deleteAll() {
		CartEntity cartEntity = cartRepository.findOneByName(SecurityUtils.getPrincipal().getUsername());
		cartEntity.setList_product("");
		cartRepository.save(cartEntity);
	}

	@Override
	public void addCart(String name) {
		// TODO Auto-generated method stub
		CartEntity cartEntity = new CartEntity();
		cartEntity.setName(name);
		cartEntity.setList_product("");
		cartRepository.save(cartEntity);
	}

	@Override
	@Transactional
	public int updateProduct(ProductDTO[] mListProductDTO) {
		CartEntity cartEntity = cartRepository.findOneByName(ser.getPrincipal().getUsername());
//		ArrayList<String> list = new ArrayList<String>();
//		int count = 0;
//		String listProduct = cartEntity.getList_product();
//		for (String result : listProduct.split(",")) {
//			list.add(result);
//			if (String.valueOf(productDTO.getId()).equals(result)) {
//				count++;
//			}
//		}
//		// case amout in cart > database
//		if (productDTO.getCount() > count) {
//			for (int i = 0; i < productDTO.getCount() - count; i++) {
//				listProduct += "," + String.valueOf(productDTO.getId());
//			}
//		} else { // case amout in cart > database
//			for (int i = 0; i < count - productDTO.getCount(); i++) {
//				list.remove(String.valueOf(productDTO.getId()));
//			}
//			listProduct = "";
//			for(int i =0; i < list.size();i++) {
//				listProduct += list.get(i) +",";
//			}
//			listProduct = listProduct.substring(0, listProduct.length()-1);
//		}
//		cartEntity.setList_product(listProduct);
		
		String list = "";
		for(ProductDTO productDTO: mListProductDTO) {
			for(int i =0; i < productDTO.getCount(); i++) {
				list += String.valueOf(productDTO.getId()) + ",";
			}
		}
		list = list.substring(0, list.length()-1);
		cartEntity.setList_product(list);
		cartRepository.save(cartEntity);
		 return mListProductDTO.length;
	}
}
