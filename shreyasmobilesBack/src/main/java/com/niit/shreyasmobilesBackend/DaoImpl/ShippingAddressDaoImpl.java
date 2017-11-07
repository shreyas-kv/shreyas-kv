package com.niit.shreyasmobilesBackend.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shreyasmobilesBackend.Dao.ShippingAddressDao;
import com.niit.shreyasmobilesBackend.model.ShippingAddress;




@Repository("shippingaddressDao")
@EnableTransactionManagement
public class ShippingAddressDaoImpl implements ShippingAddressDao 
{
	@Autowired
	SessionFactory sessionFactory;
	public ShippingAddressDaoImpl(SessionFactory sessionFactory) {
		
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	public boolean saveupdate(ShippingAddress shippingaddress) {
		sessionFactory.getCurrentSession().saveOrUpdate(shippingaddress);
		return true;
	}
	
	@Transactional
	public boolean delete(ShippingAddress shippingaddress) {
		
		sessionFactory.getCurrentSession().delete(shippingaddress);
		return true;
	}
	
	@Transactional
	public ShippingAddress get(String s_id) {
		String q1 = "From ShippingAddress where s_id='"+s_id+"'";
		Query w = sessionFactory.getCurrentSession().createQuery(q1);
		@SuppressWarnings("unchecked")
		List<ShippingAddress> list1 = (List<ShippingAddress>) w.list();
		if  (list1 == null || list1.isEmpty()) {
			return null;
			}
		else
		{
			return list1.get(0);
		}
		
	}
	@Transactional
	public List<ShippingAddress> list() {
		@SuppressWarnings("unchecked")
		List<ShippingAddress> ShippingAddress = (List<ShippingAddress>)sessionFactory.getCurrentSession().createCriteria(ShippingAddress.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		
		return ShippingAddress;
	}

	
	@Transactional
	public List<ShippingAddress> getaddbyuser(String user_id)
	{
		String q1 = "From ShippingAddress where user_id='"+user_id+"'";
		Query w = sessionFactory.getCurrentSession().createQuery(q1);
		@SuppressWarnings("unchecked")
		List<ShippingAddress> list1 = (List<ShippingAddress>) w.list();
		if  (list1 == null || list1.isEmpty()) {
			return null;
			}
		else
		{
			return list1;
		}
		
		
	}
}
