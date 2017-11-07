package com.niit.shreyasmobilesBack;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shreyasmobilesBackend.Dao.BillingAddressDao;
import com.niit.shreyasmobilesBackend.model.BillingAddress;


public class BillingAddressTest {
	public static void main(String args[])
	{
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
	context.scan("com.niit.*");
	context.refresh();
	
	
	BillingAddressDao billingaddressDao = (BillingAddressDao)context.getBean("billingaddressDao");
	BillingAddress billingaddress = (BillingAddress)context.getBean("billingAddress");
	
//	billingaddress.setB_id("123");
	billingaddress.setB_hno("151");
	billingaddress.setB_street("my street");
	billingaddress.setB_locality("my locality");
	billingaddress.setB_city("mycity");
	billingaddress.setB_state("mystatle");
	billingaddress.setB_pincode("my pincode");
	
	if(billingaddressDao.saveupdate(billingaddress)==true)
	{
		System.out.println("Successful");
	}
	else
	{
		System.out.println("Not saved");
	}
	
	
	
	BillingAddress c = billingaddressDao.get("123");
	System.out.println(c.getB_id());
	System.out.println(c.getB_hno());
	System.out.println(c.getB_street());
	System.out.println(c.getB_locality());
	System.out.println(c.getB_city());
	System.out.println(c.getB_state());
	System.out.println(c.getB_pincode());
	
	}
}

