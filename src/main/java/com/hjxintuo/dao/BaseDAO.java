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
			session.persist(object);
		} catch (Exception e) {
			log.error(e);
		}
	}
	
	public void update(T object) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.update(object);
		} catch (Exception e) {
			log.error(e);
		}
	}
	
	public void delete(T object) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.delete(object);
		} catch (Exception e) {
			log.error(e);
		}
	}
	
	public T find(Class<? extends T> type, Serializable id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			return (T)session.get(type, id);
		} catch (Exception e) {
			log.error(e);
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<T> list(String hql) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			return session.createQuery(hql).list();
		} catch (Exception e) {
			return null;
		}
	}
}
