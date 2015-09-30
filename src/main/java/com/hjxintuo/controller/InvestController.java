package com.hjxintuo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hjxintuo.dao.ProductDAO;
import com.hjxintuo.model.Product;

@Controller  
public class InvestController {
	private Logger log = Logger.getLogger(InvestController.class);
	private ProductDAO productDao = new ProductDAO();
	
	@RequestMapping({"/invest"})
	public String investHome(ModelMap model) {
		log.info("hello invest !");
		
		/*
		// products
		List<Product> productList = new ArrayList<Product>();
		Product product = new Product();
		product.setId(1);
		product.setTitle("新手专享0069期");
		product.setCategory(0);
		product.setRateOfReturn(10.00f);
		product.setDays(31);
		product.setStatus(0);
		product.setMinBuy(100f);
		product.setBuyPeopleNum(5901);
		product.setAlreadyBuyNum(4216500f);
		productList.add(product);
		
		product = new Product();
		product.setId(2);
		product.setTitle("存得乐03期");
		product.setCategory(1);
		product.setRateOfReturn(9.50f);
		product.setDays(81);
		product.setStatus(0);
		product.setMinBuy(2000f);
		product.setBuyPeopleNum(1005);
		product.setAlreadyBuyNum(342610f);
		productList.add(product);
		
		product = new Product();
		product.setId(3);
		product.setTitle("信聚金0266期");
		product.setCategory(2);
		product.setRateOfReturn(8.50f);
		product.setDays(356);
		product.setStatus(0);
		product.setMinBuy(1000f);
		product.setBuyPeopleNum(2133);
		product.setAlreadyBuyNum(1045600f);
		productList.add(product);
		
		product = new Product();
		product.setId(4);
		product.setTitle("信聚金0265期");
		product.setCategory(3);
		product.setRateOfReturn(8.50f);
		product.setDays(121);
		product.setStatus(0);
		product.setMinBuy(1000f);
		product.setBuyPeopleNum(4201);
		product.setAlreadyBuyNum(2342610f);
		productList.add(product);
		
		product = new Product();
		product.setId(5);
		product.setTitle("信聚金0264期");
		product.setCategory(2);
		product.setRateOfReturn(8.50f);
		product.setDays(91);
		product.setStatus(0);
		product.setMinBuy(1000f);
		product.setBuyPeopleNum(201);
		product.setAlreadyBuyNum(622120f);
		productList.add(product);
		*/
		
		List<Product> productList = productDao.list();
		model.put("productList", productList);
		
		return "invest/invest_home";
	}

	@RequestMapping({"/invest/product"})
	public String productDetail(HttpServletRequest request, ModelMap model) {
		log.info("hello product !");
		
		String id = request.getParameter("id");
		log.info(request.getParameter("id"));
		if (id == null)
		{
			log.info("product id is null.");
			return investHome(model);
		}
		
		/*
		Product product = new Product();
		product.setId( new Integer(id) );
		product.setTitle("新手专享0069期");
		product.setCategory(0);
		product.setRateOfReturn(10.00f);
		product.setDays(31);
		product.setStatus(0);
		product.setMinBuy(100f);
		product.setBuyPeopleNum(5901);
		product.setAlreadyBuyNum(4216500f);
		*/
		
		Product product = (Product)productDao.find(Product.class, new Integer(id));
		model.put("product", product);
		
		return "invest/product_detail";
	}
}
