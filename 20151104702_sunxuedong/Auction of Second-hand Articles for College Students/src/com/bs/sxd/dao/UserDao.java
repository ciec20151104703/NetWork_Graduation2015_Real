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

}


