package com.laptrinhjavaweb.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.dto.BrandDTO;
import com.laptrinhjavaweb.dto.ProductDTO;
import com.laptrinhjavaweb.service.IBrandService;
import com.laptrinhjavaweb.service.IProductService;

@Controller
public class HomeController {

	@Autowired
	private IBrandService brandService;

	@Autowired
	private IProductService productService;

	@RequestMapping(value = "/khach-hang/trang-chu", method = RequestMethod.GET)
	public ModelAndView homePageWeb() {
		ModelAndView mav = new ModelAndView("web/trangchu-home");
		// list brand
		List<BrandDTO> mListBrand = new ArrayList<BrandDTO>();
		mListBrand = brandService.getAllBrand();
		mav.addObject("list", mListBrand);

		// list product newest
		List<ProductDTO> mListProductNewest = new ArrayList<ProductDTO>();
		mListProductNewest = productService.getAllProductNewest();
		mav.addObject("listNewest", mListProductNewest);

		// list product is choiced
		List<ProductDTO> mListProductIsChoice = new ArrayList<ProductDTO>();
		mListProductIsChoice = productService.getAllProductIsChoice();
		mav.addObject("listIsChoice", mListProductIsChoice);

		// list best product
		List<ProductDTO> mBestListProduct = new ArrayList<ProductDTO>();
		mBestListProduct = productService.getBestProduct();
		mav.addObject("listBest", mBestListProduct);

		// list product salest
		List<ProductDTO> mListProductSalest = new ArrayList<ProductDTO>();
		mListProductSalest = productService.getAllProductSalest();
		mav.addObject("listSalest", mListProductSalest);
		return mav;
	}

	@RequestMapping(value = "/khach-hang/cua-hang", method = RequestMethod.GET)
	public ModelAndView shopPageWeb() {
		ModelAndView mav = new ModelAndView("web/trangchu-shop_grid");
		// list brand
		List<BrandDTO> mListBrand = new ArrayList<BrandDTO>();
		mListBrand = brandService.getAllBrand();
		mav.addObject("list", mListBrand);

		// list product
		List<ProductDTO> mListProduct = new ArrayList<ProductDTO>();
		mListProduct = productService.getAllProduct();
		mav.addObject("listProduct", mListProduct);

		// list product salest
		List<ProductDTO> mListProductSalest = new ArrayList<ProductDTO>();
		mListProductSalest = productService.getAllProductSalest();
		mav.addObject("listSalest", mListProductSalest);

		// list product discount
		List<ProductDTO> mListProductDiscount = new ArrayList<ProductDTO>();
		mListProductDiscount = productService.getAllProductDiscount();
		mav.addObject("listDiscount", mListProductDiscount);

		// count product
		mav.addObject("countProduct", mListProduct.size());

		return mav;
	}

	@RequestMapping(value = "/khach-hang/chi-tiet-san-pham", method = RequestMethod.GET)
	public ModelAndView shopGridPageWeb(@RequestParam(value = "id") Long id) {
		ModelAndView mav = new ModelAndView("web/trangchu-shop_details");
		ProductDTO productDTO = productService.getProduct(id);
		if (productDTO.getDiscount() > 0) {
			productDTO.setPrice(productDTO.getPrice());
		}
		mav.addObject("product", productDTO);
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

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public ModelAndView Web() {
		ModelAndView mav = new ModelAndView("test");
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
