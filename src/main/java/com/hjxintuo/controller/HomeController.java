package com.hjxintuo.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hjxintuo.dao.InvestRecordDAO;
import com.hjxintuo.dao.ProductDAO;
import com.hjxintuo.dao.UserDAO;
import com.hjxintuo.model.InvestRecord;
import com.hjxintuo.model.Product;
import com.hjxintuo.model.User;


@Controller  
public class HomeController {
	private Logger log = Logger.getLogger(HomeController.class);
	private ProductDAO productDao = new ProductDAO();
	private UserDAO userDao = new UserDAO();
	private InvestRecordDAO investRecordDao = new InvestRecordDAO();
	
	@RequestMapping({"/", "/home"})
	public String home(HttpSession session, ModelMap model) {
		log.info("hello HJXintuo !");
	
		List<Product> productList = productDao.getHotProducts();
		model.put("hotProducts", productList);
		
		return "home/home";
	}
	
	@RequestMapping({"/test"})
	public String test(HttpSession session, ModelMap model) {
		log.info("test " + new Date().getTime());
		investRecordDao.getInvestRecordForUser(11);

		return "home/test";
	}
}
