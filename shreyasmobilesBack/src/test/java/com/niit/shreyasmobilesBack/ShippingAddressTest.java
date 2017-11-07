package com.niit.shreyasmobilesBack;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shreyasmobilesBackend.Dao.ShippingAddressDao;
import com.niit.shreyasmobilesBackend.model.ShippingAddress;

public class ShippingAddressTest {
	public static void main(String args[])
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();
		
		
		ShippingAddressDao shippingaddressDao = (ShippingAddressDao)context.getBean("shippingaddressDao");
		ShippingAddress shippingaddress = (ShippingAddress)context.getBean("shippingAddress"); //shippingAddress is the model class name with first character in small letter
		
		shippingaddress.setS_id("123");
		shippingaddress.setS_hno("151");
		shippingaddress.setS_street("my street");
		shippingaddress.setS_locality("my locality");
		shippingaddress.setS_city("mycity");
		shippingaddress.setS_state("mystatle");
		shippingaddress.setS_pincode("my pincode");
		
		if(shippingaddressDao.saveupdate(shippingaddress)==true)
		{
			System.out.println("Successful");
		}
		else
		{
			System.out.println("Not saved");
		}
		
		
		
		ShippingAddress c = shippingaddressDao.get("123");
		System.out.println(c.getS_id());
		System.out.println(c.getS_hno());
		System.out.println(c.getS_street());
		System.out.println(c.getS_locality());
		System.out.println(c.getS_city());
		System.out.println(c.getS_state());
		System.out.println(c.getS_pincode());
		
		}
	}