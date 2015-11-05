package com.hjxintuo.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.hjxintuo.model.Account;

public class AccountDAO extends BaseDAO<Account> {
	public void openAccountForUser(Integer userId) {
		Account account = new Account();
		account.setUserId(userId);
		account.setBalance(20000);     // 测试，注册就送20,000
		account.setDateCreated(new Date());
		create(account);
	}
	
	public Account getAccountForUser(Integer userId) {
		String hql = "from Account a where a.userId=:userId";
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query q = session.createQuery(hql);
			q.setParameter("userId", userId);
			@SuppressWarnings("unchecked")
			List<Account> accountList = (List<Account>)q.list();
			session.getTransaction().commit();
			if ( accountList.isEmpty() ) {
				log.info("could not find account for user:" + userId);
				return null;
			}
			return accountList.get(0);
		} catch(Exception e) {
			session.getTransaction().rollback();
			log.info(e.getMessage());
			return null;
		}
	}
	
	public void recharge(Integer userId, float money) {
		String hql = "update Account a set a.balance=a.balance+:money where a.userId=:userId";
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query q = session.createQuery(hql);
			q.setParameter("userId", userId);
			q.setParameter("money", money);
			q.executeUpdate();
			session.getTransaction().commit();
		} catch(Exception e) {
			session.getTransaction().rollback();
		}
	}
}
