package com.yztc.demo.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@SuppressWarnings("deprecation")
public class HibernateUtil {
	
	private static SessionFactory sessionFactory;
	private static ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();
	
	static{
		Configuration cfg = new Configuration().configure();
		sessionFactory = cfg.buildSessionFactory();
	}	
	public static Session getSession(){
		Session session =  threadLocal.get();
		if(session==null){
			session = sessionFactory.openSession();
			threadLocal.set(session);
		}
		return session;
	}	
	public static void close(){
		Session session = threadLocal.get();
		threadLocal.set(null);
		if(session!=null&&session.isOpen()){
			session.close();
		}
	}	
}
