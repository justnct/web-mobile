package com.laptrinhjavaweb.service.imp;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.service.ICookieService;

@Service
public class CookieService implements ICookieService{
	@Autowired
	HttpServletRequest request;
	@Autowired
	HttpServletResponse response;

	@Override
	public Cookie createCookie(String name, String value, int day) {
		Cookie cookie = new Cookie(name, value);
		cookie.setMaxAge(day * 24 * 60 * 60); 
		cookie.setPath("/"); // đường dẫn mọi url trong web
		response.addCookie(cookie); 
		return cookie;
	}
	
	@Override
	public String getCookieValue(String name, String defaultValue) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equalsIgnoreCase(name)) {
					return cookie.getValue();
				}
			}
		}
		return defaultValue;
	}
}
