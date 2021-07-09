package com.laptrinhjavaweb.api.web;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.dto.ProductDTO;
import com.laptrinhjavaweb.service.ICookieService;
import com.laptrinhjavaweb.util.SecurityUtils;

@RestController(value = "likeAPI")
public class LikeAPI {
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	HttpServletResponse response;
	
	@Autowired 
	ICookieService cookieService;
	
	@Autowired
	private SecurityUtils serUtils;

	@PostMapping("/addLike")
	public String addLike(@RequestBody ProductDTO productDTO) {
		String ids = cookieService.getCookieValue(serUtils.getPrincipal().getUserName(), String.valueOf(productDTO.getId()));
		if(ids.contains("0")) {
			ids = String.valueOf(productDTO.getId());
		} else {
			if(!ids.contains(String.valueOf(productDTO.getId()))) {
				ids += "-" + String.valueOf(productDTO.getId());
			}
		}
		cookieService.createCookie(serUtils.getPrincipal().getUserName(), ids, 15);
		return ids;
	}
	
	@PostMapping("/deleteLike")
	public String deleteLike(@RequestBody ProductDTO productDTO) {
		String listFinal ="";
		String ids = cookieService.getCookieValue(serUtils.getPrincipal().getUserName(), String.valueOf(productDTO.getId()));
		if(ids.length() > 1) {
			for(String result: ids.split("-")) {
				if(!result.equals(String.valueOf(productDTO.getId()))) {
					listFinal += result +"-";
				}
			}
			listFinal = listFinal.substring(0, listFinal.length()-1);
			cookieService.createCookie(serUtils.getPrincipal().getUserName(), listFinal, 15);
		} else {
			ids ="0";
			cookieService.createCookie(serUtils.getPrincipal().getUserName(), ids, 15);
		}
		return ids;
	}
}
