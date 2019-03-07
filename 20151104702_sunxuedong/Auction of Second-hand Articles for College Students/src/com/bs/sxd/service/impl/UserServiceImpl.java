package com.bs.sxd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bs.sxd.dao.UserDao;
import com.bs.sxd.po.User;
import com.bs.sxd.service.UserService;

/**
 * �û�Service�ӿ�ʵ����
 * 
 * @author ��ѩ��
 *
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	// ע��UserDao
	@Autowired
	private UserDao userDao;

	@Override
	public User findUser(String username, String password, Integer type) {
		// TODO Auto-generated method stub
		User user = this.userDao.findUser(username, password, type);
		return user;
	}

	@Override
	public User findByUserName(String username) {
		User user = this.userDao.findByUserName(username);
		return user;
		
	}

	@Override
	public void addUser(User user) {
		userDao.addUser(user);
		
	}

	
}
