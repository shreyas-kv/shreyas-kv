package com.niit.shreyasmobilesBack;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shreyasmobilesBackend.Dao.CartDao;
import com.niit.shreyasmobilesBackend.Dao.CartItemsDao;
import com.niit.shreyasmobilesBackend.Dao.ProductDao;
import com.niit.shreyasmobilesBackend.Dao.UserDao;
import com.niit.shreyasmobilesBackend.model.Cart;
import com.niit.shreyasmobilesBackend.model.CartItems;
import com.niit.shreyasmobilesBackend.model.Product;
import com.niit.shreyasmobilesBackend.model.User;


public class CartTest {
	public static void main(String args[])
	{
		
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
	context.scan("com.niit.*");
	context.refresh();
	
	
	CartDao cartDao = (CartDao)context.getBean("cartDao");
	Cart cart = (Cart)context.getBean("cart");
	Product product =(Product) context.getBean("product");
	ProductDao productDao = (ProductDao) context.getBean("productDao");
	User user = (User) context.getBean("user");
	UserDao userDao = (UserDao) context.getBean("userDao");
	CartItems cartItems= (CartItems) context.getBean("cartItems");
	CartItemsDao cartItemsDao = (CartItemsDao) context.getBean("cartItemsDao");
	

	
	//cart.setCart_id("123");
	//cart.setTot_items("15");
	//cart.setTotal("1500");
	
	if(cartDao.saveupdate(cart)==true)
	{
		System.out.println("Successful");
	}
	else
	{
		System.out.println("Not saved");
	}
	
	
	user = userDao.get("USR7E3878");
	cart = user.getCart();
	if(cart.getCart_id()==null)
	{
		System.out.println("No dtat exists");
	}
	else
	{
		System.out.println("Data exists wieth id"+cart.getCart_id());
	}
	
	
	product = productDao.get("PRO7017A5");
	cartItems.setCart(cart);
    cartItems.setProduct(product);
    cartItems.setCartItem_price(product.getProd_price());
	
	cart.setTot_items(cart.getTot_items()+1);
	cart.setTotal(cart.getTotal()+product.getProd_price());
    
    if(cartDao.saveupdate(cart)==true)
	{
		System.out.println("Successful");
	}
	else
	{
		System.out.println("Not saved");
	}
	
    cart= cartDao.get("CARTE250C0");
    if(cartDao.delete(cart)==true){
       	System.out.println("Delete successfull");
       }
       else{
       	System.out.println("Sorry");
       }
	
	
//	Cart c = cartDao.get("123");
//	System.out.println("Cart id : "+c.getCart_id());
//	System.out.println("Cart total items : "+c.getTot_items());
//	System.out.println("Cart total : "+c.getTotal());
	}
}
