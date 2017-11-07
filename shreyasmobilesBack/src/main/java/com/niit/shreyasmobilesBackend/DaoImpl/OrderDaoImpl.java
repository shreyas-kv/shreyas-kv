package com.niit.shreyasmobilesBackend.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shreyasmobilesBackend.Dao.OrderDao;
import com.niit.shreyasmobilesBackend.model.Order;



@Repository("orderDao")
@EnableTransactionManagement
public class OrderDaoImpl implements OrderDao {
	@Autowired
	SessionFactory sessionFactory;
	public OrderDaoImpl(SessionFactory sessionFactory) {
		
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	public boolean saveupdate(Order order) {
		sessionFactory.getCurrentSession().saveOrUpdate(order);
		return true;
	}
	
	@Transactional
	public boolean delete(Order order) {
		
		sessionFactory.getCurrentSession().delete(order);
		return true;
	}
	
	@Transactional
	public Order get(String order_Id) {
		String q1 = "From Order where id='"+order_Id+"'";
		Query w = sessionFactory.getCurrentSession().createQuery(q1);
		@SuppressWarnings("unchecked")
		List<Order> list1 = (List<Order>) w.list();
		if  (list1 == null || list1.isEmpty()) {
			return null;
			}
		else
		{
			return list1.get(0);
		}
		
	}
	@Transactional
	public List<Order> list() {
		@SuppressWarnings("unchecked")
		List<Order> order = (List<Order>)sessionFactory.getCurrentSession().createCriteria(Order.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		
		return order;
	}


}
