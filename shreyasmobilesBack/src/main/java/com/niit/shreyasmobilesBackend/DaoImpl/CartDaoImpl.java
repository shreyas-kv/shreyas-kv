package com.niit.shreyasmobilesBackend.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shreyasmobilesBackend.Dao.CartDao;
import com.niit.shreyasmobilesBackend.model.Cart;


@Repository("cartDao")
@EnableTransactionManagement
public class CartDaoImpl implements CartDao {
	@Autowired
	SessionFactory sessionFactory;
	public CartDaoImpl(SessionFactory sessionFactory) {
		
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	public boolean saveupdate(Cart cart) {
		sessionFactory.getCurrentSession().saveOrUpdate(cart);
		return true;
	}
	
	@Transactional
	public boolean delete(Cart cart) {

		sessionFactory.getCurrentSession().delete(cart);
		return true;
	}
	
	@Transactional
	public Cart get(String cartid) {
		String q1 = "From Cart where cart_id='"+cartid+"'";
		Query w = sessionFactory.getCurrentSession().createQuery(q1);
		@SuppressWarnings("unchecked")
		List<Cart> list1 = (List<Cart>) w.list();
		if  (list1 == null || list1.isEmpty()) {
			return null;
			}
		else
		{
			return list1.get(0);
		}
		
	}
	@Transactional
	public List<Cart> list() {
		@SuppressWarnings("unchecked")
		List<Cart> category = (List<Cart>)sessionFactory.getCurrentSession().createCriteria(Cart.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		
		return category;
	}

}
