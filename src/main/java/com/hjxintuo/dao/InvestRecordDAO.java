package com.hjxintuo.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.hjxintuo.model.InvestRecord;

public class InvestRecordDAO extends BaseDAO<InvestRecord> {
	public List<InvestRecord> getInvestRecordForUser(Integer userId) {
		String hql = "from InvestRecord IR where IR.userId=:userId";
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query q = session.createQuery(hql);
			q.setParameter("userId", userId);
			@SuppressWarnings("unchecked")
			List<InvestRecord> userList = (List<InvestRecord>)q.list();
			session.getTransaction().commit();
			return userList;
		} catch(Exception e) {
			return null;
		}
	}
}
