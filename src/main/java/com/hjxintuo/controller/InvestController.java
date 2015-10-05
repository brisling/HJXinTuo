package com.hjxintuo.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hjxintuo.dao.AccountDAO;
import com.hjxintuo.dao.ProductDAO;
import com.hjxintuo.model.Account;
import com.hjxintuo.model.InvestRecord;
import com.hjxintuo.model.Product;
import com.hjxintuo.model.User;

@Controller  
public class InvestController {
	private Logger log = Logger.getLogger(InvestController.class);
	private ProductDAO productDao = new ProductDAO();
	private AccountDAO accountDao = new AccountDAO();
	
	@RequestMapping({"/invest"})
	public String investHome(ModelMap model) {
		log.info("hello invest !");
		
		/*
		// products
		List<Product> productList = new ArrayList<Product>();
		Product product = new Product();
		product.setId(1);
		product.setTitle("����ר��0069��");
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
		product.setTitle("�����03��");
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
		product.setTitle("�ž۽�0266��");
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
		product.setTitle("�ž۽�0265��");
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
		product.setTitle("�ž۽�0264��");
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
	public String productDetail(HttpSession session, HttpServletRequest request, ModelMap model) {
		log.info("hello product !");
		
		String id = request.getParameter("id");
		log.info(request.getParameter("id"));
		if (id == null)
		{
			log.info("product id is null.");
			return investHome(model);
		}
		
		Product product = (Product)productDao.find(Product.class, new Integer(id));
		model.put("product", product);
		
		User user = (User) session.getAttribute("user");
		if (user != null) {
			Account account = accountDao.getAccountForUser(user.getId());
			model.put("account", account);
		}
		
		return "invest/product_detail";
	}
	
	@RequestMapping("/invest/buy")
	@ResponseBody
	public Map<String, Object> doLogin(HttpServletRequest request, 
									   HttpSession session, 
									   @RequestParam("productId") 
									   Integer productId,
									   @RequestParam("investAmount")
									   float investNum) {
		log.info("buy: " + productId + ", $" + investNum); 
		
		Map<String, Object> data = new HashMap<String, Object>();
		
		User user = (User) session.getAttribute("user");
		if (user == null) {
			data.put("status", 1);
			data.put("redirectUrl", request.getContextPath()+"/login/");
			data.put("message", "请先登录");
			return data;
		} 
		
		Account account = accountDao.getAccountForUser(user.getId());
		if (account.getBalance() < investNum) {
			data.put("status", 1);
			data.put("redirectUrl", "");
			data.put("message", "购买失败，余额不足");
			return data;
		}
		
		InvestRecord investRecord = new InvestRecord();
		investRecord.setProductId(productId);
		investRecord.setDateCreated(new Date());
		investRecord.setInvestNum(investNum);
		investRecord.setUserId(user.getId());
		
		data.put("message", "购买成功");
		data.put("status", 0);
		data.put("redirectUrl", request.getContextPath()+"/account/");
		return data;
	}
}
