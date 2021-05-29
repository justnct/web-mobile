package com.laptrinhjavaweb.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.model.Brand;
import com.laptrinhjavaweb.service.IBrandService;
	
@Controller
public class HomeController {
	
	@Autowired
	private IBrandService iBrandService;
	
	@RequestMapping(value = "/khach-hang/trang-chu", method = RequestMethod.GET)
	public ModelAndView homePageWeb(@ModelAttribute("brand") Brand brand) {
		ModelAndView mav = new ModelAndView("web/trangchu-home");
		mav.addObject("brand", brand);
		return mav;
	}
	
	@RequestMapping(value = "/khach-hang/cua-hang", method = RequestMethod.GET)
	public ModelAndView shopPageWeb() {
		ModelAndView mav = new ModelAndView("web/trangchu-shop_grid");
		return mav;
	}
	
	@RequestMapping(value = "/khach-hang/chi-tiet-san-pham", method = RequestMethod.GET)
	public ModelAndView shopGridPageWeb() {
		ModelAndView mav = new ModelAndView("web/trangchu-shop_details");
		return mav;
	}
	
	@RequestMapping(value = "/khach-hang/gio-hang", method = RequestMethod.GET)
	public ModelAndView shopCartPageWeb() {
		ModelAndView mav = new ModelAndView("web/trangchu-shop_cart");
		return mav;
	}
	
	
	@RequestMapping(value = "/khach-hang/lien-he", method = RequestMethod.GET)
	public ModelAndView contactPageWeb() {
		ModelAndView mav = new ModelAndView("web/trangchu-contact");
		return mav;
	}
	
	@RequestMapping(value = "/dang-nhap", method = RequestMethod.GET)
	public ModelAndView loginWeb() {
		ModelAndView mav = new ModelAndView("login");
		return mav;
	}
	
	@RequestMapping(value = "/quan-tri", method = RequestMethod.GET)
	public ModelAndView adminWeb() {
		ModelAndView mav = new ModelAndView("admin/home");
		return mav;
	}
	
	@RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
	public ModelAndView accessDenied() {
		return new ModelAndView("redirect:/dang-nhap?accessDenied");
	}
	
	@RequestMapping(value = "/thoat", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return new ModelAndView("redirect:/dang-nhap");
	}
	
}
