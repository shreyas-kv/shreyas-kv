package com.niit.shreyasmobilesBackend.DaoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.shreyasmobilesBackend.Dao.UserDao;
import com.niit.shreyasmobilesBackend.model.Authentication;
import com.niit.shreyasmobilesBackend.model.BillingAddress;
import com.niit.shreyasmobilesBackend.model.Cart;
import com.niit.shreyasmobilesBackend.model.User;

@Repository("userDao")
@EnableTransactionManagement
public class UserDaoImpl implements UserDao {
	@Autowired
	SessionFactory sessionFactory;
	
	public UserDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	

	@Transactional
	public boolean saveupdate(User user) {
		
		// TODO Auto-generated method stub
		Authentication authentication = new Authentication();
		
		Cart cart = new Cart();
		user.setCart(cart);
		
		sessionFactory.getCurrentSession().saveOrUpdate(user.getCart());
//		sessionFactory.getCurrentSession().saveOrUpdate(user.getBillingAddress());

		sessionFactory.getCurrentSession().saveOrUpdate(user);
		
		authentication.setRole_name(user.getUser_role());
		authentication.setUsername(user.getUser_emailid());
		
		sessionFactory.getCurrentSession().saveOrUpdate(authentication);
		return true;
	}

	@Transactional
	public boolean delete(User user) {
		
		sessionFactory.getCurrentSession().delete(user);
		return true;
	}

	@Transactional
	public User get(String uid) {
		// TODO Auto-generated method stub
		String q1 = "From User where id='"+uid+"'";
		Query w = sessionFactory.getCurrentSession().createQuery(q1);
		@SuppressWarnings("unchecked")
		List<User> list1 = (List<User>) w.list();
		if  (list1 == null || list1.isEmpty()) {
			return null;
			}
		else
		{
			return list1.get(0);
		}
	
	}

	@Transactional
	public List<User> list() {
		// TODO Auto-generated method stub
		List<User> user = (List<User>) sessionFactory.getCurrentSession().createCriteria(User.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		
		return user;
	}
	
	@Transactional
	public User isvalid(String email,String pwd)
	{
		String q2 = "From User where user_emailid='" + email + "'and user_password='" + pwd + "'";
		Query w = sessionFactory.getCurrentSession().createQuery(q2);
		@SuppressWarnings("unchecked")
		List<User> list1 = (List<User>) w.list();
		if (list1 == null || list1.isEmpty()) {

			return null;
		} else {
			return list1.get(0);
		}

	}
	@Transactional
	public User getuseremail(String email)
	{
		String q3 = "From User where user_emailid = '"+email+"'";
		Query w1 = sessionFactory.getCurrentSession().createQuery(q3);
		@SuppressWarnings("unchecked")
		List<User> list1 = (List<User>) w1.list();
		if (list1 == null || list1.isEmpty()) {

			return null;
		} else {
			return list1.get(0);
		}

		
	}
	


}
