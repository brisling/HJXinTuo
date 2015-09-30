package com.hjxintuo.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;


public class BaseDAO<T> {
	protected Logger log = Logger.getLogger(BaseDAO.class);
	
	public void create(T object) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
//			if (object instanceof BaseBean) {
//				BaseBean bean = (BaseBean)object;
//				bean.setDateCreated(new Date());
//			}
			session.persist(object);
			session.getTransaction().commit();
		} catch (Exception e) {
			log.error(e);
			session.getTransaction().rollback();
		}
	}
	
	public void update(T object) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.update(object);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}
	
	public void delete(T object) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.delete(object);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}
	
	public T find(Class<? extends T> type, Serializable id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			return (T)session.get(type, id);
		} finally {
			session.getTransaction().commit();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<T> list(String hql) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			return session.createQuery(hql).list();
		} finally {
			session.getTransaction().commit();
		}
	}
}
