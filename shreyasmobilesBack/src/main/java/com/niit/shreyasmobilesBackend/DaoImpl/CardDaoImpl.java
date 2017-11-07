package com.niit.shreyasmobilesBackend.DaoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.niit.shreyasmobilesBackend.Dao.CardDao;
import com.niit.shreyasmobilesBackend.model.Card;

public class CardDaoImpl implements CardDao {
	@Autowired
	SessionFactory sessionFactory;//referance variable 

	public CardDaoImpl(SessionFactory sessionFactory) {

		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public boolean saveupdate(Card card) {
		sessionFactory.getCurrentSession().saveOrUpdate(card);
		return true;
	}

	@Transactional
	public boolean delete(Card card) {
		
			System.out.println("object is set with data"+card.getCard_id());
			sessionFactory.getCurrentSession().delete(card);
			return true;
	}
			
			
		
	

	@Transactional
	public Card get(String id) {
		String q1 = "from Card where card_id='" + id + "'";
		Query w = sessionFactory.getCurrentSession().createQuery(q1);
		@SuppressWarnings("unchecked")
		List<Card> list1 = (List<Card>) w.list();
		if (list1 == null || list1.isEmpty()) {
			return null;
		} else {
			return list1.get(0);
		}

	}
	@Transactional
public List<Card> list() {
		@SuppressWarnings("unchecked")
		List<Card> card = (List<Card>) sessionFactory.getCurrentSession().createCriteria(Card.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
     return card;
	}

	
	@Transactional
	public List<Card> getcardbyuser(String user_id)
	{
		String q1 = "from Card where user_id='" + user_id + "'";
		Query w = sessionFactory.getCurrentSession().createQuery(q1);
		@SuppressWarnings("unchecked")
		List<Card> list1 = (List<Card>) w.list();
		if (list1 == null || list1.isEmpty()) {
			return null;
		} else {
			return list1;
		}
		
	}

}
