package com.niit.mobileFrontend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shreyasmobilesBackend.Dao.CategoryDao;
import com.niit.shreyasmobilesBackend.model.Category;



@Controller
public class CategoryController {
	@Autowired
	Category category;
	@Autowired
	CategoryDao categoryDao;
	
	
	
	@RequestMapping("/CategoryForm")
	public ModelAndView categoryform()
	{
		System.out.println("1");
		List<Category> categories= categoryDao.list();
		ModelAndView obj = new ModelAndView("CategoryForm");
		obj.addObject("category",new Category());
		obj.addObject("categories",categories);
		return obj;
	}
	
	@RequestMapping("/addcategory")
	public ModelAndView addcategory(@ModelAttribute("category")Category category)
	{
		ModelAndView obj = new ModelAndView("redirect:/CategoryForm");
		if(categoryDao.saveupdate(category))
		{
			obj.addObject("msg","category added successfully");
		}
		else
		{
			obj.addObject("msg","Sorry");
		}
		return obj;
	}
	
	@RequestMapping(value="/editCategory/{cat_id}")
	public ModelAndView editCategory(@PathVariable("cat_id") String cat_id)
	{
		List<Category> categoryList = categoryDao.list();
		category = categoryDao.get(cat_id);
		ModelAndView obj = new ModelAndView("CategoryForm");
		categoryDao.saveupdate(category);
		obj.addObject("categories",categoryList);
		obj.addObject("category",category);
		return obj;
	}
	@RequestMapping(value="/deleteCategory/{cat_id}")
	public ModelAndView deleteCategory(@PathVariable("cat_id") String cat_id)
	{
		category = categoryDao.get(cat_id);
		categoryDao.delete(category);
		String url="/CategoryForm";
		ModelAndView obj = new ModelAndView("redirect:"+url);
		
		return obj;
	}
	

}
