package com.niit.shreyasmobilesBackend.DaoImpl;

import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shreyasmobilesBackend.Dao.PayDao;
import com.niit.shreyasmobilesBackend.model.Pay;

@Repository("payDao")
@EnableTransactionManagement
public class PayDaoImpl implements PayDao {
	@Autowired
	SessionFactory sessionFactory;//referance variable 

	public PayDaoImpl(SessionFactory sessionFactory) {

		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public boolean saveupdate(Pay pay) {
		sessionFactory.getCurrentSession().saveOrUpdate(pay);
		return true;
	}

	@Transactional
	public boolean delete(Pay pay) {
		
			System.out.println("object is set with data"+pay.getPay_id());
			sessionFactory.getCurrentSession().delete(pay);
			return true;
	}
			
			
		
	

	@Transactional
	public Pay get(String id) {
		String q1 = "from Pay where pay_id='" + id + "'";
		Query w = sessionFactory.getCurrentSession().createQuery(q1);
		@SuppressWarnings("unchecked")
		List<Pay> list1 = (List<Pay>) w.list();
		if (list1 == null || list1.isEmpty()) {
			return null;
		} else {
			return list1.get(0);
		}

	}
	@Transactional
public List<Pay> list() {
		@SuppressWarnings("unchecked")
		List<Pay> pay = (List<Pay>) sessionFactory.getCurrentSession().createCriteria(Pay.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
     return pay;
	}

}
