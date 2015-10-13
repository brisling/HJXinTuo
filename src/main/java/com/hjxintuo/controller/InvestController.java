package com.hjxintuo.controller;

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
import com.hjxintuo.dao.InvestRecordDAO;
import com.hjxintuo.dao.ProductDAO;
import com.hjxintuo.model.Account;
import com.hjxintuo.model.Product;
import com.hjxintuo.model.User;

@Controller  
public class InvestController {
	private Logger log = Logger.getLogger(InvestController.class);
	private ProductDAO productDao = new ProductDAO();
	private AccountDAO accountDao = new AccountDAO();
	private InvestRecordDAO investRecordDao = new InvestRecordDAO();
	
	@RequestMapping({"/invest"})
	public String investHome(ModelMap model) {
		log.info("hello invest !");
		
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
	public Map<String, Object> buy(HttpServletRequest request, 
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
			data.put("message", "请先登录");
			log.info("请先登录");
			return data;
		} 
		
		int ret = investRecordDao.buy(user.getId(), productId, investNum);
		
		if (0 == ret) {
			data.put("message", "购买成功");
			data.put("status", 0);
			data.put("redirectUrl", request.getContextPath()+"/account/");
			log.info("购买成功");
		}else if (-2 == ret) {
			data.put("status", 1);
			data.put("message", "余额不足");
			log.info("余额不足");
		}else {
			data.put("status", 1);
			data.put("message", "购买失败，请重试");
			log.info("购买失败");
		}
		return data;
	}
}
