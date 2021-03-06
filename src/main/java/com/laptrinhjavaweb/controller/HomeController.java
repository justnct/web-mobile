package com.laptrinhjavaweb.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.FormatNumber;
import com.laptrinhjavaweb.converter.ProductConverter;
import com.laptrinhjavaweb.dto.BrandDTO;
import com.laptrinhjavaweb.dto.ProductDTO;
import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.entity.ProductEntity;
import com.laptrinhjavaweb.service.IBrandService;
import com.laptrinhjavaweb.service.ICartService;
import com.laptrinhjavaweb.service.ICookieService;
import com.laptrinhjavaweb.service.IProductService;
import com.laptrinhjavaweb.service.IUser;
import com.laptrinhjavaweb.util.MessageUtil;
import com.laptrinhjavaweb.util.SecurityUtils;

@Controller
public class HomeController {
	@Autowired
	private ProductConverter productConverter;

	@Autowired
	private MessageUtil messageUtil;

	@Autowired
	private IBrandService brandService;

	@Autowired
	private IProductService productService;

	@Autowired
	private IUser userService;

	@Autowired
	private ICartService cartService;

	@Autowired
	private ICookieService cookieService;

	@RequestMapping(value = "/khach-hang/trang-chu", method = RequestMethod.GET)
	public ModelAndView homePageWeb(@RequestParam(value = "nameBrand") String name, HttpServletResponse response,
			HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("web/trangchu-home");
		// list brand
		List<BrandDTO> mListBrand = new ArrayList<BrandDTO>();
		mListBrand = brandService.getAllBrand();
		mav.addObject("list", mListBrand);

		// list product newest
		List<ProductDTO> mListProductNewest = new ArrayList<ProductDTO>();
		mListProductNewest = productService.getAllProductNewest();
		for (ProductDTO product : mListProductNewest) {
			if (product.getDiscount() > 0) {
				product.setPrice(product.getDiscountPrice());
			}
			product.setConverterPrice(FormatNumber.formatNumber(product.getPrice()));
		}
		mav.addObject("listNewest", mListProductNewest);

		// list product is choiced
		List<ProductDTO> mListProductIsChoice = new ArrayList<ProductDTO>();
		mListProductIsChoice = productService.getAllProductIsChoice();
		for (ProductDTO product : mListProductIsChoice) {
			if (product.getDiscount() > 0) {
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
				if (product.getDiscount() > 0) {
					product.setPrice(product.getDiscountPrice());
				}
				product.setConverterPrice(FormatNumber.formatNumber(product.getPrice()));
			}
			mav.addObject("listBest", mBestListProduct);
		} else {
			mBestListProduct = productService.getBestProduct(name);
			for (ProductDTO product : mBestListProduct) {
				if (product.getDiscount() > 0) {
					product.setPrice(product.getDiscountPrice());
				}
				product.setConverterPrice(FormatNumber.formatNumber(product.getPrice()));
			}
			mav.addObject("listBest", mBestListProduct);
		}

		// list iphone

		// list product salest
		List<ProductDTO> mListProductSalest = new ArrayList<ProductDTO>();
		mListProductSalest = productService.getAllProductSalest();
		for (ProductDTO product : mListProductSalest) {
			if (product.getDiscount() > 0) {
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
	public ModelAndView registerWeb() {
		ModelAndView mav = new ModelAndView("register");
		UserDTO model = new UserDTO();
		mav.addObject("model", model);
		return mav;
	}

	@RequestMapping(value = "/khach-hang/cua-hang", method = RequestMethod.GET)
	public ModelAndView test(@RequestParam("page") int page, @RequestParam("limit") int limit,
			@RequestParam("sort") String sort) {
		ModelAndView mav = new ModelAndView("web/trangchu-shop_grid");

		Pageable pageable = new PageRequest(page - 1, limit);
		mav.addObject("page", page);

		// list brand
		List<BrandDTO> mListBrand = new ArrayList<BrandDTO>();
		mListBrand = brandService.getAllBrand();
		mav.addObject("list", mListBrand);

		// list product
		List<ProductDTO> mListProduct = new ArrayList<ProductDTO>();
		if (sort.equals("normal")) {
			mListProduct = productService.getAllProduct(pageable);
			mav.addObject("kimochi",
					"<option value=\"normal\">M???c ?????nh</option>\r\n"
							+ "	<option value=\"asc\">Gi?? th???p -> cao</option>\r\n"
							+ "	<option value=\"desc\">Gi?? cao -> th???p</option>");
		} else if (sort.equals("asc")) {
			Pageable pageable1 = new PageRequest(page - 1, limit, Direction.ASC, "price");
			mListProduct = productService.getAllProductOrderByPrice(pageable1);
			mav.addObject("kimochi",
					"	<option value=\"asc\">Gi?? th???p -> cao</option>\r\n"
							+ "<option value=\"normal\">M???c ?????nh</option>\r\n"
							+ "	<option value=\"desc\">Gi?? cao -> th???p</option>");
		} else {
			Pageable pageable1 = new PageRequest(page - 1, limit, Direction.DESC, "price");
			mListProduct = productService.getAllProductOrderByPrice(pageable1);
			mav.addObject("kimochi",
					"	<option value=\"desc\">Gi?? cao -> th???p</option>"
							+ "	<option value=\"asc\">Gi?? th???p -> cao</option>\r\n"
							+ "<option value=\"normal\">M???c ?????nh</option>\r\n");
		}

		// calc total page
		int totalPage = (productService.getTotalItem() % limit == 0) ? productService.getTotalItem() / limit
				: productService.getTotalItem() / limit + 1;
		ArrayList<Integer> listPage = new ArrayList<Integer>();
		for (int i = 0; i < totalPage; i++) {
			listPage.add(i + 1);
		}
		// put list page
		mav.addObject("listPage", listPage);

		// put sort
		mav.addObject("sort", sort);

		// put totalPage
		mav.addObject("totalPage", totalPage);

		if (page != totalPage) {
			mav.addObject("numberOfDisplays", limit);
		} else {
			int numberOfDisplays = (productService.getTotalItem() % limit == 0) ? limit
					: productService.getTotalItem() - (limit * (page - 1));
			mav.addObject("numberOfDisplays", numberOfDisplays);
		}

		for (ProductDTO product : mListProduct) {
			if (product.getDiscount() > 0) {
				product.setPrice(product.getDiscountPrice());
			}
			product.setConverterPrice(FormatNumber.formatNumber(product.getPrice()));
		}
		mav.addObject("listProduct123", mListProduct);

		// list product salest
		List<ProductDTO> mListProductSalest = new ArrayList<ProductDTO>();
		mListProductSalest = productService.getAllProductSalest();
		for (ProductDTO product : mListProductSalest) {
			if (product.getDiscount() > 0) {
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
		// list user
		List<UserDTO> mList = new ArrayList<UserDTO>();
		mList = userService.getAllUser();
		mav.addObject("listUser", mList);
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

	@RequestMapping(value = "/quan-tri/chinh-sua-sp", method = RequestMethod.POST)
	public ModelAndView adminEditSPPost(@ModelAttribute("model") ProductDTO productDTO,
			@RequestParam(value = "image", required = false) MultipartFile photo) {
		productDTO.setNameImg(saveFile(photo) + ".jpg");
		productService.update(productDTO);
		return new ModelAndView("redirect:/quan-tri/danh-sach-sp");
	}

	@RequestMapping(value = "/quan-tri/chinh-sua-user", method = RequestMethod.GET)
	public ModelAndView adminEditUser(@RequestParam(value = "id", required = false) Long id,
			HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("admin/edit-user");
		UserDTO model = new UserDTO();
		if (id != null) {
			model = userService.findById(id);
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

	@RequestMapping(value = "/quan-tri/them-sp", method = RequestMethod.POST)
	public ModelAndView test(@ModelAttribute("model") ProductDTO productDTO,
			@RequestParam(value = "image", required = false) MultipartFile photo) {
		productDTO.setNameImg(saveFile(photo) + ".jpg");
		productService.insert(productDTO);
		return new ModelAndView("redirect:/quan-tri/danh-sach-sp");
	}

	private String saveFile(MultipartFile file) {
		if (file != null && !file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();
				// folder to save img
				File dir = new File(
						"C:\\Users\\Admin\\Documents\\GitHub\\web-mobile\\src\\main\\webapp\\template\\web\\img\\web\\product");
				File serverFile = new File(dir.getAbsoluteFile()+ File.separator + file.getName() +".jpg");
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile.getPath()));
				stream.write(bytes);
				stream.close();
				return file.getName();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	@RequestMapping(value = "/quan-tri/them-user", method = RequestMethod.GET)
	public ModelAndView adminAddUser(@RequestParam(value = "id", required = false) Long id,
			HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("admin/insert-user");
		UserDTO model = new UserDTO();
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

			// key is id of product
			// integer is amount of product
			Map<String, Integer> map = new TreeMap<String, Integer>();
			for (String result : list.split(",")) {
				ProductDTO productDTOTest = productService.getProduct(Long.valueOf(result));
				if (productDTOTest.getDiscount() != 0) {
					productDTOTest.setPrice(productDTOTest.getDiscountPrice());
				}

				// Put all product to list
				// To get product quantity
				// To get the total amount of the product
				listProductTest.add(productDTOTest);

				// Collect similar products
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
				// put amount to object product
				productDTO.setCount(map.get(key));
				// add object to list object
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

		// count like product
		int count = 0;
		String listLike = cookieService.getCookieValue(SecurityUtils.getPrincipal().getUserName(), "0");
		if (listLike.equals("0") || listLike.contains("0")) {
			mav.addObject("amountLike", 0);
		} else {
			for (String result : listLike.split("-")) {
				count++;
			}
			mav.addObject("amountLike", count);
		}
	}

	@RequestMapping(value = "/khach-hang/search", method = RequestMethod.GET)
	public ModelAndView search(@RequestParam String keyword) {
		List<ProductEntity> mListProduct = productService.search(keyword);
		List<ProductDTO> result = new ArrayList<ProductDTO>();
		for (ProductEntity item : mListProduct) {
			ProductDTO product = productConverter.converterToDTO(item);
			product.setConverterPrice(FormatNumber.formatNumber(product.getPrice()));
			result.add(product);
		}
		ModelAndView mav = new ModelAndView("web/trangchu-search");
		mav.addObject("result", result);
		return mav;
	}

	private void addElement(Map<String, Integer> map, String result) {
		if (map.containsKey(result)) {
			int count = map.get(result) + 1;
			map.put(result, count);
		} else {
			map.put(result, 1);
		} // TODO Auto-generated method stub

	}

	@RequestMapping(value = "/khach-hang/cac-san-pham", method = RequestMethod.GET)
	public ModelAndView productClassification(@RequestParam("nameBrand") String type) {
		ModelAndView mav = new ModelAndView("web/xiaomi");
		List<ProductDTO> mListProduct = new ArrayList<ProductDTO>();
		if (type.equals("All")) {
			mListProduct = productService.getAllProduct();
		} else {
			mListProduct = productService.getAllProductByName(type);
		}

		for (ProductDTO product : mListProduct) {
			if (product.getDiscount() > 0) {
				product.setPrice(product.getDiscountPrice());
			}
			product.setConverterPrice(FormatNumber.formatNumber(product.getPrice()));
		}
		cart(mav);
		mav.addObject("xiaomi", mListProduct);
		return mav;

	}

	@RequestMapping(value = "/khach-hang/yeu-thich", method = RequestMethod.GET)
	public ModelAndView like() {
		ModelAndView mav = new ModelAndView("web/favoriteProducts");
		List<ProductDTO> mListProduct = new ArrayList<ProductDTO>();
		String listLike = cookieService.getCookieValue(SecurityUtils.getPrincipal().getUserName(), "0");
		for (String result : listLike.split("-")) {
			if (Long.valueOf(result) > 0) {
				ProductDTO productDTO = productService.findById(Long.valueOf(result));
				if (productDTO.getDiscount() > 0) {
					productDTO.setPrice(productDTO.getDiscountPrice());
				}
				productDTO.setConverterPrice(FormatNumber.formatNumber(productDTO.getPrice()));
				mListProduct.add(productDTO);
			}
		}
		cart(mav);
		mav.addObject("xiaomi", mListProduct);
		return mav;

	}

}
