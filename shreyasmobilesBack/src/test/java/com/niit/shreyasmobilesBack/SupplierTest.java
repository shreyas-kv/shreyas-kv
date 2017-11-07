package com.niit.shreyasmobilesBack;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shreyasmobilesBackend.Dao.ProductDao;
import com.niit.shreyasmobilesBackend.Dao.SupplierDao;
import com.niit.shreyasmobilesBackend.model.Product;
import com.niit.shreyasmobilesBackend.model.Supplier;



public class SupplierTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();
		
		SupplierDao supplierDao = (SupplierDao) context.getBean("supplierDao");
		Supplier supplier =(Supplier) context.getBean("supplier");
		
		Product product = (Product) context.getBean("product");
		ProductDao productDao = (ProductDao)context.getBean("productDao");	
	
		
		supplier.setSup_id("12");
		supplier.setSup_name("ADC");
		supplier.setSup_addr("Mysore");
		supplier.setSup_phno("999999999");
		
		if(supplierDao.saveupdate(supplier)==true)
		{
			System.out.println("Saved");
			
		}
		else
		{
			System.out.println("Not saved");
		}
		
		
		supplier = supplierDao.get("200");
        List<Product> P = productDao.GetProductBySupplier(supplier.getSup_id());
        if(P==null || P.isEmpty())
        {
        	supplierDao.delete(supplier);
        }
        else
        {
         for(Product pr:P)
         {
        	 productDao.delete(pr);
         }
         if(supplierDao.delete(supplier)==true)
        	 System.out.println("supplier deleted");
         else
        	 System.out.println("supplier not deleted");
        }
        
        
//		if(supplierDao.delete("200")==true){
//			System.out.println("delete success");
//		}
//		else
//	    System.out.println("sorry");
	
		
//		if(supplierDao.delete("55")==true)
//		{
//			System.out.println("Sucessful");
//			
//		}
//		else
//		{
//			System.out.println("Unsuccessful");
//		}
		
		Supplier s = supplierDao.get("12");
		System.out.println(s.getSup_id());
		System.out.println(s.getSup_name());
		System.out.println(s.getSup_addr());
		System.out.println(s.getSup_phno());
	}

}
