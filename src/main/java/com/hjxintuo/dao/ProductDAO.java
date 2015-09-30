package com.hjxintuo.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.hjxintuo.model.Product;

public class ProductDAO extends BaseDAO<Product>{

	@SuppressWarnings("unchecked")
	public List<Product> getHotProducts() {
		String hql = "from Product";
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query q = session.createQuery(hql);
			q.setFirstResult(0);
			q.setMaxResults(3);
			return  (List<Product>)q.list();
		} finally {
			session.getTransaction().commit();
		}
	}
	
	public List<Product> list() {
		String hql = "from Product";
		return (List<Product>)list(hql);
	}
}
