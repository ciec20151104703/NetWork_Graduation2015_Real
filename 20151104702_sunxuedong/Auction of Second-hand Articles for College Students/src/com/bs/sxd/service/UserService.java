package com.bs.sxd.service;

import com.bs.sxd.po.User;

/**
 * Service �ӿ�
 * 
 * @author ��ѩ��
 *
 */
public interface UserService {
	public User findUser(String username,String password);
}
