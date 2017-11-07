package com.niit.mobileFrontend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.niit.shreyasmobilesBackend.Dao.SupplierDao;

import com.niit.shreyasmobilesBackend.model.Supplier;

@Controller
public class SupplierController {
	@Autowired
	Supplier supplier;
	@Autowired
	SupplierDao supplierDao;
	
	
	
	@RequestMapping("/SupplierForm")
	public ModelAndView supplierform()
	{
		System.out.println("1");
		List<Supplier> suppliers= supplierDao.list();
		ModelAndView obj = new ModelAndView("SupplierForm");
		obj.addObject("supplier",new Supplier());
		obj.addObject("suppliers",suppliers);
		return obj;
	}
	
	@RequestMapping("/addsupplier")
	public ModelAndView addsupplier(@ModelAttribute("suppliersss")Supplier supplier)
	{
		ModelAndView obj = new ModelAndView("redirect:/SupplierForm");
		if(supplierDao.saveupdate(supplier))
		{
			obj.addObject("msg","supplier added successfully");
		}
		else
		{
			obj.addObject("msg","Sorry");
		}
		return obj;
	}

	@RequestMapping("/editSupplier/{supid}")
	public ModelAndView editsupplier(@PathVariable("supid") String suid)
	{
		List<Supplier> slist = supplierDao.list();
		supplier = supplierDao.get(suid);
		ModelAndView obj = new ModelAndView("SupplierForm");
		supplierDao.saveupdate(supplier);
		obj.addObject("supplier",supplier);
		obj.addObject("slist",slist);
		
		return obj;
	}
	
	@RequestMapping("/deleteSupplier/{supid}")
	public ModelAndView deletesupplier(@PathVariable("supid") String suid)
	{
		supplier = supplierDao.get(suid);
		supplierDao.delete(supplier);
		String url="/SupplierForm";
		ModelAndView obj = new ModelAndView("redirect:"+url);
		return obj;
	}

}
