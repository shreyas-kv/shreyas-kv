package com.niit.mobileFrontend.controller;

import java.util.List;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shreyasmobilesBackend.Dao.CartDao;
import com.niit.shreyasmobilesBackend.Dao.CartItemsDao;
import com.niit.shreyasmobilesBackend.Dao.ProductDao;
import com.niit.shreyasmobilesBackend.Dao.UserDao;
import com.niit.shreyasmobilesBackend.model.Cart;
import com.niit.shreyasmobilesBackend.model.CartItems;
import com.niit.shreyasmobilesBackend.model.Product;
import com.niit.shreyasmobilesBackend.model.User;

@Controller
class CartController {

	@Autowired
	Cart cart;
	@Autowired
	CartDao cartDao;
	@Autowired
	User user;
	@Autowired
	UserDao userDao;
	@Autowired
	Product product;
	@Autowired
	ProductDao productDao;
	@Autowired
	CartItemsDao cartItemsDao;

	@Autowired
	HttpSession session;

	@RequestMapping("/CartForm")
	public ModelAndView cartform() {
		System.out.println("1");
		List<Cart> carties = cartDao.list();
		ModelAndView obj = new ModelAndView("CartForm");
		obj.addObject("cart", new Cart());
		obj.addObject("carties", carties);
		return obj;
	}

	@RequestMapping("/addcart")
	public ModelAndView addcart(@ModelAttribute("cart") Cart cart) {
		ModelAndView obj = new ModelAndView("redirect:/CartForm");
		if (cartDao.saveupdate(cart)) {
			obj.addObject("msg", "cart added successfully");
		} else {
			obj.addObject("msg", "Sorry");
		}
		return obj;
	}

	@RequestMapping(value = "/addCart/{prod_id}")
	public ModelAndView addCart(@PathVariable("prod_id") String prod_id) {
		System.out.println("123145");
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {

			String currusername = authentication.getName();
			System.out.println("\t received the currusername");
			User u = userDao.getuseremail(currusername);
			System.out.println("\t Received the getuseremail");
			if (user == null) {
				System.out.println("\t user Null");
				return new ModelAndView("redirect:/");
			} else {
				cart = u.getCart();
				product = productDao.get(prod_id);
				CartItems cartItems = new CartItems();

				cartItems.setCart(cart);
				cartItems.setProduct(product);
				cartItems.setCartItem_price(product.getProd_price());
				cartItemsDao.saveupdate(cartItems);
				cart.setTotal(cart.getTotal() + product.getProd_price());
				cart.setTot_items(cart.getTot_items() + 1);
				cartDao.saveupdate(cart);
				session.setAttribute("items", cart.getCartitems());
				session.setAttribute("total", cart.getTotal());
				return new ModelAndView("redirect:/");
			}
		} else {
			return new ModelAndView("redirect:/");
		}
	}

	@RequestMapping("/ViewYourCart")
	public String viewcart(Model model, HttpSession session) {
		System.out.println(1223);
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			String currusername = authentication.getName();
			User u = userDao.getuseremail(currusername);
			Cart c = u.getCart();
			System.out.println("\t Cart Intialized ");
			// List<CartItems> cartItems =
			// cartItemsDao.getList(u.getCart().getCartId());

			List<CartItems> cartItems = cartItemsDao.getCartItembyCartId(c.getCart_id());
			System.out.println("List Of Cart Items Intialized");
			if (cartItems == null || cartItems.isEmpty()) {
				session.setAttribute("items", 0);
				model.addAttribute("gtotal", 0.0);
				model.addAttribute("msg", "no Items is added to cart");
				return "CartForm";
			}
			System.out.println("\t Sending the secound viewYour Cart");
			model.addAttribute("cartItems", cartItems);
			model.addAttribute("gtotal", c.getTotal());
			session.setAttribute("items", c.getTot_items());
			session.setAttribute("cartId", c.getCart_id());
			return "CartForm";

		} else {
			return "redirect:/";
		}

	}

	@RequestMapping(value = "/deleteCart/{cartItem_id}")
	public ModelAndView deleteCart(@PathVariable("cartItem_id") String cartItem_id) {
		CartItems cartItems = cartItemsDao.get(cartItem_id);
		Cart c = cartItems.getCart();
		c.setTotal(c.getTotal() - cartItems.getCartItem_price());
		c.setTot_items(c.getTot_items() - 1);

		//cartDao.saveupdate(c);

		cartItemsDao.delete(cartItems);

		String url = "/ViewYourCart";
		ModelAndView obj = new ModelAndView("redirect:" + url);

		return obj;
	}

	@RequestMapping(value = "/Removeall")
	public String Removeall(Model model, HttpSession session) {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			String currusername = authentication.getName();
			User u = userDao.getuseremail(currusername);	
			if(u==null)
			{
				System.out.println("User not getting");
				return "redirect:/loginpg";
			}
			else
			{
				Cart c1 = u.getCart();
				if (c1==null)
				{
					System.out.println("Not getting cart to user");
					return "redirect:/ViewYourCart";
				}
				else
				{
					List<CartItems> cartItems = cartItemsDao.getCartItembyCartId(c1.getCart_id());
					for (CartItems g : cartItems)
					{
						cartItemsDao.delete(g);
					}
					c1.setTot_items(0);
					c1.setTotal(0.0);
					cartDao.saveupdate(c1);
					session.setAttribute("items", c1.getTot_items());
				}
				
			}
			
		}
		return "redirect:/ViewYourCart";
	}
 }
