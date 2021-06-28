package com.laptrinhjavaweb.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
	public ModelAndView homePageWeb(@RequestParam(value = "nameBrand") String name) {
		ModelAndView mav = new ModelAndView("web/trangchu-home");
		// list brand
		List<BrandDTO> mListBrand = new ArrayList<BrandDTO>();
		mListBrand = brandService.getAllBrand();
		mav.addObject("list", mListBrand);

		// list product newest
		List<ProductDTO> mListProductNewest = new ArrayList<ProductDTO>();
		mListProductNewest = productService.getAllProductNewest();
		for (ProductDTO product : mListProductNewest) {
			if(product.getDiscount() > 0) {
				product.setPrice(product.getDiscountPrice());
			}
			product.setConverterPrice(FormatNumber.formatNumber(product.getPrice()));
		}
		mav.addObject("listNewest", mListProductNewest);

		// list product is choiced
		List<ProductDTO> mListProductIsChoice = new ArrayList<ProductDTO>();
		mListProductIsChoice = productService.getAllProductIsChoice();
		for (ProductDTO product : mListProductIsChoice) {
			if(product.getDiscount() > 0) {
				product.setPrice(product.getDiscountPrice());
			}
			product.setConverterPrice(FormatNumber.formatNumber(product.getPrice()));
		}
		mav.addObject("listIsChoice", mListProductIsChoice);

		// list best product
		List<ProductDTO> mBestListProduct = new ArrayList<ProductDTO>();
		if (name.equals("All")) {
			mBestListProduct = productService.getBestProduct("all");
			for (ProductDTO product : mBestListProduct) {
				if(product.getDiscount() > 0) {
					product.setPrice(product.getDiscountPrice());
				}
				product.setConverterPrice(FormatNumber.formatNumber(product.getPrice()));
			}
			mav.addObject("listBest", mBestListProduct);
		} else {
			mBestListProduct = productService.getBestProduct(name);
			for (ProductDTO product : mBestListProduct) {
				if(product.getDiscount() > 0) {
					product.setPrice(product.getDiscountPrice());
				}
				product.setConverterPrice(FormatNumber.formatNumber(product.getPrice()));
			}
			mav.addObject("listBest", mBestListProduct);
		}

		// list product salest
		List<ProductDTO> mListProductSalest = new ArrayList<ProductDTO>();
		mListProductSalest = productService.getAllProductSalest();
		for (ProductDTO product : mListProductSalest) {
			if(product.getDiscount() > 0) {
				product.setPrice(product.getDiscountPrice());
			}
			product.setConverterPrice(FormatNumber.formatNumber(product.getPrice()));
		}
		mav.addObject("listSalest", mListProductSalest);
		cart(mav);
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
		cart(mav);
		return mav;
	}

	@RequestMapping(value = "/khach-hang/gio-hang", method = RequestMethod.GET)
	public ModelAndView shopCartPageWeb() {
		ModelAndView mav = new ModelAndView("web/trangchu-shop_cart");
		cart(mav);
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
	public ModelAndView registerWeb(@RequestParam(value = "duplicated", required = false) String name) {
		ModelAndView mav = new ModelAndView("register");
		if (name != null) {
			mav.addObject("duplicated", "asd");
		}
		UserDTO model = new UserDTO();
		mav.addObject("model", model);
		return mav;
	}

	@RequestMapping(value = "/customer/cua-hang", method = RequestMethod.GET)
	public ModelAndView test(@RequestParam("page") int page, @RequestParam("limit") int limit) {
		ModelAndView mav = new ModelAndView("test");
		Pageable pageable = new PageRequest(page - 1, limit);
		mav.addObject("page", page);

		// list brand
		List<BrandDTO> mListBrand = new ArrayList<BrandDTO>();
		mListBrand = brandService.getAllBrand();
		mav.addObject("list", mListBrand);

		// list product
		List<ProductDTO> mListProduct = new ArrayList<ProductDTO>();
		mListProduct = productService.getAllProduct(pageable);
		mav.addObject("totalPage", Math.ceil((double) productService.getTotalItem() / limit));
		for (ProductDTO product : mListProduct) {
			if(product.getDiscount() > 0) {
				product.setPrice(product.getDiscountPrice());
			}
			product.setConverterPrice(FormatNumber.formatNumber(product.getPrice()));
		}
		mav.addObject("listProduct123", mListProduct);

		// list product salest
		List<ProductDTO> mListProductSalest = new ArrayList<ProductDTO>();
		mListProductSalest = productService.getAllProductSalest();
		for (ProductDTO product : mListProductSalest) {
			if(product.getDiscount() > 0) {
				product.setPrice(product.getDiscountPrice());
			}
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
		mav.addObject("countProduct", productService.getTotalItem());
		cart(mav);

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

	public void cart(ModelAndView mav) {
		String list = cartService.getData().getList_product();
		if (!list.equals("")) {
			ArrayList<ProductDTO> listProduct = new ArrayList<ProductDTO>();
			ArrayList<ProductDTO> listProductTest = new ArrayList<ProductDTO>();
			
			//key is id of product
			//integer is amount of product
			Map<String, Integer> map = new TreeMap<String, Integer>();
			for (String result : list.split(",")) {
				ProductDTO productDTOTest = productService.getProduct(Long.valueOf(result));
				if(productDTOTest.getDiscount() != 0) {
					productDTOTest.setPrice(productDTOTest.getDiscountPrice());
				}
				
				//Put all product to list
				//To get product quantity
				//To get the total amount of the product
				listProductTest.add(productDTOTest);
				
				//Collect similar products 
				addElement(map, result);
			}
			for (String key : map.keySet()) {
				ProductDTO productDTO = productService.getProduct(Long.valueOf(key));
				if (productDTO.getDiscount() == 0) {
					productDTO.setConverterPrice(FormatNumber.formatNumber(productDTO.getPrice()));
					productDTO.setTotalPrice(FormatNumber.formatNumber(map.get(key) * productDTO.getPrice()));
				} else {
					productDTO.setPrice(productDTO.getDiscountPrice());
					productDTO.setConverterPrice(FormatNumber.formatNumber(productDTO.getDiscountPrice()));
					productDTO.setTotalPrice(FormatNumber.formatNumber(map.get(key) * productDTO.getDiscountPrice()));
				}
				//put amount to object product
				productDTO.setCount(map.get(key));
				//add object to list object
				listProduct.add(productDTO);
			}
			int price = totalPrice(listProductTest);
			mav.addObject("listProduct", listProduct);
			mav.addObject("count", listProductTest.size());
			mav.addObject("totalPrice", FormatNumber.formatNumber(price));
		} else {
			mav.addObject("count", 0);
			mav.addObject("totalPrice", FormatNumber.formatNumber(0));
		}
	}

	private void addElement(Map<String, Integer> map, String result) {
		if (map.containsKey(result)) {
			int count = map.get(result) + 1;
			map.put(result, count);
		} else {
			map.put(result, 1);
		} // TODO Auto-generated method stub

	}

}
