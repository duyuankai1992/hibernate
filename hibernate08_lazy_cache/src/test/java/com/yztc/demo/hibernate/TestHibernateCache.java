package com.yztc.demo.hibernate;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.junit.Test;

import com.yztc.demo.entity.Dept;
import com.yztc.demo.util.HibernateUtil;

/**
 * 测试缓存
 * 
 */
public class TestHibernateCache {

	// list()函数不支持查询缓存数据
	@Test
	public void test01() {
		Session session = HibernateUtil.getSession();

		String hql = "FROM Dept";
		List<Dept> listEmp = session.createQuery(hql).list();
		System.out.println(listEmp);

		listEmp = session.createQuery(hql).list();
		System.out.println(listEmp);

		HibernateUtil.close();
	}

	//测试一级缓存
	@Test
	public void test02() {
		Session session = HibernateUtil.getSession();

		Dept dept = (Dept) session.load(Dept.class, 1);
		System.out.println(dept.getDname());
		// HibernateUtil.close();

		session = HibernateUtil.getSession();
		dept = (Dept) session.load(Dept.class, 1);
		System.out.println(dept.getDname());

		HibernateUtil.close();
	}

	
	//测试二级缓存
	@Test
	public void test03() {

		Session session = HibernateUtil.getSession();
		Dept dept = (Dept) session.load(Dept.class, 1);
		System.out.println(dept.getDname());
		HibernateUtil.close();

		session = HibernateUtil.getSession();
		dept = (Dept) session.load(Dept.class, 1);
		System.out.println(dept.getDname());

		HibernateUtil.close();
	}

}
