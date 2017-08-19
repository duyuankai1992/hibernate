package com.yztc.demo.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.yztc.demo.entity.User;
import com.yztc.demo.util.HibernateUtil;

public class TestHibernateHW {
	/**
	 * ����Hibernate HelloWorld
	 * �������
	 * Session
	 */
	@Test
	public void testSave(){		
		//1��ʵ����Configuration   ���������ļ�
		Configuration cfg = new Configuration().configure();
		
		//2��ʵ����SessionFactory
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		
		//3��ʵ����session
		Session session = sessionFactory.openSession();
		
		//3.5  ʵ����ɾ�Ĳ��� ���뿪���������
		Transaction tx = session.beginTransaction();
		
		User user = new User();
		user.setUserName("aaa");
		user.setPassword("aaa");
		user.setName("����");
		//4������API
		session.save(user);
		
		//�ύ����
		tx.commit();
		
		//5���ͷ���Դ
		session.close();
	}
	@Test
	public void testDelete(){
		Integer id = 27;
		Session session = HibernateUtil.getSession();
		User user = new User();
		user.setId(id);
		session.delete(user);
		session.beginTransaction().commit();
		HibernateUtil.close();
	}
	
	
	@Test
	public void testUpdate(){
		Session session = HibernateUtil.getSession();
		
		User user = new User();
		user.setId(26);
		user.setPassword("ddd");		
		session.update(user);
		
		session.beginTransaction().commit();
		HibernateUtil.close();
	}	
	/**
	 * get()����������ID��ѯ����
	 * ��֧�������أ�������󲻴��ڣ�����null
	 */	
	@Test
	public void testGet(){		
		Session session = HibernateUtil.getSession();
		User user = session.get(User.class, 3);
		System.out.println(user);
		HibernateUtil.close();
	}	
	/**
	 * load()����������ID��ѯ����
	 * ֧�������أ�������󲻴��ڣ��׳��쳣
	 */	
	@Test
	public void testLoad(){
		Session session = HibernateUtil.getSession();
		User user = session.load(User.class, 2);
		System.out.println(user);
		HibernateUtil.close();
	}
	
	/**
	 * ��ѯ��������
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testFindAll(){
		
		Session session = HibernateUtil.getSession();
		String hql = "select u from User u";		
		List<User> listUser = session.createQuery(hql).list();		
		System.out.println(listUser);
		HibernateUtil.close();
		
	}
}
