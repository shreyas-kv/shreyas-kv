package com.niit.shreyasmobilesBackend.Dao;

import java.util.List;

import com.niit.shreyasmobilesBackend.model.Cart;
import com.niit.shreyasmobilesBackend.model.CartItems;

public interface CartItemsDao {

	public boolean saveupdate(CartItems cartItems);// true if succesful else
													// false
	// s returned

	public boolean delete(CartItems cartItems);

	public CartItems get(String cartitem_id);

	public List<CartItems> list();

	public List<CartItems> getCartItembyCartId(String cartId);
	
	public CartItems getlistall(String cartid,String prod_id);

}
