package com.bs.sxd.service;

import com.bs.common.utils.Page;
import com.bs.sxd.po.User;

/**
 * Service �ӿ�
 * 
 * @author ��ѩ��
 *
 */
public interface UserService {
	public User findUser(String username,String password,Integer type);

	//�����û������ң���ʼ����ע��ʱ��
		public User findByUserName(String username);
	//�����û�
		public void addUser(User user);
    //����Աģ������������ҳ��ѯ
		public Page<User> findUserList(Integer page, Integer rows_u, String username, String sex);
		
    
	



	


    


   













	
}
