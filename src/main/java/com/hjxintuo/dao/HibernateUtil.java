package com.hjxintuo.dao;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
 
public class HibernateUtil {
 
    private static final SessionFactory sessionFactory;
    private static Logger log;
     
    static {
        try {
        	log = Logger.getLogger(HibernateUtil.class);
        	
            // Create the SessionFactory from hibernate.cfg.xml
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            log.error("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
     
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
 
}
