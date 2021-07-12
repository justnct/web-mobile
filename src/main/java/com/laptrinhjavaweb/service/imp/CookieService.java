package com.laptrinhjavaweb.service.imp;

import java.util.Base64;

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
		String enCode = Base64.getEncoder().encodeToString(value.getBytes());
		Cookie cookie = new Cookie(name, enCode);
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
//					return cookie.getValue();
					return this.decode(cookie.getValue());
				}
			}
		}
		return defaultValue;
	}
	
	public String decode(String encodedText) {
		return new String(Base64.getDecoder().decode(encodedText));
	}

}
