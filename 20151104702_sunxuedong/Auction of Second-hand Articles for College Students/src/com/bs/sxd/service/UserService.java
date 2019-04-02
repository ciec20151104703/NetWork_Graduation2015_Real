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
	public User findUser(String username, String password, Integer type);
	// �����û������ң���ʼ����ע��ʱ��
	public User findByUserName(String username);
	// �����û�
	public void addUser(User user);
	// ����Աģ������������ҳ��ѯ
	public Page<User> findUserList(Integer page, Integer rows_u, String username, String sex);
	// �����û�ID��ѯ�û���Ϣ
	public User findper(Integer id);
	// �޸��û�������Ϣ
	public void updateUser(User user);
	// �޸��û�Ϊ����Ա
	public void updateUser_Admin(User user);
	// �޸Ĺ���ԱΪ�û�
	void updateUser_User(User user);
	// ɾ���û�
	public void deleteuser(Integer id);
}
