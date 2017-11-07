package com.niit.shreyasmobilesBack;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shreyasmobilesBackend.Dao.CategoryDao;
import com.niit.shreyasmobilesBackend.Dao.ProductDao;
import com.niit.shreyasmobilesBackend.model.Category;
import com.niit.shreyasmobilesBackend.model.Product;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.Annotated;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.Annotation;

public class CategoryTest {
	public static void main(String args[])
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();
		
		CategoryDao categoryDao =(CategoryDao)context.getBean("categoryDao");
		Category category=(Category)context.getBean("category");
		
		Product product = (Product) context.getBean("product");
		ProductDao productDao = (ProductDao)context.getBean("productDao");
		
		
		category.setCat_id("Mob 3");
		category.setCat_name("Lenovo");
		category.setCat_desc("Vibe X3");
		
		
		// save and update
		if(categoryDao.saveupdate(category)==true)
				{
			System.out.println("Saved");
		}
		else
		{
			System.out.println("Sorry not saved");
		}
		
		category = categoryDao.get("Mob 3");
        List<Product> P = productDao.GetProductByCategory(category.getCat_id());
        if(P == null || P.isEmpty())
        {
        	categoryDao.delete(category);
        }
        else
        {
         for(Product pr:P)
         {
        	 productDao.delete(pr);
         }
         if(categoryDao.delete(category)==true)
        	 System.out.println("category deleted");
         else
        	 System.out.println("category not deleted");
        }
		
		// delete
		
//		if(categoryDao.delete("Mob 3")==true)
//		{
//			System.out.println("Delete successful");
//		}
//		else
//		{
//			System.out.println("Delete not successful");
//		}
//		
        
        
        
		Category c = categoryDao.get("Mob 3");
		System.out.println("Category id : "+c.getCat_id());
		System.out.println("Category name : "+c.getCat_name());
		System.out.println("Category desc : "+c.getCat_desc());
		
		List<Category> l = categoryDao.list();
		for(Category c1:l){
			System.out.println(c1.getCat_id());
			System.out.println(c1.getCat_name());
			System.out.println(c1.getCat_desc());
			
		}
	}

}
