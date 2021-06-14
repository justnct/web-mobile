package com.laptrinhjavaweb.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.FormatNumber;
import com.laptrinhjavaweb.dto.BrandDTO;
import com.laptrinhjavaweb.dto.ProductDTO;
import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.service.IBrandService;
import com.laptrinhjavaweb.service.ICartService;
import com.laptrinhjavaweb.service.IProductService;
import com.laptrinhjavaweb.util.MessageUtil;

@Controller
public class HomeController {
	@Autowired
	private MessageUtil messageUtil;

	@Autowired
	private IBrandService brandService;

	@Autowired
	private IProductService productService;

	@Autowired
	private ICartService cartService;

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
		for (ProductDTO product : mListProductNewest) {
			product.setConverterPrice(FormatNumber.formatNumber(product.getPrice()));
		}
		mav.addObject("listNewest", mListProductNewest);

		// list product is choiced
		List<ProductDTO> mListProductIsChoice = new ArrayList<ProductDTO>();
		mListProductIsChoice = productService.getAllProductIsChoice();
		for (ProductDTO product : mListProductIsChoice) {
			product.setConverterPrice(FormatNumber.formatNumber(product.getPrice()));
		}
		mav.addObject("listIsChoice", mListProductIsChoice);

		// list best product
		List<ProductDTO> mBestListProduct = new ArrayList<ProductDTO>();
		mBestListProduct = productService.getBestProduct();
		for (ProductDTO product : mBestListProduct) {
			product.setConverterPrice(FormatNumber.formatNumber(product.getPrice()));
		}
		mav.addObject("listBest", mBestListProduct);

		// list product salest
		List<ProductDTO> mListProductSalest = new ArrayList<ProductDTO>();
		mListProductSalest = productService.getAllProductSalest();
		for (ProductDTO product : mListProductSalest) {
			product.setConverterPrice(FormatNumber.formatNumber(product.getPrice()));
		}
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
		for (ProductDTO product : mListProduct) {
			product.setConverterPrice(FormatNumber.formatNumber(product.getPrice()));
		}
		mav.addObject("listProduct", mListProduct);

		// list product salest
		List<ProductDTO> mListProductSalest = new ArrayList<ProductDTO>();
		mListProductSalest = productService.getAllProductSalest();
		for (ProductDTO product : mListProductSalest) {
			product.setConverterPrice(FormatNumber.formatNumber(product.getPrice()));
		}
		mav.addObject("listSalest", mListProductSalest);

		// list product discount
		List<ProductDTO> mListProductDiscount = new ArrayList<ProductDTO>();
		mListProductDiscount = productService.getAllProductDiscount();
		for (ProductDTO product : mListProductDiscount) {
			product.setConverterPrice(FormatNumber.formatNumber(product.getPrice()));
			product.setConverterDisPrice(FormatNumber.formatNumber(product.getDiscountPrice()));
		}

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
			productDTO.setPrice(productDTO.getDiscountPrice());
		}
		productDTO.setConverterPrice(FormatNumber.formatNumber(productDTO.getPrice()));
		int i = 0;
		for (String img : productDTO.getNameLittleImg().split(",")) {
			i++;
			mav.addObject("img" + i, img);
		}
		mav.addObject("product", productDTO);
		return mav;
	}

	@RequestMapping(value = "/khach-hang/gio-hang", method = RequestMethod.GET)
	public ModelAndView shopCartPageWeb() {
		ModelAndView mav = new ModelAndView("web/trangchu-shop_cart");
		String list = cartService.getData().getList_product();
		if (!list.equals("")) {
			ArrayList<ProductDTO> listProduct = new ArrayList<ProductDTO>();
			for (String result : list.split(",")) {
				ProductDTO productDTO = productService.getProduct(Long.valueOf(result));
				if (productDTO.getDiscount() == 0) {
					productDTO.setConverterPrice(FormatNumber.formatNumber(productDTO.getPrice()));
				} else {
					productDTO.setPrice(productDTO.getDiscountPrice());
					productDTO.setConverterPrice(FormatNumber.formatNumber(productDTO.getDiscountPrice()));
				}
				listProduct.add(productDTO);
			}
			int price = totalPrice(listProduct);
			mav.addObject("listProduct", listProduct);
			mav.addObject("totalPrice", FormatNumber.formatNumber(price));
		}
		return mav;
	}

	private int totalPrice(ArrayList<ProductDTO> listProduct) {
		int total = 0;
		for (int i = 0; i < listProduct.size(); i++) {
			total += listProduct.get(i).getPrice();
		}
		return total;
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
	
	@RequestMapping(value = "/dang-ky", method = RequestMethod.GET)
	public ModelAndView registerWeb() {
		ModelAndView mav = new ModelAndView("register");
		UserDTO model = new UserDTO();
//		BrandDTO model = new BrandDTO();
		mav.addObject("model",model);
		return mav;
	}


	@RequestMapping(value = "/quan-tri", method = RequestMethod.GET)
	public ModelAndView adminWeb() {
		ModelAndView mav = new ModelAndView("admin/home");
		return mav;
	}

	@RequestMapping(value = "/quan-tri/danh-sach-sp", method = RequestMethod.GET)
	public ModelAndView adminListProduct(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("admin/list-product");
		// list product
		List<ProductDTO> mListProduct = new ArrayList<ProductDTO>();
		mListProduct = productService.getAllProduct();

		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("message", message.get("message"));
			mav.addObject("alert", message.get("alert"));
		}
		mav.addObject("listProduct", mListProduct);
		return mav;
	}

	@RequestMapping(value = "/quan-tri/danh-sach-user", method = RequestMethod.GET)
	public ModelAndView adminListUser() {
		ModelAndView mav = new ModelAndView("admin/list-user");
		return mav;
	}

	@RequestMapping(value = "/quan-tri/danh-sach-don-hang", method = RequestMethod.GET)
	public ModelAndView adminListOrder() {
		ModelAndView mav = new ModelAndView("admin/list-order");
		return mav;
	}

	@RequestMapping(value = "/quan-tri/chinh-sua-sp", method = RequestMethod.GET)
	public ModelAndView adminEditSP(@RequestParam(value = "id", required = false) Long id, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("admin/edit-product");
		ProductDTO model = new ProductDTO();
		if (id != null) {
			model = productService.findById(id);
		}
		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("message", message.get("message"));
			mav.addObject("alert", message.get("alert"));
		}
		mav.addObject("model", model);
		return mav;
	}

	@RequestMapping(value = "/quan-tri/them-sp", method = RequestMethod.GET)
	public ModelAndView adminAddSP(@RequestParam(value = "id", required = false) Long id, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("admin/insert-product");
		ProductDTO model = new ProductDTO();
		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("message", message.get("message"));
			mav.addObject("alert", message.get("alert"));
		}
		mav.addObject("model", model);
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
