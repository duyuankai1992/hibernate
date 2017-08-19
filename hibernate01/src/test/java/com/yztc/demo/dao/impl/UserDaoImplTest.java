package com.yztc.demo.dao.impl;


import org.junit.Test;

import com.yztc.demo.dao.UserDao;
import com.yztc.demo.entity.User;
import com.yztc.demo.util.HibernateUtil;

public class UserDaoImplTest {

	@Test
	public void test() {
		Integer id = 3;
		UserDao userDao = new UserDaoImpl();
		User user = userDao.findById(id);
		System.out.println(user);
		//OpenSessionInViewFilter
		HibernateUtil.close();
	}
}
