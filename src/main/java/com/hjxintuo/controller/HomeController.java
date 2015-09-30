package com.hjxintuo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hjxintuo.dao.ProductDAO;
import com.hjxintuo.model.Product;


@Controller  
public class HomeController {
	private Logger log = Logger.getLogger(HomeController.class);
	private ProductDAO productDao = new ProductDAO();
	
	@RequestMapping({"/", "/home"})
	public String home(HttpSession session, ModelMap model) {
		log.info("hello HJXintuo !");
		
		/*
		// products
		List<Product> productList = new ArrayList<Product>();
		Product product = new Product();
		//product.setId(1);
		product.setTitle("新手专享0069期");
		product.setCategory(0);
		product.setRateOfReturn(10.00f);
		product.setDays(31);
		product.setStatus(0);
		product.setMinBuy(100f);
		product.setBuyPeopleNum(5901);
		product.setAlreadyBuyNum(4216500f);
		productList.add(product);
		
		productDao.create(product);
		
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
		
		productDao.create(product);
		
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
		
		productDao.create(product);
		*/
	
		List<Product> productList = productDao.getHotProducts();
		model.put("hotProducts", productList);
		
		return "home/home";
	}
}
