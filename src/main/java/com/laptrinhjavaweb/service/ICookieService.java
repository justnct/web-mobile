package com.laptrinhjavaweb.service;

import javax.servlet.http.Cookie;

public interface ICookieService {
	public Cookie createCookie(String name, String value, int day);
	public String getCookieValue(String name, String defaultValue);
}
