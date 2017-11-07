package com.niit.shreyasmobilesBackend.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shreyasmobilesBackend.Dao.CategoryDao;
import com.niit.shreyasmobilesBackend.model.Category;


@Repository("categoryDao")
@EnableTransactionManagement
public class CategoryDaoImpl implements CategoryDao 
{
	@Autowired
	SessionFactory sessionFactory;
	public CategoryDaoImpl(SessionFactory sessionFactory) {
		
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	public boolean saveupdate(Category category) {
		sessionFactory.getCurrentSession().saveOrUpdate(category);
		return true;
	}
	
	@Transactional
	public boolean delete(Category category) {
		
		sessionFactory.getCurrentSession().delete(category);
		return true;
	}
	
	@Transactional
	public Category get(String cid) {
		String q1 = "From Category where id='"+cid+"'";
		Query w = sessionFactory.getCurrentSession().createQuery(q1);
		@SuppressWarnings("unchecked")
		List<Category> list1 = (List<Category>) w.list();
		if  (list1 == null || list1.isEmpty()) {
			return null;
			}
		else
		{
			return list1.get(0);
		}
		
	}
	@Transactional
	public List<Category> list() {
		@SuppressWarnings("unchecked")
		List<Category> category = (List<Category>)sessionFactory.getCurrentSession().createCriteria(Category.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		
		return category;
	}
}
