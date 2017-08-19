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
	 * 测试Hibernate HelloWorld
	 * 保存对象
	 * Session
	 */
	@Test
	public void testSave(){		
		//1、实例化Configuration   解析配置文件
		Configuration cfg = new Configuration().configure();
		
		//2、实例化SessionFactory
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		
		//3、实例化session
		Session session = sessionFactory.openSession();
		
		//3.5  实现增删改操作 必须开启事务对象
		Transaction tx = session.beginTransaction();
		
		User user = new User();
		user.setUserName("aaa");
		user.setPassword("aaa");
		user.setName("张三");
		//4、调用API
		session.save(user);
		
		//提交事务
		tx.commit();
		
		//5、释放资源
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
	 * get()方法，根据ID查询对象
	 * 不支持懒加载，如果对象不存在，返回null
	 */	
	@Test
	public void testGet(){		
		Session session = HibernateUtil.getSession();
		User user = session.get(User.class, 3);
		System.out.println(user);
		HibernateUtil.close();
	}	
	/**
	 * load()方法，根据ID查询对象
	 * 支持懒加载，如果对象不存在，抛出异常
	 */	
	@Test
	public void testLoad(){
		Session session = HibernateUtil.getSession();
		User user = session.load(User.class, 2);
		System.out.println(user);
		HibernateUtil.close();
	}
	
	/**
	 * 查询多条数据
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
