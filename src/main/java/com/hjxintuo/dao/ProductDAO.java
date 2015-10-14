package com.hjxintuo.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.hjxintuo.model.Pagination;
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
	
	@SuppressWarnings("unchecked")
	public Pagination<Product> getProductsAtPageIndex(int index) {
		Pagination<Product> pagination = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			String hql = "select count(p) from Product p";
			Long count = (Long)session.createQuery(hql).uniqueResult();
			
			// 计算分页信息
			pagination = new Pagination<Product>(count.intValue(), index, 5);
			hql = "from Product";
			Query query = session.createQuery(hql);
			query.setFirstResult(pagination.getFirstResultOffset());
			log.info("offset: " + pagination.getFirstResultOffset());
			query.setMaxResults(5);
			//query.setResultTransformer(Transformers.aliasToBean(Product.class));
			
			pagination.setObjectList((List<Product>)query.list());
		} finally {
			session.getTransaction().commit();
		}
		
		return pagination;
	}
}
