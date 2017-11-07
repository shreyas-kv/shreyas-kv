package com.niit.shreyasmobilesBackend.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shreyasmobilesBackend.Dao.BillingAddressDao;
import com.niit.shreyasmobilesBackend.model.BillingAddress;




@Repository("billingaddressDao")
@EnableTransactionManagement
public class BillingAddressDaoImpl implements BillingAddressDao 
{
	@Autowired
	SessionFactory sessionFactory;
	public BillingAddressDaoImpl(SessionFactory sessionFactory) {
		
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	public boolean saveupdate(BillingAddress billingaddress) {
		sessionFactory.getCurrentSession().saveOrUpdate(billingaddress);
		return true;
	}
	
	@Transactional
	public boolean delete(BillingAddress billingaddress) {
		
		sessionFactory.getCurrentSession().delete(billingaddress);
		return true;
	}
	
	@Transactional
	public BillingAddress get(String b_id) {
		String q1 = "From BillingAddress where b_id='"+b_id+"'";
		Query w = sessionFactory.getCurrentSession().createQuery(q1);
		@SuppressWarnings("unchecked")
		List<BillingAddress> list1 = (List<BillingAddress>) w.list();
		if  (list1 == null || list1.isEmpty()) {
			return null;
			}
		else
		{
			return list1.get(0);
		}
		
	}
	@Transactional
	public List<BillingAddress> list() {
		@SuppressWarnings("unchecked")
		List<BillingAddress> billingaddress = (List<BillingAddress>)sessionFactory.getCurrentSession().createCriteria(BillingAddress.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		
		return billingaddress;
	}
}
