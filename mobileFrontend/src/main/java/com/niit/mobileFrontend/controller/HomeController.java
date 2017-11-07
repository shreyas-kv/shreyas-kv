package com.niit.mobileFrontend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shreyasmobilesBackend.Dao.CategoryDao;
import com.niit.shreyasmobilesBackend.Dao.ProductDao;
import com.niit.shreyasmobilesBackend.model.Category;
import com.niit.shreyasmobilesBackend.model.Product;
import com.niit.shreyasmobilesBackend.model.User;

@Controller
public class HomeController {
	
	@Autowired
	ProductDao productDao;
	@Autowired
	Product product;
	
	@Autowired
	Category category;
	@Autowired
	CategoryDao categoryDao;
	
	
	@RequestMapping(value="/")
	public String index() 
	{
      return "redirect:/HomePage";
    }
	
	@RequestMapping(value="/HomePage")
	public ModelAndView home() 
	{
		ModelAndView obj = new ModelAndView("HomePage");
		
		List<Category> categories = categoryDao.list();
		obj.addObject("categories",categories);
		
		List<Product> producties = productDao.list();
		obj.addObject("producties",producties);
		
      return obj;
    }
	
	@RequestMapping(value="/Login")
	public ModelAndView login()
	{
		return new ModelAndView("Login");
	}
	
	
	
	
	@RequestMapping(value="/SignUp")
	public ModelAndView signup()
	{
	 ModelAndView obj=new ModelAndView("SignUp");
	 obj.addObject("user", new User());
		
	 return obj;
	}
	
	@RequestMapping(value="/ContactUs")
	public ModelAndView contactus()
	{
		return new ModelAndView("ContactUs");
	}
	
	@RequestMapping(value="/Thanku")
	public ModelAndView tanks()
	{
		return new ModelAndView("Thanks");
	}
	
	
	@RequestMapping(value="/HomeCates/{cat_id}")
	public ModelAndView homectes(@PathVariable("cat_id") String cat_id)
	{
		ModelAndView obj =  new ModelAndView("HomePage");
		
		List<Product> pr = productDao.GetProductByCategory(cat_id);
		obj.addObject("producties",pr);
		
		List<Category> categories = categoryDao.list();
		obj.addObject("categories",categories);
		
		return obj;
	}

}