package com.lyh.springboot.service;

import java.util.List;

import com.lyh.springboot.pojo.Laboratory;
import com.lyh.springboot.pojo.User;


public interface UserService {
	public String getPassword(String name);

	public User getByName(String name);

	public List<User> list();

	public void add(User user);

	public void delete(Long id);

	public User get(Long id);

	public void update(User user);

	public User findUserName(String num);

	public List<User> listUser(Laboratory laboratory);
	
	public List<User> listStu(Laboratory laboratory);
	
	public List<User> listTeacher(Laboratory laboratory);

	public void skinChange(User user);

	public List<User> listStu2(Laboratory lab);

	public List<User> listTeacher2(Laboratory lab);

	public List<User> listStu();

	public List<User> listTeach();
}