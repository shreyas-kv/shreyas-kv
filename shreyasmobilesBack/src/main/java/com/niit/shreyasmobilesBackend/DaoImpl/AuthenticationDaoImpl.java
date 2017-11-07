package com.niit.shreyasmobilesBackend.DaoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.shreyasmobilesBackend.Dao.AuthenticationDao;
import com.niit.shreyasmobilesBackend.model.Authentication;


@Repository("authenticationDao")
@EnableTransactionManagement
public class AuthenticationDaoImpl implements AuthenticationDao {
	@Autowired
	SessionFactory sessionFactory;// referance variable

	public AuthenticationDaoImpl(SessionFactory sessionFactory) {

		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public boolean saveupdate(Authentication authentication) {
		sessionFactory.getCurrentSession().saveOrUpdate(authentication);
		return true;
	}

	@Transactional
	public boolean delete(Authentication authentication) {

		sessionFactory.getCurrentSession().delete(authentication);
		return true;
	}

	@Transactional
	public Authentication get(String id) {
		String q1 = "from Authentication where role_id='" + id + "'";
		Query w = sessionFactory.getCurrentSession().createQuery(q1);
		@SuppressWarnings("unchecked")
		List<Authentication> list1 = (List<Authentication>) w.list();
		if (list1 == null || list1.isEmpty()) {
			return null;
		} else {
			return list1.get(0);
		}

	}

	@Transactional
	public List<Authentication> list() {
		@SuppressWarnings("unchecked")
		List<Authentication> authentication = (List<Authentication>) sessionFactory.getCurrentSession()
				.createCriteria(Authentication.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return authentication;
	}

}
