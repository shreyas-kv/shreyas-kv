package com.niit.mobileFrontend.controller;

import javax.jms.Session;
import javax.servlet.http.HttpSession;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shreyasmobilesBackend.Dao.BillingAddressDao;
import com.niit.shreyasmobilesBackend.Dao.CardDao;
import com.niit.shreyasmobilesBackend.Dao.CartDao;
import com.niit.shreyasmobilesBackend.Dao.CartItemsDao;
import com.niit.shreyasmobilesBackend.Dao.OrderDao;
import com.niit.shreyasmobilesBackend.Dao.OrderItemsDao;
import com.niit.shreyasmobilesBackend.Dao.PayDao;
import com.niit.shreyasmobilesBackend.Dao.ProductDao;
import com.niit.shreyasmobilesBackend.Dao.ShippingAddressDao;
import com.niit.shreyasmobilesBackend.Dao.UserDao;
import com.niit.shreyasmobilesBackend.model.BillingAddress;
import com.niit.shreyasmobilesBackend.model.Card;
import com.niit.shreyasmobilesBackend.model.Cart;
import com.niit.shreyasmobilesBackend.model.CartItems;
import com.niit.shreyasmobilesBackend.model.Order;
import com.niit.shreyasmobilesBackend.model.OrderItems;
import com.niit.shreyasmobilesBackend.model.Pay;
import com.niit.shreyasmobilesBackend.model.Product;
import com.niit.shreyasmobilesBackend.model.ShippingAddress;
import com.niit.shreyasmobilesBackend.model.User;

import Otp.OtpGenerator;


@Controller
public class OrderController {

	@Autowired
	User user;
	@Autowired
	UserDao userDao;

	@Autowired
	Cart cart;
	@Autowired
	CartDao cartDao;

	@Autowired
	Product product;
	@Autowired
	ProductDao productDao;

	@Autowired
	CartItems cartItems;
	@Autowired
	CartItemsDao cartItemsDao;

	@Autowired
	BillingAddress billingAddress;
	@Autowired
	BillingAddressDao billingAddressDao;

	@Autowired
	ShippingAddress shippingAddress;
	@Autowired
	ShippingAddressDao shippingAddressDao;

	@Autowired
	Card card;
	@Autowired
	CardDao cardDao;

	@Autowired
	Pay pay;
	@Autowired
	PayDao payDao;

	@Autowired
	Order order;
	@Autowired
	OrderDao orderDao;

	@Autowired
	OrderItems orderItems;
	@Autowired
	OrderItemsDao orderItemsDao;

	@Autowired
	List<CartItems> cartitemsList;

	static String o;

	@Autowired
	private JavaMailSender mailSender;

	@RequestMapping("/Buyall")
	public String orderall(Model model, HttpSession session) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			String currusername = authentication.getName();
			user = userDao.getuseremail(currusername);
			cart = user.getCart();
			product = null;


			cartitemsList = cartItemsDao.getCartItembyCartId(cart.getCart_id());
			if (cartitemsList == null || cartitemsList.isEmpty()) {
				return "redirect:/viewcart";
			} else {
				billingAddress = billingAddressDao.get(user.getUser_id());
				List<ShippingAddress> shippingAddresies = shippingAddressDao.getaddbyuser(user.getUser_id());

				model.addAttribute("billingAddress", billingAddress);
				model.addAttribute("user", user);
				model.addAttribute("shippingAddresies", shippingAddresies);
				model.addAttribute("shippingAddress", new ShippingAddress());
				session.setAttribute("p", product);
			}
			return "BillingAndShippingAddressPage";
		} else {
			return "redirect:/";
		}
	}

	@RequestMapping("/Buy/{p_id}/{ci_id}")
	public String order(@PathVariable("p_id") String id, Model model, HttpSession session) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			String currusername = authentication.getName();
			user = userDao.getuseremail(currusername);
			cart = user.getCart();
			cartitemsList = null;

			product = productDao.get(id);
			billingAddress = billingAddressDao.get(user.getUser_id());
			List<ShippingAddress> shippingAddresies = shippingAddressDao.getaddbyuser(user.getUser_id());

			model.addAttribute("cartitemsList",cartitemsList);
			model.addAttribute("billingAddress", billingAddress);
			model.addAttribute("user", user);
			model.addAttribute("shippingAddresies", shippingAddresies);
			model.addAttribute("shippingAddress", new ShippingAddress());
			session.setAttribute("product", product);
			return "BillingAndShippingAddressPage";
		} else {
			return "redirect:/";
		}

	}

		
	
