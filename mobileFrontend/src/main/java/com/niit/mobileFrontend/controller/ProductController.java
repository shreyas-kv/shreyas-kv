package com.niit.mobileFrontend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shreyasmobilesBackend.Dao.CategoryDao;
import com.niit.shreyasmobilesBackend.Dao.ProductDao;
import com.niit.shreyasmobilesBackend.Dao.SupplierDao;
import com.niit.shreyasmobilesBackend.model.Category;
import com.niit.shreyasmobilesBackend.model.Product;
import com.niit.shreyasmobilesBackend.model.Supplier;

import FileInput.FileInput;

@Controller
public class ProductController {
	@Autowired
	ProductDao productDao;
	@Autowired
	Product product;
	
	@Autowired
	Category category;
	@Autowired
	CategoryDao categoryDao;
	
	@Autowired
	Supplier supplier;
	@Autowired
	SupplierDao supplierDao;
	
	
	String path = "C:\\Users\\SHREYAS\\Desktop\\Project Workspace\\mobileFrontend\\src\\main\\webapp\\resources\\PImages\\";
	
	@RequestMapping("/ProductForm")
	public ModelAndView productform()
	{
		List<Product> producties = productDao.list();
		ModelAndView obj =  new ModelAndView("ProductForm");
		obj.addObject("product",new Product());
		obj.addObject("producties",producties);
		
				
		List<Category> categories = categoryDao.list();
		obj.addObject("categories",categories);
		
		List<Supplier> suppliers = supplierDao.list();
		obj.addObject("suppliers",suppliers);
		
		return obj;
	}
	
	@RequestMapping(value="/addproduct",method= RequestMethod.POST)
	public ModelAndView addproduct(@ModelAttribute("product") Product product)
	{
		ModelAndView obj =  new ModelAndView("redirect:/ProductForm");
		
		if(productDao.saveupdate(product)==true)
		{
			FileInput.upload(path,product.getProd_img(),product.getProd_id()+".jpg");
			
			obj.addObject("msg","Product added success");
		}
		else{
			obj.addObject("msg","Product failed");
		}
		return obj;
		
	}
	
	@RequestMapping(value="/editProduct/{pro_id}")
	public ModelAndView editCategory(@PathVariable("pro_id") String pro_id)
	{
		List<Product> productList = productDao.list();
		List<Supplier> suppliers = supplierDao.list();
		List<Category> categories = categoryDao.list();
		
		
		product = productDao.get(pro_id);
		ModelAndView obj = new ModelAndView("ProductForm");
		productDao.saveupdate(product);
		obj.addObject("producties",productList);
		obj.addObject("product",product);

		obj.addObject("suppliers",suppliers);
		obj.addObject("categories",categories);

		return obj;
	}
	@RequestMapping(value="/deleteProduct/{pro_id}")
	public ModelAndView deleteCategory(@PathVariable("pro_id") String pro_id)
	{
		product = productDao.get(pro_id);
		productDao.delete(product);
		String url="/ProductForm";
		ModelAndView obj = new ModelAndView("redirect:"+url);
		
		return obj;
	}
	
	

}
