package com.bs.sxd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bs.common.utils.Page;
import com.bs.sxd.dao.UserDao;
import com.bs.sxd.po.Goods;
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

	@Override
	public Page<User> findUserList(Integer page, Integer rows_u, String username, String sex) {
		User user = new User();
		// ��ǰҳ
		user.setStart((page - 1) * rows_u);
		// ÿҳ��
		user.setRows(rows_u);
		//����������Ȼxml�ļ�ȡ����ֵ
		user.setUsername(username);
		user.setSex(sex);
		
		List<User> user1 = userDao.findUserList(user);
		// ��ѯ��Ʒ�б��ܼ�¼��
				Integer count = userDao.selectuserListCount(user);
		
		// ����Page���ض���
		
				Page<User> result = new Page<User>();
				
				result.setPage(page);
				result.setRows_u(user1);
				result.setSize(rows_u);
				result.setTotal(count);
				return result;
	}

	
}