//	@RequestMapping("/OrderConfirm")
//	public ModelAndView payment(@ModelAttribute("shippingAddress") ShippingAddress sh) {
//		// if(cartItems==null || cartItems.isEmpty())
//		// {
//		// System.out.println("sorry");
//		// }
//		
//		System.out.println("sh"+sh.getS_city());
//		System.out.println("Indise confirm");
//		sh.setUser(user);
//		shippingAddress = sh;
//		System.out.println("ship"+shippingAddress.getS_city());
//		ModelAndView obj =  new ModelAndView("OrderConfirm");
//		obj.addObject("billingAddress", billingAddress);
//		obj.addObject("shippingAddress", shippingAddress);
//		obj.addObject("prot", product);
//		obj.addObject("cartitemsList", cartitemsList);
//		obj.addObject("cart", cart);
//		if(shippingAddressDao.saveupdate(shippingAddress)==true)
//		{
//			System.out.println("Shipping Address Saved");
//		}
//		
//		return obj;
//	}

	
	
	@RequestMapping("/OrderConfirm")
	public String payment(@ModelAttribute("shippingAddress") ShippingAddress sh, Model model) {
		// if(cartItems==null || cartItems.isEmpty())
		// {
		// System.out.println("sorry");
		// }
		
//		System.out.println("sh"+sh.getS_city());
//		System.out.println("Indise confirm");
		sh.setUser(user);
		shippingAddress = sh;
//		System.out.println("ship"+shippingAddress.getS_city());
		billingAddress = user.getBillingAddress();
		model.addAttribute("billingAddress", billingAddress);
		//System.out.println(billingAddress.getB_city()+123);
		model.addAttribute("shippingAddress", shippingAddress);
		model.addAttribute("prot", product);
		
		
		model.addAttribute("cartitemsList", cartitemsList);
		model.addAttribute("cart", cart);
	
		if(shippingAddressDao.saveupdate(shippingAddress)==true)
	{
		System.out.println("Shipping Address Saved");
	}

		
		return "OrderConfirm";
	}

	@RequestMapping("/previous")
	public String previous(Model model) {
//		List<ShippingAddress> shippingAddresies = shippingAddressDao.getaddbyuser(user.getUser_id());
//		System.out.println("HELLOOOOOO");
//		System.out.println(shippingAddresies.isEmpty());
//		
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			String currusername = authentication.getName();
			user = userDao.getuseremail(currusername);
		
			model.addAttribute("shippingAddress",new ShippingAddress());		
		model.addAttribute("shippingAddress", shippingAddress);
		model.addAttribute("billingAddress", billingAddress);


		model.addAttribute("user",user);
		model.addAttribute("product", product);
		
		return "BillingAndShippingAddressPage";
		
		}
		
		else
			return "redirect:/"; 
		
	}
	@RequestMapping("/pay")
	public String pay(Model model) {
		List<Card> cards = cardDao.getcardbyuser(user.getUser_id());
		model.addAttribute("cards", cards);
		model.addAttribute("card", new Card());
		return "PaymentMode";
	}

	
	@RequestMapping("/payment")
	public String payment(@ModelAttribute("card")Card c, @RequestParam("otp")String otp,  Model model) {
 		System.out.println(1324);
		int a;
		if(otp==null)
		{
			
			System.out.println("Move to 2nd condition");
			a=2;
		}
		else
			a=1;
//		System.out.println(str);
				
//		if (str.equalsIgnoreCase("Start Subscription")) {
//			a = 2;
//		} else {
//			a = Integer.parseInt(str);
//		}
		System.out.println(a);
		
		switch (a) {
		case 1:
				if(otp.equals(o))
				{
					pay.setPay_method("COD");
					pay.setPay_status("no");
				}
				else
				{
					return "redirect:/pay";
				}
			 
			break;
		case 2:
			if(a==2)
			{
			pay.setPay_method("card");
			pay.setPay_status("yes");
			payDao.saveupdate(pay);
			cardDao.saveupdate(c);
			}
			else
			{
				return "Thanks";
			}

			break;
		}
		return "redirect:/Thankyou";
	}

