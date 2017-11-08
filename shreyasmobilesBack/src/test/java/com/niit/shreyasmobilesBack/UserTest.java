package com.niit.shreyasmobilesBack;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shreyasmobilesBackend.Dao.UserDao;
import com.niit.shreyasmobilesBackend.model.BillingAddress;
import com.niit.shreyasmobilesBackend.model.Cart;
import com.niit.shreyasmobilesBackend.model.User;

public class UserTest {
	public static void main(String args[])
	{
		AnnotationConfigApplicationContext context =  new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();
		
		UserDao userDao = (UserDao) context.getBean("userDao");
		User user =(User) context.getBean("user");
		
		BillingAddress billingAddress = (BillingAddress) context.getBean("billingAddress");
		Cart cart = (Cart) context.getBean("cart");
		
//		billingAddress.setB_city("Bangalore");
//		billingAddress.setB_hno("25");
//		billingAddress.setB_locality("Mg road");
//		billingAddress.setB_street("mystreet");
//		billingAddress.setB_pincode("560086");
//		billingAddress.setB_state("vhj");
//		
		
		//user.setUser_id("45");
		user.setUser_name("shreyas");
//		user.setUser_address("bangalore");
		user.setUser_emailid("ss@s.com");
//		user.setUser_enable("assdd");
		user.setUser_phno("888888888");
		user.setUser_role("admin");
		user.setUser_password("123");
		
	//	billingAddress.setUser(user);
		user.setBillingAddress(billingAddress);
		user.setCart(cart);
		
		//save or update
		if(userDao.saveupdate(user)==true)
		{
			System.out.println("Saved");
		}
		else
		{
			System.out.println("not saved");
		}
		//delete
//		
//		if(userDao.delete("45")==true)
//		{
//			System.out.println("Success");
//		}
//		else
//		{
//			System.out.println("Unsuccess");
//		}
		
//		User u = userDao.get("45");
		
		
		if(userDao.isvalid("ss@s.com","123")==null)
		{
			System.out.println("UnSuccess");
		}
		else
		{
			System.out.println("success");
		}
		
				
	}
}
