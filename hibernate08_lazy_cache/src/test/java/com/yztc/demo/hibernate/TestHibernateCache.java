package com.yztc.demo.hibernate;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.junit.Test;

import com.yztc.demo.entity.Dept;
import com.yztc.demo.util.HibernateUtil;

/**
 * ���Ի���
 * 
 */
public class TestHibernateCache {

	// list()������֧�ֲ�ѯ��������
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

	//����һ������
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

	
	//���Զ�������
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
