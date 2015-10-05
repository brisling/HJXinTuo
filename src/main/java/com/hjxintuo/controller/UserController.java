package com.hjxintuo.controller;

import java.util.HashMap;
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
import com.hjxintuo.dao.UserDAO;
import com.hjxintuo.model.Account;
import com.hjxintuo.model.User;

@Controller  
public class UserController {
	private Logger log = Logger.getLogger(UserController.class);
	private UserDAO userDao = new UserDAO();
	private AccountDAO accountDao = new AccountDAO();
	private final String REGISTER_PHONE = "registerPhone";
	
	@RequestMapping({"/login"})
	public String login(ModelMap model) {
		log.info("login !");
		
		return "account/login";
	}
	
	@RequestMapping("/do_login")
	@ResponseBody
	public Map<String, Object> doLogin(HttpServletRequest request, 
									   HttpSession session, 
									   @RequestParam("userName") 
									   String userName, 
									   @RequestParam("passwordMD5")
									   String password) {
		log.info("do_login"); 
		
		Map<String, Object> data = new HashMap<String, Object>();
		
		User user = userDao.getUserByNameAndPassword(userName, password);
		if (user == null) {
			data.put("status", 1);
			data.put("redirectUrl", request.getContextPath()+"/login/");
			data.put("message", "�û������������");
		} else {
			session.setAttribute("user", user);
			data.put("status", 0);
			data.put("redirectUrl", request.getContextPath()+"/account/");
		}
		return data;
	}
	
	@RequestMapping({"/logout"})
	public String logout(HttpSession session) {
		log.info("/logout");
		
		session.removeAttribute("user"); 
		return "redirect:/login "; 
	}
	
	@RequestMapping({"/account"})
	public String account(HttpSession session, ModelMap model) {
		log.info("/account");
		
		User user = (User)session.getAttribute("user"); 
		if (user == null) {
			log.info("pls login.");
			return "redirect:/login "; 
		}
		
		log.info("hello, " + user.getUserName() );
		
		Account account = accountDao.getAccountForUser(user.getId());
		model.put("account", account);
		
		return "account/my_account";
	}
	
	@RequestMapping({"/recharge"})
	@ResponseBody
	public Map<String, Object> recharge(HttpSession session, HttpServletRequest request) {
		
		Map<String, Object> data = new HashMap<String, Object>();
		
		User user = (User)session.getAttribute("user"); 
		if (user == null) {
			data.put("msg", "please login again !");
			data.put("redirectUrl", request.getContextPath()+"/login/");
			return data;
		}
		
		accountDao.recharge(user.getId(), 5000);
		data.put("msg", "【试用版】成功充值5000元");
		data.put("redirectUrl", request.getContextPath()+"/account/");
		return data;
	}
	
	@RequestMapping({"/register"})
	public String register(ModelMap model) {
		log.info("register !");
		
		return "account/register_step_1";
	}
	
	@RequestMapping({"/validate_phone"})
	@ResponseBody
	public boolean validatePhone(@RequestParam("phone") String userName) {
		log.info("validate phone: " + userName);
		
		return userDao.isUserNotExisting(userName);
	}
	
	@RequestMapping({"/do_register_step_1"})
	@ResponseBody
	public Map<String, Object> doRegisterStep1(HttpServletRequest request, 
											   HttpSession session,
											   @RequestParam("phone") 
											   String userName) {
		log.debug("do register step 1 !, phone: " + userName);
		
		Map<String, Object> data = new HashMap<String, Object>();
		
		if (userName == null) {
			data.put("status", 1);
			data.put("redirectUrl", request.getContextPath()+"/register/");
			return data;
		}
		
		session.setAttribute(REGISTER_PHONE, userName);
	
		data.put("status", 0);
		data.put("redirectUrl", request.getContextPath()+"/register_step_2/");
		return data;
	}
	
	@RequestMapping({"/register_step_2"})
	public String registerStep2(HttpSession session, ModelMap model) {
		log.info("register step 2 !");
		
		if (session.getAttribute(REGISTER_PHONE) == null) {
			return "redirect:/register";
		}
		
		return "account/register_step_2";
	}
	
	@RequestMapping({"/do_register_step_2"})
	@ResponseBody
	public Map<String, Object> doRegisterStep2(HttpServletRequest request, 
											   HttpSession session, 
											   String passwordMD5) {
		log.info("do register step 2 !");
		
		Map<String, Object> data = new HashMap<String, Object>();
		
		String userName = (String)session.getAttribute(REGISTER_PHONE);
		if (userName == null || userDao.isUserExisting(userName)) {
			data.put("status", 0);
			data.put("message", "�ֻ�����ע�ᣬ��ʹ����������");
			data.put("redirectUrl", request.getContextPath()+"/register/");
			return data;
		}
		
		log.info("username: " + userName + ", password: " + passwordMD5);
		User user = new User();
		user.setUserName(userName);
		user.setPassword(passwordMD5);
		userDao.create(user);
		
		// get user id from database;
		user = userDao.getUserByName(userName);
		session.setAttribute("user", user);
		
		// open account for user
		accountDao.openAccountForUser( user.getId() );
		
		// ��ֹˢ��ҳ������
		session.removeAttribute(REGISTER_PHONE);
		
		data.put("status", 0);
		data.put("redirectUrl", request.getContextPath()+"/register_step_3/");
		return data;
	}
	
	@RequestMapping({"/register_step_3"})
	public String registerStep3(ModelMap model, HttpSession session) {
		log.info("register step 3 !");
		
//		if (session.getAttribute("user") == null) {
//			return "redirect:/";
//		}
		return "account/register_step_3";
	}
}
