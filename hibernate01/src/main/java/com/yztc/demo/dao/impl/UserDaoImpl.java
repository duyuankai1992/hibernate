package com.yztc.demo.dao.impl;

import java.util.List;

import org.hibernate.Session;

import com.yztc.demo.dao.UserDao;
import com.yztc.demo.entity.User;
import com.yztc.demo.util.HibernateUtil;

public class UserDaoImpl implements UserDao{

	@Override
	public void save(User user) {
		Session session = HibernateUtil.getSession();
		session.save(user);
		session.beginTransaction().commit();
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
	}

	@Override
	public User findById(Integer id) {
		Session session = HibernateUtil.getSession();
		User user = session.load(User.class,id);
		return user;
	}

	
	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
