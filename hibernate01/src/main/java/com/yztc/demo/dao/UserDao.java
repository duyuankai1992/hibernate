package com.yztc.demo.dao;

import java.util.List;

import com.yztc.demo.entity.User;

public interface UserDao {
	
	void save(User user);
	
	void delete(Integer id);
	
	void update(User user);
	
	User findById(Integer id);
	
	List<User> findAll();

}
