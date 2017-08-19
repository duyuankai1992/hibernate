package com.yztc.demo.hibernate;

import java.util.Set;

import org.hibernate.Session;
import org.junit.Test;

import com.yztc.demo.entity.Dept;
import com.yztc.demo.entity.Emp;
import com.yztc.demo.util.HibernateUtil;

public class TestHibernateLazy {

	// 测试class元素中lazy
	@Test
	public void test01() {
		Session session = HibernateUtil.getSession();
		Dept dept = (Dept) session.load(Dept.class, 1);
		// System.out.println(dept);
		HibernateUtil.close();
	}

	// 测试<set>元素中lazy
	@Test
	public void test02() {

		Session session = HibernateUtil.getSession();
		Dept dept = (Dept) session.load(Dept.class, 1);

		// Set<Emp> emps = dept.getEmps();
		// emps.iterator();

		System.out.println(dept.getEmps().size());
		// System.out.println(dept);
		HibernateUtil.close();
	}
	// 测试<many-to-one>元素中lazy no-proxy
	@Test
	public void test03() {

		Session session = HibernateUtil.getSession();

		Emp emp = (Emp) session.load(Emp.class, 100);

		System.out.println(emp);
		
		System.out.println(emp.getDept().getDname());

		HibernateUtil.close();
	}
}
