package com.niit.mobileFrontend.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.ModelAndView;

import com.niit.shreyasmobilesBackend.Dao.UserDao;
import com.niit.shreyasmobilesBackend.model.BillingAddress;
import com.niit.shreyasmobilesBackend.model.User;

@Controller
@Transactional
public class UserController {
	@Autowired
	User user;
	@Autowired
	UserDao userDao;
	
	@RequestMapping(value="/adduser")
	public ModelAndView adduser(@ModelAttribute("user")User user)
	{    	
		BillingAddress b=user.getBillingAddress();
		//b.setUser(user);
		user.setBillingAddress(b);
		ModelAndView obj =  new ModelAndView("redirect:/SignUp");
		if(userDao.saveupdate(user)==true)
		{
			obj.addObject("mesg1","user added successfully");
		}
		else
		{
			obj.addObject("mesg2","user adding failed");
		}
		
		return obj;
	}

}