//	@RequestMapping("/payment")
//	public String payment(@ModelAttribute("card")Card c,@RequestParam("otp")String otp ,Model model) {
//
//        if(c.equals(o))
//		return "redirect:/ThankYou";
//        else
//        	return "redirect:/pay";	
//	}

	@RequestMapping("/ThankYou")
	public String orderconformation(HttpSession session) {
		System.out.println(32);
		order.setBilling(billingAddress);
		order.setShippingAddress(shippingAddress);
		order.setPay(pay);
		order.setUser(user);
		System.out.println(524);
		if (cartitemsList == null || cartitemsList.isEmpty()) {
			order.setGrand_total(product.getProd_price());
			orderDao.saveupdate(order);
			orderItems.setOrder(order);
			orderItems.setPid(product.getProd_id());
			orderItemsDao.saveupdate(orderItems);
			cart.setTotal(cart.getTotal() - cartItems.getCartItem_price());
			cart.setTot_items(cart.getTot_items() - 1);
			session.setAttribute("items", cart.getTot_items());
			cartDao.saveupdate(cart);
			cartItemsDao.delete(cartItemsDao.getlistall(cart.getCart_id(), product.getProd_id()));
			System.out.println(324);
		} else {
			System.out.println(656);
			order.setGrand_total(cart.getTotal());
			orderDao.saveupdate(order);
			for (CartItems c : cartitemsList) {
				System.out.println(3444);
				orderItems.setOrder(order);
				orderItems.setPid(c.getProduct().getProd_id());
				System.out.println(3443);
				orderItemsDao.saveupdate(orderItems);
				cartItemsDao.delete(c);
			}
			cart.setTotal(0.0);
			cart.setTot_items(0);
			System.out.println(346);
			session.setAttribute("items", cart.getTot_items());
			cartDao.saveupdate(cart);
		}
		cartItems = null;
		// cartItem=null;
		product = null;
		order = new Order();
		orderItems = new OrderItems();
		System.out.println(565);
		return "redirect:/Thanks";
	}

	@RequestMapping(value = "/SendMail")
	public void SendMail() {
		System.out.println(21312);
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) 
		{
			String currusername = authentication.getName();
			user = userDao.getuseremail(currusername);
			OtpGenerator ot = new OtpGenerator();
			
			o = ot.Otpga();
			String recipientAddress = user.getUser_emailid();
			String subject = "OTP";
			
			String message = "your one time password is " + o + " ";

			System.out.println("To:" + recipientAddress);
			System.out.println("Subject: " + subject);
			System.out.println("Message: " + message);


			SimpleMailMessage email = new SimpleMailMessage();
			email.setTo(recipientAddress);
			email.setSubject(subject);
			email.setText(message);
			mailSender.send(email);
			System.out.println("Yourt mail has been sent"+ email);

		
		}
	}
	
	
	@RequestMapping(value = "/ConfirmationMail")
	public String SendMsg(Model model, @ModelAttribute("card")Card c) {
		System.out.println(21312);
		cardDao.saveupdate(c);
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) 
		{
			String currusername = authentication.getName();
			user = userDao.getuseremail(currusername);
//			OtpGenerator ot = new OtpGenerator();
			
//			o = ot.Otpga();
			String recipientAddress = user.getUser_emailid();
			String subject = "OTP";
			
			String message = "Your order is confirmed";

			System.out.println("To:" + recipientAddress);
			System.out.println("Subject: " + subject);
			System.out.println("Message: " + message);


			SimpleMailMessage email = new SimpleMailMessage();
			email.setTo(recipientAddress);
			email.setSubject(subject);
			email.setText(message);
			mailSender.send(email);
			System.out.println("Yourt mail has been sent"+ email);

		
		}
		return "process";
	}


}
