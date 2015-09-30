package com.hjxintuo.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.hjxintuo.model.User;

public class UserDAO extends BaseDAO<User> {
	
	public User getUserByNameAndPassword(String userName, String password) {
		String hql = "select new User(u.id, u.userName, u.password) from User u where u.userName=:userName and u.password=:password";
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query q = session.createQuery(hql);
			q.setParameter("userName", userName);
			q.setParameter("password", password);
			@SuppressWarnings("unchecked")
			List<User> userList = (List<User>)q.list();
			session.getTransaction().commit();
			if ( userList.isEmpty() ) {
				return null;
			}
			return userList.get(0);
		} catch(Exception e) {
			return null;
		}
	}
	
	public boolean isUserExisting(String userName) {
		String hql = "select u.id from User u where u.userName=:userName";
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query q = session.createQuery(hql);
			q.setParameter("userName", userName);
			@SuppressWarnings("unchecked")
			List<String> userList = (List<String>)q.list();
			session.getTransaction().commit();
			return !userList.isEmpty();
		} catch(Exception e) {
			return true;
		}
	}
	
	public boolean isUserNotExisting(String userName) {
		return !isUserExisting(userName);
	}
}
