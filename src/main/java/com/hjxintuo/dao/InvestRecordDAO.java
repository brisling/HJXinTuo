package com.hjxintuo.dao;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.hjxintuo.model.InvestRecord;


public class InvestRecordDAO extends BaseDAO<InvestRecord> {
	public List<InvestRecord> getInvestRecordForUser(Integer userId) {
		String hql = "select new InvestRecord(r.product.title, r.product.startDate, " + 
					 "r.product.endDate, r.product.rateOfReturn, r.investNum) " + 
					 "from InvestRecord r " +
					 "where r.user.id=:userId " +
					 "order by r.product.startDate desc";
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
			log.error(e.getMessage());
			return null;
		}
	}
	
	public int buy(Integer userId, Integer productId, float investNum) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			
			// 扣除账户余额
			String hql = "update Account a set a.balance=a.balance-:investNum " + 
					 	 "where a.balance >= :investNum and a.userId=:userId";
			Query q = session.createQuery(hql);
			q.setParameter("userId", userId);
			q.setParameter("investNum", investNum);
			int num = q.executeUpdate();
			if (0 == num) {
				session.getTransaction().commit();
				return -2;
			}
			
			// 生成订单
			String sql = "insert into tb_invest_record(productId, userId, investNum, status) " +
						 "values(:productId, :userId, :investNum, :status)";
			SQLQuery sqlQuery = session.createSQLQuery(sql);
			sqlQuery.setParameter("productId", productId);
			sqlQuery.setParameter("userId", userId);
			sqlQuery.setParameter("investNum", investNum);
			sqlQuery.setParameter("status", 0);
			sqlQuery.executeUpdate();

			session.getTransaction().commit();
			return 0;
		} catch(Exception e) {
			session.getTransaction().rollback();
			log.error(e.getMessage());
			return -1;
		}
	}
}
