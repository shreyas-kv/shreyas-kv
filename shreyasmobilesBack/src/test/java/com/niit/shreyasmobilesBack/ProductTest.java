package com.niit.shreyasmobilesBack;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shreyasmobilesBackend.Dao.CategoryDao;
import com.niit.shreyasmobilesBackend.Dao.ProductDao;
import com.niit.shreyasmobilesBackend.Dao.SupplierDao;
import com.niit.shreyasmobilesBackend.model.Category;
import com.niit.shreyasmobilesBackend.model.Product;
import com.niit.shreyasmobilesBackend.model.Supplier;



public class ProductTest {
	public static void main(String args[])
	{
		
	
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
	context.scan("com.niit.*");
	context.refresh();
		
	ProductDao productDao = (ProductDao)context.getBean("productDao");
	Product product = (Product)context.getBean("product");
	
	SupplierDao supplierDao = (SupplierDao)context.getBean("supplierDao");
	Supplier supplier =(Supplier)context.getBean("supplier");
	
	CategoryDao categoryDao = (CategoryDao)context.getBean("categoryDao");
	Category category = (Category)context.getBean("category");
	
	
	
	category = categoryDao.get("CATDB7196");
	product.setCategory(category);
	
	supplier = supplierDao.get("SUP226162");
	product.setSupplier(supplier);
	
	
	
	
	
	product.setProd_id("12553");
	product.setProd_name("Samsung s7");
	product.setProd_qty("25");
	product.setProd_price(50900);
	product.setProd_desc("Galaxy");
	//product.setProd_img("hello");
	
	// save or update
	if(productDao.saveupdate(product)==true)
	{
		System.out.println("Saved");
		
	}
	else
	{
		System.out.println("Not Saved");
	}
	
//	// delete
//	if(productDao.delete("123")==true)
//	{
//		System.out.println("Delete success");
//	}
//	else
//	{
//		System.out.println("unsuccess");
//	}
	
	Product p = productDao.get("12553");
	
	if(p==null)
	{
		System.out.println("p not found");
	}
	else
	{
		
	
	System.out.println(p.getProd_id());
	System.out.println(p.getProd_name());
	System.out.println(p.getProd_price());
	System.out.println(p.getProd_qty());
	System.out.println(p.getProd_desc());
	//System.out.println(p.getProd_img());

	}

	}
}
