package com.laptrinhjavaweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	@RequestMapping(value = "/khach-hang/trang-chu", method = RequestMethod.GET)
	public ModelAndView homePageWeb() {
		ModelAndView mav = new ModelAndView("web/trangchu-home");
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
	
}
