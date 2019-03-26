package com.bs.sxd.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bs.sxd.po.User;
public interface UserDao {
   public User findUser(@Param("username") String username,
		                @Param("password") String password,
		                @Param("type") Integer type);

public User findByUserName(@Param("username") String username);

public void addUser(User user);
//ģ������������ҳ��ѯ
public List<User> findUserList(User user);
//��ѯ���û�����Ϊ��ҳ�ṩ����
public Integer selectuserListCount(User user);
//����ID��ѯ������Ϣ
public User findper(Integer id);
//�޸ĸ�����Ϣ
public void updateUser(User user);
//�޸��û�Ϊ����Ա
public void updateUser_Admin(User user);
//�޸Ĺ���ԱΪ�û�
public void updateUser_User(User user);
public void deleteuser(Integer id);
}


