package com.niit.shreyasmobilesBackend.DaoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.niit.shreyasmobilesBackend.Dao.CartItemsDao;
import com.niit.shreyasmobilesBackend.model.CartItems;

public class CartItemsDaoImpl implements CartItemsDao {
	@Autowired
	SessionFactory sessionFactory;//referance variable 

	public CartItemsDaoImpl(SessionFactory sessionFactory) {

		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public boolean saveupdate(CartItems cartItems) {
		sessionFactory.getCurrentSession().saveOrUpdate(cartItems);
		return true;
	}

	@Transactional
	public boolean delete(CartItems cartItems) {
		
		sessionFactory.getCurrentSession().delete(cartItems);
			return true;
	}
			
			
		
	

	@Transactional
	public CartItems get(String id) {
		String q1 = "from CartItems where cartItem_id='" + id + "'";
		Query w = sessionFactory.getCurrentSession().createQuery(q1);
		@SuppressWarnings("unchecked")
		List<CartItems> list1 = (List<CartItems>) w.list();
		if (list1 == null || list1.isEmpty()) {
			return null;
		} else {
			return list1.get(0);
		}

	}
	@Transactional
public List<CartItems> list() {
		@SuppressWarnings("unchecked")
		List<CartItems> cartItems = (List<CartItems>) sessionFactory.getCurrentSession().createCriteria(CartItems.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
     return cartItems;
	}

	@Transactional
	public List<CartItems> getCartItembyCartId(String cart_id) {
		System.out.println("123"+cart_id);
		String q1 = "from CartItems where cart_id='" +cart_id+ "'"; 
		Query w = sessionFactory.getCurrentSession().createQuery(q1);
		@SuppressWarnings("unchecked")
		List<CartItems> list1 = (List<CartItems>) w.list();
		if (list1 == null || list1.isEmpty()) {
			System.out.println("not returning items by id");
			return null;
		} else {
			System.out.println("returning items by id");
			return list1;
		}
	}
	
	@Transactional
	public CartItems getlistall(String cartid,String prod_id){
		
		String q1 = "from CartItems where cart_id='" + cartid + "' and prod_id='"+prod_id+"'";
		Query w = sessionFactory.getCurrentSession().createQuery(q1);
		@SuppressWarnings("unchecked")
		List<CartItems> list1 = (List<CartItems>) w.list();
		if (list1 == null || list1.isEmpty()) {
			return null;
		} else {
			return list1.get(0);
		}

	}

	

}
